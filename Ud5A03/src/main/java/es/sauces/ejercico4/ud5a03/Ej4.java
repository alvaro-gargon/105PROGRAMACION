/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a03;

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
        int [] vector;
        int [] vector2;
        vector=new int [10];
        Random aleatorio=new Random();
        for(int i=0;i<vector.length;i++){
            vector[i]=aleatorio.nextInt(101);
        }
        vector2=Arrays.copyOf(vector,vector.length);
        Arrays.sort(vector);
        System.out.println(Arrays.toString(vector));
        System.out.println(Arrays.toString(vector2));
    }
    
}
