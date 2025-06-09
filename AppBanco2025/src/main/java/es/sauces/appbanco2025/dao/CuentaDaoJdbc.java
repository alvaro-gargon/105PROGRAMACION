/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appbanco2025.dao;

import es.sauces.appbanco2025.modelo.Cuenta;
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
public class CuentaDaoJdbc implements CuentaDao{
    private ConexionBD conexionBD;

    public CuentaDaoJdbc(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void insertar(Cuenta cuenta) throws DaoException {
        int n=0;
        try (Connection con = conexionBD.getConnection(); 
            PreparedStatement ps = con.prepareStatement
        ("INSERT INTO `banco`.`cuenta` (`codigo`, `titular`, `saldo`) VALUES (?,?,?);");) {
            ps.setString(1, cuenta.getCodigo());
            ps.setString(2, cuenta.getTitular().getDni());
            ps.setFloat(3, cuenta.getSaldo());
            n += ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void modificar(Cuenta cuenta) throws DaoException {
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("UPDATE cuenta SET saldo=? WHERE codigo=? ");) {
            ps.setString(2, cuenta.getCodigo());
            ps.setFloat(1, cuenta.getSaldo());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void borrar(String codigo) throws DaoException {
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement
        ("DELETE FROM cuenta WHERE codigo = ?");) {
            ps.setString(1, codigo);
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public Cuenta buscar(String codigo) throws DaoException {
        Cuenta cuenta = null;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM cuenta WHERE codigo=?");) {
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cuenta=new Cuenta();
                cuenta.setCodigo(codigo);
                cuenta.setSaldo(rs.getFloat("saldo"));
            }

        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } 
        return cuenta;
    }

    @Override
    public List<Cuenta> listar() throws DaoException {
        Cuenta cuenta;
        List<Cuenta> listado = null;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM cuenta"); ResultSet rs = ps.executeQuery();) {
            listado = new ArrayList<>();
            while (rs.next()) {
                cuenta = new Cuenta();
                cuenta.setCodigo(rs.getString("codigo"));
                cuenta.setSaldo(rs.getFloat("saldo"));                
                listado.add(cuenta);
            }
 
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }        
        return listado;
    }
 
    @Override
    public List<Cuenta> listar(String titular) throws DaoException {
    Cuenta cuenta;
        List<Cuenta> listado = null;
        try (Connection con = conexionBD.getConnection(); 
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cuenta where titular=?");
                ) {
            ps.setString(1, titular);
            ResultSet rs = ps.executeQuery();
            listado = new ArrayList<>();
            
            while (rs.next()) {
                
                cuenta = new Cuenta();
                cuenta.setCodigo(rs.getString("codigo"));
                cuenta.setSaldo(rs.getFloat("saldo"));                
                listado.add(cuenta);
            }
 
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }        
        return listado;
    }
    
}
