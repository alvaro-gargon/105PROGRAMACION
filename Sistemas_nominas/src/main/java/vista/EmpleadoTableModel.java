/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Empleado;
import modelo.EmpleadoEventual;
import modelo.EmpleadoFijo;

/**
 *
 * @author alvaro.gargon.4
 */
public class EmpleadoTableModel extends AbstractTableModel{
    private List<Empleado> listado;
    private String[] columnas={"DNI","NOMBRE","SALARIO","HORAS","INGRESOS"};

    public EmpleadoTableModel() {
        listado=new ArrayList<>();
    }

    public void setListado(List<Empleado> listado) {
        this.listado = listado;
        this.fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
        return listado.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado empleado=listado.get(rowIndex);
             
        return switch(columnIndex){
            case 0 -> empleado.getDni();
            case 1 -> empleado.getNombre();
            case 2 -> empleado instanceof EmpleadoFijo e ? e.getSalario():(((EmpleadoEventual)empleado).getSalarioHora());
            case 3 -> empleado instanceof EmpleadoEventual e ? e.getHoras():0;
            case 4 ->empleado.ingresos();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch(columnIndex){
            case 0,1 -> String.class;
            case 2,4 -> Float.class;
            case 3 -> Integer.class;
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
       return columnas[column];
        
    }
    
    
}
