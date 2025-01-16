/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.simulacro;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        int num;
        System.out.println("Introduce un numero");
        num=teclado.nextInt();
        while(num<0){
            System.out.println("Introduce un numero");
            num=teclado.nextInt();
        }
        System.out.print(num+" ");
        while(num!=1){
            if (num%2==0){
                num=num/2;
            }else{
                num=num*3+1;
            }
            System.out.print(num+" ");
        }
    }
}
