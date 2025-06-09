/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appbanco2025.dao;

import es.sauces.appbanco2025.modelo.TipoUsuario;
import es.sauces.appbanco2025.modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ambrosio
 */
public class UsuarioDaoJdbc implements UsuarioDao{
    private ConexionBD conexionBD;

    public UsuarioDaoJdbc(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    

    @Override
    public void insertar(Usuario usuario) throws DaoException {
        int n=0;
        try (Connection con = conexionBD.getConnection(); 
            PreparedStatement ps = con.prepareStatement
        ("INSERT INTO `banco`.`usuario` (`dni`, `password`, `nombre`, `email`, `activo`, `rol`, `fecha_alta`) VALUES (?,?,?,?,?,?,?);");) {
           
            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getEmail());
            ps.setBoolean(5, usuario.isActivo());
            ps.setString(6, usuario.getRol().toString());
            ps.setDate(7, Date.valueOf(usuario.getFechaAlta()));
            n += ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public Usuario buscar(String dni) throws DaoException {
        Usuario usuario = null;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE dni=?");) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario=new Usuario();
                usuario.setDni(rs.getString("dni"));
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
    public void borrar(String dni) throws DaoException {
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement
        ("DELETE FROM usuario WHERE dni = ?");) {
            ps.setString(1, dni);
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void modificar(Usuario usuario) throws DaoException {
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("UPDATE usuario SET nombre=?, email=? WHERE dni=? ");) {
            ps.setString(3, usuario.getDni());
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public List<Usuario> listar() throws DaoException {
        Usuario usuario;
        List<Usuario> listado = null;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario"); ResultSet rs = ps.executeQuery();) {
            listado = new ArrayList<>();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setActivo(rs.getBoolean("activo"));
                usuario.setRol(TipoUsuario.valueOf(rs.getString("rol")));
                usuario.setFechaAlta(rs.getDate("fecha_alta").toLocalDate());
                if (rs.getTimestamp("ultimo_acceso")!= null) {
                   usuario.setUltimoAcceso(rs.getTimestamp("ultimo_acceso").toLocalDateTime()); 
                }                
                listado.add(usuario);
            }
 
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }        
        return listado;    
    }
    
}
