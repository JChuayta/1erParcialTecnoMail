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
public class MarcaModel extends Model<MarcaEntity> {

    MarcaEntity entity;

    public MarcaModel(MarcaEntity entity) {
        this.entity = entity;
    }

    public MarcaModel() {
        entity = new MarcaEntity();
    }

    public MarcaEntity getEntity() {
        return entity;
    }

    public void setEntity(MarcaEntity entity) {
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
        return new Entity("marca", atr);
    }

    @Override
    public MarcaEntity loadData(ResultSet rs) throws SQLException {
        entity = new MarcaEntity();
        entity.setId(rs.getInt("id"));
        entity.setDescripcion(rs.getString("descripcion"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getTime("hora"));
        return entity;
    }

    @Override
    public MarcaEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<MarcaEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "NOMBRE", "ESTADO", "FECHA", "HORA"}, list.size());
        for (MarcaEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getId(),
                    en.getDescripcion(),
                    en.getEstado(),
                    en.getFecha(),
                    en.getHora()
                });
            }
        }

        return model;
    }

  
}
