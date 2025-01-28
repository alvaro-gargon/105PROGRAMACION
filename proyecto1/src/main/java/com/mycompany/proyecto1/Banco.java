/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alvaro.gargon.4
 */
public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas=new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    
    
    public boolean abrirCuenta(Cuenta cuenta){
        return cuentas.add(cuenta);
    }
    
    public Cuenta buscarCuenta(String codigo){
        int posicion=cuentas.indexOf(new Cuenta(codigo));
        if(posicion!=-1){
            return cuentas.get(posicion);
        }
        return null;
    }
    public boolean cancelarCuenta(String codigo){
        return cuentas.remove(new Cuenta(codigo));
    }
    public float getTotalDepositos(){
        float acumulador=0;
        
        for(Cuenta c:cuentas){
            acumulador+=c.getSaldo();
        }
        return acumulador;
    }
}
