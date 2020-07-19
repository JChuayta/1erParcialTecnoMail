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
public class MantenimientoModel extends Model<MantenimientoEntity> {

    MantenimientoEntity entity;

    public MantenimientoModel(MantenimientoEntity entity) {
        this.entity = entity;
    }

    public MantenimientoModel() {
        entity = new MantenimientoEntity();
    }

    public MantenimientoEntity getEntity() {
        return entity;
    }

    public void setEntity(MantenimientoEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("idusuario", entity.getId());
        atr.put("idcliente", entity.getId());
        atr.put("idvehiculo", entity.getId());
        atr.put("codigo", entity.getId());
        atr.put("nroficha", entity.getId());
        atr.put("tipodescuento", entity.getId());
        atr.put("tipoincremento", entity.getId());
        atr.put("descuento", entity.getId());
        atr.put("incremento", entity.getId());
        atr.put("montototal", entity.getId());
        atr.put("montodescuento", entity.getId());
        atr.put("montoincremento", entity.getId());
        atr.put("cantidadtotal", entity.getId());
        atr.put("fechaventa", entity.getId());
        atr.put("horaventa", entity.getId());
        atr.put("nota", entity.getId());
        atr.put("estadoproceso", entity.getId());
        atr.put("estado", entity.getEstado());
        atr.put("fecha", entity.getFecha());
        atr.put("hora", entity.getHora());
        return new Entity("venta", atr);
    }

    @Override
    public MantenimientoEntity loadData(ResultSet rs) throws SQLException {
        entity = new MantenimientoEntity();
        entity.setId(rs.getInt("id"));
        entity.setIdusuario(rs.getInt("idusuario"));
        entity.setIdcliente(rs.getInt("idcliente"));
        entity.setIdvehiculo(rs.getInt("idvehiculo"));
        entity.setCodigo(rs.getString("codigo"));
        entity.setNroficha(rs.getString("nroficha"));
        entity.setTipodescuento(rs.getString("tipodescuento"));
        entity.setTipoincremento(rs.getString("tipoincremento"));
        entity.setDescuento(rs.getDouble("descuento"));
        entity.setIncremento(rs.getDouble("incremento"));
        entity.setMontototal(rs.getDouble("montototal"));
        entity.setMontodescuento(rs.getDouble("montodescuento"));
        entity.setMontoincremento(rs.getDouble("montoincremento"));
        entity.setCantidadtotal(rs.getDouble("cantidadtotal"));
        entity.setFechaventa(rs.getDate("fechaventa"));
        entity.setHoraventa(rs.getTime("horaventa"));
        entity.setNota(rs.getString("nota"));
        entity.setEstadoproceso(rs.getString("estadoproceso"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getString("hora"));
        return entity;
    }

    @Override
    public MantenimientoEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<MantenimientoEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"IDUSUARIO", "IDCLIENTE", "IDVEHICULO", "CODIGO", "DESCUENTO", "INCREMENTO", "MONTO TOTAL", "NOTA", "FECHA", "HORA"}, list.size());
        for (MantenimientoEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getIdusuario(),
                    en.getIdcliente(), 
                    en.getIdvehiculo(),
                    en.getCodigo(),
                    en.getDescuento(),
                    en.getIncremento(),
                    en.getMontototal(),
                    en.getNota(),
                    en.getFecha(),
                    en.getHora()
                });
            }
        }

        return model;
    }
}
