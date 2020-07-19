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
public class ServicioEntity {  /// en la bd es venta

    private int id;
    private int idmarca;
    private int idcategoria;
    private String descripcion;
    private String codigo;
    private String tipo;
    private double precio;
    private double costo;
    private double incremento;
    private String tipoincremento;
    private double comision;
    private double stockactual;
    private double stockmin;
    private double stockmax;
    private String nota;
    private String imagen;
    private String estado;
    private Date fecha;
    private String hora;

    public ServicioEntity() {
    }

    //contructor para insertar datos
    public ServicioEntity(int idmarca, int idcategoria, String descripcion, String codigo,  double precio, double costo, double incremento, double comision, double stockactual, double stockmin, double stockmax, String nota, String imagen) {
        this.idmarca = idmarca;
        this.idcategoria = idcategoria;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = precio;
        this.costo = costo;
        this.incremento = incremento;
        this.comision = comision;
        this.stockactual = stockactual;
        this.stockmin = stockmin;
        this.stockmax = stockmax;
        this.nota = nota;
        this.imagen = imagen;

    }

    // constructor para modificar datos
    public ServicioEntity(int id, int idmarca, int idcategoria, String descripcion, String codigo, String tipo, double precio, double costo, double incremento, String tipoincremento, double comision, double stockactual, double stockmin, double stockmax, String nota, String imagen) {
        this.id = id;
        this.idmarca = idmarca;
        this.idcategoria = idcategoria;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.tipo = tipo;
        this.precio = precio;
        this.costo = costo;
        this.incremento = incremento;
        this.tipoincremento = tipoincremento;
        this.comision = comision;
        this.stockactual = stockactual;
        this.stockmin = stockmin;
        this.stockmax = stockmax;
        this.nota = nota;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getIncremento() {
        return incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }

    public String getTipoincremento() {
        return tipoincremento;
    }

    public void setTipoincremento(String tipoincremento) {
        this.tipoincremento = tipoincremento;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getStockactual() {
        return stockactual;
    }

    public void setStockactual(double stockactual) {
        this.stockactual = stockactual;
    }

    public double getStockmin() {
        return stockmin;
    }

    public void setStockmin(double stockmin) {
        this.stockmin = stockmin;
    }

    public double getStockmax() {
        return stockmax;
    }

    public void setStockmax(double stockmax) {
        this.stockmax = stockmax;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
