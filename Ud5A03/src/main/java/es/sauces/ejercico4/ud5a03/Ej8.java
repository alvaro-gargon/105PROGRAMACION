/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int indice1,indice2,indice3;
        Integer [] v1;
        Integer [] v2;
        Integer [] v3;
        v1=new Integer [10];
        v2=new Integer [10];
        v3=new Integer [v1.length+v2.length];
        Random aleatorio=new Random();
        for(int i=0;i<v1.length;i++){
            v1[i]=aleatorio.nextInt(101);
        }
        for(int i=0;i<v2.length;i++){
            v2[i]=aleatorio.nextInt(101);
        }
        Arrays.sort(v1,Comparator.reverseOrder());
        Arrays.sort(v2,Comparator.reverseOrder());
        indice1=0;
        indice2=0;
        indice3=0;
        while(indice1<v1.length && indice2<v2.length){
        if(v1[indice1]>v2[indice2]){
            v3[indice3]=v1[indice1];
            indice1++;
        }else{
            v3[indice3]=v2[indice2];
            indice2++;  
        }
        indice3++;
        }
        while(indice1<v1.length){
            v3[indice3]=v1[indice1];
            indice1++;
            indice3++;
        }
        while(indice2<v1.length){
            v3[indice3]=v2[indice2];
            indice2++;
            indice3++;
        }
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
        System.out.println(Arrays.toString(v3));
    }
}
