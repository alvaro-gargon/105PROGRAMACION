/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.TipoUsuario;
import modelo.Usuario;

/**
 *
 * @author alvaro.gargon.4
 */
public class UsuarioDaoJbdc implements UsuarioDao{
    private ConexionBD conexionBD;

    public UsuarioDaoJbdc(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public boolean insertar(Usuario usuario) throws DaoException {
        int n=0;
        boolean operacion=false;
        try (Connection con = conexionBD.getConnection(); 
            PreparedStatement ps = con.prepareStatement
        ("INSERT INTO `gestionusuarios`.`usuario` (`nombre`, `password`, `email`, `activo`, `rol`, `fecha_alta`) VALUES (?,?,?,?,?,?);");) {
           
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            ps.setBoolean(4, usuario.isActivo());
            ps.setString(5, usuario.getRol().toString());
            ps.setDate(6, Date.valueOf(usuario.getFechaAlta()));
            n += ps.executeUpdate();
            operacion=true;

        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return operacion;
    }

    @Override
    public Usuario buscar(String nombre) throws DaoException {
        Usuario usuario = null;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE nombre=?");) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario=new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setActivo(rs.getBoolean("activo"));
                usuario.setRol(TipoUsuario.valueOf(rs.getString("rol")));
                usuario.setFechaAlta(rs.getDate("fecha_alta").toLocalDate());
                if(rs.getTimestamp("ultimo_acceso")!=null){
                usuario.setUltimoAcceso(rs.getTimestamp("ultimo_acceso").toLocalDateTime());
                }
            }

        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } 
        return usuario;
    }

    @Override
    public boolean modificar(Usuario usuario) throws DaoException {
        boolean operacion=false;
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("UPDATE usuario SET password=?, email=? WHERE nombre=? ");) {
            ps.setString(3, usuario.getNombre());
            ps.setString(1, usuario.getPassword());
            ps.setString(2, usuario.getEmail());
            n = ps.executeUpdate();
            operacion=true;
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return operacion;
    }

    @Override
    public boolean borrar(String nombre) throws DaoException {
        boolean operacion=false;
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement
        ("DELETE FROM usuario WHERE nombre = ?");) {
            ps.setString(1, nombre);
            n = ps.executeUpdate();
            operacion=true;
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return operacion;
    }

    @Override
    public List<Usuario> listar() throws DaoException {
        Usuario usuario;
        List<Usuario> listado = null;
        try (Connection con = conexionBD.getConnection(); 
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario"); 
            ResultSet rs = ps.executeQuery();) {
            listado = new ArrayList<>();
            while (rs.next()) {
                usuario=new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setActivo(rs.getBoolean("activo"));
                usuario.setRol(TipoUsuario.valueOf(rs.getString("rol")));
                usuario.setFechaAlta(rs.getDate("fecha_alta").toLocalDate());
                if(rs.getTimestamp("ultimo_acceso")!=null){
                usuario.setUltimoAcceso(rs.getTimestamp("ultimo_acceso").toLocalDateTime());
                }
                listado.add(usuario);
            }

        } catch (SQLException  ex) {
            throw new DaoException(ex.getMessage());
        }
        return listado;
    }

    
}
