/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a01;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int [] vector;
        vector = new int[5];
        for(int i=0;i<vector.length;i++){
            System.out.println("Introduce numero");
            vector[i]=teclado.nextInt();
        }
        System.out.println(contarNegativos(vector,5));
    }
    public static int contarNegativos( int[] vector,int numElementos){
        int cont=0;
        for(int i=0;i<vector.length;i++){
            if(vector[i]<0){
                cont++;
            }
        }
        return cont;
    }
    
}
