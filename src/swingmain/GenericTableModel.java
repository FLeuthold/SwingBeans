/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingmain;
//import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 * @param <T>
 */
public class GenericTableModel<T> extends AbstractTableModel {
    final private List<T> data;
    final private String[] columnNames;
    final boolean[] canEdit;
    public GenericTableModel(String[] columnNames, boolean[] canEdit ) {
        this.data = new ArrayList<>();
        this.columnNames = columnNames;
        this.canEdit = canEdit;
    }

    public void addData(T rowData) {
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
    

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T rowData = data.get(rowIndex);
        // You might need to use reflection or other mechanisms to access fields dynamically
        // For simplicity, assuming that the objects have public getter methods
        try {
            
            return rowData.getClass().getMethod("get" + columnNames[columnIndex] ).invoke(rowData);
        } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            //e.printStackTrace();
            return 0;
      
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Allow all cells to be editable
        return canEdit [columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        T rowData = data.get(rowIndex);
        // You might need to use reflection or other mechanisms to set fields dynamically
        // For simplicity, assuming that the objects have public setter methods
        try {
            rowData.getClass().getMethod("set" + columnNames[columnIndex], value.getClass()).invoke(rowData, value);
        } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            //e.printStackTrace();
            
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }
}

