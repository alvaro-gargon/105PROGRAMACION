/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.appusuarios;

import controlador.ControladorUsuarios;
import dao.DaoException;
import dao.UsuarioDao;
import dao.UsuarioDaoJbdc;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import vista.VentanaUsuarios;

/**
 *
 * @author alvaro.gargon.4
 */
public class AppGestionUsuarios {

    public static void main(String[] args) {
        ConexionBD conexionBD = ConexionBD.getConexionBD("conexion.properties");
        UsuarioDao modelo = new UsuarioDaoJbdc(conexionBD);
        VentanaUsuarios vista = new VentanaUsuarios();
        ControladorUsuarios controlador = new ControladorUsuarios(vista, modelo);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
}
