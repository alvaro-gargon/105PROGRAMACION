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
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int [] vector;
        int nota;
        vector = new int[11];
        System.out.println("Introduce numeros entre 0 y 10 para poner notas, otro numero saldra de la aplicacion");
        nota=teclado.nextInt();
        while(nota<=10 && nota>=0){
            vector[nota]=vector[nota]+1;
            System.out.println("Introduce numeros entre 0 y 10 para poner notas, otro numero saldra de la aplicacion");
            nota=teclado.nextInt();
        }
        for(int i=0;i<vector.length;i++){
            System.out.println("La calificacion "+i+" ha aparecido "+vector[i]+" veces");
        }
    }
}
