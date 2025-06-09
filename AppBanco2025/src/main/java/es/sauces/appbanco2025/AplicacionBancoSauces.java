/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package es.sauces.appbanco2025;

import es.sauces.appbanco2025.controlador.Controlador;
import es.sauces.appbanco2025.dao.ConexionBD;
import es.sauces.appbanco2025.dao.GestorDao;
import es.sauces.appbanco2025.vista.Ventana;

/**
 *
 * @author Ambrosio
 */
public class AplicacionBancoSauces {

    public static void main(String[] args) {
        GestorDao modelo=new GestorDao(ConexionBD.getConexionBD("conexion.properties"));        
        Ventana vista=new Ventana();
        Controlador controlador=new Controlador(vista,modelo);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
}
