
package ingenieria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProfesorDAO {
    
    Conexion cnx;

    public ProfesorDAO(Conexion cnx) {
        this.cnx = cnx;
    }
    
public boolean verificarCredenciales(String usuario, String contrasenia) throws SQLException {
    String consulta = "SELECT usuariop, contraseniap FROM profesor WHERE usuariop = ? AND contraseniap = ?";
    ResultSet rs = null;
    PreparedStatement ps = null;
    boolean credencialesCorrectas = false;

    try {
        cnx.conectar();
        ps = cnx.getConnection().prepareStatement(consulta);
        ps.setString(1, usuario);
        ps.setString(2, contrasenia);
        rs = ps.executeQuery();

        if (rs.next()) {
            // Si hay al menos una fila en el resultado, las credenciales son correctas.
            credencialesCorrectas = true;
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
        cnx.cerrarConexion();
    }

    return credencialesCorrectas;
}

public List<Integer> obtenerMaterias(String usuariop) throws SQLException, Exception {
        List<Integer> materiasDicta = new ArrayList<>();

        String consulta = "SELECT codMat FROM materiaProfesor WHERE usuariop = ?;";

        Connection conexion = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Obtener una conexión a la base de datos
            conexion = new Conexion().conectar();

            pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, usuariop); // Establecer el valor del parámetro en la consulta SQL
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codMat = rs.getInt("codMat");
                materiasDicta.add(codMat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de conexiones y recursos
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }

        return materiasDicta;
    }

    public DefaultTableModel obtenerMateriasQueDicta(String usuariop) throws SQLException, Exception {
        // Obtener la lista de materias regulares
        List<Integer> materias = obtenerMaterias(usuariop);

        // Crear un modelo de tabla
// Crear un modelo de tabla con dos columnas: "Materias" y "Acción"
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("MATERIAS");
    modeloTabla.addColumn("ASISTENCIA"); // Nueva columna para el botón de acción


        // Verificar si alguna materia tiene código igual a 3
        //DefaultTableModel modeloTabla = new DefaultTableModel();
        // Verificar dicta Elementos del algebra
        //modeloTabla.addColumn(" MATERIAS ");
        if (materias.contains(001)) {
            // Agregar "Elementos del Algebra" como una fila
            Object[] fila = {"Elementos del Algebra", "VER"};
            modeloTabla.addRow(fila);
        }

        // Verificar si dicta FP
        if (materias.contains(002)) {
            // Agregar "Fundamentos de la Programación" como una fila
            Object[] fila = {"Fundamentos de la Programación", "VER"};
            modeloTabla.addRow(fila);
        }

        // Verificar si dicta Ingles I
        if (materias.contains(003)) {
            // Agregar "Ingles I" como una fila
            Object[] fila = {"Ingles I", "VER"};
            modeloTabla.addRow(fila);
        }     
        
        // Verificar si dicta Laboratorio I
        if (materias.contains(004)) {
            // Agregar "Laboratorio I" como una fila
            Object[] fila = {"Laboratorio I", "VER"};
            modeloTabla.addRow(fila);
        }  

        // Verificar si dicta Logica
        if (materias.contains(005)) {

            // Agregar "Logica" como una fila
            Object[] fila = {"Logica", "VER"};
            modeloTabla.addRow(fila);
        }

        // Verificar si dicta Ingles II
        if (materias.contains(006)) {
            // Agregar "Ingles II" como una fila
            Object[] fila = {"Ingles II", "VER"};
            modeloTabla.addRow(fila);
        }

        // Verificar si dicta Laboratorio II
        if (materias.contains(007)) {
            // Agregar "Laboratorio II" como una fila
            Object[] fila = {"Laboratorio II", "VER"};
            modeloTabla.addRow(fila);
        }     
        
        // Verificar si dicta Programación
       if (materias.contains(010)) {
            // Agregar "Programación" como una fila
            Object[] fila = {"Programación", "VER"};
            modeloTabla.addRow(fila);
        }        
        
// Verificar si la tabla tiene al menos una fila
        if (modeloTabla.getRowCount() > 0) {
            // Agregar el título de la tabla si hay filas
            modeloTabla.fireTableStructureChanged();
        }

        return modeloTabla;
    }
}
