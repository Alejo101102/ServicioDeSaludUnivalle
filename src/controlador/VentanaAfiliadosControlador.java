package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaAfiliadosControlador.java
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

public class VentanaAfiliadosControlador {

    private VentanaAfiliadosVista vista;
    private VentanaAfiliadosModelo modelo;

    private int id;
    private String nombre;

    private int selectedRow;
    private int selectedID;

    /**
     * Constructor de la clase VentanaAfiliadosControlador
     *
     * @param modelo El modelo de la clase
     * @param vista La vista o GUI de la clase
     */
    public VentanaAfiliadosControlador(VentanaAfiliadosModelo modelo, VentanaAfiliadosVista vista) {

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

        cargarAfiliados();
        vista.setGuiaModificar();
    }

    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Llena la tabla con todos los afiliados almacenados en el modelo
     */
    public void cargarAfiliados() {
        for (int i = 0; i < modelo.getCantidadAfiliados(); i++) {
            id = modelo.getId(i);
            nombre = modelo.getNombre(i);
            vista.nuevaFilaAfiliado(id, nombre);
        }
    }

    
    //              MODOS DE OPERACION               //
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
     * Recarga algunos elementos y datos de la vista
     */
    public void reinicioLimpio(){
        vista.limpiarCampos();
        vista.limpiarTabla();
        modoRegistrar();
        cargarAfiliados();
    }
    
    
    //              FUNCIONES VARIADAS               //
    /**
     * Elimina el afiliado seleccionado en la tabla
     */
    public void eliminarAfiliado() {
        modelo.eliminarAfiliado(selectedID);
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

    
    //              LISTENERS               //
    /**
     * Registra un nuevo afiliado
     */
    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

            try {
                id = Integer.parseInt(vista.getCedula());
                if (vista.getNombre().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    nombre = vista.getNombre();
                    if (modelo.existeAfiliadoConId(id)) {
                        String mensaje = "Error: Ya existe un afiliado con esta cedula";
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{  
                        nombre = vista.getNombre();
                        modelo.setId(id);
                        modelo.setNombre(nombre);
                        modelo.agregarAfiliado();
                        reinicioLimpio();
                    }
                }
            }
            catch (NumberFormatException e) {
                String mensaje = "Error: Debe digirar numeros en el campo de cedula";
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    /**
     * Modifica un afiliado seleccionado que ya debe existir
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al modificar este afiliado:
                                                                   
                                                                   - Se eliminarán las citas donde participe.
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                        "Advertencia: Modificacion de afiliado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                switch (eleccion) {
                    
                    case JOptionPane.YES_OPTION:
                        
                        id = Integer.parseInt(vista.getCedula());
                        
                        if (vista.getNombre().isBlank())
                            JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                        else {
                            
                            nombre = vista.getNombre();
                            
                            if (id != selectedID && modelo.existeAfiliadoConId(id)) {
                                String mensaje = "Error: Ya existe un afiliado con esta cedula";
                                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                nombre = vista.getNombre();
                                modelo.setId(id);
                                modelo.setNombre(nombre);

                                modelo.modificarAfiliado(selectedID);
                            }
                        }
                        break;
                }
                
                reinicioLimpio();
                    
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo  de cedula", "Error", JOptionPane.ERROR_MESSAGE);
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
            reinicioLimpio();
        }
    };

    /**
     * Llama a la función eliminarAfiliado atrapando una excepción
     *
     * @see eliminarAfiliado
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al eliminar este afiliado:
                                                                   
                                                                   - Se eliminarán las citas donde participe.
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                        "Advertencia: Eliminación de afiliado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                switch (eleccion) {
                    
                    case JOptionPane.YES_OPTION:
                        eliminarAfiliado();
                        break;
                        
                    case JOptionPane.NO_OPTION:
                        reinicioLimpio();
                        break;
                }
                
            } catch (ConcurrentModificationException e) {
                eliminarAfiliado();
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
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            
            try {
                selectedID = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: No se debe modificar directamente la tabla, guardando datos y redirigiendo...", "Error crítico", JOptionPane.ERROR_MESSAGE);
                volverAlMenu();
            }

            if (Mouse_evt.getClickCount() == 1) {
                vista.setCedulaAfiliado(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setNombreAfiliado(table.getValueAt(table.getSelectedRow(), 1).toString());
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
