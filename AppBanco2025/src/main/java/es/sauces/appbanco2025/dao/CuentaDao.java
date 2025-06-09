/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.appbanco2025.dao;

import es.sauces.appbanco2025.modelo.Cuenta;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface CuentaDao {
    public void insertar(Cuenta cuenta) throws DaoException;
    public void modificar(Cuenta cuenta) throws DaoException;
    public void borrar(String codigo) throws DaoException;
    public Cuenta buscar(String codigo) throws DaoException;
    public List<Cuenta> listar() throws DaoException;
    public List<Cuenta> listar(String titular) throws DaoException;
}
