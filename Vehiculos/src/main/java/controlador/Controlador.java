/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
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
import modelo.VehiculoDao;
import modelo.VehiculoJson;
import modelo.VehiculoObj;
import modelo.VehiculoXml;
import vista.Ventana;

/**
 *
 * @author marcos.fergar
 */
public class Controlador {

    private static final Logger LOG = Logger.getLogger(Controlador.class.getName());

    Scanner teclado = new Scanner(System.in);

    private Ventana vista;
    private AgenciaAlquiler modelo;

    public Controlador(Ventana vista, AgenciaAlquiler modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciar() {
        vista.mostrar();
    }

    public void crearVehiculo() throws MatriculaException {
        String matricula = vista.getMatricula();
        String tipo = vista.getTipo();
        int plazas = vista.getPlazas();
        float capacidad = vista.getCapacidad();

        Grupo grupo = Grupo.valueOf(vista.getGrupo().toUpperCase());

        try {
            Vehiculo vehiculo = switch (tipo) {
                case "Turismo" ->
                    new Turismo(matricula, grupo, plazas);
                case "Furgoneta" ->
                    new Furgoneta(matricula, grupo, capacidad);
                default ->
                    null;
            };

            if (vehiculo != null && modelo.incluirVehiculo(vehiculo)) {
                vista.mostrarMensaje("Vehiculo creado con exito");
                vista.mostrarPrecioAlquiler(vehiculo.getPrecioAlquiler());
                vista.listarVehiculos(modelo.listarVehiculoPorPrecio());
            } else {
                vista.mostrarMensaje("Error al crear un vehiculo");
            }
        } catch (MatriculaException | IllegalArgumentException | InputMismatchException ex) {
            LOG.log(Level.SEVERE, "Error " + ex.getMessage());
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void buscarVehiculo() {
        String matricula = vista.getMatricula();
        String tipo = vista.getTipo();
        String grupo = vista.getGrupo();
        Vehiculo vehiculo = (Vehiculo) modelo.getVehiculos();
        if (vehiculo != null) {
            vista.mostrarMatricula(matricula);
            vista.mostrarTipo(tipo);
            vista.mostrarGrupo(grupo);
            if (vehiculo instanceof Turismo) {
                vista.mostrarPlazas(((Turismo) vehiculo).getPlazas());
            } else {
                vista.mostrarCapacidad(((Furgoneta) vehiculo).getCapacidad());
            }
            vista.mostrarPrecioAlquiler(vehiculo.getPrecioAlquiler());
        } else {
            vista.mostrarMensaje("No existe un Vehiculo con ese nombre");
        }
    }

    public void eliminarVehiculo() {
        if (vista.solicitarConfirmacion()) {
            if (modelo.eliminarVehiculo(modelo.consultarVehiculo(vista.getMatricula()))) {
                vista.mostrarMensaje("Vehiculo eliminado");
                vista.limpiarCampos();
                vista.listarVehiculos(modelo.listarVehiculo(Grupo.valueOf(vista.getGrupo())));
            } else {
                vista.mostrarMensaje("No se ha podido eliminar el vehiculo");
            }
        }
    }

    public void modificarVehiculo() {
        Vehiculo vehiculo;
        String matricula = vista.getMatricula();
        try {
            vehiculo = modelo.consultarVehiculo(matricula);
            if (vehiculo != null) {
                vehiculo.setMatricula(vista.getMatricula());
                if (vehiculo instanceof Turismo) {
                    ((Turismo) vehiculo).setPlazas(vista.getPlazas());
                } else {
                    ((Furgoneta) vehiculo).setCapacidad(vista.getCapacidad());
                }
                vista.mostrarPrecioAlquiler(vehiculo.getPrecioAlquiler());
                vista.listarVehiculos(modelo.listarVehiculo(Grupo.valueOf(vista.getGrupo())));
            } else {
                vista.mostrarMensaje("No se ha podido modificar el contacto");
            }
        } catch (MatriculaException ex) {
            vista.mostrarMensaje(ex.toString());
        }
    }

    public void guardarVehiculo() throws DaoException {
        String nombreArchivo = vista.getArchivo();
        modelo.setVehiculoDao(new VehiculoCsv(nombreArchivo));
        System.out.println(modelo.guardarVehiculos());
    }

    public void cargarVehiculo() {
        String nombreArchivo = vista.getArchivo();
        modelo.setVehiculoDao(new VehiculoCsv(nombreArchivo));
        try {
            modelo.cargarVehiculos();
            vista.listarVehiculos(modelo.listarVehiculo(Grupo.valueOf(vista.getGrupo())));
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void listarVehiculo() {
        List<Vehiculo> listado = null;

        switch (vista.getOrden()) {
            case "MATRICULA" ->
                listado = modelo.listarVehiculo(Grupo.valueOf(vista.getGrupo()));
            case "PRECIO ALQUILER" ->
                listado = modelo.listarVehiculoPorPrecio().reversed();
        }
        switch (vista.getFiltroGrupo()) {
            case "TODOS" ->
                listado = modelo.listarVehiculoPorPrecio();
            case "A" -> {
                listado = modelo.listarVehiculo(Grupo.A);
            }
            case "B" ->
                listado = modelo.listarVehiculo(Grupo.B);
            case "C" ->
                listado = modelo.listarVehiculo(Grupo.C);
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
        Vehiculo vehiculo = modelo.getVehiculoMasBarato();
        List<Vehiculo> listado = new ArrayList<>();
        listado.add(vehiculo);  
        vista.listarVehiculos(listado);
 
    }
    public void  getVehiculosMasCaro(){
        Vehiculo vehiculo = modelo.getVehiculoMasCaro();
        List<Vehiculo> listado = new ArrayList<>();
        listado.add(vehiculo);  
        vista.listarVehiculos(listado);
    }

    private static VehiculoDao getDao(String nombreArchivo) {
        VehiculoDao vehiculoDao = null;
        String extension = null;
        int indice = nombreArchivo.lastIndexOf(".");
        extension = nombreArchivo.substring(indice);
        //lastindexof(.)
        vehiculoDao = switch (extension) {
            case ".csv" ->
                new VehiculoCsv(nombreArchivo);
            case ".obj" ->
                new VehiculoObj(nombreArchivo);
            case ".gson" ->
                new VehiculoJson(nombreArchivo);
            case ".xml" ->
                new VehiculoXml(nombreArchivo) {
                };
            default ->
                null;
        };
        return vehiculoDao;
    }
}
