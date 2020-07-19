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
public class ClienteEntity {

    private int id;
    private String nombre;
    private String apellido;
    private String razonsocial;
    private String nit;
    private String telefono;
    private String celular;
    private String ciudad;
    private String provincia;
    private String direccion;
    private String email;
    private String imagen;
    private String genero;
    private String estado;
    private Date fecha;
    private String hora;

    public ClienteEntity() {
    }

    public ClienteEntity(String nombre, String apellido, String nit, String telefono, String celular, String ciudad, String provincia, String direccion, String email, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;   
        this.nit = nit;
        this.telefono = telefono;
        this.celular = celular;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.email = email;
        this.imagen = imagen;
    }
//constructor para modificar el caso de uso
    public ClienteEntity(int id, String nombre, String apellido, String nit, String telefono, String celular, String ciudad, String provincia, String direccion, String email, String imagen, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nit = nit;
        this.telefono = telefono;
        this.celular = celular;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.email = email;
        this.imagen = imagen;
        this.genero = genero;
    }
 
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
