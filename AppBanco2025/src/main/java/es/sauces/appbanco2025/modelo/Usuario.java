/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.appbanco2025.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author usuario
 */
public class Usuario implements Comparable<Usuario>, Serializable {

    private static final long serialVersionUID = 1L;
    private String dni;
    private String password;
    private String nombre;
    private String email;
    private boolean activo;
    private TipoUsuario rol;
    private LocalDate fechaAlta;
    private LocalDateTime ultimoAcceso;
    private List<Cuenta> cuentas=new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String dni, String password, String nombre,String email, TipoUsuario tipoUsuario) {
        this.dni=dni;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.rol = tipoUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoUsuario getRol() {
        return rol;
    }

    public void setRol(TipoUsuario rol) {
        this.rol = rol;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(LocalDateTime ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
    
    public boolean asignarCuenta(Cuenta cuenta){
        return cuentas.add(cuenta);
    }
    
    public boolean cancelarCuenta(String codigo){
        for(Cuenta c:cuentas){
            if(c.getCodigo().equals(codigo)){
                return cuentas.remove(c);
            }
        }
        return false;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.dni.compareTo(o.dni);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.dni, other.dni);
    }
    
   
}
