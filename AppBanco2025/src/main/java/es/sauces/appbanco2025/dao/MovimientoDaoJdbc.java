/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appbanco2025.dao;

import es.sauces.appbanco2025.modelo.Cuenta;
import es.sauces.appbanco2025.modelo.Movimiento;
import es.sauces.appbanco2025.modelo.TipoMovimiento;
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
public class MovimientoDaoJdbc implements MovimientoDao{
    private ConexionBD conexionBD;

    public MovimientoDaoJdbc(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void insertar(Movimiento movimiento, String codigoCuenta) throws DaoException {
        int n=0;
        try (Connection con = conexionBD.getConnection(); 
            PreparedStatement ps = con.prepareStatement
        ("INSERT INTO `banco`.`movimiento` ( `fecha`, `tipo`, `cantidad`, `saldo`, `codigo`) VALUES (?,?,?,?,?);");) {
           
            ps.setDate(1, Date.valueOf(movimiento.getFecha()));
            ps.setString(2, movimiento.getTipo().toString());
            ps.setFloat(3, movimiento.getCantidad());
            ps.setFloat(4, movimiento.getSaldo());
            ps.setString(5, codigoCuenta);
            n += ps.executeUpdate();

        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }

    }

    @Override
    public List<Movimiento> listar() throws DaoException {
        Movimiento movimiento;
        List<Movimiento> listado = new ArrayList<>();

        try (Connection con = conexionBD.getConnection(); 
                PreparedStatement ps = con.prepareStatement("SELECT * FROM movimiento"); 
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                movimiento = new Movimiento();
                movimiento.setCantidad(rs.getFloat("cantidad"));
                movimiento.setFecha(rs.getDate("fecha").toLocalDate());
                movimiento.setSaldo(rs.getFloat("saldo"));
                movimiento.setTipo(TipoMovimiento.valueOf(rs.getString("tipo")));
                listado.add(movimiento);
            }
 
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }        
        return listado;
    }

    @Override
    public List<Movimiento> listar(String codigoCuenta) throws DaoException {
        Movimiento movimiento;
        List<Movimiento> listado =  new ArrayList<>();
        try (Connection con = conexionBD.getConnection(); 
                PreparedStatement ps = con.prepareStatement("SELECT * FROM movimiento where codigo=?"); 
                ) {
            ps.setString(1, codigoCuenta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                movimiento = new Movimiento();
                movimiento.setCantidad(rs.getFloat("cantidad"));
                movimiento.setFecha(rs.getDate("fecha").toLocalDate());
                movimiento.setSaldo(rs.getFloat("saldo"));
                movimiento.setTipo(TipoMovimiento.valueOf(rs.getString("tipo")));
                listado.add(movimiento);
            }
 
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }        
        return listado;
    }
    
}
