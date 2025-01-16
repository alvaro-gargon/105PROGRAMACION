/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

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
        int vocal,consonante,totalPalabras;
        String frase,palabra;
        Character a;
        totalPalabras=0;
        System.out.println("Introduce una cadena");
        frase=teclado.nextLine();
        frase=frase.toLowerCase();
        StringTokenizer tokens = new StringTokenizer(frase);
       while(tokens.hasMoreTokens()){
           palabra=tokens.nextToken();
           vocal=0;
           consonante=0;
        for(int i=0;i<palabra.length();i++){
            a=palabra.charAt(i);
                if(esVocal(a)){
                   vocal++;
                }
                else{
                    consonante++;
                }
        }
        if(vocal==consonante){
            totalPalabras++;
        }
       }
        System.out.println("Numero de palabras con la misma cantidad de vocales y consonantes: "+totalPalabras);
    }
    
    private static boolean esVocal(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
    
}

