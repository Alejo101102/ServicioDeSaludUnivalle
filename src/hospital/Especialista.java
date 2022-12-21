package hospital;

import java.io.Serializable;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Especialista.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Especialista extends Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombreServicio;
    
    /**
     * Constructor de la clase Especialista
     * @see Persona.java - Clase de la que hereda
     * @param id El numero del documento de identificacion del especialista (int)
     * @param nombre Los nombre y apelligos del especialista (String)
     * @param nombreServicio El nombre del servicio que ofrece el especialista (String)
     */
    Especialista(int id, String nombre, String nombreServicio){
        super(id, nombre);
        this.nombreServicio = nombreServicio;
    }

    /**
     * Obtiene el id del servicio
     * @return El id del servicio que ofrece el especialista (int)
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * Asigna el id del servicio
     * @param nombreServicio El nombre del servicio que ofrece el especialista (String)
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }  
}
