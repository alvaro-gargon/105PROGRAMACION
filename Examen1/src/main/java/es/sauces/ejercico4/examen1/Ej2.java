/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

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
        int num,pos,numCeros,numaux;
        pos=0;
        numCeros=0;
        boolean tieneCero=false;
        System.out.println("Introduce un numero");
        num=teclado.nextInt();
        while(num!=999){
            if(num<=0){
                System.out.println("Error en la entrada");
            }else{
                numaux=num;
                pos=0;
                tieneCero=false;
                while(numaux!=0 && !tieneCero){  
                   if(numaux%10==0){
                       tieneCero=true;
                    }
                   numaux=numaux/10;
                   pos++;
                }
            }
            if(tieneCero){
                System.out.println("El numero "+num+ " tiene 0 en la posicion "+pos);
                numCeros++;
            }else{
                System.out.println("El numero "+num+ " no tiene 0");
            }
            System.out.println("Introduce un numero");
            num=teclado.nextInt();
        }
        System.out.println("Numeros positivos introducidos que contienen 0: "+numCeros);
    }
    
}
