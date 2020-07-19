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
public class VehiculoEntity {

    private int id;
    private int idcliente;
    private int idvehiculotipo;
    private int idmarca;
    private int idmodelo;
    private int idvehiculocolor;
    private int idvehiculoyear;
    private String placa;
    private String nroserie;
    private String observacion;
    private String estado;
    private Date fecha;
    private String hora;

    public VehiculoEntity() {
    }

    public VehiculoEntity(int idcliente, int idvehiculotipo, int idmarca, int idmodelo, int idvehiculocolor, int idvehiculoyear, String placa, String nroserie, String observacion) {
        this.idcliente = idcliente;
        this.idvehiculotipo = idvehiculotipo;
        this.idmarca = idmarca;
        this.idmodelo = idmodelo;
        this.idvehiculocolor = idvehiculocolor;
        this.idvehiculoyear = idvehiculoyear;
        this.placa = placa;
        this.nroserie = nroserie;
        this.observacion = observacion;
    }

    public VehiculoEntity(int id, int idcliente, int idvehiculotipo, int idmarca, int idmodelo, int idvehiculocolor, int idvehiculoyear, String placa, String nroserie, String observacion) {
        this.id = id;
        this.idcliente = idcliente;
        this.idvehiculotipo = idvehiculotipo;
        this.idmarca = idmarca;
        this.idmodelo = idmodelo;
        this.idvehiculocolor = idvehiculocolor;
        this.idvehiculoyear = idvehiculoyear;
        this.placa = placa;
        this.nroserie = nroserie;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdvehiculotipo() {
        return idvehiculotipo;
    }

    public void setIdvehiculotipo(int idvehiculotipo) {
        this.idvehiculotipo = idvehiculotipo;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }

    public int getIdvehiculocolor() {
        return idvehiculocolor;
    }

    public void setIdvehiculocolor(int idvehiculocolor) {
        this.idvehiculocolor = idvehiculocolor;
    }

    public int getIdvehiculoyear() {
        return idvehiculoyear;
    }

    public void setIdvehiculoyear(int idvehiculoyear) {
        this.idvehiculoyear = idvehiculoyear;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNroserie() {
        return nroserie;
    }

    public void setNroserie(String nroserie) {
        this.nroserie = nroserie;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
