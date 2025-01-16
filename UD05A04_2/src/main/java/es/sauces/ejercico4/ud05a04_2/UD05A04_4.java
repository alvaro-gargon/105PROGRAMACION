/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud05a04_2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author alvaro.gargon.4
 */
public class UD05A04_4 {

    public static void main(String[] args) {
         Scanner teclado = new Scanner(System.in);
        int opcion,num;
        TreeSet<Integer> conjunto;
        conjunto = new TreeSet<>();
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
                num = LeerNumeros();
                conjunto.add(num);
            } else {
                if (!conjunto.isEmpty()) {
                    switch (opcion) {

                        case 2 -> {
                            System.out.println(conjunto.toString());
                        }
                        case 3 -> {
                            System.out.println("El tamaño es: "+conjunto.size());
                            
                        }
                        case 4 -> {
                            System.out.println("El ultimo numero es: "+conjunto.getFirst());
                            System.out.println("El ultimo numero es: "+conjunto.getLast());
                        }
                        case 5 -> {
                           System.out.println("Introduce el numero que quieres buscar");
                            num=teclado.nextInt();
                            if(conjunto.contains(num)){
                                System.out.println("El numero se encuentra en el conjunto");
                            }else{
                                System.out.println("El numero no se encuentra en el conjunto");
                            }
                        }
                        case 6 -> {
                            System.out.println("Dame un numero para borrar del conjunto");
                            num=teclado.nextInt();
                            if(conjunto.remove(num)){
                            System.out.println("Eliminado");
                            }else{
                                System.out.println("El numero no esta en el conjunto");
                            }
                        }
                        case 7 -> {
                            conjunto.clear();
                            System.out.println("Todos los elementos han sido eliminados");
                        }
                        
                    }
                }else{System.out.println("Lista vacia");}
            }
            }while (opcion != 0);
    }
     private static int LeerNumeros() {
        int n;
        System.out.println("Introduzca un numero (0-10)");
        Scanner teclado = new Scanner(System.in);
        n = teclado.nextInt();
        while (n > 10 || n < 0) {
            System.out.println("Rango de numero incorrecto");
            System.out.println("Introduzca un numero (0-10)");
            n = teclado.nextInt();
        }
        return n;
    }
}
