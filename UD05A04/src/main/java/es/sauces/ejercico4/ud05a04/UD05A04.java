/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.ejercico4.ud05a04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */

public class UD05A04 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        ArrayList<Integer> lista;
        lista = new ArrayList<>();
        do {
            System.out.println("1.- Añadir un entero solicitado por teclado");
            System.out.println("2.- Mostrar el contenido por pantalla");
            System.out.println("3.- Solicitar una posición por teclado y mostrar por pantalla el entero que ocupa dicha posición");
            System.out.println("4.- Mostrar el contenido por pantalla en orden inverso");
            System.out.println("5.- Mostrar por pantalla el número de elementos que tiene el ArrayList");
            System.out.println("6.- Mostrar por pantalla la media de los números contenidos");
            System.out.println("7.- Solicitar una posición por teclado y cambiar el entero que ocupe dicha posición por 0");
            System.out.println("8.- Solicitar un entero por teclado y nos diga si se encuentra o no en el ArrayList");
            System.out.println("9.- Solicitar un entero por teclado y nos muestra la posición en la que está");
            System.out.println("10.- Solicitar un entero por teclado y lo elimina del ArrayList");
            System.out.println("0.- Salir");
            System.out.print("Escoja la opcion deseada: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion == 1) {
                int n;
                n = LeerNumeros();
                lista.add(n);
            } else {
                if (!lista.isEmpty()) {
                    switch (opcion) {

                        case 2 -> {
                            System.out.println(lista.toString());
                        }
                        case 3 -> {
                            int posicion;
                               System.out.println("Introduzca la posicion desea utilizar");
                                posicion = teclado.nextInt();
                                posicion = posicion - 1;
                                while (posicion < -1 || posicion > lista.size() - 1) {
                                    System.out.println("Posicion incorrecta");
                                    System.out.println("Introduzca la posicion desea utilizar");
                                    posicion = teclado.nextInt();
                                }
                                System.out.println(lista.get(posicion));
                        }
                        case 4 -> {
                            List<Integer> listaInvertida;
                            listaInvertida = new LinkedList<>();
                            lista = (ArrayList<Integer>) lista.reversed();
                            System.out.println(listaInvertida.toString());
                        }
                        case 5 -> {
                            System.out.println("El tamaño de la lista es: " + lista.size());
                        }
                        case 6 -> {
                            float acum;
                            int cont;
                            acum = 0;
                            cont = 0;
                            for (Integer elemento : lista) {
                                acum = acum + elemento;
                                cont++;
                            }
                            System.out.println("La media de la lista es: " + acum / cont);
                        }
                        case 7 -> {
                            int posicion;
                            System.out.println("Introduzca la posicion desea utilizar");
                            posicion = teclado.nextInt();
                            posicion = posicion - 1;
                            while (posicion < -1 || posicion > lista.size() - 1) {
                                System.out.println("Posicion incorrecta");
                                System.out.println("Introduzca la posicion desea utilizar");
                                posicion = teclado.nextInt();
                            }
                            lista.set(posicion, 0);
                        }
                        case 8 -> {
                            int n;
                            System.out.println("Dame un entero para buscar");
                            n=teclado.nextInt();
                            if(lista.contains(n)){
                                System.out.println("El numero esta en la lista");
                            }else{
                                System.out.println("El numero no esta en la lista");
                            }
                        }
                        case 9 -> {
                            int n;
                            System.out.println("Dame un entero para buscar");
                            n=teclado.nextInt();
                            if(lista.contains(n)){
                                System.out.println("Esta en la posicion: "+lista.indexOf(n)+1);
                            }else{
                                System.out.println("El numero no esta en la lista");
                            }
                        }
                        case 10 -> {
                            Integer n;
                            System.out.println("Dame un entero para buscar");
                            n=teclado.nextInt();
                            if(lista.contains(n)){
                                lista.remove(n);
                                System.out.println("Elemento eliminado");
                            }else{
                                System.out.println("El numero no esta en la lista");
                            }
                        }
                        case 11 ->{
                            int posicion;
                            System.out.println("Introduzca la posicion en la que desea introducir el 0");
                            posicion = teclado.nextInt();
                            posicion = posicion - 1;
                            while (posicion < -1 || posicion > lista.size() - 1) {
                                System.out.println("Posicion incorrecta");
                                System.out.println("Introduzca la posicion desea utilizar");
                                posicion = teclado.nextInt();
                            }
                            lista.add(posicion, 0);
                        }
                        case 12 ->{
                           /* List<Integer> listaOrdenada;
                            listaOrdenada = new LinkedList<>(lista);
                            listaOrdenada.sort(null);
                            System.out.println(listaOrdenada.toString());
                            */
                            Collections.sort(lista);
                            System.out.println(lista);
                        }
                        case 13 ->{
                            lista.sort(Comparator.reverseOrder());
                            System.out.println(lista.toString());
                        }
                        case 14 ->{
                            System.out.println("El mayor es: "+Collections.max(lista)); 
                            System.out.println("El menot es: "+Collections.min(lista)); 
                        }
                        case 15 ->{
                            Collections.rotate(lista, 1);
                            System.out.println(lista);
                        }
                        case 16 ->{
                            /*int aux;
                            aux=lista.getFirst();
                            lista.set(0, lista.getLast());
                            lista.set(lista.size()-1, aux);
                            System.out.println(lista.toString());
                            */
                            Collections.swap(lista, 0, lista.size()-1);
                            System.out.println(lista);
                        }
                        case 17 -> {
                            lista.clear();
                            System.out.println("Lista vaciada");
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
