/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.sistemas_nominas;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class App_nominas {

    public static void main(String[] args) {
        SistemaNominas sistemaNominas=new SistemaNominas(); 
        Empleado empleado=null;
        String dni,nombre;
        float salario,salarioHora;
        int opcion,opcion2,horas,comprobacion;
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
            try{
                opcion=teclado.nextInt();
            }catch(InputMismatchException ime){
                opcion=1000;
            }
            teclado.nextLine();
            switch(opcion){
                case 1->{
                            System.out.println("Quiere crear un empleado fijo(1) o un "
                                    + "empleado eventual(2)");
                            opcion2=teclado.nextInt();
                            teclado.nextLine();
                            switch(opcion2){
                                case 1->{
                                        System.out.println("Dame el dni");
                                        dni=teclado.nextLine();
                                        System.out.println("Dame el nombre");
                                        nombre=teclado.nextLine();
                                    try {
                                        System.out.println("Dame el salario");
                                        salario=teclado.nextFloat();
                                        empleado=new EmpleadoFijo(Dni.valueOf(dni),nombre,salario);
                                        if(sistemaNominas.incluirEmpleado(empleado)){
                                            System.out.println("Empleado fijo creado con exito");
                                        }else{
                                            System.out.println("Error al crear un empleado fijo");
                                        }
                                    } catch (DniException |IllegalArgumentException|InputMismatchException ex) {
                                        System.out.println(ex.getMessage());
                                    }finally {
                                    teclado.nextLine();
                                    }
                                }

                                case 2->{
                                        System.out.println("Dame el dni");
                                        dni=teclado.nextLine();
                                        System.out.println("Dame el nombre");
                                        nombre=teclado.nextLine();
                                    try {
                                        System.out.println("Dame el salario hora");
                                        salarioHora=teclado.nextFloat();
                                        System.out.println("Dame las horas");
                                        horas=teclado.nextInt();
                                        empleado=new EmpleadoEventual(Dni.valueOf(dni),nombre,salarioHora,horas);
                                        if(sistemaNominas.incluirEmpleado(empleado)){
                                            System.out.println("Empleado eventual creado con exito");
                                        }else{
                                            System.out.println("Error al crear un empleado eventual");
                                        }
                                    } catch (DniException|IllegalArgumentException|InputMismatchException ex) {
                                        System.out.println(ex.getMessage());
                                    }finally {
                                        teclado.nextLine();
                                    }
                                }

                                default ->{
                                    System.out.println("No se ha podido cear el empleado");
                                }
                            }
                }
                case 2->{
                    System.out.println("Introduzca el dni del empleado");
                    dni=teclado.nextLine();
                    empleado=sistemaNominas.getEmpleado(dni);
                    if(empleado!=null){
                        System.out.println(empleado);
                    }else{
                        System.out.println("No existe ese empleados");
                    }
                }
                case 3->{
                    System.out.println("Introduzca el dni del empleado");
                    dni=teclado.nextLine();
                    empleado=sistemaNominas.getEmpleado(dni);
                    if(empleado!=null){
                        System.out.println("Estas seguro que quieres borrar este empleado");
                        System.out.println("1. Si");
                        System.out.println("Pulse cualquier otro numero para cancelar");
                        comprobacion=teclado.nextInt();
                        if(comprobacion==1){
                            sistemaNominas.eliminarEmpleado(empleado);
                            System.out.println("Empleado eliminado con exito");
                        }
                    }else{
                        System.out.println("No existe ese empleado");
                    }
                }
                case 4->{
                    for(Empleado e:sistemaNominas.listarEmpleados()){
                        System.out.println(e);
                    }
                }
                case 5->{
                    for(Empleado e:sistemaNominas.listarEmpleadosPorSueldo()){
                        System.out.println(e);
                    }     
                }
                case 6->{
                    System.out.println(sistemaNominas.getTotalSalarios());
                }
                            
                case 0->{System.out.println("Bye"); }
                            
                default ->{System.out.println("Error en la entrada");}
                        
            }          
        }while(opcion!=0);
    }
}
