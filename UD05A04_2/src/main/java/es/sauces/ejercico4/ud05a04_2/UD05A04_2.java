/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud05a04_2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class UD05A04_2 {

    public static void main(String[] args) {
         Scanner teclado = new Scanner(System.in);
        int opcion,num;
        List<Integer> lista;
        lista = new LinkedList<>();
        do {
            System.out.println("1.- Añadir un entero solicitado por teclado");
            System.out.println("2.- Mostrar el contenido por pantalla");
            System.out.println("3.- Solicitar un entero por teclado e insertarlo en la primera posicion");
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
                            
                            System.out.println("Dame un numero para insertarlo el primero");
                            num=teclado.nextInt();
                            lista.addFirst(num);
                        }
                        case 4 -> {
                            
                            System.out.println("Dame un numero para insertarlo el primero");
                            num=teclado.nextInt();
                            lista.addLast(num);
                        }
                        case 5 -> {
                            System.out.println(lista.reversed());
                        }
                        case 6 -> {
                            System.out.println(lista.getFirst()+","+lista.getLast());
                        }
                        case 7 -> {
                            lista.removeFirst();
                            lista.removeLast();
                            System.out.println("Elementos borrados");
                        }
                        case 8 -> {
                            Integer num2;
                            System.out.println("Que numero desas eliminar");
                            num2=teclado.nextInt();
                            lista.remove(num2);
                        }
                        case 9 -> {
                            Integer num2;
                            System.out.println("Que numero desas eliminar");
                            num2=teclado.nextInt();
                            lista.reversed().remove(num2);
                        }
                        case 10 -> {
                            lista.sort(null);
                            System.out.println(lista);
                        }
                        case 11 ->{
                            Collections.sort(lista,Collections.reverseOrder());
                            System.out.println(lista);
                        }
                        case 12 ->{
                            for(int i=lista.getFirst();i<lista.size();i++){
                                System.out.println("Aparece el numero "+i+" estas veces: "+Collections.frequency(lista, i));
                            }
                        }
                        case 13 ->{
                           lista.removeAll(lista);
                           System.out.println("Todos los elementos eliminados");
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
