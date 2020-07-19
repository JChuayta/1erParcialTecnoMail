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
        //------------------------ CASO DE USO ARTICULOS --------------------
        list.add(new AyudaEntity("INSERTAR ARTICULO", "Descripcion: String<br>Fecha(yy-mm-dd): Date<br>Hora(hh:mm): Time", "Comando para insertar un articulo.", "INSERTAR_ARTICULO(Decripcion,Fecha(yy-mm-dd),Hora)", "INSERTAR_ARTICULO(Decripcion,Fecha(yy-mm-dd),Hora)"));
        list.add(new AyudaEntity("MODIFICAR ARTICULO", "Descripcion: String<br>Fecha(yy-mm-dd): Date<br>Hora(hh:mm): Time", "Comando para modificar un articulo.", "MODIFICAR_ARTICULO(Id,Decripcion,Fecha(yy-mm-dd),Hora)", "MODIFICAR_ARTICULO(Id,Decripcion,Fecha(yy-mm-dd),Hora)"));
        list.add(new AyudaEntity("LISTADO DE ARTICULO", "Ninguno", "Comando para generar un listado de ARTICULOS.", "LISTAR_ARTICULOS()", "LISTAR_ARTICULOS()"));
        list.add(new AyudaEntity("ELIMINAR ARTICULO", "Descripcion: Integer", "Comando para eliminar una tupla de la tabla ARTICULO.", "ELIMINAR_ARTICULOS(Id)", "ELIMINAR_ARTICULOS(Id)"));
        //------------------------ CASO DE USO MARCA --------------------
        list.add(new AyudaEntity("INSERTAR MARCA", "Descripcion: String<br>Fecha(yy-mm-dd): Date<br>Hora(hh:mm): Time", "Comando para insertar un articulo.", "INSERTAR_MARCA(Decripcion,Fecha(yy-mm-dd),Hora)", "INSERTAR_MARCA(Decripcion,Fecha(yy-mm-dd),Hora)"));
        list.add(new AyudaEntity("MODIFICAR MARCA", "Descripcion: String<br>Estado: String(A,N)<br>Fecha(yy-mm-dd): Date<br>Hora(hh:mm): Time", "Comando para modificar un articulo.", "MODIFICAR_MARCA(Id,Decripcion,Estado,Fecha(yy-mm-dd),Hora)", "MODIFICAR_MARCA(Id,Decripcion,Estado,Fecha(yy-mm-dd),Hora)"));
        list.add(new AyudaEntity("LISTADO DE MARCAS", "Ninguno", "Comando para generar un listado de MARCAS.", "LISTAR_MARCAS()", "LISTAR_MARCAS()"));
        list.add(new AyudaEntity("ELIMINAR MARCA", "Descripcion: Integer", "Comando para eliminar una tupla de la tabla MARCA.", "ELIMINAR_MARCAS(Id)", "ELIMINAR_MARCAS(Id)"));
        //------------------------ CASO DE USO MODELO --------------------
        list.add(new AyudaEntity("INSERTAR MODELO", "IdMarca: int<br>Descripcion: String<br>Fecha(yy-mm-dd): Date<br>Hora(hh:mm): Time", "Comando para insertar un modelo.", "INSERTAR_MODELO(Idmarca,Decripcion,Fecha(yy-mm-dd),Hora)", "INSERTAR_MODELO(IdMarca,Decripcion,Fecha(yy-mm-dd),Hora)"));
        list.add(new AyudaEntity("MODIFICAR MODELO", "IdMarca: int<br>Descripcion: String<br>Estado: String(A,N)<br>Fecha(yy-mm-dd): Date<br>Hora(hh:mm): Time", "Comando para modificar un modelo.", "MODIFICAR_MODELO(Id,Idmarca,Decripcion,Estado,Fecha(yy-mm-dd),Hora)", "MODIFICAR_MODELO(Id,IdMarca,Decripcion,Estado,Fecha(yy-mm-dd),Hora)"));
        list.add(new AyudaEntity("LISTADO DE MODELOS", "Ninguno", "Comando para generar un listado de MODELOS.", "LISTAR_MODELOS()", "LISTAR_MODELOS()"));
        list.add(new AyudaEntity("ELIMINAR MODELO", "Descripcion: Integer", "Comando para eliminar una tupla de la tabla MODELO.", "ELIMINAR_MODELOS(Id)", "ELIMINAR_MODELOS(Id)"));
        //------------------------ CASO DE USO VEHICULOS --------------------
        list.add(new AyudaEntity("INSERTAR VEHICULO", "idCliente: int<br>idVehiculoTipo: int<br>idMarca: int<br>idModelo: int <br>idVehiculoColor: int<br>iVehiculoYear: int<br>Placa: String<br>nroSerie: String<br>Observacion: String", "Comando para insertar un VEHICULO.", "INSERTAR_VEHICULO(idCliente,idVehiculoTipo,idMarca,idModelo,idVehiculoColor,idVehiculoYear,Placa,nroSerie,Observacion)", "INSERTAR_VEHICULO(idCliente,idVehiculoTipo,idMarca,idModelo,idVehiculoColor,idVehiculoYear,Placa,nroSerie,Observacion)"));
        list.add(new AyudaEntity("MODIFICAR VEHICULO", "id: int<br>idCliente: int<br>idVehiculoTipo: int<br>idMarca: int<br>idModelo: int <br>idVehiculoColor: int<br>iVehiculoYear: int<br>Placa: String<br>nroSerie: String<br>Observacion: String", "Comando para modificar un VEHICULO.", "MODIFICAR_VEHICULO(id,idCliente,idVehiculoTipo,idMarca,idModelo,idVehiculoColor,idVehiculoYear,Placa,nroSerie,Observacion)", "MODIFICAR_VEHICULO(id,idCliente,idVehiculoTipo,idMarca,idModelo,idVehiculoColor,idVehiculoYear,Placa,nroSerie,Observacion)"));
        list.add(new AyudaEntity("LISTADO DE VEHICULOS", "Ninguno", "Comando para generar un listado de VEHICULO.", "LISTAR_VEHICULOS()", "LISTAR_VEHICULOS()"));
        list.add(new AyudaEntity("ELIMINAR VEHICULO", "Descripcion: Integer", "Comando para eliminar una tupla de la tabla VEHICULO.", "ELIMINAR_VEHICULO(Id)", "ELIMINAR_VEHICULO(Id)"));
        //------------------------ CASO DE USO PERSONAS --------------------
        list.add(new AyudaEntity("INSERTAR PERSONA(CLIENTE,PERSONA)", "Nombre: String<br>Apellido: String<br>Nit/Ci: String<br>Telefono: String<br>Celular String<br>Ciudad: String<br>Provincia: String<br>Direccion: String<br>Email: String<br>Imagen: String", "Comando para insertar un PERSONA.", "INSERTAR_PERSONA(Nombre,Apelllido,Nit/Ci,Telefono,Celular,Ciudad,Provincia,Direccion,Email,Imagen_url,Fecha,Hora)", "INSERTAR_PERSONA(Nombre,Apelllido,Nit/Ci,Telefono,Celular,Ciudad,Provincia,Direccion,Email,Imagen_url,Tipo(C,M))"));
        list.add(new AyudaEntity("MODIFICAR PERSONA", "Id: int<br>Nombre: String<br>Apellido: String<br>Nit/Ci: String<br>Telefono: String<br>Celular String<br>Ciudad: String<br>Provincia: String<br>Direccion: String<br>Email: String<br>Imagen: String<br>Genero(N,M,F): String", "Comando para modificar un PERSONA.", "MODIFICAR_PERSONA(Id,Nombre,Apelllido,Nit/Ci,Telefono,Celular,Ciudad,Provincia,Direccion,Email,Genero,Imagen_url)", "MODIFICAR_PERSONA(Id,Nombre,Apelllido,Nit/Ci,Telefono,Celular,Ciudad,Provincia,Direccion,Email,Imagen_url,Genero,Tipo(C,M))"));
        list.add(new AyudaEntity("LISTADO DE PERSONAS", "Ninguno", "Comando para generar un listado de PERSONAS.", "LISTAR_PERSONAS(M o C)", "LISTAR_PERSONAS(M o C)"));
        list.add(new AyudaEntity("ELIMINAR PERSONA", "Descripcion: Integer", "Comando para eliminar una tupla de la tabla PERSONA.", "ELIMINAR_PERSONA(C o M,Id)", "ELIMINAR_PERSONA(C o M,Id)"));
        //------------------------ CASO DE USO SERVICIOS --------------------
        list.add(new AyudaEntity("INSERTAR SERVICIO", "IdMarca: int<br>idCategoria: int<br>Descripcion: String<br>Codigo: String<br>Precio: Double<br>Costo: Double<br>Incrememnto: Double<br>Comision: Double<br>StockActual: Double<br>StockMinimo: Doube<br>StockMax: Double<br>Nota: String<br>Imagen: String", "Comando para insertar un SERVICIO.", "INSERTAR_SERVICIO(idMarca,idCategoria,Descripcion,Codigo,Precio,Costo,Incremento,Comision,stockActual,stockMin,stockMax,Nota,Imagen)", "INSERTAR_SERVICIO(idMarca,idCategoria,Descripcion,Codigo,Precio,Costo,Incremento,Comision,stockActual,stockMin,stockMax,Nota,Imagen)"));
        list.add(new AyudaEntity("MODIFICAR SERVICIO", "Id: int<br>IdMarca: int<br>idCategoria: int<br>Descripcion: String<br>Codigo: String<br>Tipo(P,S): String<br>Precio: Double<br>Costo: Double<br>Incrememnto: Double<br>TipoIncremento(F,P): String<br>Comision: Double<br>StockActual: Double<br>StockMinimo: Doube<br>StockMax: Double<br>Nota: String<br>Imagen: String", "Comando para modificar un SERVICIO.", "MODIFICAR_SERVICIO(Id,idMarca,idCategoria,Descripcion,Codigo,Tipo,Precio,Costo,Incremento,tipoIncrementoComision,stockActual,stockMin,stockMax,Nota,Imagen)", "MODIFICAR_SERVICIO(Id,idMarca,idCategoria,Descripcion,Codigo,Tipo,Precio,Costo,Incremento,tipoIncrementoComision,stockActual,stockMin,stockMax,Nota,Imagen)"));
        list.add(new AyudaEntity("LISTADO DE SERVICIOS", "Ninguno", "Comando para generar un listado de SERVICIOS.", "LISTAR_SERVICIOS()", "LISTAR_SERVICIOS()"));
        list.add(new AyudaEntity("ELIMINAR SERVICIO", "Descripcion: Integer", "Comando para eliminar una tupla de la tabla SERVICIO.", "ELIMINAR_SERVICIOS(Id)", "ELIMINAR_SERVICIOS(Id)"));
        //------------------------ CASO DE USO MANTENIMIENTO --------------------
        list.add(new AyudaEntity("INSERTAR MANTENIMIENTO", "IdUsuario: int<br>IdCliente: int<br>IdVehiculo: int<br>Codigo: String<br>nroFicha: String<br>Descuento: Double<br>Incremento: Double<br>montoTotal: Double<br>montoDescuento: Double<br>montoInCremento: Double<br>cantidadTotal: int<br>fechaVenta(yy-mm-dd): Date<br>horaVenta(00:00): Time<br>Nota: String", "Comando para insertar un MANTENIMIENTO.", "INSERTAR_MANTENIMIENTO(IdUsuario,IdCliente,IdVehiculo,Codigo,nroFicha,Descuento,Incremento,montoTotal,montoDescuento,montoIncremento,cantidadTotal,fechaVenta,horaVenta,Nota)", "INSERTAR_MANTENIMIENTO(IdUsuario,IdCliente,IdVehiculo,Codigo,nroFicha,Descuento,Incremento,montoTotal,montoDescuento,montoIncremento,cantidadTotal,fechaVenta,horaVenta,Nota)"));
        list.add(new AyudaEntity("MODIFICAR MANTENIMIENTO", "Id: int<br>IdUsuario: int<br>IdCliente: int<br>IdVehiculo: int<br>Codigo: String<br>nroFicha: String<br>tipoDescuento(F,P,N): Char<br>tipoIncremento(F,P,N) Char<br>Descuento: Double<br>Incremento: Double<br>montoTotal: Double<br>montoDescuento: Double<br>montoInCremento: Double<br>cantidadTotal: int<br>fechaVenta(yy-mm-dd): Date<br>horaVenta(00:00): Time<br>Nota: String<br>EstadoProceso(P,E,F): Char<br>Estado: Char(A,N)", "Comando para modificar un MANTENIMIENTO.", "MODIFICAR_MANTENIMIENTO(Id,IdUsuario,IdCliente,IdVehiculo,Codigo,nroFicha,tipoDescuento,tipoIncrementoDescuento,Incremento,montoTotal,montoDescuento,montoIncremento,cantidadTotal,fechaVenta,horaVenta,Nota,EstadoProceso)", "MODIFICAR_MANTENIMIENTO(Id,IdUsuario,IdCliente,IdVehiculo,Codigo,nroFicha,tipoDescuento,tipoIncrementoDescuento,Incremento,montoTotal,montoDescuento,montoIncremento,cantidadTotal,fechaVenta,horaVenta,Nota,EstadoProceso)"));
        list.add(new AyudaEntity("LISTADO DE MANTENIMIENTOS", "Ninguno", "Comando para generar un listado de MANTENIMIENTOS.", "LISTAR_MANTENIMIENTOS()", "LISTAR_MANTENIMIENTOS()"));
        list.add(new AyudaEntity("ELIMINAR MANTENIMIENTO", "Descripcion: Integer", "Comando para eliminar una tupla de la tabla MANTENIMIENTO.", "ELIMINAR_MANTENIMIENTOS(Id)", "ELIMINAR_MANTENIMIENTOS(Id)"));
        //------------------------ DETALLE MANTENIMIENTO --------------------
        list.add(new AyudaEntity("INSERTAR ARTICULO", "Descripcion: String<br>Fecha(yy-mm-dd): Date<br>Hora(hh:mm): Time", "Comando para insertar un articulo.", "INSERTAR_ARTICULO(Decripcion,Fecha(yy-mm-dd),Hora)", "INSERTAR_ARTICULO(Decripcion,Fecha(yy-mm-dd),Hora)"));
        list.add(new AyudaEntity("LISTADO DE DETALLE MANTENIMIENTOS", "Ninguno", "Comando para generar un listado de DETALLE MANTENIMIENTOS.", "LISTAR_DETALLE_MANTENIMIENTOS()", "LISTAR_DETALLE_MANTENIMIENTOS()"));
        //------------------------ CASO DE USO ESTADISTICAS---------------------------
        list.add(new AyudaEntity("REPORTE ESTADISTICA. DE SERVICIOS POR FECHA", "Desde: Date (yyyy-MM-dd)<br>Hasta: Date (yyyy-MM-dd)", "Comando para generar un grafico estadistico de servicios<br>realizadas en un rango de fechas mostrando los estados.", "EST_SERVICIO_FECHAS(Desde,Hasta)", "EST_SERVICIO_FECHAS(Desde(año-mes-dia),Hasta(año-mes-dia))"));
        list.add(new AyudaEntity("REPORTE ESTADISTICA. DE SERVICIOS POR MODELOS", "Ninguno", "Comando para generar un grafico estadistico de modelos de autos<br>realizados mantenimiento", "EST_MANTENIMIENTO_X_MODELOS()", "EST_MANTENIMIENTO_X_MODELOS()"));
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
