/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appud10.modelo;

import java.util.List;

/**
 *
 * @author ambrosio
 */
public class Banco {

    private String nombre;
    private CuentaDao dao;

    public Banco(String nombre) {
        this.nombre = nombre;

    }

    public CuentaDao getDao() {
        return dao;
    }

    public void setDao(CuentaDao dao) {
        this.dao = dao;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas() throws DaoException {
        return dao.listar();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean abrirCuenta(String codigo, String titular, float saldo) throws SaldoException, DaoException {
        return dao.insertar(new Cuenta(codigo, titular, saldo)) == 1;
    }

    public boolean cancelarCuenta(String codigo) throws DaoException {
        return dao.borrar(codigo) == 1;
    }

    public float getTotalDepositos() throws DaoException {
        float total = 0;
        for (Cuenta c : dao.listar()) {
            total += c.getSaldo();
        }
        return total;
    }

    public Cuenta getCuenta(String codigo) throws DaoException {
        return dao.buscar(codigo);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public boolean modificarCuenta(Cuenta cuenta) throws DaoException {
        return dao.modificar(cuenta) == 1;
    }
}
