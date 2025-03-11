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

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path pathEntrada, pathSalida;
        String linea;
        if(args.length==3){
            pathSalida=Paths.get(args[2]);
            try(BufferedWriter salida = Files.newBufferedWriter(pathSalida)) 
                {
                    for(int i=0;i<2;i++){
                        pathEntrada=Paths.get(args[i]);
                        try(BufferedReader entrada = Files.newBufferedReader(pathEntrada)){
                            linea=entrada.readLine();
                                while(linea!=null){
                                    salida.write(linea);
                                    salida.newLine();
                                    linea=entrada.readLine();
                                }
                        }catch(NoSuchFileException ex){
                            System.out.printf("Archivo %s no existe\n",args[i]);
                        }
                    }
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
