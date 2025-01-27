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
        Banco banco;
        Cuenta cuenta=null;
        String codigo, titular;
        float saldo=0,cantidad;
        int opcion,opcion2;
        Scanner teclado=new Scanner(System.in);
        
        
        do{
            System.out.println("1- Abrir cuenta");
            System.out.println("2- Operar con cuenta");
            System.out.println("3- Cancelar cuenta");
            System.out.println("4- Listar cuenta");
            System.out.println("5- Consultar total depositos");
            System.out.println("0- Salir");
            System.out.print("Introduzca tu opcion:");
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                
                case 1->{
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
                        if(banco.abrirCuenta(cuenta))
                        System.out.println("Cuenta creada con exito ");
                    }else{
                        System.out.println("No se puede abrir la cuenta "+ cuenta);
                    }
                    }
                            case 2->{
                                System.out.println("Introduzca codugo de la cuenta");
                                codigo=teclado.nextLine();
                                if(cuenta!=null){
                                    do{
                                        System.out.println("1- Ingresar dinero");
                                        System.out.println("2- Retirar dinero");
                                        System.out.println("3- Consultar saldo");
                                        System.out.println("4- Realizar transferencia");
                                        System.out.println("5- Consultar movimientos");
                                        System.out.println("0- Salir");
                                        System.out.println("Introduzca su opcion");
                                        opcion2=teclado.nextInt();
                                        teclado.nextLine();
                                        switch(opcion2){
                                            case 1->{
                                            System.out.print("Introduzca cantidad a ingresar: ");
                                            cantidad=teclado.nextFloat();
                                            teclado.nextLine();
                                            cuenta.ingresar(cantidad);
                                            System.out.println("Canitdad ingresada");
                                            System.out.println("Nuevo saldo: "+cuenta.getSaldo());
                                            }
                                            case 2->{
                                            System.out.print("Introduzca cantidad a retirar: ");
                                            cantidad=teclado.nextFloat();
                                            teclado.nextLine();
                                            cuenta.reintegrar(cantidad);
                                            if( saldo!=0 && cantidad<saldo ){
                                                System.out.println("Canitdad retirada");
                                                System.out.println("Nuevo saldo: "+cuenta.getSaldo());
                                            }else{
                                                System.out.println("No puedes retirar mas dinero del que tienes");
                                            }
                                            }
                                            case 3->{
                                                System.out.println(cuenta.getSaldo());
                                            }
                                            case 4->{
                                                System.out.println("Transferencia a realizar");
                                                cantidad=teclado.nextFloat();
                                                cuenta.realizarTransferencia(null, cantidad);
                                                System.out.println("Cantidad transferida");
                                                System.out.println("Nuevo saldo: "+cuenta.getSaldo());
                                            }
                                            case 5->{
                                                System.out.println(cuenta.listarMovimientos());
                                            }
                                            case 0->{
                                                System.out.println("Adios");
                                            }
                                            default ->{
                                                System.out.println("Error en la opcion");
                                            }
                                        }
                                    }while(opcion2!=0);
                                }else{
                                    System.out.println("No existe una cuenta con ese codigo");
                                }
                            }
                            case 3->{
                                System.out.println("Introduzca codigo de cuenta");
                                codigo=teclado.nextLine();
                                cuenta=banco.buscarCuenta(codigo);
                                if(cuenta!=null){
                                    System.out.println(cuenta);
                                    if(banco.cancelarCuenta(codigo)){
                                        System.out.println("Cuenta cancelada");
                                    }else{
                                        System.out.println("No se ha podido cancelar la cuenta");
                                    }
                                }else{
                                    System.out.println("No existe una cuenta con ese codigo");
                                }
                            }
                            case 4->{
                                for(Cuenta c:banco.getCuentas()){
                                    System.out.println(c);
                                }
                            }
                            case 5->{
                                System.out.printf("Total depositos: %f\n",banco.getTotalDepositos());
                            }
                            case 0->{
                                System.out.println("Adios");
                            }
                            default ->{
                                System.out.println("Error en la opcion");
                            }
                        }
        }while(opcion!=0);   
    }
}
