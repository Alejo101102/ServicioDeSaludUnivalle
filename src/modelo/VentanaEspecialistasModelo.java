package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
    Laboratorio # 3
    Profesor: Luis Romo Portilla 

    Archivo:  VentanaEspecialistasModelo.java
    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import hospital.*;

public class VentanaEspecialistasModelo {
    BDManager bdmanager = new BDManager(); 
    
    public VentanaEspecialistasModelo(BDManager bdmanager){
        this.bdmanager = bdmanager;
    }
    
    //Recibe
    private int id;
    private String nombre;
    private int idServicioEspecialista;

    public int getId(int numero) {
        return bdmanager.getIdEspecialista(numero);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(int numero) {
        return bdmanager.getNombreEspecialista(numero);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdServicioEspecialista(int numero) {
        return bdmanager.getIdServicioEspecialista(numero);
    }

    public void setIdServicioEspecialista(int idServicioEspecialista) {
        this.idServicioEspecialista = idServicioEspecialista;
    }
    
    public void agregarEspecialista(){
        bdmanager.addEspecialista(id, nombre, idServicioEspecialista);
    }
    
    public int getCantidadEspecialistas(){
        return bdmanager.getCantidadEspecialistas();
    }

    public BDManager getBDManager() {
        return bdmanager;
    }
}
