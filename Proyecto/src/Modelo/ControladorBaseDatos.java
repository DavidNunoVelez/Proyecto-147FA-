package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 2 (Jose, Usue, David)
 */

public class ControladorBaseDatos {
    //variables
    private static Connection conexion;
    
    //métodos
 
    /**
     * Método que conecta con la base de datos, si no lo consigue muestra una ventana con error.
     * En caso de no coincidir los datos de conexión con los propios de la base de datos que se está usando, cambiar los campos login, pass y url
     */
        public static void conectar(){ 
        try{ 
            Class.forName("oracle.jdbc.OracleDriver"); 
            String login = "Aplicacion"; 
            String pass = "a12345Abcde"; 
            String url = "jdbc:oracle:thin:@10.10.10.9:1521:db12102";             
            conexion = DriverManager.getConnection(url,login,pass); 
            conexion.setAutoCommit(true); 
        }catch(ClassNotFoundException | SQLException ex){ 
            JOptionPane.showMessageDialog(null,"Ha ocurrido un problema \n"+ex.getMessage()); 
        }  
    }
   
    /**
     *Método que desconecta la aplicación de la base de datos
     * @throws SQLException
     */
    public static void desconectar() throws SQLException{ 
        conexion.close(); 
    } 
     
    /**
     * Método getter que devuelve un objeto conexión
     * @return objeto Connection
     */
    public static Connection getConexion(){ 
        return conexion; 
    } 
}
