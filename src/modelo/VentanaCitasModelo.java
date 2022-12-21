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

public class VentanaCitasModelo{
    private BDManager bdmanager = new BDManager();
    
    //      ELEMENTOS PREVIAMENTE REGISTRADOS EN OTRAS VENTANAS         //
    private java.util.List<String> serviciosRegistrados = new ArrayList();
    private java.util.List<String> especialistasRegistrados = new ArrayList();
    private java.util.List<String> afiliadosRegistrados = new ArrayList();
    private java.util.List<String> consultoriosRegistrados = new ArrayList();
    
    private String id;
    private String dia;
    private String mes;
    private String anio;
    private String horas;
    private String minutos;
    private String afiliado;
    private String especialista;
    private String servicio;
    private String consultorio;

    
    public VentanaCitasModelo(BDManager bdmanager){
        this.bdmanager = bdmanager;
        
        cargarServiciosRegistrados();
        cargarEspecialistasRegistrados();
        cargarAfiliadosRegistrados();
        cargarConsultoriosRegistrados();
    }
    
    /**
     * Obtiene su propio bdmanager
     *
     * @return El bdmanager donde tiene todos sus datos
     */
    public BDManager getBDManager() {
        return bdmanager;
    }

    public String getId(int indice) {
        return bdmanager.getIdCita(indice);
    }

    public void generarID(){
        id = anio + mes + dia + horas + minutos;
    }
    
    public String tomarNuevoId(){
        String nuevoId = anio + mes + dia + horas + minutos;
        
        return nuevoId;
    }

    public String getDia(int indice) {
        return bdmanager.getDiaCita(indice);
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes(int indice) {
        return bdmanager.getMesCita(indice);
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio(int indice) {
        return bdmanager.getAnioCita(indice);
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getHoras(int indice) {
        return bdmanager.getHorasCita(indice);
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMinutos(int indice) {
        return bdmanager.getMinutosCita(indice);
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getAfiliado(int indice) {
        return bdmanager.getAfiliadoCita(indice);
    }

    public void setAfiliado(String afiliado) {
        this.afiliado = afiliado;
    }

    public String getEspecialista(int indice) {
        return bdmanager.getEspecialistaCita(indice);
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public String getServicio(int indice) {
        return bdmanager.getServicioCita(indice);
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getConsultorio(int indice) {
        return bdmanager.getConsultorioCita(indice);
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
    
    public void agregarCita(){
        bdmanager.addCita(id, dia, mes, anio, horas, minutos, afiliado, especialista, servicio, consultorio);
    }
    
    public void modificarCita(String nuevoId){
        bdmanager.modCita(id, nuevoId, dia, mes, anio, horas, minutos, afiliado, especialista, servicio, consultorio);
    }
    
    //                 CONSULTAS AL BDMANAGER               //
    public boolean hayConsultorioParaEspecialista(String nombre){ 
        boolean resultado = bdmanager.hayConsultorioParaEspecialista(nombre);
        return resultado;
    }
    
    public String consultorioEspecialista(String nombre){
        String resultado = Integer.toString(bdmanager.consultorioEspecialista(nombre));
        return resultado;
    }
    
    public boolean hayEspecialistaParaServicio(String servicio){ 
        boolean resultado = bdmanager.hayEspecialistaParaServicio(servicio);
        return resultado;
    }
    
    public java.util.List especialistasPara(String servicio){
        java.util.List<String> resultado = new ArrayList();
        resultado = bdmanager.especialistasPara(servicio);
        return resultado;
    }
    
    public int getCantidadCitas(){
        return bdmanager.getCantidadCitas();
    }
    
    //      PROVEE ELEMENTOS PREVIAMENTE REGISTRADOS EN OTRAS VENTANAS   //
    /**
     * Obtiene la cantidad de servicios en total
     * @return La cantidad de servicios (int)
     */
    public int getCantidadServiciosRegistrados() {
        return bdmanager.getCantidadServicios();
    }
    
    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarServiciosRegistrados(){
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
    public String getServicioRegistrado(int numero){
        return serviciosRegistrados.get(numero);
    }
    
    /**
     * Obtiene la cantidad de servicios en total
     *
     * @return La cantidad de servicios (int)
     */
    public int getCantidadEspecialistasRegistrados() {
        return bdmanager.getCantidadEspecialistas();
    }

    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarEspecialistasRegistrados() {
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
    public String getEspecialistaRegistrado(int numero) {
        return especialistasRegistrados.get(numero);
    }

    /**
     * Obtiene la cantidad de servicios en total
     *
     * @return La cantidad de servicios (int)
     */
    public int getCantidadAfiliadosRegistrados() {
        return bdmanager.getCantidadAfiliados();
    }

    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarAfiliadosRegistrados() {
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
    public String getAfiliadoRegistrado(int numero) {
        return afiliadosRegistrados.get(numero);
    }

    /**
     * Obtiene la cantidad de servicios en total
     *
     * @return La cantidad de servicios (int)
     */
    public int getCantidadConsultoriosRegistrados() {
        return bdmanager.getCantidadConsultorios();
    }

    /**
     * Copia los servicios en el bdmanager a un ArrayList local
     */
    public void cargarConsultoriosRegistrados() {
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
    public String getConsultorioRegistrado(int numero) {
        return consultoriosRegistrados.get(numero);
    }
    
    public String buscarNumeroConsultorioRegistrado(String nombreEspecialista) {
        String numeroConsultorio = "";
        numeroConsultorio = bdmanager.buscarNumeroConsultorio(nombreEspecialista);
        return numeroConsultorio;
    }
}
