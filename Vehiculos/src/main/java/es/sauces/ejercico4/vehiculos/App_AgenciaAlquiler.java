/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

import modelo.DaoException;
import modelo.Furgoneta;
import modelo.Grupo;
import modelo.Turismo;
import modelo.Vehiculo;
import modelo.VehiculoCsv;
import modelo.MatriculaException;
import modelo.VehiculoDao;
import modelo.VehiculoObj;
import modelo.AgenciaAlquiler;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class App_AgenciaAlquiler {

    private static final Logger LOG = Logger.getLogger("es.sauces.ejercico4.vehiculos");
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
        LogManager.getLogManager().readConfiguration(ClassLoader.getSystemClassLoader().getResourceAsStream("logging.properties"));
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
            try{
            opcion=teclado.nextInt();
            LOG.log(Level.WARNING, "{0}Opcion escogida:", opcion);
            }catch(InputMismatchException ime){
                opcion=1000;
            }
            teclado.nextLine();
            switch(opcion){
                case 1->{
                            System.out.println("Quiere crear un turismo (1) o una "
                                    + "furgoneta(2)");
                            opcion2=teclado.nextInt();
                            teclado.nextLine();
                            switch(opcion2){
                                case 1->{
                                    try {
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
                                    } catch (MatriculaException | InputMismatchException | IllegalArgumentException ex) {
                                        System.out.println(ex.getMessage());
                                        LOG.log(Level.WARNING, Arrays.toString(ex.getStackTrace()));
                                    }finally{
                                        teclado.nextLine();
                                    }
                                }

                                case 2->{
                                    try {
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
                                    } catch (MatriculaException | InputMismatchException | IllegalArgumentException ex) {
                                        System.out.println(ex.getMessage());
                                    }finally{
                                        teclado.nextLine();
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
                case 10 -> {
                    System.out.println("Introduzca el nombre del archivo");
                String nombreArchivo = teclado.nextLine();
                    VehiculoDao dao=getDao(nombreArchivo);
                    agenciaAlquiler.setVehiculoDao(dao);
                    try{
                        System.out.println(agenciaAlquiler.guardarVehiculos());
                    }catch(DaoException ex){
                        System.out.println(ex.toString());
                    }
                }
                case 11 -> {
                    System.out.println("Introduzca el nombre del archivo");
                    String nombreArchivo = teclado.nextLine();
                    VehiculoDao dao=getDao(nombreArchivo);
                    agenciaAlquiler.setVehiculoDao(dao);
                    try{
                        System.out.println(agenciaAlquiler.cargarVehiculos());
                    }catch(DaoException ex){
                        System.out.println(ex.toString());
                    }
                }
                            
                case 0->{System.out.println("Bye"); }
                            
                default ->{System.out.println("Error en la entrada");}
                        
            }          
        }while(opcion!=0);
    }
    private static VehiculoDao getDao(String nombreArchivo){
        VehiculoDao vehiculoDao=null;
        String extension = null;
        int indice=nombreArchivo.lastIndexOf(".");
        extension=nombreArchivo.substring(indice);
        //lastindexof(.)
        vehiculoDao=switch(extension){
            case ".csv" -> new VehiculoCsv(nombreArchivo);
            case ".obj" -> new VehiculoObj(nombreArchivo);
            //case ".gson" -> new VehiculoJson(nombreArchivo);
            //case ".xml" -> new VehiculoXml(nombreArchivo);
            default -> null;
        };  
        return vehiculoDao;
    }
}
