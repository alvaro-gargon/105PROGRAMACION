/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import modelo.Usuario;
import java.util.List;

/**
 *
 * @author alvaro.gargon.4
 */
public interface UsuarioDao {
    boolean insertar(Usuario usuario) throws DaoException;
    Usuario buscar(String nombre) throws DaoException;
    boolean modificar (Usuario usuario) throws DaoException;
    boolean borrar (String nombre) throws DaoException;
    List<Usuario> listar() throws DaoException;
}
