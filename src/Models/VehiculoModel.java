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
public class VehiculoModel extends Model<VehiculoEntity> {

    VehiculoEntity entity;

    public VehiculoModel(VehiculoEntity entity) {
        this.entity = entity;
    }

    public VehiculoModel() {
        entity = new VehiculoEntity();
    }

    public VehiculoEntity getEntity() {
        return entity;
    }

    public void setEntity(VehiculoEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("idcliente", entity.getIdcliente());
        atr.put("idvehiculotipo", entity.getIdvehiculotipo());
        atr.put("idmarca", entity.getIdmarca());
        atr.put("idmodelo", entity.getIdmodelo());
        atr.put("idvehiculocolor", entity.getIdvehiculocolor());
        atr.put("idvehiculoyear", entity.getIdvehiculoyear());
        atr.put("placa", entity.getPlaca());
        atr.put("nroserie", entity.getNroserie());
        atr.put("observacion", entity.getObservacion());
        atr.put("estado", entity.getEstado());
        atr.put("fecha", entity.getFecha());
        atr.put("hora", entity.getHora());
        return new Entity("vehiculo", atr);
    }

    @Override
    public VehiculoEntity loadData(ResultSet rs) throws SQLException {
        entity = new VehiculoEntity();
        entity.setId(rs.getInt("id"));
        entity.setIdcliente(rs.getInt("idcliente"));
        entity.setIdvehiculotipo(rs.getInt("idvehiculotipo"));
        entity.setIdmarca(rs.getInt("idmarca"));
        entity.setIdmodelo(rs.getInt("idmodelo"));
        entity.setIdvehiculocolor(rs.getInt("idvehiculocolor"));
        entity.setIdvehiculoyear(rs.getInt("idvehiculoyear"));
        entity.setPlaca(rs.getString("placa"));
        entity.setNroserie(rs.getString("nroserie"));
        entity.setObservacion(rs.getString("observacion"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getString("hora"));
        return entity;
    }

    @Override
    public VehiculoEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<VehiculoEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","IDCLIENTE", "PLACA", "ESTADO","NROSERIE","OBSERVCION", "FECHA"}, list.size());
        for (VehiculoEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getId(),
                    en.getIdcliente(),
                    en.getPlaca(),
                    en.getEstado(),
                    en.getNroserie(),
                    en.getObservacion(),
                    en.getFecha()
                    
                });
            }
        }

        return model;
    }
}
