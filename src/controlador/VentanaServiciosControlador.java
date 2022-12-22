package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaServiciosControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
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

public class VentanaServiciosControlador {
    
    private VentanaServiciosVista vista;
    private VentanaServiciosModelo modelo;

    private int id;
    private String nombre;
    
    private int selectedRow;
    private int selectedID;
    
    /** 
     * Constructor de la clase VentanaServiciosControlador
     * @param modelo El modelo de la clase
     * @param vista La vista o GUI de la clase
     */
    public VentanaServiciosControlador (VentanaServiciosModelo modelo, VentanaServiciosVista vista) {
        
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

        cargarServicios();
        vista.setGuiaModificar();

        
    }
    
    /**
     * Llena la tabla con todos los servicios almacenados en el modelo
     */
    public void cargarServicios() {
        for (int i = 0; i < modelo.getCantidadServicios(); i++) {
            id = modelo.getId(i);
            nombre = modelo.getNombre(i);
            vista.nuevaFilaServicio(id, nombre);
        }
    }

    /**
     * Elimina el servicio seleccionado en la tabla
     */
    public void eliminarServicio() {
        modelo.eliminarServicio(selectedID);
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

    /**
     * Registra un nuevo servicio
     */
    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                id = Integer.parseInt(vista.getId());
                if (vista.getNombre().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    nombre = vista.getNombre();
                    if (modelo.existeServicioConId(id)) {
                        String mensaje = "Error: Ya existe un servicio con este ID";
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{  
                        modelo.setId(id);
                        modelo.setNombre(nombre);
                        modelo.agregarServicio();
                        vista.nuevaFilaServicio(id, nombre);
                        vista.limpiarCampos();
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public void limpiarTodo(){
        vista.limpiarCampos();
        vista.limpiarTabla();

        modoRegistrar();
        cargarServicios();
    }
    
    /**
     * Modifica un servicio seleccionado que ya debe existir
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al modificar este servicio:
                                                                   
                                                                   - Se desasignará de los especialistas que lo ofrezcan
                                                                   - Los especialistas que lo ofrezcan se desasignaran de los consultorios
                                                                   - Se eliminarán las citas donde se ofrezca el servicio
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                        "Advertencia: Modificacion de Servicio",
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                
                switch (eleccion) {
                    case JOptionPane.YES_OPTION:
                        id = Integer.parseInt(vista.getId());
                        if (vista.getNombre().isBlank()) {
                            JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            nombre = vista.getNombre();

                            if (id != selectedID && modelo.existeServicioConId(id)) {
                                String mensaje = "Error: Ya existe un servicio con este ID";
                                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                            } else {

                                modelo.setId(id);
                                modelo.setNombre(nombre);

                                modelo.modificarServicio(selectedID);
                            }
                        }                        
                        break;
                }    
                
                limpiarTodo();
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo  de ID", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConcurrentModificationException e) {
                // Ignora la excepción
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
            limpiarTodo();  
        }
    };

    /**
     * Llama a la función eliminarServicio atrapando una excepción
     *
     * @see eliminarServicio
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al eliminar este servicio:
                                                                   
                                                                   - Se desasignará de los especialistas que lo ofrezcan
                                                                   - Los especialistas que lo ofrezcan se desasignaran de los consultorios
                                                                   - Se eliminarán las citas donde se ofrezca el servicio
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                        "Advertencia: Eliminación de Servicio",
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                
                switch (eleccion) {
                    case JOptionPane.YES_OPTION:
                        eliminarServicio();
                        break;
                    case JOptionPane.NO_OPTION:
                        limpiarTodo();
                        break;
                }
                
            } catch (ConcurrentModificationException e) {
                eliminarServicio();
            }
        }
    };
    
    /**
     * Gestiona los clics en las filas de Afiliados
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
                vista.setIdServicio(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setNombreServicio(table.getValueAt(table.getSelectedRow(), 1).toString());
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

