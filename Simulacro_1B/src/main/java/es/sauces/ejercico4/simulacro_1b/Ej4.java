/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.simulacro_1b;

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
	int menor,mayor ;
	vector= new int[10];
	for(int i=0;i<vector.length;i++){
            vector[i]=aleatorio.nextInt(101);
        }
	System.out.println(Arrays.toString(vector));
	menor=vector[0];
	mayor=vector[0];
	for(int i=0;i<vector.length;i++){
            if(vector[i]>mayor){
                mayor=vector[i];
            }
            if(vector[i]<menor){
                menor=vector[i];
            }
        }
        System.out.println("El rango es: "+(mayor-menor));
		
    }
    
}
