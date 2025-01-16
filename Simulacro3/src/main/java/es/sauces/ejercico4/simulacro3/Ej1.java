/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.simulacro3;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        int c1,c2;
        float h;
        System.out.println("Dame los catetos");
        c1=teclado.nextInt();
        c2=teclado.nextInt();
        h=(float) Math.sqrt(c1*c1+c2*c2);
        System.out.println("La hipotenusa es: "+h);
        System.out.println("El area es: "+(c1*c2)/2f);
        System.out.println("El perimetro es: "+(c1+c2+h));
    }
}
