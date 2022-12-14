package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaPrincipalModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;
import controlador.*;

import hospital.*;

public class VentanaPrincipalModelo {
    BDManager bdmanager = new BDManager();
    
    public VentanaPrincipalModelo(BDManager bdmanager){
        this.bdmanager = bdmanager;
    }
    
    public void iniciarVentanaServicios(){
//        VentanaServiciosVista vsv = new VentanaServiciosVista();
//        VentanaServiciosModelo vsm = new VentanaServiciosModelo(bdmanager);
//        VentanaServiciosControlador vsc = new VentanaServiciosControlador(vsm, vsv);
    }
    public void iniciarVentanaEspecialistas(){
        VentanaEspecialistasVista vev = new VentanaEspecialistasVista();
        VentanaEspecialistasModelo vem = new VentanaEspecialistasModelo(bdmanager);
        VentanaEspecialistasControlador vec = new VentanaEspecialistasControlador(vem, vev);
    }
    public void iniciarVentanaAfiliados(){
        VentanaAfiliadosVista vav = new VentanaAfiliadosVista();
        VentanaAfiliadosModelo vam = new VentanaAfiliadosModelo(bdmanager);
        VentanaAfiliadosControlador vac = new VentanaAfiliadosControlador(vam, vav);
    }
    public void iniciarVentanaConsultorios(){
//        VentanaConsultoriosVista vconv = new VentanaConsultoriosVista();
//        VentanaConsultoriosModelo vconm = new VentanaConsultoriosModelo(bdmanager);
//        VentanaConsultoriosControlador vconc = new VentanaConsultoriosControlador(vcm, vconv);
    }
    public void iniciarVentanaCitas(){
//        VentanaCitasVista vcv = new VentanaCitasVista();
//        VentanaCitasModelo vcm = new VentanaCitasModelo(bdmanager);
//        VentanaCitasControlador vcc = new VentanaCitasControlador(vcm, vcv);
    }
    
}
