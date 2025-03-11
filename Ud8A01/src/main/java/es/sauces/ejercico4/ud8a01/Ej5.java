/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud8a01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Path path;
        String linea;
        String[] palabras;
        int contadorLineas, contadorPalabras, contadorCaracteres;
        if(args.length>0){
        path=Paths.get(args[0]);
        try(BufferedReader entrada=Files.newBufferedReader(path)){
            contadorLineas=0;
            contadorPalabras=0;
            contadorCaracteres=0;
            linea=entrada.readLine();
            while(linea!=null){
                contadorLineas++;
                palabras=linea.split(" ");
                contadorPalabras+=palabras.length;
                for(String palabra: palabras){
                    contadorCaracteres+=palabras.length;
                }
                linea=entrada.readLine();
            }
            System.out.println("Lineas: "+contadorLineas);
            System.out.println("Palabras: "+contadorPalabras);
            System.out.println("Caracteres: "+contadorCaracteres);
        }catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No se han encontrado los argumentos");
        }catch (NoSuchFileException ex){
            System.out.println("No existe");
        }
        }
    }
    
}
