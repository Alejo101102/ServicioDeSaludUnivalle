package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaServiciosModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import hospital.*;

public class VentanaServiciosModelo{
    BDManager bdmanager = new BDManager();
    
    private int id;
    private String nombre;
    
    /**
     * Constructor de la clase VentanaServiciosModelo
     * @param bdmanager La clase que simula una base de datos
     */
    public VentanaServiciosModelo(BDManager bdmanager){
        this.bdmanager = bdmanager;
    }
    
    /**
     * Obtiene su propio bdmanager
     *
     * @return El bdmanager donde tiene todos sus datos
     */
    public BDManager getBDManager() {
        return bdmanager;
    }

    /**
     * Obtiene el id de un servicio en especifico
     *
     * @param numero La posicion del servicio en el arreglo
     * @return id El id del servicio (int)
     */
    public int getId(int numero) {
        return bdmanager.getIdServicio(numero);
    }

    /**
     * Asigna el id del modelo
     *
     * @param id El id de un servicio (int)
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de un servicio específico
     *
     * @param numero La posicion del servicio en el arreglo
     * @return El nombre del servicio(String)
     */
    public String getNombre(int numero) {
        return bdmanager.getNombreServicio(numero);
    }

    /**
     * Asigna un nombre al modelo
     *
     * @param nombre El nombre de un servicio (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea un nuevo servicio en bdmanager usando sus atributos
     */
    public void agregarServicio() {
        bdmanager.addServicio(id, nombre);
    }

    /**
     * Modifica un servicio en bdmanager usando sus atributos
     *
     * @param idActual El idActual del servicio que se quiere modificar
     */
    public void modificarServicio(int idActual) {
        bdmanager.alteracionEnServicios(idActual);
        bdmanager.modServicio(idActual, id, nombre);
    }

    /**
     * Elimina un servicio del bdmanager
     *
     * @param id El id del servicio que se quiere eliminar
     */
    public void eliminarServicio(int id) {
        bdmanager.alteracionEnServicios(id);
        bdmanager.delServicio(id);
    }

    /**
     * Obtiene la cantidad de servicios que hay
     *
     * @return La cantidad de servicios en el arreglo de bdmanager (int)
     */
    public int getCantidadServicios() {
        return bdmanager.getCantidadServicios();
    }
}
