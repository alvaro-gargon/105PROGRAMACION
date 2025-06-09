/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author alvaro.gargon.4
 */
public class VehiculoXml implements VehiculoDao{
 
    Path path;
 
    public VehiculoXml(String path) {
        this.path = Paths.get(path);
    }
 
    public Path getPath() {
        return path;
    }
 
    public void setPath(Path path) {
        this.path = path;
    }
 
    @Override
    public List<Vehiculo> listar() throws DaoException {
        XStream xstream=new XStream(new DomDriver());
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        List<Vehiculo> listadoEmpleados=null;
        try (BufferedReader br = Files.newBufferedReader(path);) {
            listadoEmpleados = (List<Vehiculo>)xstream.fromXML(br);
        } catch (IOException ioe) {
        }
        return listadoEmpleados;
    }
 
    @Override
    public int insertar(List<Vehiculo> empleados) throws DaoException {
        int contador;
        contador = 0;
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        List<Vehiculo> listadoEmpleados;
        listadoEmpleados = empleados;
        try (BufferedWriter fichero = Files.newBufferedWriter(path)) {
            xstream.toXML(listadoEmpleados, fichero);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
 
        return contador;
    }
 
}
