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
public class Ej9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path pathEntrada, pathSalida;
        Scanner teclado=new Scanner (System.in);
        String archivoEntrada, archivoSalida, linea;
        int contadorLineas;
        if(args.length==2){
            archivoEntrada=args[0];
            pathEntrada=Paths.get(archivoEntrada);
            archivoSalida=args[1];
            pathSalida=Paths.get(archivoSalida);
            try(BufferedReader entrada=Files.newBufferedReader(pathEntrada);
                BufferedWriter salida = Files.newBufferedWriter(pathSalida)) 
                {
                    contadorLineas=0;
                    linea=entrada.readLine();
                    while(linea!=null){
                        contadorLineas++;
                        salida.write(String.format("%d: %s\n",contadorLineas,linea));
                        linea=entrada.readLine();
                    }
                }catch(NoSuchFileException ex){
                    System.out.println("Archivo de entrada no existe");
                }catch(IOException ioe){
                System.out.println("Error de entrada/salida");
                //System.out.println(ioe);
                //ioe.printStackTrace();
                }
        }else{
            System.out.println("Formato incorrecto");
        }
    }
    
}
