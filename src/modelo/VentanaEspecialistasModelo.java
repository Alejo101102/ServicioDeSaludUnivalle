package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
    Laboratorio # 3
    Profesor: Luis Romo Portilla 

    Archivo:  VentanaEspecialistasModelo.java
    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import hospital.*;

public class VentanaEspecialistasModelo {
    
    BDManager bdmanager = new BDManager();

    private int id;
    private String nombre;
    private int idServicioEspecialista;

    /**
     * Constructor de la clase VentanaEspecialistasModelo
     *
     * @param bdmanager La clase que simula una base de datos
     */
    public VentanaEspecialistasModelo(BDManager bdmanager) {
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
     * Obtiene el id de un afiliado en especifico
     *
     * @param numero La posicion del afiliado en el arreglo
     * @return id El id del afiliado (int)
     */
    public int getId(int numero) {
        return bdmanager.getIdEspecialista(numero);
    }

    /**
     * Asigna el id del modelo
     *
     * @param id El id de un afiliado (int)
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de un afiliado específico
     *
     * @param numero La posicion del afiliado en el arreglo
     * @return El nombre del afiliado(String)
     */
    public String getNombre(int numero) {
        return bdmanager.getNombreEspecialista(numero);
    }

    /**
     * Asigna un nombre completo al modelo
     *
     * @param nombre El nombre completo de un afiliado (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el id de servicio de un afiliado en especifico
     *
     * @param numero La posicion del afiliado en el arreglo
     * @return id El id del afiliado (int)
     */
    public int getIdServicioEspecialista(int numero) {
        return bdmanager.getIdServicioEspecialista(numero);
    }

    /**
     * Obtiene el nombre de un afiliado específico
     *
     * @param idServicioEspecialista El id del servicio del especialista
     */
    public void setIdServicioEspecialista(int idServicioEspecialista) {
        this.idServicioEspecialista = idServicioEspecialista;
    }

    /**
     * Crea un nuevo afiliado en bdmanager usando sus atributos
     */
    public void agregarEspecialista() {
        bdmanager.addEspecialista(id, nombre, idServicioEspecialista);
    }

    /**
     * Modifica un afiliado en bdmanager usando sus atributos
     *
     * @param idActual El idActual del afiliado que se quiere modificar
     */
    public void modificarEspecialista(int idActual) {
        bdmanager.modEspecialista(idActual, id, nombre, idServicioEspecialista);
    }

    /**
     * Elimina un afiliado del bdmanager
     *
     * @param id El id del afiliado que se quiere eliminar
     */
    public void eliminarEspecialista(int id) {
        bdmanager.delAfiliado(id);
    }

    /**
     * Obtiene la cantidad de afiliados que hay
     *
     * @return La cantidad de afiliados en el arreglo de bdmanager (int)
     */
    public int getCantidadEspecialistas() {
        return bdmanager.getCantidadEspecialistas();
    }
}
