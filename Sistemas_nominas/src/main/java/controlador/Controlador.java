/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DaoException;
import modelo.DniException;
import modelo.Empleado;
import modelo.EmpleadoCsv;
import modelo.EmpleadoDao;
import modelo.EmpleadoEventual;
import modelo.EmpleadoFijo;
import modelo.EmpleadoJson;
import modelo.EmpleadoObj;
import modelo.EmpleadoXml;
import modelo.SistemaNominas;
import vista.Ventana;

/**
 *
 * @author alvaro.gargon.4
 */
public class Controlador {

    private static final Logger LOG = Logger.getLogger(Controlador.class.getName());

    Scanner teclado = new Scanner(System.in);
    
    private Ventana vista;
    private SistemaNominas modelo;

    public Controlador(Ventana vista, SistemaNominas modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void iniciar() {
        vista.mostrar();
    }

    public void crearEmpleado() {
        String dni = vista.getDni();
        String nombre = vista.getNombre();
        String tipo = vista.getTipo();
        float salario = vista.getSalario();
        int horas = vista.getHoras();
         try {
            Empleado empleado = switch (tipo) {
            case "Fijo" ->
                new EmpleadoFijo(dni, nombre, salario);
            case "Eventual" ->
                new EmpleadoEventual(dni, nombre, salario, horas);
            default ->
                null;
        };
       
            if (empleado!=null && modelo.incluirEmpleado(empleado)) {
                vista.mostrarMensaje("Empleado fijo creado con exito");
                vista.mostrarIngresos(empleado.ingresos());
                vista.listarEmpleados(modelo.listarEmpleados());
            } else {
                vista.mostrarMensaje("Error al crear un empleado fijo");
            }
        } catch (DniException | IllegalArgumentException | InputMismatchException ex) {
            LOG.log(Level.SEVERE, "Error " + ex.getMessage());
            vista.mostrarMensaje(ex.getMessage());
        } 
    }
    
    public void buscarEmpleado() {
        String dni = vista.getDni();
        Empleado empleado = modelo.getEmpleado(dni);
        if (empleado != null) {
            vista.mostrarNombre(empleado.getNombre());
            vista.mostrarDni(empleado.getDni());
            vista.mostrarTipo(empleado instanceof EmpleadoFijo  ? "Fijo":"Eventual");
            if(empleado instanceof EmpleadoFijo){
                    vista.mostrarSalario(((EmpleadoFijo) empleado).getSalario());
                }else{
                    vista.mostrarSalario(((EmpleadoEventual) empleado).getSalarioHora());
                    vista.mostrarHoras(((EmpleadoEventual) empleado).getHoras());
                }
            vista.mostrarIngresos(empleado.ingresos());
        } else {
            vista.mostrarMensaje("No existe un Empleado con ese nombre");
        }
    }
 
    
    public void eliminarEmpleado(){
        if (vista.solicitarConfiramcion()) {
            if (modelo.eliminarEmpleado(modelo.getEmpleado(vista.getDni()))) {
                vista.mostrarMensaje("Contacto eliminado");
                vista.limpiarCampos();
                vista.listarEmpleados(modelo.listarEmpleados());
            } else {
                vista.mostrarMensaje("No se ha podido eliminar el contacto");
            }
        }
    }
    
    public void modificarEmpleado() {
        Empleado empleado;
        String dni = vista.getDni();
        try{
            empleado=modelo.getEmpleado(dni);
            if(empleado!=null){
                empleado.setNombre(vista.getNombre());
                empleado.setDni(vista.getDni());
                if(empleado instanceof EmpleadoFijo){
                    ((EmpleadoFijo) empleado).setSalario(vista.getSalario());
                }else{
                    ((EmpleadoEventual) empleado).setSalarioHora(vista.getSalario());
                    ((EmpleadoEventual) empleado).setHoras(vista.getHoras());
                }
                vista.mostrarIngresos(empleado.ingresos());
                vista.listarEmpleados(modelo.listarEmpleados());
            }else {
                vista.mostrarMensaje("No se ha podido modificar el contacto");
            }
        }catch(DniException ex){
            vista.mostrarMensaje(ex.toString());
        }
    }
    
    public void guardarEmpleado() {
        String nombreArchivo = vista.getArchivo();
        modelo.setEmpleadoDao(new EmpleadoCsv(nombreArchivo));
        try {
            System.out.println(modelo.guardarEmpleados());

        } catch (DaoException ex) {
            System.out.println(ex.toString());
        }
    }
    
     public void cargarEmpleado() {
        String nombreArchivo=vista.getArchivo();
        modelo.setEmpleadoDao(new EmpleadoCsv(nombreArchivo));
        try {
            modelo.cargarEmpleados();
            vista.listarEmpleados(modelo.listarEmpleados());
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    
    public void listarEmpleados(){
        List<Empleado> listado=null;
        vista.mostrarMensaje(vista.getOrden());
        switch(vista.getOrden()){
            case "DNI" -> listado=modelo.listarEmpleados();
            case "Nombre" -> {
                    listado=modelo.listarEmpleados();
                    listado.sort(new Comparator<Empleado>(){
                    @Override
                    public int compare(Empleado o1, Empleado o2){
                        return o1.getNombre().compareTo(o2.getNombre());
                    }
                    });
            }
            case "INGRESOS" -> listado=modelo.listarEmpleadosPorSueldo();
            
        }
        vista.mostrarMensaje(vista.getOrden());
        vista.listarEmpleados(listado);
    }
    private static EmpleadoDao getDao(String nombreArchivo){
        EmpleadoDao empleadoDao=null;
        String extension = null;
        int indice=nombreArchivo.lastIndexOf(".");
        extension=nombreArchivo.substring(indice);
        //lastindexof(.)
        empleadoDao=switch(extension){
            case ".csv" -> new EmpleadoCsv(nombreArchivo);
            case ".obj" -> new EmpleadoObj(nombreArchivo);
            case ".gson" -> new EmpleadoJson(nombreArchivo);
            case ".xml" -> new EmpleadoXml(nombreArchivo);
            default -> null;
        };  
        return empleadoDao;
    }
}
