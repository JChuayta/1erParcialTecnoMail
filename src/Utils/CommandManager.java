/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.*;
import Models.*;
import Utils.*;

//import java.util.Date;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
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
        Insercion, Reporte, Estadistica, Listado, Desconocido
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

//  instanciamos objetos de las clases entidad y models
    ArticuloEntity articuloEntity;
    ArticuloModel articuloModel;
    MarcaEntity marcaEntity;
    MarcaModel marcaModel;
    ModeloModel modeloModel;
    ModeloEntity modeloEntity;
    VehiculoModel vehiculoModel;
    VehiculoEntity vehiculoEntity;
    ClienteModel clienteModel;
    ClienteEntity clienteEntity;
    MecanicoModel mecanicoModel;
    MecanicoEntity mecanicoEntity;
    ServicioModel servicioModel;
    ServicioEntity servicioEntity;
    MantenimientoEntity mantenimientoEntity;
    MantenimientoModel mantenimientoModel;
    DetalleMantenimientoEntity detallemantenimientoEntity;
    DetalleMantenimientoModel detallemantenimientoModel;
    
    Calendar calendario = new GregorianCalendar();
    
    String hora = calendario.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)) : String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
    String minutos = calendario.get(Calendar.MINUTE) < 10 ? "0" + String.valueOf(calendario.get(Calendar.MINUTE)) : String.valueOf(calendario.get(Calendar.MINUTE));
    String segundos = calendario.get(Calendar.SECOND) < 10 ? "0" + String.valueOf(calendario.get(Calendar.SECOND)) : String.valueOf(calendario.get(Calendar.SECOND));
    java.sql.Date fechaActual = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    String horaActual = hora + ":" + minutos + ":" + segundos;
    
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
                case "PRUEBA":
                    
                    break;
                case "AYUDA":
                    table = ayudaComandos.toTable();
                    tipoComando = TipoComando.Listado;
                    break;
//------------------------  CASO DE USO ARTICULOS--------------------------------                  
                case "INSERTAR_ARTICULO":
                    articuloEntity = new ArticuloEntity(
                            contents[0].toString(),
                            Date.valueOf(contents[1].toString()),
                            (contents[2].toString() + ":00")
                    );
                    articuloEntity.setEstado("A");
                    articuloModel = new ArticuloModel(articuloEntity);
                    idInserted = articuloModel.insert();
                    break;
                case "MODIFICAR_ARTICULO":
                    articuloEntity = new ArticuloEntity(
                            Integer.valueOf(contents[0].toString()),
                            contents[1].toString(),
                            Date.valueOf(contents[2].toString()),
                            (contents[3].toString() + ":00")
                    );
                    articuloEntity.setEstado("A");
                    ArticuloModel modelArticu = new ArticuloModel(articuloEntity);
                    idInserted = modelArticu.update();
                    break;
                case "LISTAR_ARTICULOS":
                    List<ArticuloEntity> articulos = new ArticuloModel().findAll();
                    table = new ArticuloModel().toTable(articulos);
                    tipoComando = TipoComando.Reporte;
                    break;
                case "ELIMINAR_ARTICULOS":
                    articuloEntity = new ArticuloEntity();
                    articuloEntity.setId(Integer.valueOf(contents[0].toString()));
                    articuloModel = new ArticuloModel(articuloEntity);
                    idInserted = articuloModel.delete();
                    break;
