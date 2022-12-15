package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaPrincipalControlador.java
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
import modelo.*;
import vista.*;

public class VentanaPrincipalControlador {
    private VentanaPrincipalVista vista;
    private VentanaPrincipalModelo modelo;

    public VentanaPrincipalControlador(VentanaPrincipalModelo modelo, VentanaPrincipalVista vista){
        
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        
        vista.addServiciosListener(oyenteServicios);    
        vista.addEspecialistasListener(oyenteEspecialistas);    
        vista.addAfiliadosListener(oyenteAfiliados);    
        vista.addConsultoriosListener(oyenteConsultorios);    
        vista.addCitasListener(oyenteCitas);   
        vista.addExportarAfiliadosListener(oyenteExportarAfiliados);   
        vista.addRealizarBackupListener(oyenteRealizarBackup);    
        vista.addRestaurarBackupListener(oyenteRestaurarBackup);    
    }
    
    /**
     * ActionListeners de los botones de la interfaz principal
     */
    ActionListener oyenteServicios = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.iniciarVentanaServicios();
            vista.cerrar();
        }
    };  
    ActionListener oyenteEspecialistas = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.iniciarVentanaEspecialistas();
            vista.cerrar();
        }
    };  
    ActionListener oyenteAfiliados = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.iniciarVentanaAfiliados();
            vista.cerrar();
        }
    };  
    ActionListener oyenteConsultorios = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.iniciarVentanaConsultorios();
            //vista.cerrar();
        }
    };  
    ActionListener oyenteCitas = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.iniciarVentanaCitas();
            //vista.cerrar();
        }
    };  
    ActionListener oyenteExportarAfiliados = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.exportarAfiliados();
        }
    };  
    ActionListener oyenteRealizarBackup = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.realizarBackup();
        }
    };  
    ActionListener oyenteRestaurarBackup = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modelo.restaurarBackup();
        }
    };  
}
