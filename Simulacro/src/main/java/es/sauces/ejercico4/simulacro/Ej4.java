/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.simulacro;

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
       int [] vector;
       float mediana;
       int n1;
       vector = new int [10];
        for(int i=0;i<vector.length;i++){
            vector[i]=aleatorio.nextInt(101);
        }
       Arrays.sort(vector);
       mediana=(float) ((vector[vector.length/2]+vector[vector.length/2+1])/2.0);
       System.out.println("La mediana es: "+mediana);
    } 
}