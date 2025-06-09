/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.appbanco2025.dao;

/**
 *
 * @author usuario
 */
public class GestorDao {
    private ConexionBD conexion;
    private UsuarioDao usuarioDao;
    private CuentaDao cuentaDao;
    private MovimientoDao movimientoDao;

    public GestorDao(ConexionBD conexion) {
        this.conexion = conexion;
        usuarioDao=new UsuarioDaoJdbc(conexion);
        cuentaDao=new CuentaDaoJdbc(conexion);
        movimientoDao=new MovimientoDaoJdbc(conexion);
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public CuentaDao getCuentaDao() {
        return cuentaDao;
    }

    public MovimientoDao getMovimientoDao() {
        return movimientoDao;
    }
       
}
