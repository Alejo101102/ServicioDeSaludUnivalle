package hospital;

import java.io.Serializable;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Afiliado.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Afiliado extends Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * Constructor de la clase Afiliado
     * @see Persona.java - Clase de la que hereda
     * @param id El numero del documento de identificacion del afiliado (int)
     * @param nombre Los nombre y apelligos del afiliado (String)
     */
    Afiliado(int id, String nombre){
        super(id, nombre);
    }

}
