/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieria;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Conexion {
    String nameBD;
    String user;
    String pass ;
    protected  Connection con;
    private String ip;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static String url ="";
    
    
    public Connection getConnection(){
        return con;
    }
    /**
     * Descripcion: Constructor. Asigna valores de usuario y contraseña a ser usados al querer conectar con la BD
     * @param u se guarda en el atributo que corresponde al usuario
     * @param p se guarda en el atributo que corresponde a la contraseña
     */
    public Conexion( ) throws Exception {
        
        try{
        
        Properties prop = new Properties();
        prop.load(new FileInputStream(new File("configuracion.properties")));
        ip = prop.getProperty("servidor.ipServerMysql");
        this.nameBD = prop.getProperty("servidor.nameBD");
        this.user = prop.getProperty("servidor.user");
        this.pass = prop.getProperty("servidor.password");
        url="jdbc:mysql://"+ip+":3306/"+nameBD+"?useUnicode=tru"
            + "e&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al leer la ip del servidor","Error",JOptionPane.WARNING_MESSAGE);
            
        }
        
        
    }
    /**
     * Descripcion: Pregunta si estamos conectados a la base de datos
     * @return true si es correcto o false sino
     */
    public boolean estaConectado(){
        if(con != null){
            try {
                return !con.isClosed();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    /**
     * Descripcion: Conectamos a la base de datos con el usuario y contraseña espesifico 
     * en los valores de atributos.
     * @return tipo Connection
     * @throws SQLException si fallo al conectarnos a la BD
     */
    public Connection conectar() throws SQLException {
        // Reseteamos a null la conexion a la bd
      
        con=null;
        try{
            
            Class.forName(driver);
            // Nos conectamos a la bd
            System.out.println("Datos de Conexion");
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            con.setAutoCommit(false);//pongo esto para poder controlar las consultas o actualizacion de la BD en cada paso,
                                    //osea transacciones
            if (con!=null){
                System.out.println("Conexion establecida");
            }
           
            
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al establecer la conexion");
        }
        return con;
        
    }
    /**
     * Descripcion: Si hay una coneccion activa la cierra.
     * @throws SQLException  por si falla el cerrar la conexion
     */
    public void cerrarConexion() throws SQLException{
        try {
            if(con != null){
                if(!con.isClosed()){
                    con.close();
                }
            }
            System.out.println("Conexion cerrada");
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
 
    
}
