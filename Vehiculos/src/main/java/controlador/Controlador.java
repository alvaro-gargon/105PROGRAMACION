/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import modelo.AgenciaAlquiler;
import modelo.ComparadorPrecio;
import modelo.DaoException;
import modelo.Furgoneta;
import modelo.Grupo;
import modelo.MatriculaException;
import modelo.Turismo;
import modelo.Vehiculo;
import modelo.VehiculoCsv;
import vista.Ventana;

/**
 *
 * @author alvaro.gargon.4
 */
public class Controlador {
    private static final Logger LOG = Logger.getLogger(Controlador.class.getName());
    
    private Ventana vista;
    private AgenciaAlquiler agenciaAlquiler;
    
    public Controlador(Ventana vista, AgenciaAlquiler agenciaAlquiler) {
        this.vista = vista;
        this.agenciaAlquiler=agenciaAlquiler;
    }
    
    public void iniciar() {
        vista.mostrar();
    }
     
    public void crearVehiculo() throws MatriculaException {
        String matricula = vista.getMatricula();
        Grupo grupo = Grupo.valueOf(vista.getGrupo().toUpperCase());
        String tipo = vista.getTipo();
        float capacidad = vista.getCapacidad();
        int plazas = vista.getPlazas();
         try {
            Vehiculo vehiculo = switch (tipo) {
            case "TURISMO" ->
                new Turismo(matricula, grupo, plazas);
            case "FURGONETA" ->
                new Furgoneta(matricula, grupo, capacidad);
            default ->
                null;
        };
       
            if (vehiculo!=null && agenciaAlquiler.incluirVehiculo(vehiculo)) {
                vista.mostrarMensaje(vista.getTipo());
                vista.mostrarMensaje("Vehiculo creado con exito");
                vista.mostrarPrecioAlquiler(vehiculo.getPrecioAlquiler());
                vista.listarVehiculos(agenciaAlquiler.listarVehiculoPorPrecio());
            } else {
                vista.mostrarMensaje("Error al crear un vehiculo");
            }
        } catch (IllegalArgumentException | InputMismatchException ex) {
            LOG.log(Level.SEVERE, "Error " + ex.getMessage());
            vista.mostrarMensaje(ex.getMessage());
        } 
    }
    
    public void buscarVehiculo() {
        String matricula = vista.getMatricula();
        Vehiculo vehiculo = agenciaAlquiler.consultarVehiculo(matricula);
        if (vehiculo != null) {
            vista.mostrarMatricula(vehiculo.getMatricula());
            vista.mostrarGrupo(vehiculo.getGrupo().toString());
            vista.mostrarTipo(vehiculo instanceof Turismo  ? "TURISMO":"FURGONETA");
            if(vehiculo instanceof Turismo){
                    vista.mostrarPlazas(((Turismo) vehiculo).getPlazas());
                }else{
                    vista.mostrarCapacidad(((Furgoneta) vehiculo).getCapacidad());
                }
            vista.mostrarPrecioAlquiler(vehiculo.getPrecioAlquiler());
        } else {
            vista.mostrarMensaje("No existe un Empleado con ese nombre");
        }
    }
 
    
    public void eliminarVehiculo(){
        if (vista.solicitarConfiramcion()) {
            if (agenciaAlquiler.eliminarVehiculo(agenciaAlquiler.consultarVehiculo(vista.getMatricula()))) {
                vista.mostrarMensaje("Vehiculo eliminado");
                vista.limpiarCampos();
                vista.listarVehiculos(agenciaAlquiler.listarVehiculoPorPrecio());
            } else {
                vista.mostrarMensaje("No se ha podido eliminar el vehiculo");
            }
        }
    }
    
    public void modificarVehiculo() {
        Vehiculo vehiculo;
        String matricula = vista.getMatricula();
        try {
            vehiculo = agenciaAlquiler.consultarVehiculo(matricula);
            if (vehiculo != null) {
                vehiculo.setMatricula(vista.getMatricula());
                if (vehiculo instanceof Turismo) {
                    ((Turismo) vehiculo).setPlazas(vista.getPlazas());
                } else {
                    ((Furgoneta) vehiculo).setCapacidad(vista.getCapacidad());
                }
                vista.mostrarPrecioAlquiler(vehiculo.getPrecioAlquiler());
                vista.listarVehiculos(agenciaAlquiler.listarVehiculoPorPrecio());
            } else {
                vista.mostrarMensaje("No se ha podido modificar el contacto");
            }
        } catch (MatriculaException ex) {
            vista.mostrarMensaje(ex.toString());
        }
    }
    
    public void guardarVehiculo() {
        String nombreArchivo = vista.getArchivo();
        agenciaAlquiler.setVehiculoDao(new VehiculoCsv(nombreArchivo));
        try {
            System.out.println(agenciaAlquiler.guardarVehiculos());

        } catch (DaoException ex) {
            System.out.println(ex.toString());
        }
    }
    
     public void cargarVehiculo() {
        String nombreArchivo=vista.getArchivo();
        agenciaAlquiler.setVehiculoDao(new VehiculoCsv(nombreArchivo));
        try {
            agenciaAlquiler.cargarVehiculos();
            vista.listarVehiculos(agenciaAlquiler.listarVehiculoPorPrecio());
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    
    public void listarVehiculo() {
        List<Vehiculo> listado = null;
 
        switch (vista.getOrden()) {
            case "MATRICULA" ->
                listado = agenciaAlquiler.listarVehiculo(Grupo.valueOf(vista.getGrupo()));
            case "PRECIO ALQUILER" -> {
                listado = agenciaAlquiler.listarVehiculoPorPrecio();
                /*listado.sort(new Comparator<Vehiculo>() {
                    @Override
                    public int compare(Vehiculo v1, Vehiculo v2) {
                        return Float.compare(v1.getPrecioAlquiler(), v2.getPrecioAlquiler());
                    }
                });
                */
            }
        }
        switch (vista.getFiltroGrupo()) {
            case "TODOS" ->
                listado = agenciaAlquiler.listarVehiculoPorPrecio();
            case "A" -> {
                listado = agenciaAlquiler.listarVehiculo(Grupo.A);
            }
            case "B" ->
                listado = agenciaAlquiler.listarVehiculo(Grupo.B);
            case "C" ->
                listado = agenciaAlquiler.listarVehiculo(Grupo.C);
        }
        switch (vista.getFiltroTipo()) {
            case "TURISMO" -> {
                listado = listado.stream().filter(v -> v instanceof Turismo).collect(Collectors.toList());
            }
            case "FURGONETA" -> {
                listado = listado.stream().filter(v -> v instanceof Furgoneta).collect(Collectors.toList());
            }
        }
        vista.mostrarMensaje(vista.getFiltroTipo());
        vista.mostrarMensaje(vista.getFiltroGrupo());
        vista.listarVehiculos(listado);
    }
    public void getVehiculosMasBarato(){
        Vehiculo vehiculo = agenciaAlquiler.getVehiculoMasBarato();
        List<Vehiculo> listado = new ArrayList<>();
        listado.add(vehiculo);  
        vista.listarVehiculos(listado);

    }
    public void  getVehiculosMasCaro(){
        Vehiculo vehiculo = agenciaAlquiler.getVehiculoMasCaro();
        List<Vehiculo> listado = new ArrayList<>();
        listado.add(vehiculo);  
        vista.listarVehiculos(listado);
    }
    
}
