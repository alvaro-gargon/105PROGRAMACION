/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud08a02_archivos_binario;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contadorAprobados;
        int contadorSuspensos;
       try (DataInputStream entrada = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("notas.dat"))))) {
           contadorAprobados=0;
           contadorSuspensos=0;
           while (entrada.available() > 0) {
               String nombre=entrada.readUTF();
               float num=entrada.readFloat();
                System.out.println(nombre+":"+num);
                if(num<5){
                    contadorSuspensos++;
                }else{
                    contadorAprobados++;
                }
            }
           System.out.println("Aprobados: "+contadorAprobados);
           System.out.println("Suspensos: "+contadorSuspensos);
        } catch (FileNotFoundException fnfe) {
            System.out.println("No existe el fichero");
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida");
        }
    }    
}
