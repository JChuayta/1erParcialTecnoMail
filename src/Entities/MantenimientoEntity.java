/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.*;

/**
 *
 * @author Grupo10sc
 */
public class MantenimientoEntity {  /// en la bd es venta

    private int id;
    private int idusuario;
    private int idcliente;
    private int idvehiculo;
    private String codigo;
    private String nroficha;
    private String tipodescuento;
    private String tipoincremento;
    private double descuento;
    private double incremento;
    private double montototal;
    private double montodescuento;
    private double montoincremento;
    private double cantidadtotal;
    private Date fechaventa;
    private Time horaventa;
    private String nota;
    private String estadoproceso;
    private String estado;
    private Date fecha;
    private String hora;

    public MantenimientoEntity() {
    }

    //contructor para insertar datos
    public MantenimientoEntity(int idusuario, int idcliente, int idvehiculo, String codigo, String nroficha, double descuento, double incremento, double montototal, double montodescuento, double montoincremento, double cantidadtotal, Date fechaventa, Time horaventa, String nota) {
        this.idusuario = idusuario;
        this.idcliente = idcliente;
        this.idvehiculo = idvehiculo;
        this.codigo = codigo;
        this.nroficha = nroficha;
        
        this.descuento = descuento;
        this.incremento = incremento;
        this.montototal = montototal;
        this.montodescuento = montodescuento;
        this.montoincremento = montoincremento;
        this.cantidadtotal = cantidadtotal;
        this.fechaventa = fechaventa;
        this.horaventa = horaventa;
        this.nota = nota;
    }

    // constructor para modificar datos
    public MantenimientoEntity(int id, int idusuario, int idcliente, int idvehiculo, String codigo, String nroficha, String tipodescuento, String tipoincremento, double descuento, double incremento, double montototal, double montodescuento, double montoincremento, double cantidadtotal, Date fechaventa, Time horaventa, String nota, String estadoproceso) {
        this.id = id;
        this.idusuario = idusuario;
        this.idcliente = idcliente;
        this.idvehiculo = idvehiculo;
        this.codigo = codigo;
        this.nroficha = nroficha;
        this.tipodescuento = tipodescuento;
        this.tipoincremento = tipoincremento;
        this.descuento = descuento;
        this.incremento = incremento;
        this.montototal = montototal;
        this.montodescuento = montodescuento;
        this.montoincremento = montoincremento;
        this.cantidadtotal = cantidadtotal;
        this.fechaventa = fechaventa;
        this.horaventa = horaventa;
        this.nota = nota;
        this.estadoproceso = estadoproceso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNroficha() {
        return nroficha;
    }

    public void setNroficha(String nroficha) {
        this.nroficha = nroficha;
    }

    public String getTipodescuento() {
        return tipodescuento;
    }

    public void setTipodescuento(String tipodescuento) {
        this.tipodescuento = tipodescuento;
    }

    public String getTipoincremento() {
        return tipoincremento;
    }

    public void setTipoincremento(String tipoincremento) {
        this.tipoincremento = tipoincremento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIncremento() {
        return incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }

    public double getMontototal() {
        return montototal;
    }

    public void setMontototal(double montototal) {
        this.montototal = montototal;
    }

    public double getMontodescuento() {
        return montodescuento;
    }

    public void setMontodescuento(double montodescuento) {
        this.montodescuento = montodescuento;
    }

    public double getMontoincremento() {
        return montoincremento;
    }

    public void setMontoincremento(double montoincremento) {
        this.montoincremento = montoincremento;
    }

    public double getCantidadtotal() {
        return cantidadtotal;
    }

    public void setCantidadtotal(double cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Time getHoraventa() {
        return horaventa;
    }

    public void setHoraventa(Time horaventa) {
        this.horaventa = horaventa;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getEstadoproceso() {
        return estadoproceso;
    }

    public void setEstadoproceso(String estadoproceso) {
        this.estadoproceso = estadoproceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
