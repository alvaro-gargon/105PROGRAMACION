/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Comparator;

/**
 *
 * @author alvaro.gargon.4
 */
public class ComparadorSueldo implements Comparator<Empleado> {
    @Override
    public int compare(Empleado e1, Empleado e2){
        return Float.compare(e1.ingresos(), e2.ingresos());
    }
}
