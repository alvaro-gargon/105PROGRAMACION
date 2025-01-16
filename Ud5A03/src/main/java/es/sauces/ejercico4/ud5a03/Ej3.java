/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a03;

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
        System.out.println(calcularMedia(14,20,45));
        System.out.println(calcularMedia(21,7,19));
        System.out.println(calcularMedia(4,5,5));
    }
    public static float calcularMedia(int... param){
        float acum,media;
        acum=0;
        for(int i=0;i<param.length;i++){
            acum=acum+param[i];
        }
        media=acum/param.length;
        return media;
    }
}
