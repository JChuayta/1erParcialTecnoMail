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
public class ClienteModel extends Model<ClienteEntity> {

    ClienteEntity entity;

    public ClienteModel(ClienteEntity entity) {
        this.entity = entity;
    }

    public ClienteModel() {
        entity = new ClienteEntity();
    }

    public ClienteEntity getEntity() {
        return entity;
    }

    public void setEntity(ClienteEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity loadEntity() {
        Map<String, Object> atr = new HashMap<>();
        atr.put("id", entity.getId());
        atr.put("nombre", entity.getNombre());
        atr.put("apellido", entity.getApellido());
        atr.put("razonsocial", entity.getRazonsocial());
        atr.put("nit", entity.getNit());
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
        return new Entity("cliente", atr);
    }

    @Override
    public ClienteEntity loadData(ResultSet rs) throws SQLException {
        entity = new ClienteEntity();
        entity.setId(rs.getInt("id"));
        entity.setNombre(rs.getString("nombre"));
        entity.setApellido(rs.getString("apellido"));
        entity.setRazonsocial(rs.getString("razonsocial"));
        entity.setNit(rs.getString("nit"));
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
    public ClienteEntity findById(int id) {
        return super.findById(id);
    }

    public DefaultTableModel toTable(List<ClienteEntity> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "NOMBRE", "TELEFONO", "CIUDAD", "EMAIL", "NIT", "SEXO", "IMAGEN"}, list.size());
        for (ClienteEntity en : list) {
            if (en != null) {
                model.addRow(new Object[]{
                    en.getId(),
                    en.getNombre() + " " + en.getApellido(),
                    en.getTelefono(),
                    en.getCiudad(),
                    en.getEmail(),
                    en.getNit(),
                    en.getGenero(),
                    "<img width=\"55\" height=\"55\" src=\"" + en.getImagen() + "\">"
                });
            }
        }

        return model;
    }
}
