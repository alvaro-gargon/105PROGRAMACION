/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appud10.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ambrosio
 */
public class CuentaDaoJdbc implements CuentaDao {

    private ConexionBD conexionBD;

    public CuentaDaoJdbc(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<Cuenta> listar() throws DaoException {
        List<Cuenta> listado = null;
        try (Connection con = conexionBD.getConnection(); 
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cuenta"); 
            ResultSet rs = ps.executeQuery();) {
            listado = new ArrayList<>();
            while (rs.next()) {
                listado.add(new Cuenta(rs.getString("codigo"), rs.getString("titular"), rs.getFloat("saldo")));
            }

        } catch (SQLException | SaldoException ex) {
            throw new DaoException(ex.getMessage());
        }
        return listado;
    }

    @Override
    public int insertar(List<Cuenta> listado) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta buscar(String codigo) throws DaoException {
        Cuenta c = null;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM cuenta WHERE codigo=?");) {
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cuenta(rs.getString("codigo"), rs.getString("titular"), rs.getFloat("saldo"));
            }

        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } catch (SaldoException ex) {
            Logger.getLogger(CuentaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }

    @Override
    public int insertar(Cuenta cuenta) throws DaoException {
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("INSERT INTO cuenta VALUES (?,?,?) ");) {

            ps.setString(1, cuenta.getCodigo());
            ps.setString(2, cuenta.getTitular());
            ps.setFloat(3, cuenta.getSaldo());
            n += ps.executeUpdate();

        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return n;
    }

    @Override
    public int borrar(String codigo) throws DaoException {
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("DELETE FROM cuenta WHERE codigo = ?");) {
            ps.setString(1, codigo);
            n = ps.executeUpdate();

        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return n;
    }

    @Override
    public int modificar(Cuenta cuenta) throws DaoException {
        int n = 0;
        try (Connection con = conexionBD.getConnection(); PreparedStatement ps = con.prepareStatement("UPDATE cuenta SET saldo=? WHERE codigo=? ");) {
            ps.setString(2, cuenta.getCodigo());
            ps.setFloat(1, cuenta.getSaldo());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return n;
    }

}
