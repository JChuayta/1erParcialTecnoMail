/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.AyudaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo10sc
 */
public class AyudaComandos {

    List<AyudaEntity> list = new ArrayList<>();

    public AyudaComandos() {
        list.add(new AyudaEntity("INSERTAR ACTIVIDAD", "Nombre: String<br>Codigo: Integer<br>Descripcion: String", "Comando para insertar una actividad.", "INSERTAR_ACTIVIDAD(Nombre,Codigo,Descripcion)", "INSERTAR_ACTIVIDAD(Nombre,Codigo,Descripcion)"));
    }

    public DefaultTableModel toTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"OPERACION", "PARAMETROS", "DESCRIPCION", "COMANDO", "ENVIAR"}, list.size());
        model.setRowCount(0);
        list.forEach((entity) -> {
            model.addRow(new Object[]{
                entity.getOperacion(),
                entity.getParametros(),
                entity.getDescripcion(),
                entity.getComandoMuestra(),
                "<a href=\"mailto:" + Constantes.MAIL_USERMAIL + "?Subject=" + entity.getComando() + "\">Usar comando</a>"
            });
        });
        return model;
    }
}
