/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.introduccion_memoria_dinamica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alvaro.gargon.4
 */
public class Mapas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer,String> mapa;
        
        mapa=new HashMap<>();
        
        mapa.put(1,"uno");
        mapa.put(2, "dos");
        mapa.put(3, "tres");
        System.out.println(mapa.get(2));
    }    
}