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
import java.util.Scanner;
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
        System.out.println("Introduzca nombre imagen: ");
        Scanner teclado = new Scanner(System.in);
        String nombreArchivo;
        byte [][] imagen=null;
        nombreArchivo=teclado.nextLine();
        
        try{
            imagen=leerArchivoImagen(nombreArchivo);
            imagen=crearNegativo(imagen);// esto rompe la imagen original
            imagen=espejoHorizontal(imagen);
            escribirArchivoImagen(nombreArchivo+"-copia",imagen);
        }catch(ImagenException ex){
            System.out.println(ex.getMessage());
        }
    }
    private static byte[][] leerArchivoImagen(String nombre) throws FileNotFoundException, ImagenException{
        short ancho,alto;
        byte [][] imagen=null;
        File fich = new File(nombre+".raw");
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
            throw new ImagenException(ex.toString());
        }
        return imagen;
    }
    private static void escribirArchivoImagen(String nombre, byte[][] imagen) throws ImagenException{
        short ancho = 0,alto = 0;
        alto=(short) imagen.length;
        ancho=(short) imagen[0].length;
        try(DataOutputStream salida = new DataOutputStream(Files.newOutputStream(Paths.get(nombre+".raw")))){
            salida.writeShort(ancho);
            salida.writeShort(alto);
            for (int i = 0; i < alto; i++) {
                    for (int j = 0; j < ancho; j++) {
                        salida.writeByte(imagen[i][j]);
                    }
                }
        } catch (IOException ex) {
            throw new ImagenException(ex.toString());
        }
    }
    
    private static byte[][] crearNegativo(byte[][] imagen){
        byte[][] nuevaImagen;
        short ancho,alto;
        alto=(short) imagen.length;
        ancho=(short) imagen[0].length;
        nuevaImagen=new byte[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                nuevaImagen[i][j]=(byte) (255-imagen[i][j]);
            }
        }
        return nuevaImagen;
    }
    
    private static byte[][] espejoHorizontal(byte[][] imagen){
        byte[][] nuevaImagen;
        short ancho,alto;
        alto=(short) imagen.length;
        ancho=(short) imagen[0].length;
        nuevaImagen=new byte[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0, j2=ancho-1; j < ancho; j++,j2--) {
                nuevaImagen[i][j2]= imagen[i][j];
            }
        }
        return nuevaImagen;
    }
    
    private static byte[][] rotarImagenIzquierda(byte[][] imagen){
        byte[][] nuevaImagen;
        short ancho,alto;
        alto=(short) imagen.length;
        ancho=(short) imagen[0].length;
        nuevaImagen=new byte[ancho][alto];//cambian las diemnsiones de la matriz
        for (int i = 0,j2=0; i < alto; i++,j2++) {
            for (int j = 0,i2=ancho-1; j < ancho; j++,i2--) {
                nuevaImagen[i2][j2]= imagen[i][j];
            }
        }
        return nuevaImagen;
    }
    
    private static byte[][] rotarImagenDerecha(byte[][] imagen){
        byte[][] nuevaImagen;
        short ancho,alto;
        alto=(short) imagen.length;
        ancho=(short) imagen[0].length;
        nuevaImagen=new byte[ancho][alto];//cambian las diemnsiones de la matriz
        for (int i = 0,j2=alto-1; i < alto; i++,j2--) {
            for (int j = 0, i2=0; j < ancho; j++,i2++) {
                nuevaImagen[i2][j2]= imagen[i][j];
            }
        }
        return nuevaImagen;
    }
}
