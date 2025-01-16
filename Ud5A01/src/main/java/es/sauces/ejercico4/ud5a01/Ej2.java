/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud5a01;

import static es.sauces.ejercico4.ud5a01.Ej1.contarNegativos;
import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej2 {

    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int [] vector;
        vector = new int[5];
        for(int i=0;i<vector.length;i++){
            System.out.println("Introduce numero");
            vector[i]=teclado.nextInt();
        }
        System.out.println(sacarMedia(vector,5));
    }
    public static float sacarMedia(int [] v, int numElementos){
        int cont;
        float sacarMedia,acum;
        cont=0;
        acum=0;
        for(int i=0;i<v.length;i++){
            acum=acum+v[i];
            cont++;
        }
        sacarMedia=acum/cont;
        return sacarMedia;
}
}
