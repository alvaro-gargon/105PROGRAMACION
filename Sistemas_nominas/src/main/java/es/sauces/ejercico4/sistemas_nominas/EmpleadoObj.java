/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.sistemas_nominas;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class EmpleadoObj implements EmpleadoDao {

    Path path;
    private static final Logger LOG = Logger.getLogger(EmpleadoObj.class.getName());

    public EmpleadoObj(String path) {
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
        return "EmpleadoObj{" + "path=" + path + '}';
    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List lista = new ArrayList<>();
        String linea;
        String[] parte;
        Empleado e;
        try (InputStream is = Files.newInputStream(Paths.get(path.toString())); 
                ObjectInputStream entrada = new ObjectInputStream(is)) {
            while (is.available() > 0) {
                e = (Empleado) entrada.readObject();
                lista.add(e);
            }
        } catch (EOFException eofe) {
            LOG.info("Fin de fichero");
            throw new DaoException("Fin de fichero");
        } catch (ClassNotFoundException cnfe) {
            LOG.info("Objeto no esperado");
            throw new DaoException("Objeto no esperado");
        } catch (IOException ioe) {
            LOG.info("Error ed entrada/salida");
            throw new DaoException("Error de entrada/salida");
        }

        return lista;
    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {
        int cont;
        cont = 0;
        try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path.toString())))) {
            for (Empleado e : empleados) {
                salida.writeObject(e);
                cont++;
            }
        } catch (FileNotFoundException fnfe) {
            LOG.info("No existe el fichero");
            throw new DaoException("No existe el ficheri");
        } catch (IOException ioe) {
            LOG.info("Error de entrada/salida");
            throw new DaoException("Error de entrada/salida");
        }
        return cont;
    }

}
