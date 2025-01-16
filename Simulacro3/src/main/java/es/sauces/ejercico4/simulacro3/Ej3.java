/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.simulacro3;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        String frase,palabra;
        Character primeraLetra;
        Boolean tautograma;
        tautograma=true;
        System.out.println("Dame una frase y te digo si es un tautograma");
        frase=teclado.nextLine();
        StringTokenizer tokens = new StringTokenizer(frase);
        primeraLetra=tokens.nextToken().charAt(0);
        primeraLetra=Character.toLowerCase(primeraLetra);
        while(tokens.hasMoreTokens() && tautograma){
            palabra=tokens.nextToken();
            if(palabra.startsWith(primeraLetra.toString())){
                tautograma=true;
            }else{
                tautograma=false;
            }
        }
        if(tautograma){
            System.out.println("Tautograma");
        }else{
            System.out.println("No");
        }
    }
    
}
