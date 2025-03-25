/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud08a02_archivos_binario;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Provincia provincia;
        int acum;
        try (FileInputStream fis = new FileInputStream("provincias.obj"); 
            ObjectInputStream entrada = new ObjectInputStream(fis);
            BufferedWriter salida = Files.newBufferedWriter(Paths.get("provincias.txt")) )
        {
            acum=0;
            while (fis.available() > 0) {
                provincia = (Provincia) entrada.readObject();
                salida.write(provincia.getCodigo()+","+provincia.getNombre()+","+provincia.getHabitantes());
                salida.newLine();
                acum=acum+provincia.getHabitantes();
            }
            salida.write("El total de habitantes es: "+acum);
        } catch (EOFException eofe) {
            System.out.println("Fin de fichero");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Objeto no esperado");
        } catch (FileNotFoundException fnfe) {
            System.out.println("No existe el fichero");
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida");
        }
    }

}
