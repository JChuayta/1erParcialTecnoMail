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
public class DetalleMantenimientoEntity { // esto es detalle venta en la BD

    private int id;
    private int idventa;
    private int idservicio;
    private int idmecanico;
    private double precio;
    private double cantidad;
    private double descuento;
    private double montodescuento;
    private String tipodescuento;
    private String nota;
    private String estadoproceso;

    private String estado;
    private Date fecha;
    private String hora;

    public DetalleMantenimientoEntity() {
    }

    // contructor para insertar datos
    public DetalleMantenimientoEntity(int idventa, int idservicio, int idmecanico, double precio, double cantidad, double descuento, double montodescuento, String nota) {
        this.idventa = idventa;
        this.idservicio = idservicio;
        this.idmecanico = idmecanico;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.montodescuento = montodescuento;;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public int getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(int idmecanico) {
        this.idmecanico = idmecanico;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMontodescuento() {
        return montodescuento;
    }

    public void setMontodescuento(double montodescuento) {
        this.montodescuento = montodescuento;
    }

    public String getTiodescuento() {
        return tipodescuento;
    }

    public void setTiodescuento(String tiodescuento) {
        this.tipodescuento = tiodescuento;
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
