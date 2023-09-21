/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ingenieria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author luzan
 */
public class AsistenciaDAO {
        Conexion cnx;

    public AsistenciaDAO(Conexion cnx) {
        this.cnx = cnx;
    }

    
    public boolean registrarAsistencia(String codigoMateria, String usuarioAlumno) throws SQLException {
    boolean hecho = false;
    String insertAsistencia = "INSERT INTO asistencia_1 (fechaclase, tipoAsistencia, codMat, usuarioa) VALUES (?, ?, ?, ?)";
    
    PreparedStatement ps = null;
    try {
        // Abre la conexión al inicio de la operación
        cnx.conectar();
        
        ps = cnx.getConnection().prepareStatement(insertAsistencia);
        
        // Establecer la fecha actual como fecha de clase
        java.util.Date fechaActual = new java.util.Date();
        java.sql.Date fechaSql = new java.sql.Date(fechaActual.getTime());
        ps.setDate(1, fechaSql);
        
        // Establecer el tipo de asistencia
        ps.setString(2, "Presente");
        
        // Obtener el código de materia
        int codMat = obtenerCodigoMateriaPorNombre(codigoMateria);
        if (codMat == -1) {
            // La materia no existe
            return false;
        }
        
        // Establecer el código de materia en la consulta
        ps.setInt(3, codMat);
        
        // Establecer el usuario del alumno
        ps.setString(4, usuarioAlumno);
        
        int c = ps.executeUpdate();
        cnx.getConnection().commit();
        if (c == 1) {
            hecho = true;
        }
    } catch (SQLException e) {
        // Maneja las excepciones de SQL de manera adecuada registrando el error
        // y realizando un rollback
        cnx.getConnection().rollback();
        System.out.println("Error SQL: " + e.toString());
        JOptionPane.showMessageDialog(null, "Error al registrar asistencia", "", JOptionPane.WARNING_MESSAGE);
    } catch (Exception e) {
        // Maneja otras excepciones de manera adecuada
        System.out.println("Error: " + e.toString());
    } finally {
        // Cierra la conexión en el bloque finally para asegurarte de que siempre se cierre
        if (ps != null) {
            ps.close();
        }
        cnx.cerrarConexion();
    }
    
    return hecho;
}

public int obtenerCodigoMateriaPorNombre(String nombreMateria) throws SQLException {
    String consulta = "SELECT codMat FROM materia WHERE nombreMat = ?";
    ResultSet rs = null;
    PreparedStatement ps = null;
    int codigoMateria = -1; // Valor predeterminado en caso de que no se encuentre la materia

    try {
        cnx.conectar();
        ps = cnx.getConnection().prepareStatement(consulta);
        ps.setString(1, nombreMateria); // Establecer el nombre de la materia como parámetro
        rs = ps.executeQuery();

        if (rs.next()) {
            codigoMateria = rs.getInt("codMat"); // Obtener el código de materia si se encuentra
            System.out.println("codigo materia"+codigoMateria);
        }

        cnx.getConnection().commit();
    } catch (SQLException e) {
        cnx.getConnection().rollback();
        System.out.println(consulta);
        System.out.println(e);
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
     //   cnx.cerrarConexion();
    }

    return codigoMateria;
}
}
