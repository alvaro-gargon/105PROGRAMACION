/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud5a03;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) {
        int cont;
        float acum;
        acum=0;
        cont=0;
        for(String argumento:args){
            System.out.println(argumento);
            acum=acum+Integer.parseInt(argumento);
            cont++;
        }
        System.out.println("La media es: "+acum/cont);
    }
}
