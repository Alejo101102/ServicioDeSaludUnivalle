package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaAfiliadosControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import modelo.*;
import vista.*;

public class VentanaAfiliadosControlador {
    private VentanaAfiliadosVista vista;
    private VentanaAfiliadosModelo modelo;

    public VentanaAfiliadosControlador(VentanaAfiliadosModelo modelo, VentanaAfiliadosVista vista){
        
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

}
