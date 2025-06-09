/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

import controlador.Controlador;
import java.util.logging.Logger;
import modelo.AgenciaAlquiler;
import vista.Ventana;

/**
 *
 * @author marcos.fergar
 */
public class AppAlquilerMVC {
private static final Logger LOG = Logger.getLogger("es.sauces.Agenda");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        AgenciaAlquiler modelo=new AgenciaAlquiler("Alquiler de Vehiculos");
        Ventana vista=new Ventana();
        Controlador controlador=new Controlador(vista,modelo);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
}
