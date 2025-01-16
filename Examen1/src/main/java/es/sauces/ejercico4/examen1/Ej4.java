/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.examen1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random aleatorio=new Random();
        int [] vector, vectorFrecuencias;
        int frecuenciaMayor;
        
        vector =new int[10];
        for (int i=0;i<vector.length;i++){
            vector[i]=aleatorio.nextInt(6);
        }
        System.out.println(Arrays.toString(vector));
        
        vectorFrecuencias=new int[6];
        for (int i=0;i<vector.length;i++){
            vectorFrecuencias[vector[i]]++;
        }
        frecuenciaMayor=vectorFrecuencias[0];
        for (int i=1;i<vectorFrecuencias.length;i++){
            if(vectorFrecuencias[i]>frecuenciaMayor){
                System.out.println(i);
            }
        }
    }
    
}
