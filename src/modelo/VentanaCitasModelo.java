package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaCitasModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import hospital.BDManager;
import java.util.ArrayList;

public class VentanaCitasModelo {
    
    private BDManager bdmanager = new BDManager();
    
    private java.util.List<String> serviciosRegistrados = new ArrayList();
    private java.util.List<String> especialistasRegistrados = new ArrayList();
    private java.util.List<String> afiliadosRegistrados = new ArrayList();
    private java.util.List<String> consultoriosRegistrados = new ArrayList();
    
    public VentanaCitasModelo(BDManager bdmanager){
        this.bdmanager = bdmanager;
        
        cargarServicios();
        cargarEspecialistas();
        cargarAfiliados();
        cargarConsultorios();
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
     * Obtiene la cantidad de servicios en total
     * @return La cantidad de servicios (int)
     */
    public int getCantidadServicios() {
        return bdmanager.getCantidadServicios();
    }
    
    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarServicios(){
        if(bdmanager.getCantidadServicios()>0){
            for(int i = 0; i < bdmanager.getCantidadServicios(); i++){
                serviciosRegistrados.add(bdmanager.getNombreServicio(i));
            }
        }
    }
    
    /**
     * Obtiene el nombre de un servicio en una posicion específica del arreglo
     * @param numero El indice del servicio que se quiere obtener (int)
     * @return El nombre del servicio (String)
     */
    public String getServicio(int numero){
        return serviciosRegistrados.get(numero);
    }
    
    /**
     * Obtiene la cantidad de servicios en total
     *
     * @return La cantidad de servicios (int)
     */
    public int getCantidadEspecialistas() {
        return bdmanager.getCantidadEspecialistas();
    }

    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarEspecialistas() {
        if (bdmanager.getCantidadEspecialistas() > 0) {
            for (int i = 0; i < bdmanager.getCantidadEspecialistas(); i++) {
                especialistasRegistrados.add(bdmanager.getNombreEspecialista(i));
            }
        }
    }

    /**
     * Obtiene el nombre de un servicio en una posicion específica del arreglo
     *
     * @param numero El indice del servicio que se quiere obtener (int)
     * @return El nombre del servicio (String)
     */
    public String getEspecialista(int numero) {
        return especialistasRegistrados.get(numero);
    }

    /**
     * Obtiene la cantidad de servicios en total
     *
     * @return La cantidad de servicios (int)
     */
    public int getCantidadAfiliados() {
        return bdmanager.getCantidadServicios();
    }

    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarAfiliados() {
        if (bdmanager.getCantidadAfiliados() > 0) {
            for (int i = 0; i < bdmanager.getCantidadAfiliados(); i++) {
                afiliadosRegistrados.add(bdmanager.getNombreAfiliado(i));
            }
        }
    }

    /**
     * Obtiene el nombre de un servicio en una posicion específica del arreglo
     *
     * @param numero El indice del servicio que se quiere obtener (int)
     * @return El nombre del servicio (String)
     */
    public String getAfiliado(int numero) {
        return afiliadosRegistrados.get(numero);
    }

    /**
     * Obtiene la cantidad de servicios en total
     *
     * @return La cantidad de servicios (int)
     */
    public int getCantidadConsultorios() {
        return bdmanager.getCantidadConsultorios();
    }

    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarConsultorios() {
        if (bdmanager.getCantidadConsultorios() > 0) {
            for (int i = 0; i < bdmanager.getCantidadConsultorios(); i++) {
                consultoriosRegistrados.add(Integer.toString(bdmanager.getNumeroConsultorio(i)));
            }
        }
    }

    /**
     * Obtiene el nombre de un servicio en una posicion específica del arreglo
     *
     * @param numero El indice del servicio que se quiere obtener (int)
     * @return El nombre del servicio (String)
     */
    public String getConsultorio(int numero) {
        return consultoriosRegistrados.get(numero);
    }
    
    public String buscarNumeroConsultorio(String nombreEspecialista) {
        String numeroConsultorio = "";
        numeroConsultorio = bdmanager.buscarNumeroConsultorio(nombreEspecialista);
        return numeroConsultorio;
    }
}