//---------------------------  CASO DE USO MARCAS  --------------------------------                    
                case "LISTAR_MARCAS":
                    List<MarcaEntity> marcas = new MarcaModel().findAll();
                    table = new MarcaModel().toTable(marcas);
                    tipoComando = TipoComando.Reporte;
                    break;
                case "INSERTAR_MARCA":
                    marcaEntity = new MarcaEntity(
                            contents[0].toString(),
                            Date.valueOf(contents[1].toString()),
                            Time.valueOf(contents[2].toString() + ":00")
                    );
                    marcaEntity.setEstado("A");
                    marcaModel = new MarcaModel(marcaEntity);
                    idInserted = marcaModel.insert();
                    break;
                case "MODIFICAR_MARCA":
                    marcaEntity = new MarcaEntity(
                            Integer.valueOf(contents[0].toString()),
                            contents[1].toString(),
                            Date.valueOf(contents[2].toString()),
                            Time.valueOf(contents[3].toString() + ":00")
                    );
                    marcaEntity.setEstado("A");
                    marcaModel = new MarcaModel(marcaEntity);
                    idInserted = marcaModel.insert();
                    break;
                case "ELIMINAR_MARCA":
                    marcaEntity = new MarcaEntity();
                    marcaEntity.setId(Integer.valueOf(contents[0].toString()));
                    marcaModel = new MarcaModel(marcaEntity);
                    idInserted = marcaModel.delete();
                    break;
//---------------------------  CASO DE USO MODELOS-------------------------------- 
                case "LISTAR_MODELOS":
                    List<ModeloEntity> modelo = new ModeloModel().findAll();
                    table = new ModeloModel().toTable(modelo);
                    tipoComando = TipoComando.Reporte;
                    break;
                case "INSERTAR_MODELO":
                    modeloEntity = new ModeloEntity(
                            Integer.valueOf(contents[0].toString()),
                            contents[1].toString(),
                            Date.valueOf(contents[2].toString()),
                            Time.valueOf(contents[3].toString() + ":00")
                    );
                    modeloEntity.setEstado("A");
                    modeloModel = new ModeloModel(modeloEntity);
                    idInserted = modeloModel.insert();
                    break;
                case "MODIFICAR_MODELO":
                    modeloEntity = new ModeloEntity(
                            Integer.valueOf(contents[0].toString()),
                            Integer.valueOf(contents[1].toString()),
                            contents[2].toString(),
                            Date.valueOf(contents[3].toString()),
                            Time.valueOf(contents[4].toString() + ":00")
                    );
                    modeloEntity.setEstado("A");
                    modeloModel = new ModeloModel(modeloEntity);
                    idInserted = modeloModel.update();
                    break;
                case "ELIMINAR_MODELO":
                    modeloEntity = new ModeloEntity();
                    modeloEntity.setId(Integer.valueOf(contents[0].toString()));
                    modeloModel = new ModeloModel(modeloEntity);
                    idInserted = modeloModel.delete();
                    break;
//---------------------------  CASO DE USO VEHICULO--------------------------------
                case "LISTAR_VEHICULOS":
                    List<VehiculoEntity> vehiculo = new VehiculoModel().findAll();
                    table = new VehiculoModel().toTable(vehiculo);
                    tipoComando = TipoComando.Reporte;
                    break;
                case "INSERTAR_VEHICULO":
                    vehiculoEntity = new VehiculoEntity(
                            Integer.valueOf(contents[0].toString()),//idcliente 
                            Integer.valueOf(contents[1].toString()),//idvehiculotipo
                            Integer.valueOf(contents[2].toString()),//idmarca
                            Integer.valueOf(contents[3].toString()),//idmodelo
                            Integer.valueOf(contents[4].toString()),//idvehiculocolor
                            Integer.valueOf(contents[5].toString()),//idvehiculoyear
                            contents[6].toString(),//placa
                            contents[7].toString(),//nroserie
                            contents[8].toString()//observacion
                    );
                    vehiculoEntity.setEstado("A");
                    vehiculoEntity.setFecha(fechaActual);
                    vehiculoEntity.setHora(horaActual);
                    vehiculoModel = new VehiculoModel(vehiculoEntity);
                    idInserted = modeloModel.insert();
                    break;
                case "MODIFICAR_VEHICULO":
                    vehiculoEntity = new VehiculoEntity(
                            Integer.valueOf(contents[0].toString()),//id
                            Integer.valueOf(contents[1].toString()),//idcliente 
                            Integer.valueOf(contents[2].toString()),//idvehiculotipo
                            Integer.valueOf(contents[3].toString()),//idmarca
                            Integer.valueOf(contents[4].toString()),//idmodelo
                            Integer.valueOf(contents[5].toString()),//idvehiculocolor
                            Integer.valueOf(contents[6].toString()),//idvehiculoyear
                            contents[7].toString(), //placa
                            contents[8].toString(), //nroserie
                            contents[9].toString() //observacion
                    );
                    vehiculoEntity.setEstado("A");
                    vehiculoEntity.setFecha(fechaActual);
                    vehiculoEntity.setHora(horaActual);
                    vehiculoModel = new VehiculoModel(vehiculoEntity);
                    idInserted = modeloModel.update();
                    break;
                case "ELIMINAR_VEHICULO":
                    vehiculoEntity = new VehiculoEntity();
                    vehiculoEntity.setId(Integer.valueOf(contents[0].toString()));
                    vehiculoModel = new VehiculoModel(vehiculoEntity);
                    idInserted = vehiculoModel.delete();
                    break;
