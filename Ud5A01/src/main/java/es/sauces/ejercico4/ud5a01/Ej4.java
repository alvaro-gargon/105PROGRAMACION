/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud5a01;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        String [] vector;
        String nombre;
        vector = new String [5];
        for(int i=0;i<vector.length;i++){
            System.out.println("Introduce nombre");
            vector[i]=teclado.nextLine();
        }
        System.out.println("Dame tu nombre para buscarlo");
        nombre=teclado.nextLine();
        if(buscarNombre(vector,5,nombre)<0){
            System.out.println("No hemos encontrado el nombre");
        }else{
        System.out.println("El nombre estaba en la posicion "+(buscarNombre(vector,5,nombre)+1));
        }
    }
    public static int buscarNombre(String [] v, int numElementos, String nombre){
        int pos;
        pos=-1;
        for(int i=0;i<v.length && pos==-1;i++){
            if(v[i].equals(nombre)){
                pos=i;
            }
        }
        return pos;
    }
    }