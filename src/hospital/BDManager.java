package hospital;

import java.util.ArrayList;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  BDManager.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
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
    
    /**
     * Añade un nuevo afiliado
     * @param id El numero del documento de identificacion del afiliado (int)
     * @param nombre Los nombre y apelligos del afiliado (String)
     */
    public void addAfiliado(int id, String nombre){
        afiliados.add(new Afiliado(id, nombre));
    }
    
    /**
     * Añade un nuevo especialista
     * @param id El numero del documento de identificacion del especialista (int)
     * @param nombre Los nombre y apelligos del especialista (String)
     * @param idServicio El id del servicio que ofrece el especialista (int)
     */
    public void addEspecialista(int id, String nombre, int idServicio){
        especialistas.add(new Especialista(id, nombre, idServicio));
    }
    
    /**
     * Añade un nuevo servicio
     * @param idServicio El id por el que se identificará el servicio (int)
     * @param nombreServicio El nombre del servicio (String)
     */
    public void addServicio(int idServicio, String nombreServicio){
        servicios.add(new Servicio(idServicio, nombreServicio));
    }
    
    /**
     * Modifica los datos de un afiliado
     * @param id El numero del documento de identificacion actual del afiliado que se va a modificar (int)
     * @param nuevoId El NUEVO numero del documento de identificacion (int)
     * @param nuevoNombre Los NUEVOS nombre y apelligos (String)
     */
    public void modAfiliado(int id, int nuevoId, String nuevoNombre){
        for(Afiliado afiliadoActual: afiliados){
            if(afiliadoActual.getId() == id){
                afiliadoActual.setId(nuevoId);
                afiliadoActual.setNombre(nuevoNombre);
            }
        }
    }
    
    /**
     * Modifica los datos de un especialista
     * @param id El numero del documento de identificacion actual del especialista que se va a modificar (int)
     * @param nuevoId El NUEVO numero del documento de identificacion (int)
     * @param nuevoNombre Los NUEVOS nombre y apelligos (String)
     * @param nuevoIdServicio  El NUEVO id del servicio que ofrece (int)
     */
    public void modEspecialista(int id, int nuevoId, String nuevoNombre, int nuevoIdServicio){
        for(Especialista especialistaActual: especialistas){
            if(especialistaActual.getId() == id){
                especialistaActual.setId(nuevoId);
                especialistaActual.setNombre(nuevoNombre);
                especialistaActual.setIdServicio(nuevoIdServicio);
            }
        }
    }
    
    /**
     * Modifica los datos de un servicio
     * @param idServicio El id actual del servicio que se va a modicar
     * @param nuevoIdServicio El NUEVO id por el que se identificará el servicio (int)
     * @param nuevoNombreServicio El NUEVO nombre del servicio (String)
     */
    public void modServicio(int idServicio, int nuevoIdServicio, String nuevoNombreServicio){
        for(Servicio servicioActual: servicios){
            if(servicioActual.getIdServicio() == idServicio){
                servicioActual.setIdServicio(nuevoIdServicio);
                servicioActual.setNombreServicio(nuevoNombreServicio);
            }
        }
    }
    
    /**
     * Elimina un afiliado
     * @param id El id actual del afiliado que se va a eliminar (int)
     */
    public void delAfiliado(int id){
        for(Afiliado afiliadoActual: afiliados){
            if(afiliadoActual.getId() == id){
                afiliados.remove(afiliadoActual);
            }
        }
    }
    
    /** 
     * Elimina un especialista
     * @param id El id actual del especialista que se va a eliminar (int)
     */
    public void delEspecialista(int id){
        for(Especialista especialistaActual: especialistas){
            if(especialistaActual.getId() == id){
                especialistas.remove(especialistaActual);
            }
        }
    }
    
    /**
     * Elimina un servicio
     * @param idServicio El id actual del servicio que se va a eliminar (int)
     */
    public void delServicio(int idServicio){
        for(Servicio servicioActual: servicios){
            if(servicioActual.getIdServicio() == idServicio){
                servicios.remove(servicioActual);
            }
        }
    }    
}
