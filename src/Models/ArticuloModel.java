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
public class ArticuloModel extends Model<ArticuloEntity> {

    ArticuloEntity entity;

    public ArticuloModel(ArticuloEntity entity) {
        this.entity = entity;
    }

    public ArticuloModel() {
        entity = new ArticuloEntity();
    }

    public ArticuloEntity getEntity() {
        return entity;
    }

    public void setEntity(ArticuloEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("descripcion", entity.getDescripcion());
        atr.put("estado", entity.getEstado());
        atr.put("fecha", entity.getFecha());
        atr.put("hora", entity.getHora());
        return new Entity("articulo", atr);
    }

    @Override
    public ArticuloEntity loadData(ResultSet rs) throws SQLException {
        entity = new ArticuloEntity();

        entity.setId(rs.getInt("id"));
        entity.setDescripcion(rs.getString("descripcion"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getString("hora"));
        return entity;
    }

    @Override
    public ArticuloEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<ArticuloEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "DESCRIPCION", "FECHA", "HORA"}, list.size());
//        System.out.println("cantidad=>>>" + list.size());
        for (ArticuloEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getId(),
                    en.getDescripcion(),                    
                    en.getFecha(),
                    en.getHora()
                });
            }
        }

        return model;
    }
}
