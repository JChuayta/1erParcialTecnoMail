/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.*;
import Entities.*;
import java.sql.*;
import java.util.*;
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
        this.entity = entity;
    }

    public ArticuloEntity getEntity() {
        return entity;
    }

    public void setEntity(ArticuloEntity entity) {
        this.entity = entity;
    }

    @Override
    public ArticuloEntity loadData(ResultSet rs) throws SQLException {
        entity = new ArticuloEntity();
        if (rs.next()) {
            entity.setId(rs.getInt("id"));
            entity.setDescripcion(rs.getString("descripcion"));
            entity.setEstado(rs.getString("estado"));
            entity.setFecha(rs.getString("fecha"));
            entity.setHora(rs.getString("hora"));
        }
        return entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> args = new HashMap<>();
        args.put("id", entity.getId());
        args.put("descripcion", entity.getDescripcion());
        args.put("estado", entity.getEstado());
        args.put("fecha", entity.getFecha());
        args.put("hora", entity.getHora());
        return new Entity("articulo", args);
    }
      public DefaultTableModel toTable(List<ArticuloEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","DESCRIPCION","FECHA","HORA"}, list.size());
        for (ArticuloEntity entity : list) {
            model.addRow(new Object[]{
                entity.getId(),
                entity.getDescripcion(),
                entity.getFecha(),
                entity.getHora()
            });
        }
        return model;
    }

}
