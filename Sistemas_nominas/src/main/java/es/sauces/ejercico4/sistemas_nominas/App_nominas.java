/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.sistemas_nominas;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class App_nominas {

    public static void main(String[] args) {
        int opcion;
        Scanner teclado=new Scanner(System.in);
        do{
            System.out.println("1-Crear empleado");
            System.out.println("2-Consultar empleado");
            System.out.println("3-Eliminar empleado");
            System.out.println("4-Listar empleado");
            System.out.println("5-Listar empleados por sueldo");
            System.out.println("6-Consultar total salarios");
            System.out.println("0-Salir");
            System.out.print("Introduzca tu opcion:");
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1->{
                        
                        }
                            
                case 0->{System.out.println("Bye"); }
                            
                default ->{System.out.println("Error en la entrada");}
                        
                    }          
        }while(opcion!=0);
    }
}
