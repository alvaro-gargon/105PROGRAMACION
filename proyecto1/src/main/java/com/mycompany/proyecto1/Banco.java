/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author alvaro.gargon.4
 */
public class Banco {
    private String nombre;
    private Map<String,Cuenta> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas=new TreeMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return new ArrayList<>(cuentas.values());
    }
    
    
    public boolean abrirCuenta(Cuenta cuenta){
        return cuentas.putIfAbsent(cuenta.getCodigo(), cuenta)==null;
    }
    
    public Cuenta buscarCuenta(String codigo){
        return cuentas.get(codigo);
    }
    
    public boolean cancelarCuenta(String codigo){
        return cuentas.remove(codigo)!=null;
    }
    public float getTotalDepositos(){
        float acumulador=0;
        
        for(Cuenta c:cuentas.values()){
            acumulador+=c.getSaldo();
        }
        return acumulador;
    }
}
