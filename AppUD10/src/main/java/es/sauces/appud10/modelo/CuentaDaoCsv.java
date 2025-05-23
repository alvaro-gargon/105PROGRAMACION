/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appud10.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class CuentaDaoCsv implements CuentaDao {

    private Path path;

    public CuentaDaoCsv(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Cuenta> listar() throws DaoException {
        List<Cuenta> listado = new ArrayList<>();
        String linea;
        String[] tokens;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            linea = br.readLine();
            while (linea != null) {
                tokens = linea.split(",");
                listado.add(new Cuenta(tokens[0], tokens[1], Float.parseFloat(tokens[2])));
                linea = br.readLine();
            }
        } catch (IOException | SaldoException ex) {
            throw new DaoException(ex.toString());
        }

        return listado;
    }

    @Override
    public int insertar(List<Cuenta> listado) throws DaoException {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Cuenta c : listado) {
                bw.write(c.toString());
                bw.newLine();
            }
        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        return listado.size();
    }

    @Override
    public Cuenta buscar(String codigo) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertar(Cuenta cuenta) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int borrar(String codigo) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(Cuenta cuenta) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
