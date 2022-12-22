package modelo;

import hospital.BDManager;
import java.util.ArrayList;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaConsultoriosModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaConsultoriosModelo {

    BDManager bdmanager = new BDManager();

    private int numeroConsultorio;
    private String especialistaAsociado;
    
    private java.util.List<String> especialistas = new ArrayList();

    /**
     * Constructor de clase VentanaConsultoriosModelo
     *
     * @param bdmanager La clase que simula una base de datos
     */
    public VentanaConsultoriosModelo(BDManager bdmanager) {
        this.bdmanager = bdmanager;
        cargarEspecialistas();
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
     * Obtiene el numeroConsultorio de un consultorio en especifico
     *
     * @param numero La posicion del consultorio en el arreglo
     * @return numeroConsultorio El numeroConsultorio del consultorio (int)
     */
    public int getNumeroConsultorio(int numero) {
        return bdmanager.getNumeroConsultorio(numero);
    }

    /**
     * Asigna el numero del modelo
     *
     * @param numeroConsultorio El numeroConsultorio de un consultorio (int)
     */
    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    /**
     * Obtiene el especialistaAsociado de un consultorio específico
     *
     * @param numero La posicion del consultorio en el arreglo
     * @return El especialistaAsociado del consultorio(String)
     */
    public String getEspecialistaAsociado(int numero) {
        return bdmanager.getEspecialistaAsociadoConsultorio(numero);
    }

    /**
     * Asigna un especialistaAsociado completo al modelo
     *
     * @param especialistaAsociado El especialistaAsociado completo de un consultorio (String)
     */
    public void setEspecialistaAsociado(String especialistaAsociado) {
        this.especialistaAsociado = especialistaAsociado;
    }

    /**
     * Crea un nuevo consultorio en bdmanager usando sus atributos
     */
    public void agregarConsultorio() {
        bdmanager.addConsultorio(numeroConsultorio, especialistaAsociado);
    }

    /**
     * Modifica un consultorio en bdmanager usando sus atributos
     *
     * @param idActual El idActual del consultorio que se quiere modificar
     */
    public void modificarConsultorio(int idActual) {
        bdmanager.modConsultorio(idActual, numeroConsultorio, especialistaAsociado);
    }

    /**
     * Elimina un consultorio del bdmanager
     *
     * @param numeroConsultorio El numeroConsultorio del consultorio que se quiere eliminar
     */
    public void eliminarConsultorio(int numeroConsultorio) {
        bdmanager.delConsultorio(numeroConsultorio);
    }

    /**
     * Obtiene la cantidad de consultorios que hay
     *
     * @return La cantidad de consultorios en el arreglo de bdmanager (int)
     */
    public int getCantidadConsultorios() {
        return bdmanager.getCantidadConsultorios();
    }
    
    /**
     * Obtiene la cantidad de especialistas en total
     * @return La cantidad de especialistas (int)
     */
    public int getCantidadEspecialistas() {
        return bdmanager.getCantidadEspecialistas();
    }
    
    /**
     * Hace una copia de los nombres de los especialistas en un ArrayList local
     */
    public void cargarEspecialistas(){
        if(bdmanager.getCantidadEspecialistas()>0){
            for(int i = 0; i < bdmanager.getCantidadEspecialistas(); i++){
                especialistas.add(bdmanager.getNombreEspecialista(i));
            }
        }
    }
    
    /**
     * Obtiene el nombre de un especialista en una posición del arreglo
     * @param numero El indice del que se obtendra el nombre (int)
     * @return El nombre del especialista  (String)
     */
    public String getEspecialista(int numero){
        return especialistas.get(numero);
    }
    
    public boolean existeConsultorioConId(int id){
        boolean resultado = bdmanager.existeConsultorioConId(id);
        return resultado;
    } 
}

