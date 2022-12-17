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
    private String nombreServicio;

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

        cargarEspecialistasDesde(0);
        cargarServicios();
        vista.setGuiaModificar();
    }

    /**
     * Llena la tabla con todos los especialistas almacenados en el modelo
     */
    public void cargarEspecialistasDesde(int numEspecialista) {       
        for (int i = numEspecialista; i < modelo.getCantidadEspecialistas(); i++) {
            numEspecialista = i;
            id = modelo.getId(i);
            nombre = modelo.getNombre(i);                
            nombreServicio = modelo.getNombreServicioEspecialista(i);

            vista.nuevaFilaEspecialista(id, nombre, nombreServicio);
        }        
    }
    
    /**
     * Llena la tabla con todos los especialistas almacenados en el modelo
     */
    public void cargarServicios() {        
        for (int i = 0; i < modelo.getCantidadServicios(); i++) {
            vista.addServicio(modelo.getServicio(i));
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
                            
                if (vista.getNombre().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    nombre = vista.getNombre();
                    if (modelo.existeEspecialistaConId(id)) {
                        String mensaje = "Error: Ya existe un especialista con esta cedula";
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        nombreServicio = vista.getNombreServicio();

                        modelo.setId(id);
                        modelo.setNombre(nombre);
                        modelo.setNombreServicio(nombreServicio);

                        modelo.agregarEspecialista();

                        vista.nuevaFilaEspecialista(id, nombre, nombreServicio);
                        vista.limpiarCampos();
                        vista.deshabilitarAgregar();
                        vista.habilitarAgregar();
                    }
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Error: Aun no se ha registrado ningun servicio", "Error", JOptionPane.ERROR_MESSAGE);
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
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al modificar este especialista:
                                                                   
                                                                   - Se eliminarán las citas donde participe
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                        "Advertencia: Modificación de especialista",
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                
                switch (eleccion) {
                    case JOptionPane.YES_OPTION:
                        id = Integer.parseInt(vista.getCedula());

                        nombreServicio = vista.getNombreServicio();

                        if (vista.getNombre().isBlank()) {
                            JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            nombre = vista.getNombre();
                            if (id != selectedID && modelo.existeEspecialistaConId(id)) {
                                String mensaje = "Error: Ya existe un especialista con esta cedula";
                                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                nombreServicio = vista.getNombreServicio();

                                modelo.setId(id);
                                modelo.setNombre(nombre);
                                modelo.setNombreServicio(nombreServicio);

                                modelo.modificarEspecialista(selectedID);
                                vista.limpiarCampos();
                                vista.limpiarTabla();

                                modoRegistrar();
                                cargarEspecialistasDesde(0);
                            }
                        }  
                        break;
                        
                    case JOptionPane.NO_OPTION:
                        vista.limpiarCampos();
                        vista.limpiarTabla();

                        cargarEspecialistasDesde(0);
                        modoRegistrar();                       
                        break;
                }
                
                
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error: No se han encontrado servicios registrados", "Error", JOptionPane.ERROR_MESSAGE);
                modoRegistrar();
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
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al eliminar este especialista:
                                                                   
                                                                   - Se desasignará de los consultorios.
                                                                   - Se eliminarán las citas donde participe.
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                        "Advertencia: Eliminación de especialista",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                
                switch (eleccion) {
                    case JOptionPane.YES_OPTION:
                        eliminarEspecialista();
                        break;
                    case JOptionPane.NO_OPTION:
                        vista.limpiarCampos();
                        vista.limpiarTabla();

                        cargarEspecialistasDesde(0);
                        modoRegistrar();    
                        break;
                }
                
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
                int indiceServicio = 0;
                vista.setCedulaEspecialista(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setNombreEspecialista(table.getValueAt(table.getSelectedRow(), 1).toString());
                vista.setServicioSeleccionado(table.getValueAt(table.getSelectedRow(), 2).toString());
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
