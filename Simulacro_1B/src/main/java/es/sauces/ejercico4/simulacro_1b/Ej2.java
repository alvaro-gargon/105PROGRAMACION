/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.simulacro_1b;

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
       String cadena,palabra;
       System.out.println("Introduce una oracion con #");
       cadena=teclado.nextLine();
       StringTokenizer tokens = new StringTokenizer(cadena);
       while(tokens.hasMoreTokens()){
           palabra=tokens.nextToken();
          if(palabra.startsWith("#")){
              System.out.println(palabra);
          }
       }
    }
    
}
