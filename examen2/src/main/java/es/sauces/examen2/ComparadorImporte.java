/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

import java.util.Comparator;

/**
 *
 * @author alvaro.gargon.4
 */
public class ComparadorImporte implements Comparator<Consumo>{

    @Override
    public int compare(Consumo o1, Consumo o2) {
       return Float.compare(o1.getImporte(), o2.getImporte());
    }
    
}
