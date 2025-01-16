/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a02;

import java.util.Arrays;
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
        
        float num;
        float [][] matriz;
        matriz=new float[3][2];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.println("Introduzca sus numeros");
                matriz[i][j]=teclado.nextFloat();
            }
        }
        System.out.println(mostrarMatriz(matriz));
        System.out.println("Introduce el numero que quieres buscar");
        num=teclado.nextFloat();
        
        if(buscarPosicion(matriz,num)[0]>0){
            System.out.println("Hemos encontrado tu numero");
            System.out.println("Y esta en la posicion: "+Arrays.toString(buscarPosicion(matriz, num)));
        }else{
            System.out.println("No hemos encontrado tu numero");
        }
    }
    public static String mostrarMatriz(float [][] m){
        for(int i=0;i<m.length;i++){
            System.out.println("");
            for(int j=0;j<m[i].length;j++){
                System.out.print(m[i][j]+" ");
            }
        }
        return "";
    }
    public static int[] buscarPosicion(float [][]m,float num){
        int [] posicion=new int[2];
        posicion[0]=-1;
        posicion[1]=-1;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                if(m[i][j]==num){
                    posicion[0]=i;
                    posicion[1]=j;
                }
            }
        }
        return posicion;
    }
}
