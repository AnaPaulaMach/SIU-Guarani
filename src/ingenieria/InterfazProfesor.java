package ingenieria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class InterfazProfesor extends javax.swing.JFrame {

    private String usuariop;
    private int b = 0;
    private String codigoGenerado = "0"; // Variable estática para almacenar el código generado

    public InterfazProfesor() {
        //initComponents();
        initComponents();
        setLocationRelativeTo(null);
        jPanel1.setVisible(false);
        jLabel2.setVisible(false);
        jButton3.setVisible(false);
        //de volver
        jButton4.setVisible(false);
        jPanel2.setVisible(false);
        jTable2.setVisible(false);
    }

    ProfesorDAO info;

    public InterfazProfesor(ProfesorDAO info, String usuariop) {
        this.info = info;
        this.usuariop = usuariop;
        initComponents();
        setLocationRelativeTo(null);
        jPanel1.setVisible(false);
        jLabel2.setVisible(false);
        jButton3.setVisible(false);
        //de volver
        jButton4.setVisible(false);
        jPanel2.setVisible(false);
        jTable2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        popupMenu1 = new java.awt.PopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu3.setText("jMenu3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        popupMenu1.setLabel("popupMenu1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ingenieria/profesor.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Ver Asistencia");
        jButton1.setAutoscrolls(true);
        jButton1.setMaximumSize(new java.awt.Dimension(188, 27));
        jButton1.setMinimumSize(new java.awt.Dimension(188, 27));
        jButton1.setPreferredSize(new java.awt.Dimension(188, 27));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Generar codigo de clase");
        jButton2.setMaximumSize(new java.awt.Dimension(188, 27));
        jButton2.setMinimumSize(new java.awt.Dimension(188, 27));
        jButton2.setPreferredSize(new java.awt.Dimension(188, 27));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        button1.setBackground(new java.awt.Color(0, 0, 0));
        button1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Cerrar Sesion");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel2.setText("AHORA: ");

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ingenieria/codigo.png"))); // NOI18N
        jButton3.setText("Generar codigo");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setToolTipText("");
        jTable2.setName(""); // NOI18N
        jTable2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jButton4.setBackground(new java.awt.Color(51, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("VOLVER");
        jButton4.setMaximumSize(new java.awt.Dimension(700, 700));
        jButton4.setPreferredSize(new java.awt.Dimension(700, 150));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//VER ASISTENCIA
//MATERIAS QUE DICTA
    try {
        // Del generar código
        jPanel1.setVisible(false);
        jButton3.setVisible(false);
        jLabel2.setVisible(false);

        DefaultTableModel modeloTabla;
        modeloTabla = info.obtenerMateriasQueDicta(usuariop);

        // Establece el modelo de tabla
        jTable2.setModel(modeloTabla);
        // Ajusta el ancho de la columna "MATERIAS" a un valor específico (por ejemplo, 200 píxeles)
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);

        // Ajusta el ancho de la columna "ASISTENCIA" a un valor específico (por ejemplo, 100 píxeles)
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
        // Cambia el color de fondo para el título "MATERIAS" (celeste)
        jTable2.getTableHeader().setBackground(new Color(0, 170, 250)); // Cambia el color de fondo a celeste
        // Cambia el color de fuente para el título "MATERIAS" (blanco)
        jTable2.getTableHeader().setForeground(Color.WHITE); // Cambia el color de fuente a blanco
        // Cambia el tamaño de fuente para el título "MATERIAS"
        jTable2.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        // Aplica un renderizador personalizado para la columna "ACCION"
        jTable2.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
        
        // Agrega un ActionListener para manejar los clics en los botones
        jTable2.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JCheckBox()));
        
        jPanel2.setVisible(true);
        jTable2.setVisible(true);
        jButton4.setVisible(true);
    } catch (Exception ex) {
        Logger.getLogger(InterfazProfesor.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    //GENERAR CODIGO DE CLASE  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*
        // Crear un nuevo JDialog emergente
        JDialog dialogo = new JDialog(this, "FECHA", true); // El tercer argumento (true) lo hace modal

        // Crear un JPanel para contener los componentes
        JPanel panel = new JPanel(new GridLayout(3, 2)); // 3 filas, 2 columnas

        // Crear los JTextFields
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();

        // Agregar los JTextFields al JPanel
        panel.add(new JLabel("     Dia:"));
        panel.add(textField1);
        panel.add(new JLabel("     Hora:"));
        panel.add(textField2);

        // Crear el botón de "Aceptar"
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setPreferredSize(new Dimension(20, 10));

        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String valorCampo1 = textField1.getText();
                String valorCampo2 = textField2.getText();

                if (!valorCampo1.isEmpty() && !valorCampo2.isEmpty()) {
                    // Ambos campos están completos, realizar acciones necesarias
                    //System.out.println("  Dia: " + valorCampo1);
                    //System.out.println("  Hora: " + valorCampo2);
                    // Cerrar el JDialog
                    b = b + 1;
                    dialogo.dispose();
                    ///COMENZAR CON LA GENERACION DEL CODIGO DE CLASE
              
                    
                } else {
                    // Mostrar un mensaje si alguno de los campos está vacío
                    JOptionPane.showMessageDialog(dialogo, "Completa ambos campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar el botón de "Aceptar" al JPanel
        panel.add(botonAceptar);

        // Agregar el JPanel al JDialog
        dialogo.add(panel);

        // Configurar el JDialog
        dialogo.setSize(300, 200);
        dialogo.setLocationRelativeTo(this); // Mostrar en el centro de la ventana principal
        dialogo.setVisible(true); // Mostrar el diálogo
         */
        if (b == 0 || b == 1) {
            jPanel2.setVisible(false);
            jTable2.setVisible(false);
            jPanel1.setVisible(true);
            jButton3.setVisible(true);
            jLabel2.setVisible(true);
            jButton4.setVisible(true);
        } else if (b > 1) {
            jPanel2.setVisible(false);
            jTable2.setVisible(false);
            jPanel1.setVisible(true);
            jLabel2.setVisible(false);
            jButton3.setVisible(false);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel4.setText("Codigo de clase: ");
            jLabel3.setText("                    " + codigoGenerado);
            jButton4.setVisible(true);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //VOLVER
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel1.setVisible(false);
        jButton4.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jTable2.setVisible(false);
        jPanel2.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed


    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
//Cierra la ventana actual
        this.dispose();
//Muestra la ventana de Inicio
        Inicio vi = new Inicio();
        vi.setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    //GENERA CODIGO
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //JDialog dialogo = new JDialog(this, "CODIGO", true); // El tercer argumento (true) lo hace modal
        //String codigoGenerado = ""; // Declarar la variable aquí

        if (b == 1) {
            codigoGenerado = generarCodigoAleatorio();
            jLabel2.setVisible(false);
            jButton3.setVisible(false);
            jLabel4.setText("Codigo de clase: ");
            jLabel4.setFont(new Font("Arial", Font.PLAIN, 20)); // Cambia la fuente y el tamaño
            jLabel3.setText("                    " + codigoGenerado);
            jLabel3.setFont(new Font("Arial", Font.BOLD, 20)); // Cambia la fuente y el tamaño
            System.out.println(codigoGenerado);
            // PASARLE ESE CODIGO A CUALQUIER ALUMNO QUE CONDICION SEA "CURSANDO"        
        } else if (b > 1) {
            jPanel1.setVisible(true);
            jLabel2.setVisible(false);
            jButton3.setVisible(false);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel4.setText("Codigo de clase: ");
            jLabel4.setFont(new Font("Arial", Font.BOLD, 20)); // Cambia la fuente y el tamaño
            jLabel3.setText("                    " + codigoGenerado);
            jLabel3.setFont(new Font("Arial", Font.PLAIN, 20)); // Cambia la fuente y el tamaño
        }

        b++; // Incrementa el valor de b después de usarlo
    }//GEN-LAST:event_jButton3ActionPerformed

    // Genera un código aleatorio de 5 caracteres
    private String generarCodigoAleatorio() {
        // Caracteres válidos para el código
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // Longitud del código
        int longitudCodigo = 5;

        // Usamos SecureRandom para una generación más segura
        SecureRandom random = new SecureRandom();

        // StringBuilder para construir el código
        StringBuilder codigoAleatorio = new StringBuilder(longitudCodigo);

        for (int i = 0; i < longitudCodigo; i++) {
            // Obtenemos un índice aleatorio dentro del rango de caracteres
            int indice = random.nextInt(caracteres.length());

            // Agregamos el caracter aleatorio al código
            codigoAleatorio.append(caracteres.charAt(indice));
        }
        // Devolvemos el código aleatorio como una cadena
        return codigoAleatorio.toString();
    }

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
            java.util.logging.Logger.getLogger(InterfazProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables

}
