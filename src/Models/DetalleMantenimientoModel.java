/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.Entity;
import Utils.Model;
import Entities.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo10sc
 */
public class DetalleMantenimientoModel extends Model<DetalleMantenimientoEntity> {

    DetalleMantenimientoEntity entity;

    public DetalleMantenimientoModel(DetalleMantenimientoEntity entity) {
        this.entity = entity;
    }

    public DetalleMantenimientoModel() {
        entity = new DetalleMantenimientoEntity();
    }

    public DetalleMantenimientoEntity getEntity() {
        return entity;
    }

    public void setEntity(DetalleMantenimientoEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("idventa", entity.getIdventa());
        atr.put("idservicio", entity.getIdservicio());
        atr.put("idmecanico", entity.getIdmecanico());
        atr.put("precio", entity.getPrecio());
        atr.put("cantidad", entity.getCantidad());
        atr.put("descuento", entity.getDescuento());
        atr.put("montodescuento", entity.getMontodescuento());
        atr.put("tipodescuento", entity.getTiodescuento());
        atr.put("nota", entity.getNota());
        atr.put("estadoproceso", entity.getEstadoproceso());
        atr.put("estado", entity.getEstado());
        atr.put("fecha", entity.getFecha());
        atr.put("hora", entity.getHora());
        return new Entity("detalleventa", atr);
    }

    @Override
    public DetalleMantenimientoEntity loadData(ResultSet rs) throws SQLException {
        entity = new DetalleMantenimientoEntity();
        entity.setId(rs.getInt("id"));
        entity.setIdventa(rs.getInt("idventa"));
        entity.setIdservicio(rs.getInt("idservicio"));
        entity.setIdmecanico(rs.getInt("idmecanico"));
        entity.setPrecio(rs.getDouble("precio"));
        entity.setCantidad(rs.getDouble("cantidad"));
        entity.setDescuento(rs.getDouble("descuento"));
        entity.setMontodescuento(rs.getDouble("montodescuento"));
        entity.setTiodescuento(rs.getString("tipodescuento"));
        entity.setNota(rs.getString("nota"));
        entity.setEstadoproceso(rs.getString("estadoproceso"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getString("hora"));
        return entity;
    }

    @Override
    public DetalleMantenimientoEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<DetalleMantenimientoEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","IDMANTENIMIENTO","IDSERVICIO","IDMECANICO","PRECIO","CANTIDAD","DESCUENTO","MONTODESCUENTO", "FECHA", "HORA"}, list.size());
        for (DetalleMantenimientoEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getId(),                   
                    en.getIdventa(),   
                    en.getIdservicio(),   
                    en.getIdmecanico(),   
                    en.getPrecio(),   
                    en.getCantidad(),   
                    en.getDescuento(),   
                    en.getMontodescuento(),   
                    en.getFecha(),
                    en.getHora()
                });
            }
        }

        return model;
    }
}
