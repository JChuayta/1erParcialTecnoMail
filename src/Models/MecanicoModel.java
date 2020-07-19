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
public class MecanicoModel extends Model<MecanicoEntity> {

    MecanicoEntity entity;

    public MecanicoModel(MecanicoEntity entity) {
        this.entity = entity;
    }

    public MecanicoModel() {
        entity = new MecanicoEntity();
    }

    public MecanicoEntity getEntity() {
        return entity;
    }

    public void setEntity(MecanicoEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("nombre", entity.getNombre());
        atr.put("apellido", entity.getApellido());
        atr.put("ci", entity.getCi());
        atr.put("telefono", entity.getTelefono());
        atr.put("celular", entity.getCelular());
        atr.put("ciudad", entity.getCiudad());
        atr.put("provincia", entity.getProvincia());
        atr.put("direccion", entity.getDireccion());
        atr.put("email", entity.getEmail());
        atr.put("imagen", entity.getImagen());
        atr.put("genero", entity.getGenero());
        atr.put("estado", entity.getEstado());
        atr.put("fecha", entity.getFecha());
        atr.put("hora", entity.getHora());
        return new Entity("mecanico", atr);
    }

    @Override
    public MecanicoEntity loadData(ResultSet rs) throws SQLException {
        entity = new MecanicoEntity();
        entity.setId(rs.getInt("id"));
        entity.setNombre(rs.getString("nombre"));
        entity.setApellido(rs.getString("apellido"));
        entity.setCi(rs.getString("ci"));
        entity.setTelefono(rs.getString("telefono"));
        entity.setCelular(rs.getString("celular"));
        entity.setCiudad(rs.getString("ciudad"));
        entity.setProvincia(rs.getString("provincia"));
        entity.setDireccion(rs.getString("direccion"));
        entity.setEmail(rs.getString("email"));
        entity.setImagen(rs.getString("imagen"));
        entity.setGenero(rs.getString("genero"));
        entity.setEstado(rs.getString("estado"));
        entity.setFecha(rs.getDate("fecha"));
        entity.setHora(rs.getString("hora"));
        return entity;
    }

    @Override
    public MecanicoEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<MecanicoEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "NOMBRE", "TELEFONO", "CIUDAD", "EMAIL", "CI", "SEXO", "IMAGEN"}, list.size());
        for (MecanicoEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getId(),
                    en.getNombre() + " " + en.getApellido(),
                    en.getTelefono(),
                    en.getCiudad(),
                    en.getEmail(),
                    en.getCi(),
                    en.getGenero(),
                    "<img width='55' height='55' src='data:image/jpeg;base64," + en.getImagen() + "'>"
                });
            }
        }

        return model;
    }
}
