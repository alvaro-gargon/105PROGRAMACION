/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

import controlador.Controlador;
import modelo.SistemaNominas;
import vista.Ventana;

/**
 *
 * @author alvaro.gargon.4
 */
public class AppSistemaNominasMvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana vista=new Ventana();
        SistemaNominas modelo=new SistemaNominas();
        Controlador controlador= new Controlador(vista,modelo);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
    
}
