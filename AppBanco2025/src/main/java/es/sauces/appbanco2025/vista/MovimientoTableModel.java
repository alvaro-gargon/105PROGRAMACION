
package es.sauces.appbanco2025.vista;

import es.sauces.appbanco2025.modelo.Movimiento;
import es.sauces.appbanco2025.modelo.TipoMovimiento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author usuario
 */
public class MovimientoTableModel extends AbstractTableModel {
    private List<Movimiento> movimientos;
    private String[] columnas;

    public MovimientoTableModel() {
        movimientos=new ArrayList<>();
        columnas=new String[]{"Fecha","Tipo","Cantidad","Saldo"};
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
        this.fireTableDataChanged();
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }
    
    

    @Override
    public int getRowCount() {
        return movimientos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movimiento m=movimientos.get(rowIndex);
        return switch(columnIndex){
            case 0 -> m.getFecha();
                    
            case 1 -> m.getTipo();
                    
            case 2 -> m.getCantidad();
                    
            case 3 -> m.getSaldo();
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
            case 0 -> LocalDate.class;
            case 1 -> TipoMovimiento.class;
            case 2,3 -> Float.class;
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column]; 
    }
    
    
    
}