//---------------------------  CASO DE USO PERSONAS--------------------------------
                case "LISTAR_PERSONAS":
                    String parametro = contents[0].toString();
                    System.out.println("parametro dde entrada ==> " + parametro);
                    switch (parametro) {
                        case "C":
                            List<ClienteEntity> cliente = new ClienteModel().findAll();
                            table = new ClienteModel().toTable(cliente);
                            tipoComando = TipoComando.Reporte;
                            break;
                        case "M":
                            List<MecanicoEntity> mecanico = new MecanicoModel().findAll();
                            table = new MecanicoModel().toTable(mecanico);
                            tipoComando = TipoComando.Reporte;
                            break;
                    }
                    break;
                case "INSERTAR_PERSONA":
                    parametro = contents[10].toString();
                    switch (parametro) {
                        case "M":
                            mecanicoEntity = new MecanicoEntity(
                                    contents[0].toString(),//nombre
                                    contents[1].toString(),//apellido
                                    contents[2].toString(),//nit
                                    contents[3].toString(),//telefono
                                    contents[4].toString(),//celular
                                    contents[5].toString(),//ciudad
                                    contents[6].toString(),//provincia
                                    contents[7].toString(),//direccion
                                    contents[8].toString(),//email
                                    contents[9].toString() //imagen
                            );
                            mecanicoEntity.setEstado("A");
                            mecanicoEntity.setGenero("N");
                            mecanicoEntity.setFecha(fechaActual);
                            mecanicoEntity.setHora(horaActual);
                            mecanicoModel = new MecanicoModel(mecanicoEntity);
                            idInserted = mecanicoModel.insert();
                            break;
                        case "C":
                            System.out.println("entro a cliente");
                            clienteEntity = new ClienteEntity(
                                    contents[0].toString(),//nombre
                                    contents[1].toString(),//apellido
                                    contents[2].toString(),//nit
                                    contents[3].toString(),//telefono
                                    contents[4].toString(),//celular
                                    contents[5].toString(),//ciudad
                                    contents[6].toString(),//provincia
                                    contents[7].toString(),//direccion
                                    contents[8].toString(),//email
                                    contents[9].toString()//imagen
                            );
                            clienteEntity.setEstado("A");
                            clienteEntity.setGenero("N");
                            clienteEntity.setRazonsocial("Null");
                            clienteEntity.setFecha(fechaActual);
                            clienteEntity.setHora(horaActual);
                            clienteModel = new ClienteModel(clienteEntity);
                            idInserted = clienteModel.insert();
                            break;
                    }
                    
                    break;
                case "MODIFICAR_PERSONA":
                    parametro = contents[12].toString();
                    switch (parametro) {
                        case "C":
                            clienteEntity = new ClienteEntity(
                                    Integer.valueOf(contents[0].toString()),//id
                                    contents[1].toString(),//nombre
                                    contents[2].toString(),//apellido
                                    contents[3].toString(),//nit
                                    contents[4].toString(),//telefono
                                    contents[5].toString(),//celular
                                    contents[6].toString(),//ciudad
                                    contents[7].toString(),//provincia
                                    contents[8].toString(),//direccion
                                    contents[9].toString(),//email
                                    contents[10].toString(),//imagen
                                    contents[11].toString() //genero
                            );
                            clienteEntity.setEstado("A");
                            clienteEntity.setRazonsocial("Null");
                            clienteEntity.setFecha(fechaActual);
                            clienteEntity.setHora(horaActual);
                            clienteModel = new ClienteModel(clienteEntity);
                            idInserted = clienteModel.update();
                            break;
                        case "M":
                            //MODIFICAR_PERSONA(2,CristianApaza,456789,112312,222222,Santa cruz,ichilo,nose,cri@gmail.com,cristian.png,M,M)
                            System.out.println("tipo de persona===>> " + parametro);
                            mecanicoEntity = new MecanicoEntity(
                                    Integer.valueOf(contents[0].toString()),//id
                                    contents[1].toString(),//nombre
                                    contents[2].toString(),//apellido
                                    contents[3].toString(),//nit
                                    contents[4].toString(),//telefono
                                    contents[5].toString(),//celular
                                    contents[6].toString(),//ciudad
                                    contents[7].toString(),//provincia
                                    contents[8].toString(),//direccion
                                    contents[9].toString(),//email
                                    contents[10].toString(),//imagen
                                    contents[11].toString() //genero
                            );
                            mecanicoEntity.setEstado("A");
                            mecanicoEntity.setFecha(fechaActual);
                            mecanicoEntity.setHora(horaActual);
                            mecanicoModel = new MecanicoModel(mecanicoEntity);
                            idInserted = mecanicoModel.update();
                            break;
                    }
                    
                    break;
                case "ELIMINAR_PERSONA":
                    
                    parametro = contents[0].toString();
                    switch (parametro) {
                        case "C":
                            clienteEntity = new ClienteEntity();
                            clienteEntity.setId(Integer.valueOf(contents[1].toString()));
                            clienteModel = new ClienteModel(clienteEntity);
                            idInserted = clienteModel.delete();
                            break;
                        case "M":
                            mecanicoEntity = new MecanicoEntity();
                            mecanicoEntity.setId(Integer.valueOf(contents[1].toString()));
                            mecanicoModel = new MecanicoModel(mecanicoEntity);
                            idInserted = mecanicoModel.delete();
                            break;
                    }
                    break;
