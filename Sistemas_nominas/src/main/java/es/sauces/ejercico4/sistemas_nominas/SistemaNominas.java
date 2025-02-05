/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * @author alvaro.gargon.4
 */
public class SistemaNominas {
    
    private Set<Empleado> empleados;

    public SistemaNominas() {
        empleados=new TreeSet<>();
    }
    
    
    public boolean incluirEmpleado(Empleado empleado){
        return empleados.add(empleado);
    }
    
    public Empleado getEmpleado(String dni){
        for(Empleado e:empleados){
            if(e.getDni().equals(dni)){
                return e;
            }
        }
        return null;
    }
    
    public boolean eliminarEmpleado(Empleado empleado){
        return empleados.remove(empleado);
    }
    
    public List<Empleado> listarEmpleados(){
        return new ArrayList<>(empleados);
    }
    
    public List<Empleado> listarEmpleadosPorSueldo(){
        ArrayList listaOrdenada = new ArrayList<>(empleados);
        listaOrdenada.sort(new ComparadorSueldo());
        return listaOrdenada;
    }
    
    public float getTotalSalarios(){
        float acum;
        Empleado empleado=null;
        acum=0;
        for(Empleado e:empleados){
           acum=acum+e.ingresos();
        }
        return acum;
    }
}
