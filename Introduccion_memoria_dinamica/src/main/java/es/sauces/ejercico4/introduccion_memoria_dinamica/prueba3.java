/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.introduccion_memoria_dinamica;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author alvaro.gargon.4
 */
public class prueba3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<String> conjunto;
        Iterator<String> iterador;
        conjunto=new TreeSet<>(Comparator.reverseOrder());
        
        conjunto.add("d");
        conjunto.add("c");
        conjunto.add("c");
        conjunto.add("b");
        conjunto.add("a");
        conjunto.add("e");
        
        for(String elemento:conjunto){
            System.out.println(elemento);
        }
        
        /*
        for(int i=0;lista.size();i++){
            System.out.println(lista.get(i));
        }
        */
       
    }
    
}
