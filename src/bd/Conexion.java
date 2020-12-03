/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ricardo
 */
public class Conexion {
    public static String bd = "automotora";
    public static String login = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/"+bd;
    //
    public static Connection conn;
    public static Statement sentencia;
    
    public static boolean buscarChasis;
    
    public static void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, pass);
            if (conn != null){
                System.out.println("Contexion establecida con"+bd);
            }
        } catch (SQLException e) {
            System.out.println("Hubo un problema al contectar");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
    }
    public static void desconectar() throws SQLException{
        conn.close();
        
    }
}
