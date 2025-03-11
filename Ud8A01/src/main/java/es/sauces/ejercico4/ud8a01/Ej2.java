/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud8a01;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        String nombre, extension;
        int posicion;
            Path path= Paths.get(args[0]);
            posicion=args[0].lastIndexOf(".");
            if(posicion!=-1){
                nombre=args[0].substring(0,posicion);
                extension=args[0].substring(posicion);
                Path pathDestino =Paths.get(nombre +"-copia"+extension);
                try{
                Files.copy(path, pathDestino);
                }catch(FileAlreadyExistsException ex){
                    System.out.println("Ya existe el archivo de destino");
                }
                
            }
    }
    
}
