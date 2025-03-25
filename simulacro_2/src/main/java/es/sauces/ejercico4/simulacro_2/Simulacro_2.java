/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.simulacro_2;

import java.io.IOException;
import java.util.logging.LogManager;

/**
 *
 * @author alvaro.gargon.4
 */
public class Simulacro_2 {

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(ClassLoader.getSystemClassLoader().getResourceAsStream("mylogging.properties"));
        
        Inmobiliaria i=new Inmobiliaria();
    }
}
