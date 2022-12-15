package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaEspecialistasControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.*;
import vista.*;

public class VentanaEspecialistasControlador {

    private VentanaEspecialistasVista vista;
    private VentanaEspecialistasModelo modelo;

    private int id;
    private String nombre;
    private int idServicioEspecialista;

    private int selectedRow;
    private int selectedID;

    /**
     * Constructor de la clase VentanaEspecialistasControlador
     *
     * @param modelo El modelo de la clase
     * @param vista La vista o GUI de la clase
     */
    public VentanaEspecialistasControlador(VentanaEspecialistasModelo modelo, VentanaEspecialistasVista vista) {

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

        cargarEspecialistas();
    }

    /**
     * Llena la tabla con todos los especialistas almacenados en el modelo
     */
    public void cargarEspecialistas() {
        for (int i = 0; i < modelo.getCantidadEspecialistas(); i++) {
            id = modelo.getId(i);
            nombre = modelo.getNombre(i);
            idServicioEspecialista = modelo.getIdServicioEspecialista(i);
            vista.nuevaFilaEspecialista(id, nombre, idServicioEspecialista);
        }
    }

    /**
     * Elimina el especialista seleccionado en la tabla
     */
    public void eliminarEspecialista() {
        modelo.eliminarEspecialista(selectedID);
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
     * Registra un nuevo especialista
     */
    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

            try {
                id = Integer.parseInt(vista.getCedula());

                try {
                    idServicioEspecialista = Integer.parseInt(vista.getIdServicioEspecialista());

                    if (vista.getNombre().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        nombre = vista.getNombre();

                        modelo.setId(id);
                        modelo.setNombre(nombre);
                        modelo.setIdServicioEspecialista(idServicioEspecialista);

                        modelo.agregarEspecialista();

                        vista.nuevaFilaEspecialista(id, nombre, idServicioEspecialista);
                        vista.limpiarCampos();
                        vista.deshabilitarAgregar();
                        vista.habilitarAgregar();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de ID servicio", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    /**
     * Modifica un especialista seleccionado que ya debe existir
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                id = Integer.parseInt(vista.getCedula());

                try {
                    idServicioEspecialista = Integer.parseInt(vista.getIdServicioEspecialista());

                    if (vista.getNombre().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        nombre = vista.getNombre();

                        modelo.setId(id);
                        modelo.setNombre(nombre);
                        modelo.setIdServicioEspecialista(idServicioEspecialista);

                        modelo.modificarEspecialista(selectedID);
                        vista.limpiarCampos();
                        vista.limpiarTabla();

                        modoRegistrar();
                        cargarEspecialistas();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de ID servicio", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de cedula", "Error", JOptionPane.ERROR_MESSAGE);
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
            vista.deshabilitarModificar();
            vista.deshabilitarEliminar();
            vista.habilitarAgregar();
        }
    };
    
    /**
     * Llama a la función eliminarEspecialista atrapando una excepción
     *
     * @see eliminarEspecialista
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                eliminarEspecialista();
            } catch (ConcurrentModificationException e) {
                eliminarEspecialista();
            }
        }
    };
    
    /**
     * Gestiona los clics en las filas de Especialistas
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
                vista.setCedulaEspecialista(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setNombreEspecialista(table.getValueAt(table.getSelectedRow(), 1).toString());
                vista.setIdServicioEspecialista(table.getValueAt(table.getSelectedRow(), 2).toString());
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
