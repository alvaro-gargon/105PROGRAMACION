/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.sauces.appud10.modelo;

import java.util.List;

/**
 *
 * @author ambrosio
 */
public interface CuentaDao {

    List<Cuenta> listar() throws DaoException;

    int insertar(List<Cuenta> listado) throws DaoException;

    Cuenta buscar(String codigo) throws DaoException;

    int insertar(Cuenta cuenta) throws DaoException;

    int borrar(String codigo) throws DaoException;

    int modificar(Cuenta cuenta) throws DaoException;
}
