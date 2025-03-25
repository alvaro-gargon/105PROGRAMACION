/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.ejercico4.ud08a02_archivos_binario;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ej1 {

    public static void main(String[] args) throws IOException {
        Scanner teclado=new Scanner(System.in);
        DataOutputStream salida = null;
        int num;
        System.out.println("Introduzca un numero");
        num=teclado.nextInt();
        try {
            salida = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("numeros.dat"), true)));
            while(num!=0){
                salida.writeInt(num);
                System.out.println("Introduzca un numero");
                num=teclado.nextInt();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("No existe el fichero");
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida");
        } finally {
            if (salida != null) {
                salida.close();
            }
        }
    }
}
