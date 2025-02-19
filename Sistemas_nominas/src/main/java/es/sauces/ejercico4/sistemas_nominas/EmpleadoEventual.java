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

    public EmpleadoEventual(Dni dni) {
        super(dni);
    }

    public EmpleadoEventual(Dni dni, String nombre,float salarioHora, int horas) {
        super(dni, nombre);
        if(salarioHora<0){
            throw new IllegalArgumentException("El salario no puede ser menor de 0");
        }
        if(horas<0){
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
