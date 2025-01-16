/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        Integer [] vector;
        vector=new Integer [10];
        for(int i=0;i<10;i++){
            System.out.println("Dame numeros");
            vector[i]=teclado.nextInt();
        }
        Arrays.sort(vector,Comparator.reverseOrder());
        
        System.out.println(Arrays.toString(vector));
    }
    
}
