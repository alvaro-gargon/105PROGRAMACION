/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.testeedd;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class TestEEDD {

    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int num,num1;
        System.out.println("Dame dos numeros!");
        num=teclado.nextInt();
        num1=teclado.nextInt();
        System.out.println("El resultado de la suma es: "+(num+num1));
    }
}
