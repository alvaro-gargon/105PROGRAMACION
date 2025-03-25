/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.ud08a02_archivos_binario;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
public class Ej8 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        short ancho = 0, alto = 0;
        byte [][] imagen = null;
        File fich = new File("barbara_512x512.raw");
        FileInputStream fis = new FileInputStream(fich);
        BufferedInputStream bis = new BufferedInputStream(fis);
        try (DataInputStream entrada = new DataInputStream(bis); 
            DataOutputStream salida = new DataOutputStream(Files.newOutputStream(Paths.get("copia_imagen.raw")))) {
            ancho = entrada.readShort();
            alto = entrada.readShort();
            imagen= new byte[alto][ancho];
                for (int i = 0; i < alto; i++) {
                    for (int j = 0; j < ancho; j++) {
                        imagen[i][j]=entrada.readByte();
                    }
                }
        } catch (IOException ex) {
            Logger.getLogger(Ej8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(DataOutputStream salida = new DataOutputStream(Files.newOutputStream(Paths.get("barbara-copia_512x512.raw")))){
            salida.writeShort(ancho);
            salida.writeShort(alto);
            for (int i = 0; i < alto; i++) {
                    for (int j = 0; j < ancho; j++) {
                        salida.writeByte(imagen[i][j]);
                    }
                }
        } catch (IOException ex) {
            Logger.getLogger(Ej8.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
