/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Usuario;

/**
 *
 * @author alvaro.gargon.4
 */
public class UsuarioTableModel extends AbstractTableModel{
    private List<Usuario> usuarios;
    private String[] columnas={"NOMBRE","EMAIL","ROL","FECHA ALTA"," ULTIMO ACCESO", "ACTIVO"};
    
    public UsuarioTableModel(){
        usuarios=new ArrayList<>();
    }
    
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.fireTableDataChanged();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch(columnIndex){
            case 0,1,3,4 -> String.class;
            case 2 -> Object.class;
            case 5 -> Boolean.class;
            default -> null;
        }; 
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario=usuarios.get(rowIndex);
        return switch(columnIndex){
            case 0 -> usuario.getNombre();
            case 1 -> usuario.getEmail();
            case 2 -> usuario.getRol();
            case 3 -> usuario.getFechaAlta().toString();
            case 4 -> usuario.getUltimoAcceso()!=null?usuario.getUltimoAcceso().toString():"Sin acceso";
            case 5 -> usuario.isActivo();
            default ->null;
        };
    }
    
}
