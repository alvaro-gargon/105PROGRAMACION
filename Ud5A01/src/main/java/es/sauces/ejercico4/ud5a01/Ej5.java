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
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int [] vector;
        vector = new int[5];
        for(int i=0;i<vector.length;i++){
            System.out.println("Introduce numero de forma ordenada descendiente");
            vector[i]=teclado.nextInt();
        }
        if(comprobarOrden(vector,5)){
            System.out.println("Vector ordenado");
        }else{
            System.out.println("Vector no ordenado");
        }
        
    }
    public static boolean comprobarOrden(int [] v, int numElementos){
       boolean estaOrdenado=true;
        for(int i=1;i<v.length && estaOrdenado ;i++){
            estaOrdenado = v[i] <= v[i-1];
        }
        return estaOrdenado;
    }
    
}