//---------------------------  CASO DE USO SERVICIO--------------------------------
                case "LISTAR_SERVICIOS":
                    List<ServicioEntity> servicio = new ServicioModel().findAll();
                    table = new ServicioModel().toTable(servicio);
                    tipoComando = TipoComando.Reporte;
                    break;
                case "INSERTAR_SERVICIO":
                    servicioEntity = new ServicioEntity(
                            Integer.valueOf(contents[0].toString()),//idmarca
                            Integer.valueOf(contents[1].toString()),//idcategoriaa
                            contents[2].toString(),//descripcion
                            contents[3].toString(),//codigo
                            Double.valueOf(contents[4].toString()),//precio
                            Double.valueOf(contents[5].toString()),//costo
                            Double.valueOf(contents[6].toString()),//incremento
                            Double.valueOf(contents[7].toString()),//comision
                            Double.valueOf(contents[8].toString()),//stockactual
                            Double.valueOf(contents[9].toString()),//stockmin
                            Double.valueOf(contents[10].toString()),//stockmax
                            contents[11].toString(),//nota
                            contents[12].toString()//imagen
                    );
                    servicioEntity.setHora(horaActual);
                    servicioEntity.setFecha(fechaActual);
                    servicioEntity.setTipo("S");
                    servicioEntity.setTipoincremento("F");
                    servicioEntity.setEstado("A");
                    servicioModel = new ServicioModel(servicioEntity);
                    idInserted = servicioModel.insert();
                    break;
                case "MODIFICAR_SERVICIO":
                    servicioEntity = new ServicioEntity(
                            Integer.valueOf(contents[0].toString()), //id 
                            Integer.valueOf(contents[1].toString()),//idmarca
                            Integer.valueOf(contents[2].toString()),//idcategoriaa
                            contents[3].toString(),//descripcion
                            contents[4].toString(),//codigo
                            contents[5].toString(),//tipo default S
                            Double.valueOf(contents[6].toString()),//precio
                            Double.valueOf(contents[7].toString()),//costo
                            Double.valueOf(contents[8].toString()),//incremento
                            contents[9].toString(),//tipoincremento default F
                            Double.valueOf(contents[10].toString()),//comision
                            Double.valueOf(contents[11].toString()),//stockactual
                            Double.valueOf(contents[12].toString()),//stockmin
                            Double.valueOf(contents[13].toString()),//stockmax
                            contents[13].toString(),//nota
                            contents[14].toString()//imagen
                    );
                    servicioEntity.setHora(horaActual);
                    servicioEntity.setFecha(fechaActual);
                    servicioModel = new ServicioModel(servicioEntity);
                    idInserted = servicioModel.update();
                    break;
                case "ELIMINAR_SERVICIO":
                    servicioEntity = new ServicioEntity();
                    servicioEntity.setId(Integer.valueOf(contents[0].toString()));
                    servicioModel = new ServicioModel(servicioEntity);
                    idInserted = servicioModel.delete();
                    break;
