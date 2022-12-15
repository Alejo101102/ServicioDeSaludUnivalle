package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
    Laboratorio # 3
    Profesor: Luis Romo Portilla 

    Archivo:  VentanaAfiliadosModelo.java
    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import hospital.*;

public class VentanaAfiliadosModelo {
    BDManager bdmanager = new BDManager(); 
    
    public VentanaAfiliadosModelo(BDManager bdmanager){
        this.bdmanager = bdmanager;
    }
    
    //Recibe
    private int id;
    private String nombre;

    public int getId(int numero) {
        return bdmanager.getIdAfiliado(numero);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(int numero) {
        return bdmanager.getNombreAfiliado(numero);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarAfiliado(){
        bdmanager.addAfiliado(id, nombre);
    }
    
    public void eliminarAfiliado(int id){
        bdmanager.delAfiliado(id);
    }
    
    public int getCantidadAfiliados(){
        return bdmanager.getCantidadAfiliados();
    }

    public BDManager getBDManager() {
        return bdmanager;
    }
}
