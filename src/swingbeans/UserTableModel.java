package swingbeans;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class UserTableModel extends AbstractTableModel {
    private final List<UserData> data;
    private final String[] columnNames = {"ID", "Username", "Password"};

    public UserTableModel() {
        this.data = new ArrayList<>();
    }

    public void addUserData(UserData userData) {
        data.add(userData);
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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Allow all cells to be editable
        return columnIndex > 0;
        //return true;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        UserData userData = data.get(rowIndex);

        switch (columnIndex) {
            //case 0 -> userData.setId((int) value);
            case 1 -> userData.setUsername((String) value);
            case 2 -> userData.setPassword((String) value);
            default -> {
            }
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UserData userData = data.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> userData.getId();
            case 1 -> userData.getUsername();
            case 2 -> userData.getPassword();
            default -> null;
        };
    }
}
