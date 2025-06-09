/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Furgoneta;
import modelo.Turismo;
import modelo.Vehiculo;

/**
 *
 * @author marcos.fergar
 */
public class VehiculoTableModel extends AbstractTableModel{
    private List<Vehiculo> vehiculos;
    private String[] columnas={"MATRICULA","TIPO","GRUPO","PLAZAS","CAPACIDAD","PRECIO ALQUILES"};

    public VehiculoTableModel() {
        vehiculos=new ArrayList<>();        
    }

    public void setListado(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
        this.fireTableDataChanged();
    }        
    
    @Override
    public int getRowCount() {
        return vehiculos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehiculo vehiculo = vehiculos.get(rowIndex);
 
        return switch (columnIndex) {
            case 0 ->
                vehiculo.getMatricula();
            case 1 ->
                vehiculo instanceof Turismo  ? "TURISMO" : "FURGONETA";
            case 2 ->
                vehiculo.getGrupo().toString();            
            case 3 ->
                vehiculo instanceof Turismo v ? v.getPlazas():0;
            case 4 ->
                vehiculo instanceof Furgoneta v ? v.getCapacidad():0;
            case 5 ->
                vehiculo.getPrecioAlquiler();
            default ->
                null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch(columnIndex){
            case 0,1,2 -> String.class;
            case 3 -> Integer.class;
            case 4,5 -> Float.class;            
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
