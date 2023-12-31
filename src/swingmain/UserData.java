/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingmain;

/**
 *
 * @author fabio
 */
public class UserData extends javax.swing.table.DefaultTableColumnModel {
    private int id;
    private String username;
    private String password;

    public UserData(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    
    // Getters and setters (you can generate them automatically in most IDEs)
    // ...

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
