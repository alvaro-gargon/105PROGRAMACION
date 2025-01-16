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
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        int [] vector;
        int num;
        vector=new int[10];
        for(int i=0;i<10;i++){
            System.out.println("Dame numeros");
            vector[i]=teclado.nextInt();
        }
        System.out.println("Dame un numero para buscarlo");
        num=teclado.nextInt();
        Arrays.sort(vector);
        if(Arrays.binarySearch(vector, num)<0){
            System.out.println("No hemos podido encontrar el numero");
        }else{
            System.out.println("Hemos encontrado el numero en la posicion: "+Arrays.binarySearch(vector, num)+1);
        }
        
    }
    
}
