package hospital;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Persona.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Persona {
    protected int id;
    protected String nombre;
    
    /**
     * Constructor de la clase persona
     * @param id El numero del documento de identificacion de la persona (int)
     * @param nombre Los nombre y apelligos de la persona (String)
     */
    Persona(int id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }

    /**
     * Obtiene el id de la persona
     * @return El numero del documento de identificacion de la persona (int)
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna un id a la persona
     * @param id El numero del documento de identificacion de la persona (int) 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo de la persona (Nombres y apellidos)
     * @return Los nombre y apelligos de la persona (String)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre completo de la persona (Nombres y apellidos)
     * @param nombre Los nombre y apelligos de la persona (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
