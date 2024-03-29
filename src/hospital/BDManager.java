package hospital;

import java.awt.Component;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  BDManager.java
 *    Licencia: GNU-GPL 
 *    @version  1.5
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class BDManager {

    private java.util.List<Afiliado> afiliados = new ArrayList<>();
    private java.util.List<Especialista> especialistas = new ArrayList<>();
    private java.util.List<Servicio> servicios = new ArrayList<>();
    private java.util.List<Consultorio> consultorios = new ArrayList<>();
    private java.util.List<Cita> citas = new ArrayList<>();
    
    // FECHA
    private Date date = new Date();  
    private SimpleDateFormat fechaActual = new SimpleDateFormat("dd_MMM_YYYY"); 
    
    // HORA
    private Calendar calendario = new GregorianCalendar();
    
    // NAVEGADOR DE ARCHIVOS
    private JFileChooser selectorArchivos = new JFileChooser("src/backup");
    private Component contentPane;
    
    /**
     * Constructor de la clase BDManager
     */
    public BDManager() {
    }
    
    //              MANEJO DE AFILIADOS             //
    /**
     * Añade un nuevo afiliado
     *
     * @param id El numero del documento de identificacion del afiliado (int)
     * @param nombre Los nombre y apelligos del afiliado (String)
     */
    public void addAfiliado(int id, String nombre) {
        afiliados.add(new Afiliado(id, nombre));
    }
    
    /**
     * Modifica los datos de un afiliado
     *
     * @param id El numero del documento de identificacion actual del afiliado
     * que se va a modificar (int)
     * @param nuevoId El NUEVO numero del documento de identificacion (int)
     * @param nuevoNombre Los NUEVOS nombre y apelligos (String)
     */
    public void modAfiliado(int id, int nuevoId, String nuevoNombre) {
        for (Afiliado afiliadoActual : afiliados) {
            if (afiliadoActual.getId() == id) {
                afiliadoActual.setId(nuevoId);
                afiliadoActual.setNombre(nuevoNombre);
            }
        }
    }

    /**
     * Elimina un afiliado
     *
     * @param id El id actual del afiliado que se va a eliminar (int)
     */
    public void delAfiliado(int id) {
        for (Afiliado afiliadoActual : afiliados) {
            if (afiliadoActual.getId() == id) {
                afiliados.remove(afiliadoActual);
            }
        }
    }    

    /**
     * Obtiene el id de un afiliado de la lista de afiliados
     *
     * @param numero La posicion del afiliado en el vector
     * @return El ID del afiliado (int)
     */
    public int getIdAfiliado(int numero) {
        return afiliados.get(numero).getId();
    }

    /**
     * Obtiene el nombre de un afiliado de la lista de afiliados
     *
     * @param numero La posicion del afiliado en el vector
     * @return El nombre completo del afiliado (String)
     */
    public String getNombreAfiliado(int numero) {
        return afiliados.get(numero).getNombre();
    }

    /**
     * Obtiene la cantidad de afiliados
     *
     * @return El numero de afiliados del vector de afiliados (int)
     */
    public int getCantidadAfiliados() {
        return afiliados.size();
    }    
    
    /**
     * Provoca alteraciones en otros objetos según la relación
     * @param id El id del afiliado que fue alterado (Modificado/Eliminado)
     */
    public void alteracionEnAfiliado(int id){
        String nombreAfiliado = buscarNombreAfiliado(id);
        
        if(nombreAfiliado != "EMPTY"){
            //ELIMINACION EN CITAS
//            for (Cita citaActual : citas) {
//                if (citaActual.getEspecialista() == nombreEspecialista) {
//                    citaActual.setEspecialista("NO ECONTRADO");
//                }
//            }        
        }
    }
    
    /**
     * Busca el nombre de un afiliado a partir de su cedula
     * @param id La cedula del afiliado (int)
     * @return El nombre completo del afiliado (String)
     */
    public String buscarNombreAfiliado(int id){
        String nombreAfiliado = "EMPTY";
        
        for (Afiliado afiliadoActual : afiliados) {
            if (afiliadoActual.getId() == id) {
                nombreAfiliado = afiliadoActual.getNombre();
                break;
            }
        }
        
        return nombreAfiliado;
    }
    
    /**
     * Verifica si existe un afiliado con una cedula
     * @param id La cedula del afiliado (int)
     * @return True, si un afiliado ya tiene esa cedual; False, si no existe un afiliado con esa cedula
     */
    public boolean existeAfiliadoConId(int id){
        boolean resultado = false;
        for (Afiliado afiliadoActual : afiliados) {
            if (afiliadoActual.getId() == id) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    //              MANEJO DE ESPECIALISTAS         //
    /**
     * Añade un nuevo especialista
     *
     * @param id El numero del documento de identificacion del especialista
     * (int)
     * @param nombre Los nombre y apelligos del especialista (String)
     * @param nombreServicio El nombre del servicio que ofrece el especialista (String)
     */
    public void addEspecialista(int id, String nombre, String nombreServicio) {
        especialistas.add(new Especialista(id, nombre, nombreServicio));
    }

    /**
     * Modifica los datos de un especialista
     *
     * @param id El numero del documento de identificacion actual del
     * especialista que se va a modificar (int)
     * @param nuevoId El NUEVO numero del documento de identificacion (int)
     * @param nuevoNombre Los NUEVOS nombre y apelligos (String)
     * @param nuevoNombreServicio El NUEVO nombre del servicio que ofrece (String)
     */
    public void modEspecialista(int id, int nuevoId, String nuevoNombre, String nuevoNombreServicio) {
        for (Especialista especialistaActual : especialistas) {
            if (especialistaActual.getId() == id) {
                especialistaActual.setId(nuevoId);
                especialistaActual.setNombre(nuevoNombre);
                especialistaActual.setNombreServicio(nuevoNombreServicio);
            }
        }
    }
    
    /**
     * Declara el servicio de un especialista como NO ASIGNADO
     *
     * @param id El numero del documento de identificacion actual del
     * especialista que se va a modificar (int)
     */
    public void serEliminadoEspecialista(int id) {
        for (Especialista especialistaActual : especialistas) {
            if (especialistaActual.getId() == id) {
                especialistaActual.setNombreServicio("NO ASIGNADO");
            }
        }
    }

    /**
     * Elimina un especialista
     *
     * @param id El id actual del especialista que se va a eliminar (int)
     */
    public void delEspecialista(int id) {
        for (Especialista especialistaActual : especialistas) {
            if (especialistaActual.getId() == id) {
                especialistas.remove(especialistaActual);
            }
        }
    }

    /**
     * Obtiene el id de un especialistas de la lista de especialistas
     *
     * @param numero La posicion del especialistas en el vector
     * @return El ID del especialistas (int)
     */
    public int getIdEspecialista(int numero) {
        return especialistas.get(numero).getId();
    }

    /**
     * Obtiene el nombre de un especialistas de la lista de especialistas
     *
     * @param numero La posicion del especialistas en el vector
     * @return El nombre completo del especialistas (String)
     */
    public String getNombreEspecialista(int numero) {
        return especialistas.get(numero).getNombre();
    }

    /**
     * Obtiene el nombre de un especialistas de la lista de especialistas
     *
     * @param numero La posicion del especialistas en el vector
     * @return El nombre completo del especialistas (String)
     */
    public String getNombreServicioEspecialista(int numero) {
        return especialistas.get(numero).getNombreServicio();
    }

    /**
     * Obtiene la cantidad de especialistas
     *
     * @return El numero de especialistas del vector de especialistas (int)
     */
    public int getCantidadEspecialistas() {
        return especialistas.size();
    }
    
    /**
     * Verifica si existe algu especialista que se ocupe de un servicio especifico
     * @param servicio El nombre del servicio (String)
     * @return True, si existe un especialista en ese servicio; False, si no existe
     */
    public boolean hayEspecialistaParaServicio(String servicio) {
        boolean resultado = false;
        
        for (Especialista especialistaActual : especialistas) {
            
            if (especialistaActual.getNombreServicio() == servicio) {
                resultado = true;
                break;
            }
            
        }
        
        return resultado;
    }

    /**
     * Lista los nombres completos de los especialistas que se ocupan de un servicio especifico 
     * @param servicio El nombre del servicio (String)
     * @return El listado de nombres completos de los especialistas (List-String-)
     */
    public java.util.List especialistasPara(String servicio) {
        
        java.util.List<String> resultado = new ArrayList();
        
        for (Especialista especialistaActual : especialistas) {
            
            if (especialistaActual.getNombreServicio() == servicio) {
                
                resultado.add(especialistaActual.getNombre());
                
            }
        }        
        return resultado;
    }
    
    /**
     * Efectua cambios en los objetos de otras clases dependientes o relacionados con la clase Especialista
     * @param id El ID del especialista que sufrió una alteracion (int)
     */
    public void alteracionEnEspecialista(int id){
        String nombreEspecialista = buscarNombreEspecialista(id);
         
        if(nombreEspecialista != "EMPTY"){
            //ELIMINACION EN CONSULTORIOS
            for (Consultorio consultorioActual : consultorios) {
                if (consultorioActual.getNombre() == nombreEspecialista) {
                    alteracionEnConsultorio(consultorioActual.getNombre());
                    consultorioActual.setNombre("NO ASIGNADO");
                    
                }
            }

            //ELIMINACION EN CITAS
//            for (Cita citaActual : citas) {
//                if (citaActual.getEspecialista() == nombreEspecialista) {
//                    citaActual.setEspecialista("NO ASIGNADO");
//                }
//            }        
        }
    }
    
    /**
     * Busca el nombre de un especialista
     * @param id El ID del especialista del que se quiere obtener el nombre (int)
     * @return El nombre del especialista (String)
     */
    public String buscarNombreEspecialista(int id){
        String nombreEspecialista = "EMPTY";
        
        for (Especialista especialistaActual : especialistas) {
            if (especialistaActual.getId() == id) {
                nombreEspecialista = especialistaActual.getNombre();
                break;
            }
        }
        return nombreEspecialista;
    }
    
    /**
     * Verifica si existe un especialista con un numero de cedula especifico
     * @param id El numero de cedula del especialista (int)
     * @return True, si existe un especialista con esa cedula; False, si no existe un especialista con esa cedula
     */
    public boolean existeEspecialistaConId(int id){
        boolean resultado = false;
        for (Especialista especialistaActual : especialistas) {
            if (especialistaActual.getId() == id) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }
    
    //              MANEJO DE SERVICIOS         //
    /**
     * Añade un nuevo servicio
     *
     * @param idServicio El id por el que se identificará el servicio (int)
     * @param nombreServicio El nombre del servicio (String)
     */
    public void addServicio(int idServicio, String nombreServicio) {
        servicios.add(new Servicio(idServicio, nombreServicio));
    }

    /**
     * Modifica los datos de un servicio
     *
     * @param idServicio El id actual del servicio que se va a modicar
     * @param nuevoIdServicio El NUEVO id por el que se identificará el servicio
     * (int)
     * @param nuevoNombreServicio El NUEVO nombre del servicio (String)
     */
    public void modServicio(int idServicio, int nuevoIdServicio, String nuevoNombreServicio) {
        for (Servicio servicioActual : servicios) {
            if (servicioActual.getIdServicio() == idServicio) {
                servicioActual.setIdServicio(nuevoIdServicio);
                servicioActual.setNombreServicio(nuevoNombreServicio);
            }
        }
    }

    /**
     * Elimina un servicio
     *
     * @param idServicio El id actual del servicio que se va a eliminar (int)
     */
    public void delServicio(int idServicio) {
        for (Servicio servicioActual : servicios) {
            if (servicioActual.getIdServicio() == idServicio) {
                servicios.remove(servicioActual);
            }
        }
    }

    /**
     * Obtiene el id de un servicio de la lista de servicios
     *
     * @param numero La posicion del servicio en el vector
     * @return El ID del servicio (int)
     */
    public int getIdServicio(int numero) {
        return servicios.get(numero).getIdServicio();
    }

    /**
     * Obtiene el nombre de un servicio de la lista de servicios
     *
     * @param numero La posicion del servicio en el vector
     * @return El nombre completo del servicio (String)
     */
    public String getNombreServicio(int numero) {
        return servicios.get(numero).getNombreServicio();
    }

    /**
     * Obtiene la cantidad de servicios
     *
     * @return El numero de servicios del vector de servicios (int)
     */
    public int getCantidadServicios() {
        return servicios.size();
    }
    
    /**
     * Efectua cambios en los objetos de otras clases dependientes o relacionados con la clase Servicio
     * @param id El ID del servicio que sufrió una alteracion
     */
    public void alteracionEnServicios(int id){
        
        String nombreServicio = buscarNombreServicio(id);
        
        if(nombreServicio != "EMPTY"){
            //ELIMINACION EN ESPECIALISTAS
            for (Especialista especialistaActual : especialistas) {
                if (especialistaActual.getNombreServicio() == nombreServicio) {
                    alteracionEnEspecialista(especialistaActual.getId());
                    especialistaActual.setNombreServicio("NO ASIGNADO");
                }
            } 
            
            //ELIMINACION EN CITAS
//            for (Cita citaActual : citas) {
//                if (citaActual.getEspecialista() == nombreEspecialista) {
//                    alteracionEnCita(citaActual.getID())
//                    citaActual.setEspecialista("NO ASIGNADO");
//                }
//            }
        }
    }
    
    /**
     * Busca el nombre de un servicio
     * @param id El ID del servicio del que se quiere obtener el nombre (int)
     * @return El nombre del servicio (String)
     */
    public String buscarNombreServicio(int id){
        String nombreServicio = "EMPTY";
        
        for (Servicio servicioActual : servicios) {
            if (servicioActual.getIdServicio() == id) {
                nombreServicio = servicioActual.getNombreServicio();
                break;
            }
        }
        return nombreServicio;
    }
    
    /**
     * Verifica si existe un servicio con un id especifico
     * @param id El numero de id del servicio (int)
     * @return True, si existe un servicio con esa id; False, si no existe un servicio con ese ID
     */
    public boolean existeServicioConId(int id){
        boolean resultado = false;
        for (Servicio servicioActual : servicios) {
            if (servicioActual.getIdServicio() == id) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }
    
    
    //              MANEJO DE CONSULTORIOS             //
    /**
     * Añade un nuevo consultorio
     *
     * @param numeroConsultorio El numero del consultorio (int)
     * @param especialistaAsociado El especialista asociado al consultorio (String)
     */
    public void addConsultorio(int numeroConsultorio, String especialistaAsociado) {
        consultorios.add(new Consultorio(numeroConsultorio, especialistaAsociado));        
    }
    
    /**
     * Modifica los datos de un consultorio
     *
     * @param numeroConsultorio El numero del consultorio que se va a modificar (int)
     * @param nuevoId El NUEVO numero del consultorio (int)
     * @param nuevoNombre El NUEVO especialista asociado (String)
     */
    public void modConsultorio(int numeroConsultorio, int nuevoId, String nuevoNombre) {
        for (Consultorio consultorioActual : consultorios) {
            if (consultorioActual.getNumeroConsultorio() == numeroConsultorio) {
                consultorioActual.setId(nuevoId);
                consultorioActual.setNombre(nuevoNombre);
            }
        }
    }

    /**
     * Elimina un consultorio
     *
     * @param numeroConsultorio El numero actual del consultorio que se va a eliminar (int)
     */
    public void delConsultorio(int numeroConsultorio) {
        for (Consultorio consultorioActual : consultorios) {
            if (consultorioActual.getNumeroConsultorio() == numeroConsultorio) {
                consultorios.remove(consultorioActual);
            }
        }
    }    

    /**
     * Obtiene el numero de un consultorio de la lista de consultorios
     *
     * @param numero La posicion del consultorio en el vector
     * @return El numero del consultorio (int)
     */
    public int getNumeroConsultorio(int numero) {
        return consultorios.get(numero).getNumeroConsultorio();
    }

    /**
     * Obtiene el especialista asociado de un consultorio de la lista de consultorios
     *
     * @param numero La posicion del consultorio en el vector
     * @return El nombre del especialista asociado  del consultorio (String)
     */
    public String getEspecialistaAsociadoConsultorio(int numero) {
        return consultorios.get(numero).getNombre();
    }

    /**
     * Obtiene la cantidad de consultorios
     *
     * @return El numero de consultorios del vector de consultorios (int)
     */
    public int getCantidadConsultorios() {
        return consultorios.size();
    }  
    
    /**
     * Efectua cambios en los objetos de otras clases dependientes o relacionados con la clase Consultorio
     * @param nombreEspecialista El nombre del Especialista del consultorio que sufrió una alteracion
     */
    public void alteracionEnConsultorio(String nombreEspecialista){
        String numeroConsultorio = buscarNumeroConsultorio(nombreEspecialista);
        
        if(numeroConsultorio != "EMPTY"){
            //ELIMINACION EN CITAS
//            for (Cita citaActual : citas) {
//                if (citaActual.getConsultorio() == numeroConsultorio) {
//                    citaActual.setNumeroConsultorio("NO ASIGNADO");
//                }
//            }        
        }
    }
    
    /**
     * Busca el nombre de un especialista
     * @param nombreEspecialista El nombre del especialista del que se quiere obtener el numero de Consultorio (int)
     * @return El nombre del especialista (String)
     */
    public String buscarNumeroConsultorio(String nombreEspecialista){
        String numeroConsultorio = "EMPTY";
        
        for (Consultorio consultorioActual : consultorios) {
            if (consultorioActual.getNombre() == nombreEspecialista) {
                numeroConsultorio = Integer.toString(consultorioActual.getNumeroConsultorio());
                break;
            }
        }
        
        return numeroConsultorio;
    }
    
    /**
     * Verifica si hay algun consultorio asignado al especialista
     * @param nombre El nombre completo del especialista (String)
     * @return True, si existe un consultorio para ese especialista; False, si no 
     */
    public boolean hayConsultorioParaEspecialista(String nombre){
        boolean resultado = false;
        for (Consultorio consultorioActual : consultorios) {
            if (consultorioActual.getNombre() == nombre) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }
    
    /**
     * Obtiene el numero del consultorio asignado a un especialista (El primer consultorio que encuentra)
     * @param nombre El nombre completo del especialista (String)
     * @return El numero del consultorio (int)
     */
    public int consultorioEspecialista(String nombre){
        int resultado = 0;
        for (Consultorio consultorioActual : consultorios) {
            if (consultorioActual.getNombre() == nombre) {
                resultado = consultorioActual.getNumeroConsultorio();
                break;
            }
        }
        return resultado;
    }
    
    /**
     * Verifica si existe un consultorio con cierto numero
     * @param id El numero del consultorio a comprobar (int)
     * @return True, si existe un consultorio con ese nombre; False, si no
     */
    public boolean existeConsultorioConId(int id){
        boolean resultado = false;
        for (Consultorio consultorioActual : consultorios) {
            if (consultorioActual.getNumeroConsultorio() == id) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }
    
    
    //              MANEJO DE CITAS             //
    /**
     * Añade una cita nueva a la lista
     * @param id El id de la cita (String)
     * @param dia El dia en el que se efectua la cita (String)
     * @param mes El mes en el que se efectua la cita (String)
     * @param anio El año en el que se efectua la cita (String)
     * @param horas La hora en la que se efectua la cita sin considerar minutos (String)
     * @param minutos Los minutos en el que se efectua la cita en la hora escogida (String)
     * @param afiliado El nombre completo del afiliado que participa en la cita (String)
     * @param especialista El nombre completo del servicio que participa en la cita (String)
     * @param servicio El nombre del servicio que se efectua en la cita (String)
     * @param consultorio El numero de consultorio donde se llevará a cabo la cita (String)
     */
    public void addCita(String id, String dia, String mes, String anio, String horas, String minutos, String afiliado, String especialista, String servicio, String consultorio) {
        citas.add(new Cita(id, dia, mes, anio, horas, minutos, afiliado, especialista, servicio, consultorio));        
    }
    
    /**
     * Modifica los datos de una cita de la lista
     * @param idActual El id que tiene la cita actualmente (String)
     * @param afiliadoActual El nombre completo del afiliado actual que participa en la cita (String)
     * @param especialistaActual El nombre completo especialista actual que participa en la cita (String)
     * @param nuevoID El NUEVO id quetiee la nueva  cita
     * @param dia El NUEVO dia en el que se efectua la cita (String)
     * @param mes El NUEVO mes en el que se efectua la cita (String)
     * @param anio El NUEVO año en el que se efectua la cita (String)
     * @param horas La NUEVA hora en la que se efectua la cita sin considerar minutos (String)
     * @param minutos Los NUEVOS minutos en el que se efectua la cita en la hora escogida (String)
     * @param afiliado El NUEVO nombre completo del afiliado que participa en la cita (String)
     * @param especialista El NUEVO nombre completo del servicio que participa en la cita (String)
     * @param servicio El NUEVO nombre del servicio que se efectua en la cita (String)
     * @param consultorio El NUEVO numero de consultorio donde se llevará a cabo la cita (String)
     */
    public void modCita(String idActual, String afiliadoActual, String especialistaActual, String nuevoID, String dia, String mes, String anio, String horas, String minutos, String afiliado, String especialista, String servicio, String consultorio) {
        // DESARROLLADOR
        //System.out.println("\nDATA: Id: " + id + " afiliado: " + afiliado + " especialista: " + especialista);
        
        for (Cita citaActual : citas) {
            
            // DESARROLLADOR
            // System.out.println("\nCITA: Id: " + citaActual.getId() + " Afiliado: " + citaActual.getAfiliado() + " Especialista: " + citaActual.getEspecialista());
            if (citaActual.getAfiliado() == afiliadoActual && citaActual.getEspecialista() == especialistaActual) {
                citaActual.setId(nuevoID);
                citaActual.setDia(dia);
                citaActual.setMes(mes);
                citaActual.setAnio(anio);
                citaActual.setHoras(horas);
                citaActual.setMinutos(minutos);
                citaActual.setAfiliado(afiliado);
                citaActual.setEspecialista(especialista);
                citaActual.setConsultorio(consultorio);
                citaActual.setServicio(servicio);    
            }
        }
    }

    /**
     * Elimina una cita de la lista
     * @param id El id de la cita (String)
     * @param afiliado El nombre completo del afiliado que participa en la cita (String)
     * @param especialista El nombre completo del servicio que participa en la cita (String)
     */
    public void delCita(String id, String afiliado, String especialista) {
        // DESARROLLADOR
        //System.out.println("\nDATA: Id: " + id + " afiliado: " + afiliado + " especialista: " + especialista);
        
        for (Cita citaActual : citas) {
            
            // DESARROLLADOR
            // System.out.println("\nCITA: Id: " + citaActual.getId() + " Afiliado: " + citaActual.getAfiliado() + " Especialista: " + citaActual.getEspecialista());            
            if (citaActual.getAfiliado() == afiliado && citaActual.getEspecialista() == especialista) {                
                citas.remove(citaActual);
            }
        }
    }    
    
    /**
     * Obtiene el Id de una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El Id de la cita en el arreglo (String)
     */ 
    public String getIdCita(int indice) {
        return citas.get(indice).getId();
    }
    
    /**
     * Obtiene el año de una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El Año de la cita en el arreglo (String)
     */
    public String getAnioCita(int indice) {
        return citas.get(indice).getAnio();
    }
    
    /**
     * Obtiene el Mes de una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El Mes de la cita en el arreglo (String)
     */
    public String getMesCita(int indice) {
        return citas.get(indice).getMes();
    }
    
    /**
     * Obtiene el dia de una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El dia de la cita en el arreglo (String)
     */
    public String getDiaCita(int indice) {
        return citas.get(indice).getDia();
    }
    
    /**
     * Obtiene las horas de una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return Las horas sin considerar minutos de la cita en el arreglo (String)
     */
    public String getHorasCita(int indice) {
        return citas.get(indice).getHoras();
    }
    
    /**
     * Obtiene los minutos de la hora de una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return Los minutos de la cita en el arreglo (String)
     */
    public String getMinutosCita(int indice) {
        return citas.get(indice).getMinutos();
    }

    /**
     * Obtiene el afiliado que participa en una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El afiliado de la cita en el arreglo (String)
     */
    public String getAfiliadoCita(int indice) {
        return citas.get(indice).getAfiliado();
    }

    /**
     * Obtiene el especialista que participa en una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El especialista de la cita en el arreglo (String)
     */
    public String getEspecialistaCita(int indice) {
        return citas.get(indice).getEspecialista();
    }

    /**
     * Obtiene el servicio ofrecido en una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El servicio de la cita en el arreglo (String)
     */
    public String getServicioCita(int indice) {
        return citas.get(indice).getServicio();
    }
    
     /**
     * Obtiene el numero de consultorio donde se llevara a cabo una cita en una posicion del arreglo
     * @param indice El indice o posicion de la cita en el arreglo (int)
     * @return El numero de consultorio de la cita en el arreglo (String)
     */
    public String getConsultorioCita(int indice) {
        return citas.get(indice).getConsultorio();
    }

    /**
     * Obtiene la cantidad de citas total registradas
     * @return El numero de citas en total (int)
     */
    public int getCantidadCitas() {
        return citas.size();
    }  
    
    //              MANEJO DE ARCHIVOS         //
    /**
     * Exporta el ID y nombre de cada afiliado en un archivo .txt separado por punto y coma
     */
    public void exportarAfiliados(){
        for (Afiliado afiliadoActual: afiliados){ 
            String Id;
            Id=Integer.toString(afiliadoActual.getId());
            try{
                FileWriter exportar = new FileWriter("src/archivosAfiliados/"+Id+".txt");
                BufferedWriter bw = new BufferedWriter(exportar);
                PrintWriter pw = new PrintWriter(bw);
                pw.print(Id);
                pw.println("; "+afiliadoActual.getNombre()+"\r\n");
                pw.close();
            }catch(Exception x){
                JOptionPane.showMessageDialog(null, "No se ha podido exportar");
            }
        }
        JOptionPane.showMessageDialog(null, "Se exportaron con éxito los datos");
    }
    
    /**
     * Realiza un backup de Afiliado, Cita, Consultorio, Especialista, Servicio
     */
    public void realizarBackup(){
        try{
            String fecha= fechaActual.format(date);
            int hora, minutos, segundos;
            hora =calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
            ObjectOutputStream backup = new ObjectOutputStream(new FileOutputStream("src/backup/"+fecha+"_"+hora+"-"+minutos+"-"+segundos+"backup.data"));
            backup.writeObject(afiliados);
            backup.writeObject(especialistas);
            backup.writeObject(consultorios);
            backup.writeObject(citas);
            backup.writeObject(servicios);
            backup.flush();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No hay archivos para exportar");
        }
    }
    
    /**
     * Restaura el backup de Afiliado, Cita, Consultorio, Especialista, Servicio
     */
    public void restaurarBackup(){
        // Abre la selección del usuario
        int seleccion =  selectorArchivos.showOpenDialog(contentPane); 
        //Si el usuario le da aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION){ 
           try {
            //Seleccionamos el arcchivo
            File archivo = selectorArchivos.getSelectedFile();
            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream(archivo));
            afiliados = (ArrayList) recuperar.readObject();
            especialistas = (ArrayList) recuperar.readObject();
            consultorios = (ArrayList) recuperar.readObject();
            citas = (ArrayList) recuperar.readObject();
            servicios = (ArrayList) recuperar.readObject();
            recuperar.close();
            
            }catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, "error 1");
            }catch(EOFException e){
                JOptionPane.showMessageDialog(null, "error 2");
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "error 3");
            }catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "error de gestor de archivos");
            } 
        }  
    }
}
