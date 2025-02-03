/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

/**
 *
 * @author alvaro.gargon.4
 */
public class EmpleadoEventual extends Empleado {
    private float salarioHora;
    private int horas;

    public EmpleadoEventual() {
    }

    public EmpleadoEventual(String dni) {
        super(dni);
    }

    public EmpleadoEventual(float salarioHora, int horas, String dni, String nombre) {
        super(dni, nombre);
        this.salarioHora = salarioHora;
        this.horas = horas;
    }

    public float getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(float salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "EmpleadoEventual{" + "salarioHora=" + salarioHora + ", horas=" + horas + '}';
    }
    @Override
    public float ingresos(){
        return horas*salarioHora;
    }
}
