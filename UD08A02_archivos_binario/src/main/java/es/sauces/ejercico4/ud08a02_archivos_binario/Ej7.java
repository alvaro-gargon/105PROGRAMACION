/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud08a02_archivos_binario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Random access file 31 tamaño registro
        Scanner teclado = new Scanner(System.in);
        int opcion,habitantesNuevos;
        long posicion;
        do {
            System.out.println("1-Listado general");
            System.out.println("2-Consulta del numero de habitantes de una provincia");
            System.out.println("3-Modificacion del numero de habitantes de una provincia");
            System.out.println("0-Salir");
            System.out.print("Introduzca tu opcion:");
            opcion = teclado.nextInt();
            teclado.nextLine();
            try (RandomAccessFile fichero = new RandomAccessFile("poblacion.dat", "rw")) {
                switch (opcion) {
                    case 1 -> {
                        fichero.seek(0);
                        while (fichero.getFilePointer() < fichero.length()) {
                            byte codigo = fichero.readByte();//1 byte
                            String nombre = fichero.readLine();//26 bytes, 25 de caracteres y otro de salto de linea
                            int habitantes = fichero.readInt();//4 bytes, todos los int son 4 bytes
                            System.out.println(codigo + "," + nombre + "," + habitantes);
                        }
                    }
                    case 2 -> {
                        System.out.println("De que provincia quieres consultar la poblacion (codigo)");
                        opcion=teclado.nextInt();
                        posicion=((opcion-1)*31)+27;
                        fichero.seek(posicion);
                        System.out.println("El numero de habitantes es: "+fichero.readInt());
                    }
                    case 3 -> {
                        System.out.println("De que provincia quieres consultar la poblacion (codigo)");
                        opcion=teclado.nextInt();
                        posicion=((opcion-1)*31)+27;
                        fichero.seek(posicion);
                        System.out.println("¿El numero de habitantes a modifcar es?");
                        habitantesNuevos=teclado.nextInt();
                        fichero.writeInt(habitantesNuevos);
                    }
                    case 0->{
                        System.out.println("Adios");    
                    }
                    default -> {
                        System.out.println("Error entrada/salida");
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ej7.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ej7.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 0);
    }

}
