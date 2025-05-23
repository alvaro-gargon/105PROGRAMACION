/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.appud10;

import es.sauces.appud10.controlador.Controlador;
import es.sauces.appud10.modelo.Banco;
import es.sauces.appud10.modelo.ConexionBD;
import es.sauces.appud10.modelo.CuentaDao;
import es.sauces.appud10.modelo.CuentaDaoJdbc;
import es.sauces.appud10.vista.Ventana;

/**
 *
 * @author Ambrosio
 */
public class AppBanco {

    public static void main(String[] args) {
        Banco modelo = new Banco("BANCO SAUCES");
        ConexionBD conexionBD = ConexionBD.getConexionBD("conexion.properties");
        CuentaDao cuentaDao = new CuentaDaoJdbc(conexionBD);
        modelo.setDao(cuentaDao);
        Ventana vista = new Ventana();
        Controlador controlador = new Controlador(vista, modelo);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
}
