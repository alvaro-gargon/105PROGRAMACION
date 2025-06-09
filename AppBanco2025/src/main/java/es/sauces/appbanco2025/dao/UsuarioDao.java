/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.appbanco2025.dao;

import es.sauces.appbanco2025.modelo.Usuario;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface UsuarioDao {
    void insertar(Usuario usuario) throws DaoException;
    Usuario buscar(String dni) throws DaoException;
    void borrar(String dni) throws DaoException;
    void modificar(Usuario usuario) throws DaoException;
    List<Usuario> listar() throws DaoException;
}
