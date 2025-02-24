/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author alvaro.gargon.4
 */
public class AplicacionBanco {
    private static final Logger Log=Logger.getLogger("com.mycompany.proyecto1");
    public static void main(String[] args) throws SaldoInsuficienteException, IOException {
        
        Banco banco;
        boolean error;
        Cuenta cuenta=null,cuentaDestino=null;
        String codigo, titular;
        float saldo=0,cantidad;
        int opcion,opcion2;
        Scanner teclado=new Scanner(System.in);
        banco=new Banco("Sauces");
        
        Handler controlador=new FileHandler("./register.log",true);
        controlador.setFormatter(new SimpleFormatter());
        Log.addHandler(controlador);
        
        do{
            System.out.println("1- Abrir cuenta");
            System.out.println("2- Operar con cuenta");
            System.out.println("3- Cancelar cuenta");
            System.out.println("4- Listar cuenta");
            System.out.println("5- Consultar total depositos");
            System.out.println("0- Salir");
            System.out.print("Introduzca tu opcion:");
            try{
                opcion=teclado.nextInt();
            }catch(InputMismatchException ime){
                opcion=1000;
            }
            teclado.nextLine();
            switch(opcion){
                case 1 -> {
                        do {
                            error = false;
                            try {
                                System.out.print("Introducir codigo ");
                                codigo = teclado.nextLine();
                                while(!Cuenta.esIbanValido(codigo)){
                                    System.out.println("Error al introducri el codigo, vuelve a intentarlo");
                                    codigo = teclado.nextLine();
                                }
                                System.out.print("Introducir titular ");
                                titular = teclado.nextLine();
                                System.out.print("Introducir saldo ");
                                saldo = teclado.nextFloat();
                                cuenta = new Cuenta(codigo, titular, saldo);
                                if (banco.abrirCuenta(cuenta)) {
                                    System.out.println("Cuenta creada con exito ");
                                } else {
                                    System.out.println("No se puede abrir la cuenta " + cuenta);
                                }
                            } catch (IllegalArgumentException | IbanException ex) {
                                Log.log(Level.WARNING,ex.getMessage());
                                System.out.println(ex.getMessage());
                                error = true;
                            } catch (InputMismatchException ime) {
                                opcion = 1000;
                            } finally {
                                teclado.nextLine();
                            }
                        } while (error);
                }
                            case 2->{
                                System.out.println("Introduzca codigo de la cuenta");
                                codigo=teclado.nextLine();
                                cuenta=banco.buscarCuenta(codigo);
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
                                            try{
                                            cuenta.reintegrar(cantidad);
                                            if( saldo!=0 && cantidad<saldo ){
                                                System.out.println("Canitdad retirada");
                                                System.out.println("Nuevo saldo: "+cuenta.getSaldo());
                                            }else{
                                                System.out.println("No puedes retirar mas dinero del que tienes");
                                            }
                                            }catch(SaldoInsuficienteException | IllegalArgumentException ex){
                                                System.out.println(ex.getMessage());
                                            }
                                            }
                                            case 3->{
                                                System.out.println(cuenta.getSaldo());
                                            }
                                            case 4->{
                                                System.out.println("Introduzca el codigo de cuenta de destino: ");
                                                try{
                                                codigo=teclado.nextLine();
                                                cuentaDestino=banco.buscarCuenta(codigo);
                                                }catch(NullPointerException | IllegalArgumentException ex){
                                                    System.out.println(ex.getMessage());
                                                }
                                                System.out.println("Transferencia a realizar");
                                                try{
                                                cantidad=teclado.nextFloat();
                                                cuenta.realizarTransferencia(cuentaDestino, cantidad);
                                                }catch(SaldoInsuficienteException | IllegalArgumentException ex){
                                                    System.out.println(ex.getMessage());
                                                }
                                                System.out.println("Cantidad transferida");
                                                System.out.println("Nuevo saldo: "+cuenta.getSaldo());
                                            }    
                                            case 5->{
                                                for(Movimiento m:cuenta.getMovimientos()){
                                                    System.out.println(m);
                                                }
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
                                try{
                                codigo=teclado.nextLine();
                                cuenta=banco.buscarCuenta(codigo);
                                System.out.println(cuenta);
                                    if(banco.cancelarCuenta(codigo)){
                                        System.out.println("Cuenta cancelada");
                                    }else{
                                        System.out.println("No se ha podido cancelar la cuenta");
                                    }
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
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
