/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class EmpleadoFijo extends Empleado {
    private float salario;
    private static final Logger LOG = Logger.getLogger(EmpleadoFijo.class.getName());

    public EmpleadoFijo() {
    }

    public EmpleadoFijo(String dni) throws DniException {
        super(dni);
    }

    public EmpleadoFijo(String dni, String nombre) throws DniException {
        super(dni, nombre);
    }

    public EmpleadoFijo(String dni, String nombre,float salario) throws DniException {
        super(dni, nombre);
        if(salario<0){
            LOG.log(Level.WARNING, "La cantidad ha sido menor de 0");
            throw new IllegalArgumentException("El salario no puede ser menor de 0");
        }
        this.salario = salario;
    }
    

    public void setSalario(float salario) {
        if(salario<0){
            throw new IllegalArgumentException("El salario no puede ser menor de 0");
        }
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString()+","+salario;
    }

    
    @Override
    public float ingresos(){
        return salario;
    }
}
