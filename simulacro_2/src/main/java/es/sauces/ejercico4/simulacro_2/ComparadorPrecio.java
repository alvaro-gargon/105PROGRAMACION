/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.simulacro_2;

import java.util.Comparator;

/**
 *
 * @author alvaro.gargon.4
 */
public class ComparadorPrecio implements Comparator<Inmueble>{

    @Override
    public int compare(Inmueble o1, Inmueble o2) {
        return Float.compare(o1.getPrecio(), o2.getPrecio());
    }
    
}
