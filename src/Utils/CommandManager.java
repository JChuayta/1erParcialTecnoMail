/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.*;
import Models.ArticuloModel;
import Utils.AyudaComandos;
import Utils.ValidatorCommand;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo10sc
 */
public class CommandManager {

    private Object[] quitarEspacios(Object[] contents) {
        Object[] r = new Object[contents.length];
        for (int i = 0; i < contents.length; i++) {
            if (!contents[i].toString().isEmpty()) {
                r[i] = contents[i].toString().trim();
            } else {
                r[i] = " ";
            }
        }
        return r;
    }

    public enum TipoComando {
        Insercion, Reporte, Estadistica, Desconocido
    }
    private String command;
    private String args;
    private final AyudaComandos ayudaComandos;
    private TipoComando tipoComando;
    private String nombreEstadistica;
    Map<String, Object> result;

    public CommandManager(String command) {
        this.command = command;
        result = new HashMap<>();
        ayudaComandos = new AyudaComandos();
        tipoComando = TipoComando.Insercion;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public TipoComando getTipoComando() {
        return tipoComando;
    }

    public void setTipoComando(TipoComando tipoComando) {
        this.tipoComando = tipoComando;
    }

    public String getNombreEstadistica() {
        return nombreEstadistica;
    }

    public void executeCommand(ValidatorCommand validatorCommand) {
        int idInserted = -1;
        DefaultTableModel table = null;
        List<EstadisticaEntity> list = null;
        int index = command.indexOf("(");
        int index2 = command.indexOf(")");
        if (index < 0 && index2 < 0) {
            result.put("result", idInserted);
        }
        try {
            args = command.substring(index + 1, index2);
            command = command.substring(0, index).trim();
            Object[] contents = args.split(",");
            contents = quitarEspacios(contents);
            switch (command.toUpperCase()) {
                case "AYUDA":
                    table = ayudaComandos.toTable();
                    tipoComando = TipoComando.Reporte;
                    break;
                case "INSERTAR_ARTICULO":
                    ArticuloEntity articuloEntity = new ArticuloEntity(
                            contents[0].toString(),
                            contents[1].toString(),
                            contents[2].toString(),
                            contents[3].toString()
                    );
                    ArticuloModel articuloModel = new ArticuloModel(articuloEntity);
                    idInserted = articuloModel.insert();
                    break;
                case "RPT_ARTICULOS":
                    List<ArticuloEntity> articulo = new ArticuloModel().findAll(Status.Active) ;
                    table = new ArticuloModel().toTable(articulo);
                    tipoComando = TipoComando.Reporte;
                    break;
                default:
                    tipoComando = TipoComando.Desconocido;
                    break;

            }
            switch (tipoComando) {
                case Insercion:
                    if (idInserted > 0) {
                        result.put("result", idInserted);
                        validatorCommand.onSuccess();
                    } else {
                        validatorCommand.onError();
                    }
                    break;
                case Reporte:
                    result.put("result", table);
                    validatorCommand.onSuccess();
                    break;
                case Estadistica:
                    result.put("result", list);
                    validatorCommand.onSuccess();
                    break;
                case Desconocido:
                    validatorCommand.onError();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            validatorCommand.onError();
        }
    }
}
