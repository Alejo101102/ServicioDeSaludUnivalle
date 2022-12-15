package vista;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
    Laboratorio # 3
    Profesor: Luis Romo Portilla 

    Archivo:  VentanaEspecialistasVista.java
    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class VentanaEspecialistasVista extends javax.swing.JFrame {

    /**
     * Creacion de un modelo de tabla NO editable
     */
    private DefaultTableModel modeloTabla = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    /**
     * Constructor de la clase VentanaEspecialistasVista
     */  
    public VentanaEspecialistasVista() {
        initComponents();
        table_especialistas.setModel(modeloTabla);
        configurarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_tituloEspecialistas = new javax.swing.JLabel();
        lbl_cedulaEspecialista = new javax.swing.JLabel();
        lbl_nombreEspecialista = new javax.swing.JLabel();
        txtF_cedulaEspecialista = new javax.swing.JTextField();
        txtF_nombreEspecialista = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_especialistas = new javax.swing.JTable();
        btn_agregar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        lbl_idServicioEspecialista = new javax.swing.JLabel();
        txtF_idServicioEspecialista = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_textoGuia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(400, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tituloEspecialistas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_tituloEspecialistas.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tituloEspecialistas.setText("Especialistas");
        jPanel1.add(lbl_tituloEspecialistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl_cedulaEspecialista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cedulaEspecialista.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cedulaEspecialista.setText("Cédula");
        jPanel1.add(lbl_cedulaEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lbl_nombreEspecialista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nombreEspecialista.setForeground(new java.awt.Color(0, 0, 0));
        lbl_nombreEspecialista.setText("Nombre completo");
        jPanel1.add(lbl_nombreEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(txtF_cedulaEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 190, -1));
        jPanel1.add(txtF_nombreEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, -1));

        table_especialistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_especialistas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 340, 220));

        btn_agregar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_agregar.setText("Agregar");
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 90, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        btn_modificar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setEnabled(false);
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        lbl_idServicioEspecialista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_idServicioEspecialista.setForeground(new java.awt.Color(0, 0, 0));
        lbl_idServicioEspecialista.setText("ID Servicio");
        jPanel1.add(lbl_idServicioEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel1.add(txtF_idServicioEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 190, -1));

        btn_limpiar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setEnabled(false);
        jPanel1.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 90, -1));

        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        lbl_textoGuia.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbl_textoGuia.setForeground(new java.awt.Color(0, 102, 102));
        lbl_textoGuia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_textoGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 380, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(VentanaEspecialistasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEspecialistasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEspecialistasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEspecialistasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEspecialistasVista().setVisible(true);
            }
        });
    }

    public String getCedula(){        
        return txtF_cedulaEspecialista.getText();
    }

    public void setCedulaEspecialista(String text) {
        txtF_cedulaEspecialista.setText(text);
    }

    public String getNombre() {
        return txtF_nombreEspecialista.getText();
    }

    public void setNombreEspecialista(String text) {
        txtF_nombreEspecialista.setText(text);
    }
    
    public String getIdServicioEspecialista(){        
        return txtF_idServicioEspecialista.getText();
    }

    public void setIdServicioEspecialista(String text) {
        txtF_idServicioEspecialista.setText(text);
    }

    /**
     * Crea los titulos de la tabla 
     */
    public void configurarTabla(){
        String[] titulosTabla = new String[]{"ID", "NOMBRE COMPLETO", "ID SERVICIO"};
        modeloTabla.setColumnIdentifiers(titulosTabla);
    }
    
    /**
     * Añade una nueva fila con los datos de un nuevo especialista
     * @param Id El Id del nuevo especialista
     * @param nombreCompleto El nombre completo del nuevo especialista
     * @param IdServicio El Id de servicio del nuevo especialista
     */
    public void nuevaFilaEspecialista(int Id, String nombreCompleto, int IdServicio){
        modeloTabla.addRow(new Object[]{
            Id, nombreCompleto, IdServicio
        });
    }
    
     /**
     * Establece un texto para instruir en el modo Registrar
     */
    public void setGuiaRegistrar() {
        lbl_textoGuia.setText("Modifique los campos arriba o presione LIMPIAR para volver al modo registro");
    }

    /**
     * Establece un texto para instruir en el modo Modificar
     */
    public void setGuiaModificar() {
        lbl_textoGuia.setText("Seleccione especialistas en la tabla (si los hay) para modificarlos");
    }
    
    public void cerrar(){
        dispose();
    }
    
    
    //               FUNCIONES DE LIMPIEZA                 // 
    /**
     * Elimina todas las filas de la tabla para dejarla vacia
     */
    public void limpiarTabla(){
        int filasTabla = modeloTabla.getRowCount();
        for(int i = 0; i < filasTabla; i++){
            modeloTabla.removeRow(0);
        }
    }
    
    /**
     * Elimina una fila específica de la tabla
     *
     * @param fila La Fila a eliminar
     */
    public void eliminarFilaTabla(int fila) {
        modeloTabla.removeRow(fila);
    }
    
    public void limpiarCampos(){
        txtF_cedulaEspecialista.setText("");
        txtF_nombreEspecialista.setText("");
        txtF_idServicioEspecialista.setText("");
    }
    
    
    //              HABILITAR/DESHABILITAR BOTONES          //
    public void habilitarLimpiar() {
        btn_limpiar.setEnabled(true);
    }

    public void deshabilitarLimpiar() {
        btn_limpiar.setEnabled(false);
    }

    public void habilitarAgregar() {
        btn_agregar.setEnabled(true);
    }

    public void deshabilitarAgregar() {
        btn_agregar.setEnabled(false);
    }

    public void habilitarModificar() {
        btn_modificar.setEnabled(true);
    }

    public void deshabilitarModificar() {
        btn_modificar.setEnabled(false);
    }

    /**
     * Habilita btn_eliminar y configura su color en rojo
     */
    public void habilitarEliminar() {
        btn_eliminar.setEnabled(true);
        btn_eliminar.setBackground(new java.awt.Color(255, 0, 51));
    }

    /**
     * Deshabilita btn_eliminar y configura su color en gris
     */
    public void deshabilitarEliminar() {
        btn_eliminar.setEnabled(false);
        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
    }
    
    //                  LISTENERS                       //
    /**
     * Agrega un ActionListener al btn_agregar
     *
     * @param listener El ActionListener
     */
    public void addAgregarListener(ActionListener listener) {
        btn_agregar.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al btn_modificar
     *
     * @param listener El ActionListener
     */
    public void addModificarListener(ActionListener listener) {
        btn_modificar.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al btn_eliminar
     *
     * @param listener El ActionListener
     */
    public void addEliminarListener(ActionListener listener) {
        btn_eliminar.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al btn_volver
     *
     * @param listener El ActionListener
     */
    public void addVolverListener(ActionListener listener) {
        btn_volver.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al btn_limpiar
     *
     * @param listener El ActionListener
     */
    public void addLimpiarListener(ActionListener listener) {
        btn_limpiar.addActionListener(listener);
    }

    /**
     * Agrega un MouseListener al btn_agregar
     *
     * @param listener El MouseListener
     */
    public void addTableListener(MouseListener listener) {
        table_especialistas.addMouseListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cedulaEspecialista;
    private javax.swing.JLabel lbl_idServicioEspecialista;
    private javax.swing.JLabel lbl_nombreEspecialista;
    private javax.swing.JLabel lbl_textoGuia;
    private javax.swing.JLabel lbl_tituloEspecialistas;
    private javax.swing.JTable table_especialistas;
    private javax.swing.JTextField txtF_cedulaEspecialista;
    private javax.swing.JTextField txtF_idServicioEspecialista;
    private javax.swing.JTextField txtF_nombreEspecialista;
    // End of variables declaration//GEN-END:variables
}
