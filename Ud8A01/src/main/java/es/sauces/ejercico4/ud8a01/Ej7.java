/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud8a01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Path path;
        String nombreArchivo,linea,palabraABuscar;
        int n,contadorLineas;
        if(args.length==2){
            palabraABuscar=args[0];
           for(int i=1;i<args.length;i++){
               nombreArchivo=args[i];
               System.out.println(nombreArchivo);
               path=Paths.get(nombreArchivo);
                try(BufferedReader entrada=Files.newBufferedReader(path)){
                    contadorLineas=0;
                    linea=entrada.readLine();
                    while(linea!=null){
                        contadorLineas++;
                        if(linea.contains(palabraABuscar)){
                        System.out.println(contadorLineas+" "+linea);
                        }
                        linea=entrada.readLine();
                    }
                }catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("No se han encontrado los argumentos");
                }catch (NoSuchFileException ex){
                    System.out.println("No existe");
                }
           }
        }else{
            System.out.println("Formato incorrecto");
        }
    }
    
}
