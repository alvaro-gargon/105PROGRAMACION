/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

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
public class EmpleadoXml implements EmpleadoDao {

    Path path;

    public EmpleadoXml(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public List<Empleado> listar() throws DaoException {
        XStream xstream=new XStream(new DomDriver());
        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);
        List<Empleado> listadoEmpleados=null;
        try (BufferedReader br = Files.newBufferedReader(path);) {
            listadoEmpleados = (List<Empleado>)xstream.fromXML(br);
        } catch (IOException ioe) {
        }
        return listadoEmpleados;
    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {
        int contador;
        contador = 0;
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);
        List<Empleado> listadoEmpleados;
        listadoEmpleados = empleados;
        try (BufferedWriter fichero = Files.newBufferedWriter(path)) {
            xstream.toXML(listadoEmpleados, fichero);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        return contador;
    }

}
