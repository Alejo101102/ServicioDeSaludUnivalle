package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
    Laboratorio # 3
    Profesor: Luis Romo Portilla 

    Archivo:  VentanaAfiliadosModelo.java
    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import hospital.*;

public class VentanaAfiliadosModelo{
    
    BDManager bdmanager = new BDManager();

    private int id;
    private String nombre;

    /**
     * Constructor de clase VentanaAfiliadosModelo
     *
     * @param bdmanager La clase que simula una base de datos
     */
    public VentanaAfiliadosModelo(BDManager bdmanager) {
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
        return bdmanager.getIdAfiliado(numero);
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
        return bdmanager.getNombreAfiliado(numero);
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
     * Crea un nuevo afiliado en bdmanager usando sus atributos
     */
    public void agregarAfiliado() {
        bdmanager.addAfiliado(id, nombre);
    }

    /**
     * Modifica un afiliado en bdmanager usando sus atributos
     *
     * @param idActual El idActual del afiliado que se quiere modificar
     */
    public void modificarAfiliado(int idActual) {
        bdmanager.modAfiliado(idActual, id, nombre);
    }

    /**
     * Elimina un afiliado del bdmanager
     *
     * @param id El id del afiliado que se quiere eliminar
     */
    public void eliminarAfiliado(int id) {
        bdmanager.delAfiliado(id);
    }

    /**
     * Obtiene la cantidad de afiliados que hay
     *
     * @return La cantidad de afiliados en el arreglo de bdmanager (int)
     */
    public int getCantidadAfiliados() {
        return bdmanager.getCantidadAfiliados();
    }

    public boolean existeAfiliadoConId(int id){
        boolean resultado = bdmanager.existeAfiliadoConId(id);
        return resultado;
    }   
}
