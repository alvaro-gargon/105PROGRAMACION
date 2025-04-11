/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

import java.util.List;

/**
 *
 * @author alvaro.gargon.4
 */
public interface VehiculoDao {
    List<Vehiculo> listar() throws DaoException;
    int insertar(List<Vehiculo> vehiculos) throws DaoException;
}
