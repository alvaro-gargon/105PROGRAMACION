/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud8a01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path path;
        Scanner teclado=new Scanner (System.in);
        String nombreArchivo,entrada;
        if(args.length==1){
            nombreArchivo=args[0];
            path=Paths.get(nombreArchivo);
                try(BufferedWriter salida = Files.newBufferedWriter(path)) 
                {
                    System.out.println("Introduzca una cadena: ");
                    entrada=teclado.nextLine();
                    while(!entrada.equals("FIN"))
                        salida.write(entrada);
                        salida.newLine();
                        System.out.println();
                        entrada=teclado.nextLine();
                }catch(IOException ioe){
               System.out.println("Error de entrada/salida");
                }
        }else{
            System.out.println("Formato incorrecto");
        }
    }
    
}
