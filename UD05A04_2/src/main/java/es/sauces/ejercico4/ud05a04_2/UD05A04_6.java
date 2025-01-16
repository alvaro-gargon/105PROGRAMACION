/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud05a04_2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author alvaro.gargon.4
 */
public class UD05A04_6 {

    public static void main(String[] args) {
         Scanner teclado = new Scanner(System.in);
        int opcion;
        String clave,valor;
        TreeMap<String,String> mapa;
        mapa = new TreeMap<>();
        do {
            System.out.println("1.- Añadir un entero solicitado por teclado");
            System.out.println("2.- Mostrar el contenido por pantalla");
            System.out.println("3.- Solicitar un entero por teclado e insertarlo en la primera posicion");
            System.out.println("4.- Mostrar el contenido por pantalla en orden inverso");
            System.out.println("5.- Mostrar por pantalla el número de elementos que tiene el ArrayList");
            System.out.println("6.- Mostrar por pantalla la media de los números contenidos");
            System.out.println("7.- Solicitar una posición por teclado y cambiar el entero que ocupe dicha posición por 0");
            System.out.println("0.- Salir");
            System.out.print("Escoja la opcion deseada: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion == 1) {
                System.out.println("Introduce la clave del color y su nombre");
                clave=teclado.nextLine();
                valor=teclado.nextLine();
                mapa.put(clave, valor);
            } else {
                if (!mapa.isEmpty()) {
                    switch (opcion) {

                        case 2 -> {
                            System.out.println(mapa.toString());
                        }
                        case 3 -> {
                            System.out.println("El primer codigo es: "+mapa.firstKey());
                            System.out.println("El ultimo codigo es: "+mapa.lastKey());
                        }
                        case 4 -> {
                            System.out.println(mapa.firstEntry());
                        }
                        case 5 -> {
                            System.out.println(mapa.entrySet());
                        }
                        case 6 -> {
                            mapa.clear();
                            System.out.println("Mapa eliminado");
                        }
                    }
                }else{System.out.println("Lista vacia");}
            }
        }while (opcion != 0);
    }
}
