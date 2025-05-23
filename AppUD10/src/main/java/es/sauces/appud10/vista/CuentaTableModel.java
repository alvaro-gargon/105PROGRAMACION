/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appud10.vista;

import es.sauces.appud10.modelo.Cuenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ambrosio
 */
public class CuentaTableModel extends AbstractTableModel {

    private String[] columnas = {"CÓDIGO", "TITULAR", "SALDO"};
    private List<Cuenta> cuentas;

    public CuentaTableModel() {
        cuentas = new ArrayList<>();
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta c = cuentas.get(rowIndex);
        Object o = switch (columnIndex) {
            case 0 ->
                c.getCodigo();

            case 1 ->
                c.getTitular();

            case 2 ->
                c.getSaldo();

            default ->
                null;
        };
        return o;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clase = switch (columnIndex) {
            case 0, 1 ->
                String.class;
            case 2 ->
                Float.class;
            default ->
                null;
        };

        return clase;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cuenta c = cuentas.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                c.setCodigo((String) aValue);
            case 1 ->
                c.setTitular((String) aValue);
            case 2 ->
                c.setSaldo((Float) aValue);
        }
    }
    
}
