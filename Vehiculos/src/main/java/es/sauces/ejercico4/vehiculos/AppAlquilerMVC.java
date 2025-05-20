/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

import controlador.Controlador;
import modelo.AgenciaAlquiler;
import vista.Ventana;

/**
 *
 * @author alvaro.gargon.4
 */
public class AppAlquilerMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana vista=new Ventana();
        AgenciaAlquiler agenciaAlquiler=new AgenciaAlquiler("Alquiler de vehiculos");
        Controlador controlador= new Controlador(vista,agenciaAlquiler);
        vista.setControlador(controlador);
        controlador.iniciar();
        
        
    }
    
}
