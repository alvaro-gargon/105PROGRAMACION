/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class EmpleadoCsv implements EmpleadoDao {

    private static final Logger LOG = Logger.getLogger(EmpleadoCsv.class.getName());

    private Path path;

    public EmpleadoCsv(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path + "";
    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List lista = new ArrayList<>();
        String linea;
        String[] parte;
        Empleado e;
        try (BufferedReader fichero = Files.newBufferedReader(path)) {
                linea=fichero.readLine();
                while(linea!=null){
                    parte=linea.split(",");
                    switch(parte[0]){
                        case "EmpleadoFijo"->{    
                        e=new EmpleadoFijo(parte[1],parte[2],Float.parseFloat(parte[3]));
                        lista.add(e);
                        }
                        case "EmpleadoEventual"->{
                        e=new EmpleadoEventual(parte[1],parte[2],Float.parseFloat(parte[3]),Integer.parseInt(parte[4]));
                        lista.add(e);
                        }
                    }
                    
                    linea=fichero.readLine();
                }
        } catch (IOException | DniException|NumberFormatException|ArrayIndexOutOfBoundsException ex) {
            LOG.log(Level.WARNING, "Ha ocurrido un error: "+ex.toString());
            throw new DaoException(ex.toString());
        }
        return lista;
    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {
        int cont;
        cont = 0;
        try (BufferedWriter fichero = Files.newBufferedWriter(path)){
            for(Empleado e:empleados){
            fichero.write(e.getClass().getSimpleName() + "," + e.toString());
            fichero.newLine();
            cont++;
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
        return cont;
    }

}
