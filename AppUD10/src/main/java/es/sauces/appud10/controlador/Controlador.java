/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appud10.controlador;

import es.sauces.appud10.modelo.Banco;
import es.sauces.appud10.modelo.Cuenta;
import es.sauces.appud10.modelo.CuentaDao;
import es.sauces.appud10.modelo.CuentaDaoCsv;
import es.sauces.appud10.modelo.DaoException;
import es.sauces.appud10.modelo.SaldoException;
import es.sauces.appud10.vista.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ambrosio
 */
public class Controlador {

    private Ventana vista;
    private Banco modelo;

    public Controlador(Ventana vista, Banco modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void buscarCuenta() {
        String codigo = vista.getCodigo();
        try {
            Cuenta cuenta = modelo.getCuenta(codigo);
            if (cuenta != null) {
                vista.mostrarTitular(cuenta.getTitular());
                vista.mostrarSaldo(cuenta.getSaldo());
            } else {
                vista.mostrarMensaje("No se ha encontrado la cuenta");
                vista.limpiarCampos();
            }
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.toString());
        }

    }

    public void abrirCuenta() {
        String codigo = vista.getCodigo();
        String titular = vista.getTitular();
        float saldo = vista.getSaldo();
        try {
            if (modelo.abrirCuenta(codigo, titular, saldo)) {
                vista.mostrarMensaje("Cuenta creado con exito");
            } else {
                vista.mostrarMensaje("No se ha podido crear una cuenta");
            }
            listarCuentas();
        } catch (SaldoException | DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void operarConCuenta() {
        String operacion;
        float cantidad;
        String codigo = vista.getCodigo();
        Cuenta cuenta = null;
        try {
            cuenta = modelo.getCuenta(codigo);
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
        if (cuenta != null) {
            try {
                operacion = vista.getOperacion();
                if (operacion != null) {
                    cantidad = vista.getCantidad();
                    switch (operacion) {
                        case "INGRESAR" -> {
                            cuenta.ingresar(cantidad);
                        }
                        case "REINTEGRAR" -> {
                            cuenta.reintegrar(cantidad);
                        }
                    }
                    try {
                        modelo.modificarCuenta(cuenta);
                        vista.mostrarSaldo(cuenta.getSaldo());
                    } catch (DaoException ex) {
                        vista.mostrarMensaje(ex.getMessage());
                    }
                }
            } catch (SaldoException|IllegalArgumentException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        } else {
            vista.mostrarMensaje("No existe la cuenta");
        }
    }

    public void cancelarCuenta() {
        try {
            String codigo=vista.getCodigo();
            if(modelo.cancelarCuenta(codigo)){
                vista.limpiarCampos();
                vista.mostrarMensaje("Cuenta eliminada");
                listarCuentas();
            }else{
                vista.mostrarMensaje("No se ha podido eliminar");
            }
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void listarCuentas() {
        try {
            vista.mostrarCuentas(modelo.getCuentas());
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void importarCuentas() {
        String nombreArchivo=vista.getArchivo();
        CuentaDao dao=getDao(nombreArchivo);
        if(dao!=null){
            try {
               for(Cuenta cuenta:dao.listar()){
                   try {
                       modelo.abrirCuenta(cuenta.getCodigo(), cuenta.getTitular(), cuenta.getSaldo());
                   } catch (SaldoException ex) {
                       vista.mostrarMensaje(ex.getMessage());
                   }
               }
               listarCuentas();
            } catch (DaoException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        }
    }

    public void exportarCuentas() {
        String nombreArchivo=vista.getArchivo();
        CuentaDao dao=getDao(nombreArchivo);
        if(dao!=null){
            try {
                dao.insertar(modelo.getCuentas());
            } catch (DaoException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        }
    }

    public void iniciar() {
        try {
            vista.mostrarCuentas(modelo.getCuentas());
            vista.mostrar();
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    private CuentaDao getDao(String archivo) {
        CuentaDao dao = null;
        String extension;
        int pos = archivo.lastIndexOf(".");
        if (pos > 0) {
            extension = archivo.substring(pos);
            switch (extension) {
                case ".csv" ->
                    dao = new CuentaDaoCsv(archivo);

            }
        }
        return dao;
    }

}
