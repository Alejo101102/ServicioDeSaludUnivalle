package hospital;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Servicio.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Servicio {
    private int idServicio;
    private String nombreServicio;
    
    /**
     * Constructor de la clase Servicio
     * @param idServicio El id por el que se identificará el servicio
     * @param nombreServicio El nombre del servicio
     */
    Servicio(int idServicio, String nombreServicio){
        this.idServicio=idServicio;
        this.nombreServicio=nombreServicio;
    }

    /**
     * Obtiene el id del servicio
     * @return El id por el que se identifica el servicio (int)
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Asigna un id al servicio
     * @param idServicio El id por el que se identifica el servicio(int)
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * Obtiene el nombre del servicio
     * @return El nombre del servicio (String)
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * Asigna un nombre al servicio
     * @param nombreServicio El nombre del servicio (String)
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
}
