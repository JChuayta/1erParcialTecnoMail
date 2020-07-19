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
public class ServicioModel extends Model<ServicioEntity> {

    ServicioEntity entity;

    public ServicioModel(ServicioEntity entity) {
        this.entity = entity;
    }

    public ServicioModel() {
        entity = new ServicioEntity();
    }

    public ServicioEntity getEntity() {
        return entity;
    }

    public void setEntity(ServicioEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("idmarca", entity.getIdmarca());
        atr.put("idcategoria", entity.getIdcategoria());
        atr.put("descripcion", entity.getDescripcion());
        atr.put("codigo", entity.getCodigo());
        atr.put("tipo", entity.getTipo());
        atr.put("precio", entity.getPrecio());
        atr.put("costo", entity.getCosto());
        atr.put("incremento", entity.getIncremento());
        atr.put("tipoincremento", entity.getTipoincremento());
        atr.put("comision", entity.getComision());
        atr.put("stockactual", entity.getStockactual());
        atr.put("stockmin", entity.getStockmin());
        atr.put("stockmax", entity.getStockmax());
        atr.put("nota", entity.getNota());
        atr.put("imagen", entity.getImagen());
        atr.put("estado", entity.getEstado());
        atr.put("fecha", entity.getFecha());
        atr.put("hora", entity.getHora());
        return new Entity("servicio", atr);
    }

    @Override
    public ServicioEntity loadData(ResultSet rs) throws SQLException {
        entity = new ServicioEntity();
        entity.setId(rs.getInt("id"));
        entity.setIdmarca(rs.getInt("idmarca"));
        entity.setIdcategoria(rs.getInt("idcategoria"));
        entity.setDescripcion(rs.getString("descripcion"));
        entity.setCodigo(rs.getString("codigo"));
        entity.setTipo(rs.getString("tipo"));
        entity.setPrecio(rs.getDouble("precio"));
        entity.setCosto(rs.getDouble("costo"));
        entity.setIncremento(rs.getDouble("incremento"));
        entity.setTipoincremento(rs.getString("tipoincremento"));
        entity.setComision(rs.getDouble("comision"));
        entity.setStockactual(rs.getDouble("stockactual"));
        entity.setStockmin(rs.getDouble("stockmin"));
        entity.setStockmax(rs.getDouble("stockmax"));
        entity.setNota(rs.getString("nota"));
        entity.setImagen(rs.getString("imagen"));
        entity.setDescripcion(rs.getString("descripcion"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getString("hora"));
        return entity;
    }

    @Override
    public ServicioEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<ServicioEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"IDMARCA", "IDCATEGORIA", "DESCRIPCION", "CODIGO", "TIPO", "PRECIO", "COSTO", "COMISION", "STOCK ACTUAL", "NOTA", "FECHA", "HORA"}, list.size());
        for (ServicioEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getIdmarca(),
                    en.getIdcategoria(),
                    en.getDescripcion(),
                    en.getCodigo(),
                    en.getTipo(),
                    en.getPrecio(),
                    en.getCosto(),
                    en.getComision(),
                    en.getStockactual(),
                    en.getNota(),
                    en.getFecha(),
                    en.getHora()
                });
            }
        }

        return model;
    }

    public List<EstadisticaEntity> findStadisticsByDates(String desde, String hasta) {
        if (desde.isEmpty() || desde.isEmpty()) {
            hasta = "2020-06-01";
            desde = "2020-04-01";
        }
        String query = "select estadoproceso as label,count(*)as value from servicio where fecha>='" + desde + "' and fecha<='" + hasta + "' group by estadoproceso";
        System.out.println(query);
        List<EstadisticaEntity> solicitudes = new EstadisticaModel().findListByQuery(query);
        return solicitudes;
    }

    public List<EstadisticaEntity> findStadisticsModels() {
        String query = "select m.descripcion as label,count(*) as value from venta v,vehiculo vh,modelo m where m.id=vh.idmodelo and vh.id=v.idvehiculo group by m.descripcion";
        System.out.println(query);
        List<EstadisticaEntity> solicitudes = new EstadisticaModel().findListByQuery(query);
        return solicitudes;
    }

}
