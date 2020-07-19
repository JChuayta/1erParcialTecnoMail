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
public class MarcaEntity {

    private int id;
    private String descripcion;
    private String estado;
    private Date fecha;
    private Time hora;

    public MarcaEntity() {
    }
    //constructor para modificar el caso de uso
    public MarcaEntity(int id, String descripcion, Date fecha, Time hora) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }
    // consstrunctor para insertar el caso de uso
    public MarcaEntity(String descripcion, Date fecha, Time hora) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
