/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a01;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] vector;
        int aux;
        Random aleatorio=new Random();
        vector= new int [10];
        for(int i=0;i<vector.length;i++){
            vector[i]=aleatorio.nextInt(100);
        }
        System.out.println("Vector original");
        System.out.println(Arrays.toString(vector));
        aux=0;
        for(int i=0,j=9;i<vector.length;i++,j--){
            aux=vector[i];
            vector[i]=vector[j];
            vector[j]=aux;
        }
        System.out.println("Vector invertido");
        System.out.println(Arrays.toString(vector));
    }
    
}
