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
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int [][] matriz;
        matriz=new int[2][3];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.println("Introduzca sus numeros");
                matriz[i][j]=teclado.nextInt();
            }
        }
        System.out.println(mostrarMatriz(matriz));
        System.out.println("La media de la matriz es: "+calcularMedia(matriz));
        System.out.println("El menor  esta en la posicion"+Arrays.toString(buscarPosicionMenor(matriz))+" y es el numero "+buscarMenor(matriz));
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
    public static float calcularMedia(int [][]m){
        float media,acum;
        int cont;
        cont=0;
        acum=0;
         for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                acum=acum+m[i][j];
                cont++;
            }
        }
         media=acum/cont;
        return media;
    }
    public static int buscarMenor(int [][]m){
        int menor;
        menor=m[0][0];
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                if(m[i][j]<menor){
                    menor=m[i][j];
                }
            }
        }
        return menor;
    }
    public static int[] buscarPosicionMenor(int [][]m){
        int menor;
        int [] posicion=new int[2];
        menor=m[0][0];
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                if(m[i][j]<menor){
                    menor=m[i][j];
                    posicion[0]=i;
                    posicion[1]=j;
                }
            }
        }
        return posicion;
    }
}
