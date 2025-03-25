/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// COMPLETA EL CÓDIGO
public class LineaMovil {
    private final String numero;
    private String cliente;
    private Tarifa tarifa;
    private int datosDisponibles;
    private List<Consumo> consumos;
    private static final Logger LOG = Logger.getLogger(LineaMovil.class.getName());

    
    // COMPLETA EL CÓDIGO
    public LineaMovil(String numero, String cliente, Tarifa tarifa) throws NumeroFormatException {
        String patron="([6|7]{1})([0-9]{8})";
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(numero);
        m.matches();
        if(m.matches()==false){
            LOG.log(Level.SEVERE, "El numero no cumple el formato: ([6|7]{1})([0-9]{8})"+numero);
            throw new NumeroFormatException("El formato del numero es incorrecto");
        }
        this.datosDisponibles=tarifa.getDatos()*1000;
        this.consumos=new LinkedList<>();
        this.numero = numero;
        this.cliente = cliente;
        this.tarifa = tarifa;
    }

    public String getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public int getDatosDisponibles() {
        return datosDisponibles;
    }

    public void setDatosDisponibles(int datosDisponibles) {
        this.datosDisponibles = datosDisponibles;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }
    
    // COMPLETA EL CÓDIGO
    public float registrarLlamada(LocalDate fecha, LocalTime hora, String numero, int duracion){
        float importe;
        if(duracion<0){
            LOG.log(Level.SEVERE,"Duracion negativa"+duracion);
            throw new IllegalArgumentException("La duracion no puede ser negativa");
        }
        Consumo llamada =null;
        importe=tarifa.getPrecioEstablecimiento()+Math.ceilDiv(duracion,60)*tarifa.getPrecioMinuto();
        llamada=new Llamada(fecha, hora, importe, numero, duracion);
        consumos.add(llamada);
        return importe;
    }
    
    // COMPLETA EL CÓDIGO
    public float registrarSms(LocalDate fecha, LocalTime hora, String numero){
        float importe;
        Consumo sms;
        importe=tarifa.getPrecioSms();
        sms=new Sms(fecha,hora,importe,numero);
        consumos.add(sms);
        return importe;
    }
    
    // COMPLETA EL CÓDIGO
    public int registrarConsumoDatos(LocalDate fecha, LocalTime hora, int volumen) throws DatosException{
        if(volumen<0 || volumen>datosDisponibles){
            throw new DatosException("El consumo de datos es mayor que los datos disponibles");
        }
        float importe=0;
        datosDisponibles=datosDisponibles-volumen;
        Consumo datos;
        datos=new Datos(fecha,hora, importe,volumen);
        return datosDisponibles;
    }
    
    // COMPLETA EL CÓDIGO
    public List<Consumo> listarConsumos(TipoConsumo tipoConsumo){
        ArrayList listaConsumo = new ArrayList<>();
        for(Consumo c:consumos){
            if(c.getTipoConsumo()==tipoConsumo){
                listaConsumo.add(c);
            }
        }
        return listaConsumo;
    }
    
    // COMPLETA EL CÓDIGO
    public List<Consumo> listarConsumos(LocalDate desde, LocalDate hasta){
        ArrayList listaConsumo = new ArrayList<>();
        for(Consumo c:consumos){
            if(c.getFecha().isAfter(desde)&&c.getFecha().isBefore(hasta)){
                listaConsumo.add(c);
            }
        }
        return listaConsumo;
    }
    
    // COMPLETA EL CÓDIGO
    public String getConsumo(TipoConsumo tipoConsumo){
        int contador,acum;
        contador=0;
        acum=0;
        //ListIterator<Consumo> iterador=consumos.listIterator();
        /*
            while(iterador.){
            if(c.getTipoConsumo()==tipoConsumo){
                acum=acum+c.getDuracionVolumen();
                contador++;
            }
            }
        */
        for(Consumo c:consumos){
            if(c.getTipoConsumo()==tipoConsumo){
                acum=acum+c.getDuracionVolumen();
                contador++;
            }
        }
        return contador+","+acum;
    }
    
    // COMPLETA EL CÓDIGO
    public Consumo getConsumoMayorImporte(){
        Consumo consumoMayor = null;
        float importeMayor=Float.MAX_VALUE;
        for(Consumo c:consumos){
            if(c.getImporte()<importeMayor){
                importeMayor=c.getImporte();
                consumoMayor=c;
            }     
        }
        return consumoMayor;
    }
    
    // COMPLETA EL CÓDIGO
    public Llamada getLLamadaMayorDuracion(){
        Llamada llamadaMasLarga = null;
        int duracionMayor=Integer.MAX_VALUE;
        for(Consumo c:consumos){
            if(c instanceof Llamada l){
                if(l.getDuracion()<duracionMayor){
                duracionMayor=l.getDuracion();
                llamadaMasLarga=l;
                }     
            }
        }
        return llamadaMasLarga;
    }
    
    // COMPLETA EL CÓDIGO
    public int cargarConsumos(String archivo) throws DaoException{
        Path path;
        int contador;
        String tipo,linea,dormitorios,escaparate,referencia;
        String[] parte;
        path=Paths.get(archivo);
        Consumo consumo = null;
        contador=0;
        try(BufferedReader entrada=Files.newBufferedReader(path)){
            linea=entrada.readLine();
            while(linea!=null){
                parte=linea.split(",");
                tipo=parte[0];
                if("LLAMADA".equals(tipo)){
                    consumo=new Llamada(LocalDate.parse(parte[1]), LocalTime.parse(parte[2]), 
                            Float.parseFloat(parte[3]),parte[4], Integer.parseInt(parte[5]));
                }else if("SMS".equals(tipo)){
                    
                    consumo=new Sms(LocalDate.parse(parte[1]),LocalTime.parse(parte[2])
                            ,Float.parseFloat(parte[3]),parte[4]);
                }else{
                    consumo=new Datos(LocalDate.parse(parte[1]),LocalTime.parse(parte[2]),Float.parseFloat(parte[3])
                            ,Integer.parseInt(parte[4]));
                }
                contador++;
                consumos.add(consumo);
                linea=entrada.readLine();
            }
        } catch (IOException ex) {
            LOG.log(Level.INFO, "No se ha podido cargar los archivos");
            throw new DaoException("Error al cargar los consumos en el archivo");
        }
        return contador;
    }
    
    // COMPLETA EL CÓDIGO
    public int guardarConsumos(String archivo) throws DaoException{
        Path path;
        int contador;
        String tipo;
        path=Paths.get(archivo);
        contador=0;
            try(BufferedWriter salida = Files.newBufferedWriter(path)) 
            {
                for(Consumo c: consumos){
                    salida.write(c.toString());
                    salida.newLine();
                    contador++;
                }
            }catch(IOException ioe){
                LOG.log(Level.INFO, "No se ha podido guardar los archivos");
                throw new DaoException("Error al guardar los consumos en el archivo");
            }
        return contador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.numero);
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
        final LineaMovil other = (LineaMovil) obj;
        return Objects.equals(this.numero, other.numero);
    }
    
    public int compareTo(LineaMovil linea) {
        return this.numero.compareTo(linea.numero);
    }

}
