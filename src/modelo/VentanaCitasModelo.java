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
    
    //      ELEMENTOS PREVIAMENTE REGISTRADOS EN OTRAS VENTANAS         //
    private java.util.List<String> serviciosRegistrados = new ArrayList();
    private java.util.List<String> especialistasRegistrados = new ArrayList();
    private java.util.List<String> afiliadosRegistrados = new ArrayList();
    private java.util.List<String> consultoriosRegistrados = new ArrayList();
    
    private int id;
    private int dia;
    private int mes;
    private int anio;
    private int horas;
    private int minutos;
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

    public int getId(int indice) {
        return bdmanager.getIdCita(indice);
    }

    public void generarID(){
        String idS;
        String anioS;
        String mesS;
        String diaS;
        String horasS;
        String minutosS;        

        if(anio < 10) anioS = "0" + Integer.toString(anio);
        else anioS = Integer.toString(anio);
        if(mes < 10) mesS = "0" + Integer.toString(mes);
        else mesS = Integer.toString(mes);
        if(dia < 10) diaS = "0" + Integer.toString(dia);
        else diaS = Integer.toString(dia); 
        if(horas < 10) horasS = "0" + Integer.toString(horas);
        else horasS = Integer.toString(horas); 
        if(minutos < 10) minutosS = "0" + Integer.toString(minutos);
        else minutosS = Integer.toString(minutos); 
        
        idS = anioS + mesS + diaS + horasS + minutosS;
        id = Integer.parseInt(idS);   
    }

    public int getDia(int indice) {
        return bdmanager.getDiaCita(indice);
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes(int indice) {
        return bdmanager.getMesCita(indice);
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio(int indice) {
        return bdmanager.getAnioCita(indice);
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHoras(int indice) {
        return bdmanager.getHorasCita(indice);
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos(int indice) {
        return bdmanager.getMinutosCita(indice);
    }

    public void setMinutos(int minutos) {
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
    
    public boolean hayConsultorioParaEspecialista(String nombre){ 
        boolean resultado = bdmanager.hayConsultorioParaEspecialista(nombre);
        return resultado;
    }
    
    public String consultorioEspecialista(String nombre){
        String resultado = Integer.toString(bdmanager.consultorioEspecialista(nombre));
        return resultado;
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
