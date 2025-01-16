/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.introduccion_memoria_dinamica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alvaro.gargon.4
 */
public class Introduccion_memoria_dinamica {

    public static void main(String[] args) {
        List<String> lista;
        Iterator<String> iterador;
        lista=new LinkedList<>();
        
        lista.add("a");
        lista.add("b");
        lista.add("c");
        
        /*
        for(String elemento:lista){
            System.out.println(elemento);
        }
        */
        
        /*
        for(int i=0;lista.size();i++){
            System.out.println(lista.get(i));
        }
        */
        lista.addFirst("primero");
        lista.addLast("ultimo");
        
        iterador=lista.iterator();
        while(iterador.hasNext()){
            System.out.println(iterador.next());
        }
    }
}