//---------------------------  CASO DE USO MANTENIMIENTO(venta)  -------------------------------
                case "INSERTAR_MANTENIMIENTO":
                    mantenimientoEntity = new MantenimientoEntity(
                            Integer.valueOf(contents[0].toString()),//ideusuario
                            Integer.valueOf(contents[1].toString()),//idcliente
                            Integer.valueOf(contents[2].toString()),//idvehiculo 
                            contents[3].toString(),//codigo
                            contents[4].toString(),//nroficha
                            Double.valueOf(contents[5].toString()), //descuento
                            Double.valueOf(contents[6].toString()), //incremento
                            Double.valueOf(contents[7].toString()), //montototal
                            Double.valueOf(contents[8].toString()), //montodescuento
                            Double.valueOf(contents[9].toString()), //montoincremento
                            Double.valueOf(contents[10].toString()), //cantidadtotal
                            Date.valueOf(contents[11].toString()), //fechaventa
                            Time.valueOf(contents[12].toString()), //fechaventa
                            contents[13].toString() //nota
                    );
                    mantenimientoEntity.setHora(horaActual);
                    mantenimientoEntity.setFecha(fechaActual);
                    mantenimientoEntity.setTipodescuento("N");
                    mantenimientoEntity.setTipoincremento("N");
                    mantenimientoEntity.setEstadoproceso("F");
                    mantenimientoEntity.setEstado("A");
                    mantenimientoModel = new MantenimientoModel(mantenimientoEntity);
                    idInserted = mantenimientoModel.insert();
                    break;
                case "MODIFICAR_MANTENIMIENTO":
                    mantenimientoEntity = new MantenimientoEntity(
                            Integer.valueOf(contents[0].toString()),//id
                            Integer.valueOf(contents[1].toString()),//ideusuario
                            Integer.valueOf(contents[2].toString()),//idcliente
                            Integer.valueOf(contents[3].toString()),//idvehiculo 
                            contents[4].toString(),//codigo
                            contents[5].toString(),//nroficha
                            contents[6].toString(),//tipodescuento default N (F,P,N)
                            contents[7].toString(),//tipoincremento default N (F,P,N)
                            Double.valueOf(contents[8].toString()), //descuento
                            Double.valueOf(contents[9].toString()), //incremento
                            Double.valueOf(contents[10].toString()), //montototal
                            Double.valueOf(contents[11].toString()), //montodescuento
                            Double.valueOf(contents[12].toString()), //montoincremento
                            Double.valueOf(contents[13].toString()), //cantidadtotal
                            Date.valueOf(contents[14].toString()), //fechaventa
                            Time.valueOf(contents[15].toString()), //fechaventa
                            contents[16].toString(), //nota
                            contents[17].toString() //estadoprocesos default F (P,E,F)         
                    );
                    mantenimientoEntity.setHora(horaActual);
                    mantenimientoEntity.setFecha(fechaActual);
                    mantenimientoModel = new MantenimientoModel(mantenimientoEntity);
                    idInserted = mantenimientoModel.update();
                    break;
                case "LISTAR_MANTENIMIENTOS":
                    List<MantenimientoEntity> mantenimiento = new MantenimientoModel().findAll();
                    table = new MantenimientoModel().toTable(mantenimiento);
                    tipoComando = TipoComando.Reporte;
                    break;
                case "ELIMINAR_MANTENIMIENTO":
                    mantenimientoEntity = new MantenimientoEntity();
                    mantenimientoEntity.setId(Integer.valueOf(contents[0].toString()));
                    mantenimientoModel = new MantenimientoModel(mantenimientoEntity);
                    idInserted = mantenimientoModel.delete();
                    break;
