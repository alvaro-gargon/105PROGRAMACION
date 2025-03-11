/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud8a01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        try{
        Path path= Paths.get(args[0]);
        Files.deleteIfExists(path);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No se han encontrado los argumentos");
        }
               
    }  
}
