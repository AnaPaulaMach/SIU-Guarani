package ingenieria;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    Conexion cnx;

    public Inicio() {
        initComponents();
        try {
            cnx = new Conexion();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear la conexión a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        setLocationRelativeTo(null);
        // Cargar la imagen y escalarla al tamaño deseado (792x531)
        java.awt.Image imagen = new javax.swing.ImageIcon(getClass().getResource("/ingenieria/Login.jpg")).getImage();
        int nuevoAncho = 800;
        int nuevoAlto = 300;
        imagen = imagen.getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH);
        javax.swing.ImageIcon icono = new javax.swing.ImageIcon(imagen);
        jLabel4.setIcon(icono);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Contraseña");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ingenieria/Login.jpg"))); // NOI18N
        jLabel4.setToolTipText("");

        jPasswordField1.setPreferredSize(new java.awt.Dimension(64, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String usuario = jTextField1.getText();

        String contrasenia = jPasswordField1.getText();

        try {

            AlumnoDAO alumnoDAO = new AlumnoDAO(cnx);
            ProfesorDAO profesorDAO = new ProfesorDAO(cnx);

            boolean credencialesCorrectas = alumnoDAO.verificarCredenciales(usuario, contrasenia);
            boolean credencialesCorrectasP = profesorDAO.verificarCredenciales(usuario, contrasenia);
            if (credencialesCorrectas) {
                // Las credenciales son correctas, permitir acceso.
                JOptionPane.showMessageDialog(this, "Acceso concedido como alumno", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Agregar aquí el código para permitir el acceso al sistema como alumno.
                InterfazAlumno ventanaAlumno = new InterfazAlumno(alumnoDAO,usuario); // Crea una instancia de la interfaz de alumno
                ventanaAlumno.setVisible(true); // Hace visible la ventana de alumno
                this.dispose(); // Cierra la ventana actual (si es necesario)

            } else if (credencialesCorrectasP) {
                // Las credenciales son correctas, permitir acceso.
                JOptionPane.showMessageDialog(this, "Acceso concedido como profesor", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Agregar aquí el código para permitir el acceso al sistema como profesor.
                InterfazProfesor ventanaProfesor = new InterfazProfesor(profesorDAO,usuario); // Crea una instancia de la interfaz de profesor
                ventanaProfesor.setVisible(true); // Hace visible la ventana de profesor
                this.dispose(); // Cierra la ventana actual (si es necesario)
                
            } else {

                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            // Manejo de excepciones en caso de problemas con la base de datos.
            JOptionPane.showMessageDialog(this, "Error al verificar credenciales", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
