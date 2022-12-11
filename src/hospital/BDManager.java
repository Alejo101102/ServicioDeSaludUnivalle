package hospital;

import java.util.ArrayList;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  BDManager.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class BDManager {
    private java.util.List<Afiliado> afiliados = new ArrayList<>();
    private java.util.List<Especialista> especialistas = new ArrayList<>();
    private java.util.List<Servicio> servicios = new ArrayList<>();
    
    /**
     * Constructor de la clase BDManager
     */
    BDManager(){
    }
    
    
    public void addAfiliado(int id, String nombre){
        afiliados.add(new Afiliado(id, nombre));
    }
    
    public void addEspecialista(int id, String nombre, int idServicio){
        especialistas.add(new Especialista(id, nombre, idServicio));
    }
    
    public void addServicio(int idServicio, String nombreServicio){
        servicios.add(new Servicio(idServicio, nombreServicio));
    }
        
    public void delAfiliado(int id){
        for(Afiliado afiliadoActual: afiliados){
            if(afiliadoActual.getId() == id){
                afiliados.remove(afiliadoActual);
            }
        }
    }
    
    public void delEspecialista(int id){
        for(Especialista especialistaActual: especialistas){
            if(especialistaActual.getId() == id){
                especialistas.remove(especialistaActual);
            }
        }
    }
    
    public void delServicio(int idServicio){
        for(Servicio servicioActual: servicios){
            if(servicioActual.getIdServicio() == idServicio){
                servicios.remove(servicioActual);
            }
        }
    }    
}
