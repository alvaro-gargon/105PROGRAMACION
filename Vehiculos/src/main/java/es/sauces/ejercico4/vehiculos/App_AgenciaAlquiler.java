/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class App_AgenciaAlquiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
        AgenciaAlquiler agenciaAlquiler=new AgenciaAlquiler("Marcos Fernandez Industries"); 
        Vehiculo vehiculo=null;
        String dni,nombre;
        int opcion,opcion2,comprobacion,plaza;
        String matricula,grupo;
        float capacidad;
        Scanner teclado=new Scanner(System.in);
        do{
            System.out.println("1-Crear vehiculo");
            System.out.println("2-Consultar vehiculo");
            System.out.println("3-Eliminar vehiculo");
            System.out.println("4-Listar vehiculos");
            System.out.println("5-Consultar alquiler más barato");
            System.out.println("0-Salir");
            System.out.print("Introduzca tu opcion:");
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1->{
                            System.out.println("Quiere crear un turismo (1) o una "
                                    + "furgoneta(2)");
                            opcion2=teclado.nextInt();
                            teclado.nextLine();
                            switch(opcion2){
                                case 1->{
                                    System.out.println("Dame la matricula");
                                    matricula=teclado.nextLine();
                                    System.out.println("Dame el grupo");
                                    grupo=teclado.nextLine();
                                    System.out.println("Dame las plazas");
                                    plaza=teclado.nextInt();
                                    vehiculo=new Turismo(matricula,Grupo.valueOf(grupo),plaza);
                                    if(agenciaAlquiler.incluirVehiculo(vehiculo)){
                                        System.out.println("Turismo creado con exito");
                                    }else{
                                        System.out.println("Error al crear un turismo");
                                    }
                                }
                                case 2->{
                                    System.out.println("Dame la matricula");
                                    matricula=teclado.nextLine();
                                    System.out.println("Dame el grupo");
                                    grupo=teclado.nextLine();
                                    System.out.println("Dame la capacidad");
                                    capacidad=teclado.nextFloat();
                                    vehiculo=new Furgoneta(matricula,Grupo.valueOf(grupo),capacidad);
                                     if(agenciaAlquiler.incluirVehiculo(vehiculo)){
                                        System.out.println("Furgoneta creada con exito");
                                    }else{
                                        System.out.println("Error al crear una furgoneta");
                                    }
                                }
                                default ->{
                                    System.out.println("No se ha podido cear el vehiculo");
                                }
                            }
                }
                case 2->{
                    System.out.println("Introduzca la matricula del vehiculo");
                    matricula=teclado.nextLine();
                    vehiculo=agenciaAlquiler.consultarVehiculo(matricula);
                    if(vehiculo!=null){
                        System.out.println(vehiculo);
                    }else{
                        System.out.println("No existe ese empleados");
                    }
                }
                case 3->{
                    System.out.println("Introduzca la matricula del vehiculo");
                    matricula=teclado.nextLine();
                    vehiculo=agenciaAlquiler.consultarVehiculo(matricula);
                    if(vehiculo!=null){
                        System.out.println(vehiculo.getMatricula());
                        System.out.println("Estas seguro que quieres borrar este vehiculo");
                        System.out.println("1. Si");
                        System.out.println("Pulse cualquier otro numero para cancelar");
                        comprobacion=teclado.nextInt();
                        if(comprobacion==1){
                            agenciaAlquiler.eliminarVehiculo(vehiculo);
                            System.out.println("Vehiculo eliminado con exito");
                        }
                    }else{
                        System.out.println("No existe ese vehiculo");
                    }
                }
                case 4->{
                    System.out.println("Listar vehiculos por precio(1), listar vehiculo por turismo(2),"
                            + "listar vehiculo por turismo(3) ");
                    opcion2=teclado.nextInt();
                    switch(opcion2){
                        case 1->{
                            for(Vehiculo v:agenciaAlquiler.listarVehiculoPorPrecio()){
                            System.out.println(v);
                            }
                        }
                        case 2->{
                            for(Vehiculo v:agenciaAlquiler.listarVehiculoPorPrecio()){
                                if(v instanceof Turismo t){
                                    System.out.println(t);
                                }
                            }
                        }
                        case 3->{
                            for(Vehiculo v:agenciaAlquiler.listarVehiculoPorPrecio()){
                                if(v instanceof Furgoneta f){
                                    System.out.println(f);
                                }
                            }
                        }
                    }
                }
                case 5->{
                    System.out.println(agenciaAlquiler.getVehiculoMasBarato());
                    System.out.println(agenciaAlquiler.getVehiculoMasBarato().getPrecioAlquiler());
                }
                            
                case 0->{System.out.println("Bye"); }
                            
                default ->{System.out.println("Error en la entrada");}
                        
            }          
        }while(opcion!=0);
    }
}
