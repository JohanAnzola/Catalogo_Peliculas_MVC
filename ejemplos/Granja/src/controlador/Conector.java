package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private static Connection conn;

    public static void conectar(){
        String dbURL = "jdbc:mysql://localhost:3306/granja";
        String username = "root";
        String password = "Sasuke1-";
        try{
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn != null){
                System.out.println("ESTAMOS CONECTADOOOOOOOOOOOOOOS");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
    }

    public static Connection getConn() {
        return conn;
    }
    
    
}
