/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author alvaro.gargon.4
 */
public class AgenciaAlquiler {
 private VehiculoDao vehiculoDao;
 private String nombre;
 private Map<String,Vehiculo> vehiculos;

    
    public AgenciaAlquiler(String nombre) {
        this.nombre = nombre;
        vehiculos=new TreeMap<>();
    }
    
    public List<Vehiculo> getVehiculos(){
        return new ArrayList<>(vehiculos.values());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVehiculos(Map<String, Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public VehiculoDao getVehiculoDao() {
        return vehiculoDao;
    }

    public void setVehiculoDao(VehiculoDao vehiculoDao) {
        this.vehiculoDao = vehiculoDao;
    }
    
    public boolean incluirVehiculo(Vehiculo vehiculo){
        return vehiculos.putIfAbsent(vehiculo.getMatricula(), vehiculo)==null;
    }
    
    public Vehiculo consultarVehiculo(String matricula){
        return vehiculos.get(matricula);
    }
    
    public boolean eliminarVehiculo(Vehiculo vehiculo){
        return vehiculos.remove(vehiculo.getMatricula())!=null;
    }
    
    public List<Vehiculo> listarVehiculoPorPrecio(){
        ArrayList listaPrecio = new ArrayList<>(vehiculos.values());
        listaPrecio.sort(new ComparadorPrecio());
        return listaPrecio;
    }
    
    public List<Vehiculo> listarVehiculo(Grupo grupo){
        ArrayList listaGrupo = new ArrayList<>();
        for(Vehiculo v:vehiculos.values()){
            if(v.getGrupo()==grupo){
                listaGrupo.add(v);
            }
        }
        return listaGrupo;
    }
    
    public Vehiculo getVehiculoMasBarato(){
        ArrayList buscarMenor = new ArrayList<>(vehiculos.values());
        return Collections.min(buscarMenor,new ComparadorPrecio());
    }
    
    public Vehiculo getVehiculoMasCaro(){
        ArrayList buscarMenor = new ArrayList<>(vehiculos.values());
        return Collections.max(buscarMenor,new ComparadorPrecio());
    }
    
    public int guardarVehiculos() throws DaoException{
        if(vehiculoDao==null){
            throw new DaoException("Empleado null");
        }
        vehiculoDao.insertar(new ArrayList<>(vehiculos.values()));
        return vehiculos.size();
    }
    
    public int cargarVehiculos() throws DaoException{
        if(vehiculoDao==null){
            throw new DaoException("Empleado null");
        }
        for (Vehiculo v : vehiculoDao.listar()) {
            vehiculos.putIfAbsent(v.getMatricula(), v);
        }
        return vehiculos.size();
    }
}
