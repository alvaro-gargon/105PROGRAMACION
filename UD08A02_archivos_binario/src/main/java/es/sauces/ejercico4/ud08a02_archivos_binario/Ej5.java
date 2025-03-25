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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Byte codigo;
        String nombre;
        int habitantes;
        Provincia provincia;
        File fich=new File("provincias.dat");
        FileInputStream fis=new FileInputStream(fich);
        BufferedInputStream bis=new BufferedInputStream(fis);
        try (DataInputStream entrada=new DataInputStream(bis);
                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("provincias.obj"))){
            while(entrada.available()>0){
                codigo=entrada.readByte();
                nombre=entrada.readUTF();
                habitantes=entrada.readInt();
                provincia=new Provincia(codigo,nombre,habitantes);
                salida.writeObject(provincia);
            }
            
        } catch (FileNotFoundException fnfe) {
            System.out.println("No existe el fichero");
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida");
        }
    }
}
