package hospital;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 3
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  BDManager.java
 *    Licencia: GNU-GPL 
 *    @version  1.4
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
     * Declara el servicio de un especialista como NO ENCONTRADO
     *
     * @param id El numero del documento de identificacion actual del
     * especialista que se va a modificar (int)
     */
    public void serEliminadoEspecialista(int id) {
        for (Especialista especialistaActual : especialistas) {
            if (especialistaActual.getId() == id) {
                especialistaActual.setNombreServicio("NO ENCONTRADO");
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
                    consultorioActual.setNombre("NO ENCONTRADO");
                    
                }
            }

            //ELIMINACION EN CITAS
//            for (Cita citaActual : citas) {
//                if (citaActual.getEspecialista() == nombreEspecialista) {
//                    citaActual.setEspecialista("NO ENCONTRADO");
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
                    especialistaActual.setNombreServicio("NO ENCONTRADO");
                }
            } 
            
            //ELIMINACION EN CITAS
//            for (Cita citaActual : citas) {
//                if (citaActual.getEspecialista() == nombreEspecialista) {
//                    alteracionEnCita(citaActual.getID())
//                    citaActual.setEspecialista("NO ENCONTRADO");
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
//                    citaActual.setNumeroConsultorio("NO ENCONTRADO");
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
    

    //              MANEJO DE ARCHIVOS         //
    /**
     * Exporta el ID y nombre de cada afiliado en un archivo .txt separado por punto y coma
     */
    public void exportarAfiliados(){
        for (Afiliado afiliadoActual: afiliados){ 
            String Id;
            Id=Integer.toString(afiliadoActual.getId());
            try{
                FileWriter exportar = new FileWriter("src/backup/"+Id+".txt");
                BufferedWriter bw = new BufferedWriter(exportar);
                PrintWriter pw = new PrintWriter(bw);
                pw.print(Id);
                pw.println("; "+afiliadoActual.getNombre()+"\r\n");
                pw.close();
                JOptionPane.showMessageDialog(null, "Se exportaron con éxito los datos");
            }catch(Exception x){
                JOptionPane.showMessageDialog(null, "No se ha podido exportar");
            }
            
        }
    }
    
    public void realizarBackup(){
        JOptionPane.showMessageDialog(null, "Aqui se realiza un backup");
    }
    
    public void restaurarBackup(){
        JOptionPane.showMessageDialog(null, "Aqui se restaura un backup");
    }
}
