/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

import java.util.List;

/**
 *
 * @author alvaro.gargon.4
 */
public interface EmpleadoDao {
    List<Empleado> listar() throws DaoException;
    int insertar(List<Empleado> empleados) throws DaoException;
    
}
