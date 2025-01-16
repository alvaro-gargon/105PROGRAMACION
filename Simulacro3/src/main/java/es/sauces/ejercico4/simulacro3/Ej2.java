/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.simulacro3;

import java.util.Scanner;

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
        int num,acum=0,numaux,cont;
        cont=0;
        while(cont<3){
            System.out.println("Introduce un numero");
            num=teclado.nextInt();
            while(num<0){
                System.out.println("Introduce un numero");
                num=teclado.nextInt();
            }
            numaux=num;
            while(numaux>0){
                acum=0;
                while(numaux!=0){
                    acum=acum+(numaux%10);
                    numaux=numaux/10;
                }
            }
            if (num%acum==0){
                System.out.println("Es un numero Harshad");
                cont++;
            }else{
                System.out.println("No es un numero Harshad");
            }
        }
    }
    
}
