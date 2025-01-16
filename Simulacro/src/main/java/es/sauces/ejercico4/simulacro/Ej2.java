/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.simulacro;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner teclado=new Scanner (System.in);
       String cadena,palabra,auxp;
       StringTokenizer tokens;
       System.out.println("Introduce una oracion");
       cadena=teclado.nextLine();
       tokens = new StringTokenizer(cadena);
       palabra=tokens.nextToken();
       while(tokens.hasMoreTokens()){
           auxp=tokens.nextToken();
          if(auxp.length()>palabra.length()){
              palabra=auxp;
          }
       }
       System.out.println("La palabra mas larga es: "+palabra);
    }
}
