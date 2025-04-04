/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alvaro.gargon.4
 */
public abstract class  Empleado implements Serializable,Comparable<Empleado> {
    private String dni;
    private String nombre;
    private static final Logger LOG = Logger.getLogger(Empleado.class.getName());
    private static final long serialVersionUID=1L;

    public Empleado() {
    }

    public Empleado(String  dni) throws DniException {
        if(!esDniValido(dni)){
            LOG.log(Level.SEVERE, "El dni no es valido: "+dni);
            throw new DniException("El dni no es valido: "+dni);
        }
        this.dni=dni;
    }

    public Empleado(String dni, String nombre) throws DniException {
         if(!esDniValido(dni)){
             LOG.log(Level.SEVERE, "El dni no es valido: "+dni);
            throw new DniException("El dni no es valido: "+dni);
        }
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DniException {
         if(!esDniValido(dni)){
             LOG.log(Level.SEVERE, "El dni no es valido: "+dni);
            throw new DniException("El dni no es valido: "+dni);
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public int compareTo(Empleado empleado){
        return this.dni.compareTo(empleado.dni);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dni);
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return   dni+","+nombre;
    }
    
    private static boolean esDniValido(String dni){
        boolean valido=false;
        String patron="([0-9]{8})([A-Z])";
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        int posicion;
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(dni);
        if(m.matches()){
            posicion=Integer.parseInt(m.group(1))%23;
            valido=letras.charAt(posicion)==m.group(2).charAt(0);
            return valido;
        }
        return valido;
    }
    
    public abstract float ingresos();
    
 
}
