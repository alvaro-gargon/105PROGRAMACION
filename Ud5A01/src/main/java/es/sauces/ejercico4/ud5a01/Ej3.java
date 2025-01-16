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
public class Ej3 {

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
        System.out.println("El menor es: "+vector[buscarMenor(vector,5)]+" y esta en la posicion: "+(buscarMenor(vector,5)+1));
    }
    public static int buscarMenor(int [] v, int numElementos){
        int pos;
        pos=0;
        for(int i=0;i<v.length;i++){
            if(v[i]<v[pos]){
                pos=i;
            }
        }
        
        return pos;
    }
    
}
