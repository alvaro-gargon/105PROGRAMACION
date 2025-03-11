/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud8a01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        try {
            Path path= Paths.get(args[0]);
            DirectoryStream<Path> directorio= Files.newDirectoryStream(path);
            for(Path p:directorio){
            System.out.println(p.toAbsolutePath());
            }
        }catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No se han encontrado los argumentos");
        }catch (NoSuchFileException ex){
            System.out.println("No existe");
        }catch (NotDirectoryException ex){
            System.out.println("No es un directorio");
        }
    }
    
}
