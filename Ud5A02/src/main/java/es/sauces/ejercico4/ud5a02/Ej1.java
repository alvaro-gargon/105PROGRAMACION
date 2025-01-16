/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud5a02;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        boolean esPositiva;
        int [][] matriz;
        matriz=new int[3][2];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.println("Introduzca sus numeros");
                matriz[i][j]=teclado.nextInt();
            }
        }
        esPositiva=true;
        for(int i=0;i<matriz.length && esPositiva;i++){
            for(int j=0;j<matriz[i].length && esPositiva;j++){
                if(matriz[i][j]<0){
                    esPositiva=false;
                }
            }
        }
        if(esPositiva){
            System.out.println("Matriz positiva");
        }else{
            System.out.println("Matriz no positiva");
        }
    }
}
