package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaEspecialistasControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
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

    public VentanaEspecialistasControlador(VentanaEspecialistasModelo modelo, VentanaEspecialistasVista vista) {

        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        vista.addAgregarListener(oyenteAgregar);
        vista.addVolverListener(oyenteVolver);
        vista.addLimpiarListener(oyenteLimpiar);
        vista.addTableListener(oyenteFila);

        cargarEspecialistas();
    }

    public void cargarEspecialistas() {
        for (int i = 0; i < modelo.getCantidadEspecialistas(); i++) {
            id = modelo.getId(i);
            nombre = modelo.getNombre(i);
            idServicioEspecialista = modelo.getIdServicioEspecialista(i);
            vista.nuevaFilaEspecialista(id, nombre, idServicioEspecialista);
        }

    }

    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

            try {
                id = Integer.parseInt(vista.getCedula());
                
                try{
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
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo de ID servicio", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo  de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    ActionListener oyenteVolver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            VentanaPrincipalVista vpv = new VentanaPrincipalVista();
            VentanaPrincipalModelo vpm = new VentanaPrincipalModelo(modelo.getBDManager());
            VentanaPrincipalControlador vpc = new VentanaPrincipalControlador(vpm, vpv);
            vista.cerrar();
        }
    };
    ActionListener oyenteLimpiar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            vista.limpiarCampos();
        }
    };
    MouseListener oyenteFila = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table = (JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            if (Mouse_evt.getClickCount() == 1) {
                vista.setCedulaEspecialista(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setNombreEspecialista(table.getValueAt(table.getSelectedRow(), 1).toString());
                vista.setIdServicioEspecialista(table.getValueAt(table.getSelectedRow(), 2).toString());
                vista.deshabilitarAgregar();
                vista.habilitarModificar();
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
