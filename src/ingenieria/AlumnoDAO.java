package ingenieria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;

public class AlumnoDAO {

    Conexion cnx;

    public AlumnoDAO(Conexion cnx) {
        this.cnx = cnx;
    }

    public boolean cargarAlumno(DTO_transaccion alumno) throws SQLException {

        boolean hecho = false;
        String insertMeca = "insert into alumno(usuarioa,contraseniaa,nombrea,apellidoa) value(?,?,?,?)";

        PreparedStatement ps = null;
        try {
            if (cnx.estaConectado()) {
                cnx.cerrarConexion();
            }
            cnx.conectar();
            ps = cnx.getConnection().prepareStatement(insertMeca);
            ps.setString(1, alumno.nombre);
            ps.setString(2, alumno.apellido);

            int c = ps.executeUpdate();
            cnx.getConnection().commit(); //confirma que todo salio bien en la transaccion sino da excepcion
            if (c == 1) {
                hecho = true;
            }
        } catch (SQLException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Posiblemente ya fue cargada!", "", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.toString());
            cnx.getConnection().rollback();//Deshacemos cambios por excepcion;
        } finally {
            if (ps != null) {
                ps.close();
                
            }
            cnx.cerrarConexion();
        }

        return true;

    }

    public Boolean actualizar(DTO_transaccion dato) throws Exception {
        /**
         * Descripcion: Actualiza la fecha de una reparacion x con cierto id_r
         * para un motor y fecha en espesifico. Retorna true si actualizo una
         * columna caso contrario retorna falso.
         */

        boolean hecho = false;
        PreparedStatement ps = null;

        String update = "update reparacion set resultado= '" + dato.nombre + "' where tipo=" + dato.apellido;

        try {
            if (cnx.estaConectado()) {
                cnx.cerrarConexion();
            }
            cnx.conectar();
            //ejecucion actualizacion
            ps = cnx.getConnection().prepareStatement(update);

            int cant = ps.executeUpdate();
            cnx.getConnection().commit();
            if (cant == 1) {
                hecho = true;
            } else {
                hecho = false;
                JOptionPane.showMessageDialog(null, "Por favor revise los datos ingresados!", "", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            System.out.println(e);
            cnx.getConnection().rollback();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        cnx.cerrarConexion();
        return hecho;
    }

    public DefaultTableModel obtenerEvaluaciones() throws SQLException {
        String consulta = "SELECT nombrea, apellidoa FROM alumno;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        DefaultTableModel modeloTabla = new DefaultTableModel();

        try {
            cnx.conectar();
            ps = cnx.getConnection().prepareStatement(consulta);
            rs = ps.executeQuery();

            modeloTabla.addColumn("nombrea");
            modeloTabla.addColumn("apellidoa");

            while (rs.next()) {
                Object[] filaEvaluacion = new Object[2];
                filaEvaluacion[0] = rs.getString("nombrea");
                filaEvaluacion[1] = rs.getString("apellidoa");
                modeloTabla.addRow(filaEvaluacion);
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

        return modeloTabla;
    }

    public List<Integer> obtenerMateriasRegulares(String usuario) throws SQLException, Exception {
        List<Integer> materiasRegulares = new ArrayList<>();

        String consulta = "SELECT codMat FROM alumnoMateria WHERE usuarioa = ? AND condicion = 'Regular';";

        Connection conexion = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Obtener una conexión a la base de datos
            conexion = new Conexion().conectar();

            pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, usuario); // Establecer el valor del parámetro en la consulta SQL
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codMat = rs.getInt("codMat");
                materiasRegulares.add(codMat);
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

        return materiasRegulares;
    }

    public DefaultTableModel obtenerMateriasPuedeCursar(String usuario) throws SQLException, Exception {
        // Obtener la lista de materias regulares
        List<Integer> materiasRegulares = obtenerMateriasRegulares(usuario);

        // Crear un modelo de tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();

        // Verificar si alguna materia tiene código igual a 3
        //DefaultTableModel modeloTabla = new DefaultTableModel();
        // Verificar si tiene el código 003(ingles)
        modeloTabla.addColumn(" Materias que puede cursar");
        if (materiasRegulares.contains(003)) {
            // Agregar el título de la tabla
            //   modeloTabla.addColumn("Materias puede cursar");

            // Agregar "Ingles 2" como una fila
            Object[] fila = {"Ingles II"};
            modeloTabla.addRow(fila);
        }

        // Verificar si tiene los códigos 005 y 002
        if (materiasRegulares.contains(005) && materiasRegulares.contains(002) && materiasRegulares.contains(004)) {
            // Agregar "Programacion I" como una fila
            Object[] fila = {"Programacion I"};
            modeloTabla.addRow(fila);
        }

// Verificar si tiene los códigos 002, 003 y 004 con eso se puede cursar laboratorioII
        if (materiasRegulares.contains(002) && materiasRegulares.contains(003) && materiasRegulares.contains(004)) {
            // Agregar "Laboratorio II" como una fila
            Object[] fila = {"Laboratorio II"};
            modeloTabla.addRow(fila);
        }

// Verificar si la tabla tiene al menos una fila
        if (modeloTabla.getRowCount() > 0) {
            // Agregar el título de la tabla si hay filas
            modeloTabla.fireTableStructureChanged();
        }

        return modeloTabla;
    }

    public boolean verificarCredenciales(String usuario, String contrasenia) throws SQLException {
        String consulta = "SELECT usuarioa, contraseniaa FROM alumno WHERE usuarioa = ? AND contraseniaa = ?";
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

}
