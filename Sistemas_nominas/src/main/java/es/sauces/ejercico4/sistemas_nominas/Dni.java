/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alvaro.gargon.4
 */
public class Dni implements Comparable<Dni>{

    private String dni;

    private Dni(String dni) throws DniException {
        if(!esDniValido(dni)){
            throw new DniException("Formato de DNI incorrecto");
        }
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DniException {
        if(!esDniValido(dni)){
            throw new DniException("Formato de DNI incorrecto");
        }
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Dni{" + "dni=" + dni + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.dni);
        return hash;
    }
    
    public static Dni valueOf(String dni) throws DniException{
        if(!esDniValido(dni)){
            throw new DniException("Formato de DNI incorrecto");
        }
        return new Dni(dni);
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
        final Dni other = (Dni) obj;
        return Objects.equals(this.dni, other.dni);
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

    @Override
    public int compareTo(Dni o) {
        return this.dni.compareTo(o.dni);
    }
    
}
