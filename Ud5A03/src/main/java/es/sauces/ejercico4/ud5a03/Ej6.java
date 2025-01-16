/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a03;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        int [] v1;
        int [] v2;
        v1= new int[5];
        v2= new int[5];
        for(int i=0;i<v1.length;i++){
            System.out.println("Dame numeros");
            v1[i]=teclado.nextInt();
        }
        System.out.println("Primer vector rellenado");
        for(int i=0;i<v2.length;i++){
            System.out.println("Dame numeros");
            v2[i]=teclado.nextInt();
        }
        System.out.println("Segundo vector rellenado");
        if(Arrays.compare(v1, v2)==0){
            System.out.println("Los vectores son iguales");
        }
    }
    
}
