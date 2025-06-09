/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appbanco2025.controlador;

import es.sauces.appbanco2025.dao.CuentaDao;
import es.sauces.appbanco2025.dao.DaoException;
import es.sauces.appbanco2025.dao.GestorDao;
import es.sauces.appbanco2025.modelo.Cuenta;
import es.sauces.appbanco2025.modelo.Movimiento;
import es.sauces.appbanco2025.modelo.TipoUsuario;
import es.sauces.appbanco2025.modelo.Usuario;
import es.sauces.appbanco2025.vista.Ventana;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Ambrosio
 */
public class Controlador {
    private Ventana vista;
    private GestorDao modelo;
    private Usuario usuarioActivo;
    
    public Controlador(Ventana vista, GestorDao modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
   
    public void iniciar(){
        vista.mostrar();
    }
    public void hacerLogin() {
        try {
            usuarioActivo = modelo.getUsuarioDao().buscar(vista.getDniU());
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (usuarioActivo != null) {
            String password = vista.getPasswordU();
            String contraseña = DigestUtils.sha256Hex(password);
            if (usuarioActivo.getPassword().equals(contraseña)) {
                vista.cambiarVista(usuarioActivo.getRol());
                vista.mostrarDni(usuarioActivo.getDni());
                vista.mostrarNombre(usuarioActivo.getNombre());
                vista.mostrarEmail(usuarioActivo.getEmail());
                listarCuentasUsuario();
            } else {
                vista.mostrarMensaje("Usuario o contraseña incorrectos");
            }
        } else {
            vista.mostrarMensaje("Usuario o contraseña incorrectos");
        }
    }
    
    public void hacerLogout(){
        usuarioActivo=null;
        vista.cambiarVista(TipoUsuario.INVITADO);
    }
    
    public void listarCuentasUsuario(){
        try {
            if(usuarioActivo!=null){
            int i=0;
            List<Cuenta> listado=modelo.getCuentaDao().listar(usuarioActivo.getDni());
            String[] cuentas=new String[listado.size()];
            for(Cuenta c : listado){
                cuentas[i]=c.getCodigo();
                i++;
            }
            vista.mostrarCuentas(cuentas);
            }else{
                vista.mostrarMensaje("Usuario no encontrado");
            }
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void buscarCuenta(){
        try {
            Cuenta cuenta=modelo.getCuentaDao().buscar(vista.getCodigoCuenta());
            if(cuenta!=null){
            vista.mostrarSaldoCuenta(cuenta.getSaldo());
            vista.mostrarMovimientos(modelo.getMovimientoDao().listar(cuenta.getCodigo()));
            }
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.toString());
        }
    }
    public void ingresar(){
        try {
            String codigoCuenta=vista.getCodigoCuenta();
            Cuenta cuenta;
            cuenta=modelo.getCuentaDao().buscar(codigoCuenta);
            Movimiento m=cuenta.ingresar(vista.getCantidad());
            modelo.getMovimientoDao().insertar(m, codigoCuenta);
            modelo.getCuentaDao().modificar(cuenta);
            vista.mostrarSaldoCuenta(cuenta.getSaldo());
            vista.mostrarMovimientos(modelo.getMovimientoDao().listar(cuenta.getCodigo()));
        } catch (DaoException|IllegalArgumentException ex) {
            vista.mostrarMensaje(ex.toString());
        }
                
    }
    public void reintegrar(){
        try {
            String codigoCuenta=vista.getCodigoCuenta();
            Cuenta cuenta;
            cuenta=modelo.getCuentaDao().buscar(codigoCuenta);
            Movimiento m=cuenta.reintegrar(vista.getCantidad());
            modelo.getMovimientoDao().insertar(m, codigoCuenta);
            modelo.getCuentaDao().modificar(cuenta);
            vista.mostrarSaldoCuenta(cuenta.getSaldo());
            vista.mostrarMovimientos(modelo.getMovimientoDao().listar(cuenta.getCodigo()));
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.toString());
        }
    }
    public void abrirCuenta(){
        try {
            String codigoCuenta=vista.getCodigoCuenta();
            vista.mostrarCodigoCuenta(codigoCuenta);
            Cuenta cuenta=null;
            cuenta=new Cuenta(codigoCuenta,usuarioActivo,vista.getSaldo());
            if(usuarioActivo.asignarCuenta(cuenta)){
                modelo.getCuentaDao().insertar(cuenta);
                listarCuentasUsuario();
            }else{
                vista.mostrarMensaje("No se ha podido abrir una cuenta nueva");
            }
        }catch(DaoException ex){
            vista.mostrarMensaje(ex.toString());
        }
    }
    public void cancelarCuenta(){
        //tiene que no tener movimientos
        try {
            String codigoCuenta=vista.getCodigoCuenta();
            modelo.getCuentaDao().borrar(codigoCuenta);
            if(usuarioActivo.cancelarCuenta(codigoCuenta)){
                vista.mostrarMensaje("Cuenta cancelada con exito");
            }else{
                vista.mostrarMensaje("No se ha podido cancelar la cuenta");
            }
            listarCuentasUsuario();
        }catch(DaoException ex){
            vista.mostrarMensaje(ex.toString());
        }
    }
    public void crearUsuario(){
        try {
            Usuario usuario=new Usuario();
            String nombre = vista.getNombre();
            String email = vista.getEmail();
            String contraseña = vista.getPasswordU();
            String password = DigestUtils.sha256Hex(contraseña);
            String dni=vista.getDni();
            usuario.setDni(dni);
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setActivo(true);
            usuario.setFechaAlta(LocalDate.now());
            usuario.setRol(TipoUsuario.REGISTRADO);
            usuario.setUltimoAcceso(null);
            modelo.getUsuarioDao().insertar(usuario);
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.toString());
        }
    }
    public void modificarUsuario(){
        String dni = vista.getDni();
        Usuario usuario = null;
        try {
            usuario = modelo.getUsuarioDao().buscar(dni);
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
        if (usuario != null) {
            try {
                usuario.setNombre(vista.getNombre());
                usuario.setEmail(vista.getEmail());
                modelo.getUsuarioDao().modificar(usuario);
            } catch (DaoException|IllegalArgumentException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        } else {
            vista.mostrarMensaje("No existe el usuario");
        }
    
    }
    public void borrarUsuario(){
        try {
            String dni=vista.getDni();
            modelo.getUsuarioDao().borrar(dni);
            vista.mostrarMensaje("Usuario borrado");
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
}
