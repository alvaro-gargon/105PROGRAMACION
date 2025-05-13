/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class EmpleadoEventual extends Empleado {
    private float salarioHora;
    private int horas;
    private static final Logger LOG = Logger.getLogger(EmpleadoEventual.class.getName());

    public EmpleadoEventual() {
    }

    public EmpleadoEventual(String dni) throws DniException {
        super(dni);
    }

    public EmpleadoEventual(String dni, String nombre,float salarioHora, int horas) throws DniException {
        super(dni, nombre);
        if(salarioHora<0){
            LOG.log(Level.WARNING, "El salario ha sido menor de 0");
            throw new IllegalArgumentException("El salario no puede ser menor de 0");
        }
        if(horas<0){
            LOG.log(Level.WARNING, "Las horas han sido menor de 0");
            throw new IllegalArgumentException("Las horas no pueden ser menor de 0");
        }
        this.salarioHora = salarioHora;
        this.horas = horas;
    }

    public float getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(float salarioHora) {
        if(salarioHora<0){
            throw new IllegalArgumentException("El salario no puede ser menor de 0");
        }
        this.salarioHora = salarioHora;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if(horas<0){
            throw new IllegalArgumentException("Las horas no pueden ser menor de 0");
        }
        this.horas = horas;
    }

    @Override
    public String toString() {
        return super.toString()+","+salarioHora+","+horas;
    }
    @Override
    public float ingresos(){
        return horas*salarioHora;
    }
}
