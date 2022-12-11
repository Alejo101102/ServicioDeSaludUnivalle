package hospital;

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

public class Especialista extends Persona{
    private int idServicio;
    
    /**
     * Constructor de la clase Especialista
     * @see Persona.java - Clase de la que hereda
     * @param id El numero del documento de identificacion del especialista (int)
     * @param nombre Los nombre y apelligos del especialista (String)
     * @param idServicio El id del servicio que ofrece el especialista (int)
     */
    Especialista(int id, String nombre, int idServicio){
        super(id, nombre);
        this.idServicio = idServicio;
    }

    /**
     * Obtiene el id del servicio
     * @return El id del servicio que ofrece el especialista (int)
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Asigna el id del servicio
     * @param idServicio El id del servicio que ofrece el especialista (int)
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }  
}
