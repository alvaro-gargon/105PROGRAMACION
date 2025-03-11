/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud8a01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) {
        try{
        Path path= Paths.get(args[0]);
        System.out.println(Files.exists(path));
        if(Files.isDirectory(path)){
            System.out.println("Es un directorios");
        }else{System.out.println("Es un archivo");}
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No se ha introducido argumentos");
        }
    }
}
