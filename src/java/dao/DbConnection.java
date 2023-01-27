
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DbConnection {
    
    static String bd = "sistemadb";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;
    
    Connection conn;
    
    
    //CONSTRUCTOR DE LA CLASE
    public DbConnection() {
        
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection(url, login, password);
            
            if(conn != null){
                System.out.println("Conexión a base de datos ["+ conn +"] OK");
            }else{
                System.out.println("Ocurrió un error en la Conexión");
            }
        } catch (SQLException e) {
            System.out.println("Excepción de conexión: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Excepción de Driver: "+ex.getMessage());
            }
        
    }
    
    
    //
    public Connection getConnection(){
            return conn;
    }
    
    public void disconnect(){
        System.out.println("Clossing database: ["+ conn +"] OK");
        
        if(conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("error: "+e);
            }
        }
    }
    
}
