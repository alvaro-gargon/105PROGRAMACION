/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.introduccion_memoria_dinamica;
import java.util.Stack;
/**
 *
 * @author alvaro.gargon.4
 */
public class prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<String> pila=new Stack<>();
        pila.push("uno");
        pila.push("dos");
        System.out.println(pila.pop());
        System.out.println(pila.peek());
                
    }
    
}
