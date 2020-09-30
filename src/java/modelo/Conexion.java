/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public Connection conexionDB;
    //jdbc:mysql://localhost:3306/db_empresa
    private final String urlConexion = "jdbc:mysql://localhost:3306/parcial?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String usuario = "jonha";
    private final String contra = "123456789abc";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionDB = DriverManager.getConnection(urlConexion, usuario, contra);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa", "Estado conexion", JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException |ClassNotFoundException| SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void cerrar_conexion(){
        try{
            conexionDB.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}