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
public class ModeloModel extends Model<ModeloEntity> {

    ModeloEntity entity;

    public ModeloModel(ModeloEntity entity) {
        this.entity = entity;
    }

    public ModeloModel() {
        entity = new ModeloEntity();
    }

    public ModeloEntity getEntity() {
        return entity;
    }

    public void setEntity(ModeloEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("idmarca", entity.getIdmarca());
        atr.put("descripcion", entity.getDescripcion());
        atr.put("estado", entity.getEstado());
        atr.put("fecha", entity.getFecha());
        atr.put("hora", entity.getHora());
        return new Entity("modelo", atr);
    }

    @Override
    public ModeloEntity loadData(ResultSet rs) throws SQLException {
        entity = new ModeloEntity();
        entity.setId(rs.getInt("id"));
        entity.setIdmarca(rs.getInt("idmarca"));
        entity.setDescripcion(rs.getString("descripcion"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getTime("hora"));
        return entity;
    }

    @Override
    public ModeloEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<ModeloEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "IDMARCA", "NOMBRE", "ESTADO", "FECHA", "HORA"}, list.size());
        for (ModeloEntity en : list) {
            model.addRow(new Object[]{
                en.getId(),
                en.getIdmarca(),
                en.getDescripcion(),
                en.getEstado(),
                en.getFecha(),
                en.getHora()
            });
        }

        return model;
    }
}
