package vista;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
    Laboratorio # 3
    Profesor: Luis Romo Portilla 

    Archivo:  VentanaConsultoriosVista.java
    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaConsultoriosVista extends javax.swing.JFrame {

    /** Creates new form ventanaConsultorios */
    public VentanaConsultoriosVista() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_tituloConsultorios = new javax.swing.JLabel();
        lbl_consultoriosNumero = new javax.swing.JLabel();
        txtF_consultoriosNumero = new javax.swing.JTextField();
        lbl_consultoriosMedico = new javax.swing.JLabel();
        txtF_consultoriosMedico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_consultoriosAgregar = new javax.swing.JButton();
        btn_consultoriosActualizar = new javax.swing.JButton();
        btn_consultoriosVerLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tituloConsultorios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_tituloConsultorios.setText("Consultorios");
        jPanel1.add(lbl_tituloConsultorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl_consultoriosNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_consultoriosNumero.setText("Número de consultorio");
        jPanel1.add(lbl_consultoriosNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        jPanel1.add(txtF_consultoriosNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, -1));

        lbl_consultoriosMedico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_consultoriosMedico.setText("Médico");
        jPanel1.add(lbl_consultoriosMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        jPanel1.add(txtF_consultoriosMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 190, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 340, 140));

        btn_consultoriosAgregar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_consultoriosAgregar.setText("Agregar");
        jPanel1.add(btn_consultoriosAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        btn_consultoriosActualizar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_consultoriosActualizar.setText("Actualizar");
        jPanel1.add(btn_consultoriosActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        btn_consultoriosVerLista.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_consultoriosVerLista.setText("Ver Lista");
        jPanel1.add(btn_consultoriosVerLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaConsultoriosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultoriosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultoriosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultoriosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConsultoriosVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_consultoriosActualizar;
    private javax.swing.JButton btn_consultoriosAgregar;
    private javax.swing.JButton btn_consultoriosVerLista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_consultoriosMedico;
    private javax.swing.JLabel lbl_consultoriosNumero;
    private javax.swing.JLabel lbl_tituloConsultorios;
    private javax.swing.JTextField txtF_consultoriosMedico;
    private javax.swing.JTextField txtF_consultoriosNumero;
    // End of variables declaration//GEN-END:variables

}