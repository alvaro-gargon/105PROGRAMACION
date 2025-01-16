/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        int num,menor,mayor;
        float acum;
        acum=0;
        menor=10;
        mayor=0;
        for(int i=0;i<5;i++){
            System.out.println("Dame un numero");
            num=teclado.nextInt();
            while(num<0 || num>10){
                System.out.println("Error en la entrada");
                System.out.println("Dame un numero");
                num=teclado.nextInt();
            }
            acum=acum+num;
            if(num>mayor){
                mayor=num;
            }
            if(num<menor){
                menor=num;
            }
        }
        System.out.println("La media acotada es: "+(acum-mayor-menor)/3.0);
    }
}
