/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto1;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class AplicacionBanco {

    public static void main(String[] args) {
        Cuenta cuenta=null;
        String codigo, titular;
        float saldo=0,cantidad;
        int opcion;
        Scanner teclado=new Scanner(System.in);
        do{
            System.out.println("1- Abrir cuenta");
            System.out.println("2- Ingresar dinero");
            System.out.println("3- Retirar dinero");
            System.out.println("4- Consultar saldo");
            System.out.println("5- Cancelar cuenta");
            System.out.println("0- Salir");
            System.out.print("Introduzca tu opcion:");
            opcion=teclado.nextInt();
            teclado.nextLine();
            if(opcion>=1 && opcion<=5){
                
                if(opcion==1){
                    if(cuenta==null){
                        System.out.print("Introducir titular ");
                        titular=teclado.nextLine();
                        System.out.print("Introducir saldo ");
                        saldo=teclado.nextFloat();
                        teclado.nextLine();
                        System.out.print("Introducir codigo ");
                        codigo=teclado.nextLine();
                        teclado.nextLine();
                        cuenta=new Cuenta(codigo,titular,saldo);
                        System.out.println("Cuenta creada con exito ");
                    }else{
                        System.out.println("No se puede abrir la cuenta "+ cuenta);
                    }
                }else{
                    System.out.print("Introducir codigo ");
                    codigo=teclado.nextLine();
                    if(cuenta!=null && codigo.equals(cuenta.getCodigo())){
                        switch(opcion){
                            case 2->{

                                System.out.print("Introduzca cantidad a ingresar: ");
                                cantidad=teclado.nextFloat();
                                teclado.nextLine();
                                cuenta.ingresar(cantidad);
                                System.out.println("Canitdad ingresada");
                                System.out.println("Nuevo saldo: "+cuenta.getSaldo());
                            }
                            case 3->{

                                   System.out.print("Introduzca cantidad a retirar: ");
                                   cantidad=teclado.nextFloat();
                                   teclado.nextLine();
                                   cuenta.integrar(cantidad);
                                   if( saldo!=0 && cantidad<saldo ){
                                       System.out.println("Canitdad retirada");
                                       System.out.println("Nuevo saldo: "+cuenta.getSaldo());
                                   }else{
                                       System.out.println("No puedes retirar mas dinero del que tienes");
                                        }
                            }
                            case 4->{

                                System.out.println(cuenta.getSaldo());
                                    }
                            case 5->{
                                cuenta=null;
                                System.out.println("Cuenta cancelada"); 
                                    }
                        }
                    }
                
                }       
            }       
        }while(opcion!=0);
    }
}