//---------------------------  CASO DE USO DETALLE DE MANTENIMIENTO(detalle venta) ---------------------
                case "INSERTAR_DETALLE_MANTENIMIENTO":
                    detallemantenimientoEntity = new DetalleMantenimientoEntity(
                            Integer.valueOf(contents[0].toString()),//idventa                            Integer.valueOf(contents[0].toString()),//idventa
                            Integer.valueOf(contents[1].toString()),//idservicio
                            Integer.valueOf(contents[2].toString()),//idmecanico 
                            Double.valueOf(contents[3].toString()), //precio
                            Double.valueOf(contents[4].toString()), //cantidad
                            Double.valueOf(contents[5].toString()), //descuento
                            Double.valueOf(contents[6].toString()), //montodescuento
                            contents[7].toString() //nota
                    );
                    detallemantenimientoEntity.setFecha(fechaActual);
                    detallemantenimientoEntity.setHora(horaActual);
                    detallemantenimientoEntity.setTiodescuento("P");
                    detallemantenimientoEntity.setEstadoproceso("F");
                    detallemantenimientoEntity.setEstado("A");
                    detallemantenimientoModel = new DetalleMantenimientoModel(detallemantenimientoEntity);
                    idInserted = detallemantenimientoModel.insert();
                    break;
                
                case "LISTAR_DETALLE_MANTENIMIENTOS":
                    List<DetalleMantenimientoEntity> detalle = new DetalleMantenimientoModel().findAll();
                    table = new DetalleMantenimientoModel().toTable(detalle);
                    tipoComando = TipoComando.Reporte;
                    break;
                case "ELIMINAR_DETALLE_MANTENIMIENTO":
                    break;
//---------------------------  CASO DE USO REPORTES  --------------------------------
// ------------------------------ ESTADISTICAS ------------------------------------------
                case "EST_SERVICIO_FECHAS":
                    list = new ServicioModel().findStadisticsByDates(contents[0].toString(), contents[1].toString());
                    tipoComando = TipoComando.Estadistica;
                    nombreEstadistica = "ESTADISTICAS DE SERVICIO";
                    break;
                case "EST_MANTENIMIENTO_X_MODELOS":
                    list = new ServicioModel().findStadisticsModels();
                    tipoComando = TipoComando.Estadistica;
                    nombreEstadistica = "ESTADISTICAS DE MANTENIMIENTO X MODELO";
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
                case Listado:
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
        //result.put("result", idInserted);
        //return result;
    }
}
