/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.simulacro_1b;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) {
       Scanner teclado=new Scanner (System.in);
       int num,cont,acum;
       System.out.println("Introduce un numero");
       num=teclado.nextInt();
       cont=0;
       while(num>0){
           acum=0;
           cont++;
           while(num!=0){
           acum=acum+(num%10);
           num=num/10;
           }
           System.out.println("Suma de digitos: "+acum);
           System.out.println("Introduce un numero");
           num=teclado.nextInt();
       }
       
       System.out.println("Numeros positivos: "+cont);

    }
}
