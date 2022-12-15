package hospital;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Consultorio.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Consultorio {
    protected int numeroConsultorio;
    protected String especialistaAsociado;
    
    /**
     * Constructor de la clase consultorio
     * @param numeroConsultorio El numero del documento de identificacion de la consultorio (int)
     * @param especialistaAsociado Los especialistaAsociado y apelligos de la consultorio (String)
     */
    public Consultorio(int numeroConsultorio, String especialistaAsociado){
        this.numeroConsultorio=numeroConsultorio;
        this.especialistaAsociado=especialistaAsociado;
    }

    /**
     * Obtiene el numero del consultorio
     * @return El numero del consultorio (int)
     */
    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    /**
     * Asigna un numero al consultorio
     * @param numeroConsultorio El numero del documento de identificacion de la consultorio (int) 
     */
    public void setId(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    /**
     * Obtiene el especialista asociado del consultorio
     * @return El nombre del especialista asociado al consultorio (String)
     */
    public String getNombre() {
        return especialistaAsociado;
    }

    /**
     * Asigna un especialista asociado al consultorio
     * @param especialistaAsociado El especialista asociado al consultorio (String)
     */
    public void setNombre(String especialistaAsociado) {
        this.especialistaAsociado = especialistaAsociado;
    }
}
