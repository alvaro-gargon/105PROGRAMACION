/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud08a02_archivos_binario;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String linea;
        String[] parte;
        float media;
        try(BufferedReader entrada=Files.newBufferedReader(Paths.get("calificaciones.txt"));
                DataOutputStream salida=new DataOutputStream(Files.newOutputStream(Paths.get("notas.dat")))){
            linea=entrada.readLine();
            while(linea!=null){
                parte=linea.split(",");
                media=(Integer.parseInt(parte[1])+Integer.parseInt(parte[2])+Integer.parseInt(parte[3]))/3.0f;
                System.out.println(media);
                salida.writeUTF(parte[0]);
                salida.writeFloat(media);
                linea=entrada.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("No existe el fichero");
        } catch (IOException ex) {
            Logger.getLogger(Ej3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
