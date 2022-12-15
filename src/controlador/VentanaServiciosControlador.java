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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class VentanaServiciosControlador {
    
    private VentanaServiciosVista vista;
    private VentanaServiciosModelo modelo;

    private int id;
    private String servicio;
    
    public VentanaServiciosControlador (VentanaServiciosModelo modelo, VentanaServiciosVista vista) {
        
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        vista.addAgregarListener(oyenteAgregar);
        //vista.addVolverListener(oyenteVolver);

        
    }

    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

            try {
                id = Integer.parseInt(vista.getIdServicio());
                
            } 
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe digirar numeros en el campo  de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    /*
    ActionListener oyenteVolver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            VentanaPrincipalVista vpv = new VentanaPrincipalVista();
            VentanaPrincipalModelo vpm = new VentanaPrincipalModelo(modelo.getBDManager());
            VentanaPrincipalControlador vpc = new VentanaPrincipalControlador(vpm, vpv);
            vista.cerrar();
        }
    };
    */

}
