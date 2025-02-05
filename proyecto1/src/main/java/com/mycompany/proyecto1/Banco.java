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

    /**
     *
     * @param nombre
     */
    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas=new TreeMap<>();
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public List<Cuenta> getCuentas() {
        return new ArrayList<>(cuentas.values());
    }
    
    /**
     *
     * @param cuenta
     * @return
     */
    public boolean abrirCuenta(Cuenta cuenta){
        return cuentas.putIfAbsent(cuenta.getCodigo(), cuenta)==null;
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public Cuenta buscarCuenta(String codigo){
        return cuentas.get(codigo);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean cancelarCuenta(String codigo){
        return cuentas.remove(codigo)!=null;
    }

    /**
     *
     * @return
     */
    public float getTotalDepositos(){
        float acumulador=0;
        
        for(Cuenta c:cuentas.values()){
            acumulador+=c.getSaldo();
        }
        return acumulador;
    }
}
