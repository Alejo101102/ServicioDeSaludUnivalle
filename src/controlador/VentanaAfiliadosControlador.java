package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaAfiliadosControlador.java
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

public class VentanaAfiliadosControlador {

    private VentanaAfiliadosVista vista;
    private VentanaAfiliadosModelo modelo;

    private int id;
    private String nombre;
    
    private int selectedRow;
    private int selectedID;

    public VentanaAfiliadosControlador(VentanaAfiliadosModelo modelo, VentanaAfiliadosVista vista) {

        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        vista.addLimpiarListener(oyenteLimpiar);
        vista.addAgregarListener(oyenteAgregar);
        vista.addEliminarListener(oyenteEliminar);
        vista.addVolverListener(oyenteVolver);
        vista.addTableListener(oyenteFila);

        cargarAfiliados();
    }

    public void cargarAfiliados() {
        for (int i = 0; i < modelo.getCantidadAfiliados(); i++) {
            id = modelo.getId(i);
            nombre = modelo.getNombre(i);
            vista.nuevaFilaAfiliado(id, nombre);
        }

    }

    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

            try {
                id = Integer.parseInt(vista.getCedula());
                if (vista.getNombre().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Error: El campo de nombre no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    nombre = vista.getNombre();
                    modelo.setId(id);
                    modelo.setNombre(nombre);
                    modelo.agregarAfiliado();
                    vista.nuevaFilaAfiliado(id, nombre);
                    vista.limpiarCampos();
                }

            } catch (NumberFormatException e) {
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
            vista.deshabilitarModificar();
            vista.deshabilitarEliminar();
            vista.habilitarAgregar();
        }
    };
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.eliminarAfiliado(selectedID);
            vista.eliminarFilaTabla(selectedRow);
            vista.limpiarCampos();
            vista.deshabilitarModificar();
            vista.deshabilitarEliminar();
            vista.habilitarAgregar();
        }
    };
    MouseListener oyenteFila = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table = (JTable) Mouse_evt.getSource();
            selectedRow = table.getSelectedRow();
            try{
            selectedID = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Error inesperado, salga al Menu Principal e intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            if (Mouse_evt.getClickCount() == 1) {
                vista.setCedulaAfiliado(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setNombreAfiliado(table.getValueAt(table.getSelectedRow(), 1).toString());
                vista.deshabilitarAgregar();
                vista.habilitarModificar();
                vista.habilitarEliminar();
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
