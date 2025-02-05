/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

/**
 *
 * @author alvaro.gargon.4
 */
public class EmpleadoFijo extends Empleado {
    private float salario;

    public EmpleadoFijo() {
    }

    public EmpleadoFijo(String dni) {
        super(dni);
    }

    public EmpleadoFijo(String dni, String nombre) {
        super(dni, nombre);
    }

    public EmpleadoFijo(String dni, String nombre,float salario) {
        super(dni, nombre);
        this.salario = salario;
    }
    

    public void setSalario(float salario) {
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
