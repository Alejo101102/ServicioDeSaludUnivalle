package controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.VentanaConsultoriosModelo;
import modelo.VentanaPrincipalModelo;
import vista.VentanaConsultoriosVista;
import vista.VentanaPrincipalVista;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaConsultoriosControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaConsultoriosControlador {

    private VentanaConsultoriosVista vista;
    private VentanaConsultoriosModelo modelo;

    private int numeroConsultorio;
    private String especialistaAsociado;

    private int selectedRow;
    private int selectedID;

    /**
     * Constructor de la clase VentanaConsultoriosControlador
     *
     * @param modelo El modelo de la clase
     * @param vista La vista o GUI de la clase
     */
    public VentanaConsultoriosControlador(VentanaConsultoriosModelo modelo, VentanaConsultoriosVista vista) {

        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);

        vista.addLimpiarListener(oyenteLimpiar);
        vista.addAgregarListener(oyenteAgregar);
        vista.addModificarListener(oyenteModificar);
        vista.addEliminarListener(oyenteEliminar);
        vista.addVolverListener(oyenteVolver);
        vista.addTableListener(oyenteFila);

        vista.configurarTabla();
        cargarConsultorios();
        vista.setGuiaModificar();
    }

    /**
     * Llena la tabla con todos los consultorios almacenados en el modelo
     */
    public void cargarConsultorios() {
        for (int i = 0; i < modelo.getCantidadConsultorios(); i++) {
            numeroConsultorio = modelo.getNumeroConsultorio(i);
            especialistaAsociado = modelo.getEspecialistaAsociado(i);
            vista.nuevaFilaConsultorio(numeroConsultorio, especialistaAsociado);
        }
    }

    /**
     * Elimina el consultorio seleccionado en la tabla
     */
    public void eliminarConsultorio() {
        modelo.eliminarConsultorio(selectedID);
        vista.eliminarFilaTabla(selectedRow);
        vista.limpiarCampos();
        modoRegistrar();
    }

    /**
     * Instancia una VentanaPrincipal
     */
    public void volverAlMenu() {
        VentanaPrincipalVista vpv = new VentanaPrincipalVista();
        VentanaPrincipalModelo vpm = new VentanaPrincipalModelo(modelo.getBDManager());
        VentanaPrincipalControlador vpc = new VentanaPrincipalControlador(vpm, vpv);
        vista.cerrar();
    }

    /**
     * Habilita y deshabilita elementos en la interfaz para REGISTRAR NUEVOS
     * AFILIADOS
     */
    public void modoRegistrar() {
        vista.setGuiaModificar();
        vista.deshabilitarLimpiar();
        vista.deshabilitarModificar();
        vista.deshabilitarEliminar();
        vista.habilitarAgregar();
    }

    /**
     * Habilita y deshabilita elementos en la interfaz para HACER MODIFICACIONES
     * EN AFILIADOS EXISTENTES (Modificar datos y eliminar)
     */
    public void modoModificar() {
        vista.setGuiaRegistrar();
        vista.deshabilitarAgregar();
        vista.habilitarModificar();
        vista.habilitarEliminar();
        vista.habilitarLimpiar();
    }

    //              LISTENERS               //
    /**
     * Registra un nuevo consultorio
     */
    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

            try {
                numeroConsultorio = Integer.parseInt(vista.getNumeroConsultorio());
                if (vista.getEspecialistaAsociado().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Error: El campo de especialista asociado no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    especialistaAsociado = vista.getEspecialistaAsociado();
                    modelo.setNumeroConsultorio(numeroConsultorio);
                    modelo.setEspecialistaAsociado(especialistaAsociado);
                    modelo.agregarConsultorio();
                    vista.nuevaFilaConsultorio(numeroConsultorio, especialistaAsociado);
                    vista.limpiarCampos();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    /**
     * Modifica un consultorio seleccionado que ya debe existir
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                numeroConsultorio = Integer.parseInt(vista.getNumeroConsultorio());
                if (vista.getEspecialistaAsociado().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Error: El campo de especialistaAsociado no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    especialistaAsociado = vista.getEspecialistaAsociado();

                    modelo.setNumeroConsultorio(numeroConsultorio);
                    modelo.setEspecialistaAsociado(especialistaAsociado);

                    modelo.modificarConsultorio(selectedID);
                    vista.limpiarCampos();
                    vista.limpiarTabla();

                    modoRegistrar();
                    cargarConsultorios();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo  de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    /**
     * Regresa al Menu Principal
     */
    ActionListener oyenteVolver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            volverAlMenu();
        }
    };

    /**
     * Limpia los campos de texto y vuelve al modo de registrar
     */
    ActionListener oyenteLimpiar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            vista.limpiarCampos();
            modoRegistrar();
        }
    };

    /**
     * Llama a la función eliminarConsultorio atrapando una excepción
     *
     * @see eliminarConsultorio
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                eliminarConsultorio();
            } catch (ConcurrentModificationException e) {
                eliminarConsultorio();
            }
        }
    };

    /**
     * Gestiona los clics en las filas de Consultorios
     */
    MouseListener oyenteFila = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table = (JTable) Mouse_evt.getSource();
            selectedRow = table.getSelectedRow();
            try {
                selectedID = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: No se debe modificar directamente la tabla, guardando datos y redirigiendo...", "Error crítico", JOptionPane.ERROR_MESSAGE);
                volverAlMenu();
            }
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            if (Mouse_evt.getClickCount() == 1) {
                vista.setNumeroConsultorio(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setEspecialistaAsociado(table.getValueAt(table.getSelectedRow(), 1).toString());
                modoModificar();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
}
