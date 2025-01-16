/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a02;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int [][] matriz;
        matriz=new int[3][2];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.println("Introduzca sus numeros");
                matriz[i][j]=teclado.nextInt();
            }
        }
        System.out.println(mostrarMatriz(matriz));
        System.out.println(trasponerMatriz(matriz));
    }
    public static String mostrarMatriz(int [][] m){
        for(int i=0;i<m.length;i++){
            System.out.println("");
            for(int j=0;j<m[i].length;j++){
                System.out.print(m[i][j]+" ");
            }
        }
        return "";
    }
    public static String trasponerMatriz(int [][] m){
        for(int j=0;j<m[0].length;j++){
            System.out.println("");
            for(int i=0;i<m.length;i++){
                System.out.print(m[i][j]+" ");
            }
        }
        return "";
    }
    
}
