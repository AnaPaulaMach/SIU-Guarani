
package ingenieria;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class comienzo {
    
    public static void main(String[] args) {
        //Revisar referencia
        Conexion cnx = null;
        try {
            cnx = new Conexion( );
            cnx.conectar();
            if(cnx.estaConectado()){
                System.out.println("Esta conectado");
                //cnx.cerrarConexion();
            }
            System.out.println("No esta conectado en inicio");
            
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        System.out.println("Inicio:"+cnx+"es");
        AlumnoDAO alumno = new AlumnoDAO(cnx);
        /**modificar el argumento y se iran cargando evaluaciones con id=3 osea tipo = 2, etc
        DTO_transaccion x = new DTO_transaccion(4, "aprobado");
        try {
            evaluacion.cargarEvalualiones(x);
        } catch (SQLException ex) {
            Logger.getLogger(Ingenieria.class.getName()).log(Level.SEVERE, null, ex);
        }**/
        
        /**
         * Una actualizacion
         */
      /*  InterfazAlumno grafica = new InterfazAlumno(alumno);
        grafica.setVisible(true);*/
        
        Inicio graficaLogin = new Inicio();
        graficaLogin.setVisible(true);
        
  
    }
}
