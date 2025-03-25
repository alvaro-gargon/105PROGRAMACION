/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Operadora {
    private String nombre;
    private Set<Tarifa> tarifas;
    private Map<String,LineaMovil> lineas;

    
    // COMPLETA EL CÓDIGO
    public Operadora(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    // COMPLETA EL CÓDIGO
    public List<Tarifa> getTarifas() {
        return new ArrayList<>(tarifas);
    }

    // COMPLETA EL CÓDIGO
    public void setTarifas(List<Tarifa> tarifas) {
        this.tarifas = new TreeSet<>(tarifas);
    }

    // COMPLETA EL CÓDIGO
    public List<LineaMovil> getLineas() {
        return null;
    }

    // COMPLETA EL CÓDIGO
    public void setLineas(List<LineaMovil> lineas) {
        //hay que hacer el mapa a mano
       this.lineas=new TreeMap<>();
       for(LineaMovil l:lineas){
           agregarLineaMovil(l);
       }
    }
    
    // COMPLETA EL CÓDIGO
    public boolean agregarTarifa(Tarifa tarifa){
        return tarifas.add(tarifa);
    }
    
    // COMPLETA EL CÓDIGO
    public Tarifa getTarifa(String nombre){
        for(Tarifa t:tarifas){
            if(t.getNombre().equals(nombre)){
                return t;
            }
        }
        return null;
    }
    
    // COMPLETA EL CÓDIGO
    public boolean agregarLineaMovil(LineaMovil linea){
        return lineas.putIfAbsent(nombre, linea)==null;
    }
    
    // COMPLETA EL CÓDIGO
    public LineaMovil getLineaMovil(String numero){
        return lineas.get(numero);
    }
    
    // COMPLETA EL CÓDIGO
    public boolean cancelarLineaMovil(String numero){
        return lineas.remove(numero)!=null;
    }
}
