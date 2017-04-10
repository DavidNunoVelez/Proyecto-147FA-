package Modelo;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose
 */
public class Centro {
    
    private int id_centro;
    private String nombre;
    private String direccion;
    private String cp;
    private String loc;
    private String provincia;
    private String telf;
    
    /* relación con trabajador*/
    
    private List<Trabajador>trabajadores = new ArrayList<>();

    public Centro() {
    }

    public Centro(int id_centro, String nombre, String direccion, String cp, String provincia, String telf) {
        this.id_centro = id_centro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.provincia = provincia;
        this.telf = telf;
    }

    public int getId_centro() {
        return id_centro;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    
    /* métodos a utilizar */
    
    public void guardarCentro(){
 
        try {
            ControladorBaseDatos.conectar();
            PreparedStatement ps = ControladorBaseDatos.getConexion().
                    prepareStatement("INSERT INTO CENTRO(NOMBRE,DIRECCION,CP,"
                            + "LOC,PROVINCIA,TELF) VALUES(?,?,?,?,?,?) ");
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, cp);
            ps.setString(4, loc);
            ps.setString(5, provincia);
            ps.setString(6, telf);
            boolean correcto = ps.execute();
            ControladorBaseDatos.desconectar();
 
        } catch (SQLException ex) {
 
            JOptionPane.showMessageDialog(null,"Ha ocurrido un problema \n"
                    +ex.getMessage());
        }
    }
 
    
    public List<Centro> listarCentros(){
        List<Centro> centros = new ArrayList<>();
        try {
            ControladorBaseDatos.conectar();
            CallableStatement cs = ControladorBaseDatos.getConexion().
                    prepareCall("{call PAQ_CENTROS.CONSULTA_CENTROS(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Centro c = new Centro();
                c.setNombre(rs.getString("NOMBRE"));
                c.setId_centro(rs.getInt("ID_CENTRO"));
                c.setLoc(rs.getString("LOC"));
                centros.add(c);
            }
            ControladorBaseDatos.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un problema \n"+ex.getMessage()); 
        }
        return centros;
    }
    
    public void modificarCentro(){
        try {
            ControladorBaseDatos.conectar();
            PreparedStatement ps = ControladorBaseDatos.getConexion()
                    .prepareStatement("UPDATE CENTRO(NOMBRE,DIRECCION,LOC,PROVINCIA"
                            + "CP,TELF SET(?,?,?,?,?) WHERE ID_CENTRO=?)");
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, loc);
            ps.setString(4, provincia);
            ps.setString(5, cp);
            ps.setString(6, telf);
            ps.setInt(7, id_centro);
            ps.executeUpdate();
            ControladorBaseDatos.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un problema \n"+ex.getMessage());
        }
    }
    
    public Centro verCentro(){
        try {
            ControladorBaseDatos.conectar();
            CallableStatement cs = ControladorBaseDatos.getConexion().
                    prepareCall("{call PAQ_CENTROS.CONSULTA_CENTRO(?,?)}");
            cs.setInt(1, id_centro);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("NOMBRE");
                direccion = rs.getString("DIRECCION");
                loc = rs.getString("LOC");
                provincia = rs.getString("PROVINCIA");
                cp = rs.getString("CP");
                telf = rs.getString("TELF");
            }
            ControladorBaseDatos.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un problema \n"+ex.getMessage());
        }
        return this;
    }
    
    public Centro listarTrabajadoresCentro(){
        try {
            ControladorBaseDatos.conectar();
            CallableStatement cs = ControladorBaseDatos.getConexion()
                    .prepareCall("{call PAQ_CENTROS.CONSULTA_CENTRO_TRABAJADORES(?,?,?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.setInt(3, id_centro);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                nombre= rs.g;
            }
            ControladorBaseDatos.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Centro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
    public void borrarCentro(){
        try {
            ControladorBaseDatos.conectar();
            PreparedStatement ps = ControladorBaseDatos.getConexion()
                    .prepareStatement("DELETE FROM CENTRO WHERE ID_CENTRO=?");
            ps.setInt(1, id_centro);
            ps.execute();
            ControladorBaseDatos.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un problema \n"+ex.getMessage());
        }
    }

    public void añadirTrabajador(Trabajador trabajador){
        trabajadores.add(trabajador);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
