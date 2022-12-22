package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaCitasControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.*;
import vista.*;

public class VentanaCitasControlador {

    VentanaCitasModelo modelo;
    VentanaCitasVista vista;
    
    private String dia;
    private String mes;
    private String anio;
    private String horas;
    private String minutos;
    private String afiliado;
    private String especialista;
    private String servicio;
    private String consultorio;
    
    private int selectedRow;
    
    public VentanaCitasControlador(VentanaCitasModelo modelo, VentanaCitasVista vista){
    
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);

        vista.addLimpiarListener(oyenteLimpiar);
        vista.addAgregarListener(oyenteAgregar);
        vista.addModificarListener(oyenteModificar);
        vista.addEliminarListener(oyenteEliminar);
        vista.addServicioListener(oyenteServicio);
        vista.addEspecialistaListener(oyenteEspecialista);
        vista.addVolverListener(oyenteVolver);
        vista.addTableListener(oyenteFila);

        cargarMeses();
        cargarDias();
        cargarAnios();
        
        cargarHora();
        cargarMinutos();

        cargarServicios();
        cargarAfiliados();
        
        cargarCitas();
        
        vista.setGuiaModificar();
    }
    
    
    //              ELEMENTOS EN INTERFAZ               //
    /**
     * Añade los distintos meses al JComboBox en la vista
     */
    public void cargarMeses(){
        for(int i = 1; i < 10; i++){
            vista.addMes("0" + Integer.toString(i));
        }
        for(int i = 10; i < 13; i++){
            vista.addMes(Integer.toString(i));
        }
    }
    
    /**
     * Añade los distintos dias al JComboBox en la vista
     */
    public void cargarDias(){
        for(int i = 1; i < 10; i++){
            vista.addDia("0" + Integer.toString(i));
        }
        for(int i = 10; i < 32; i++){
            vista.addDia(Integer.toString(i));
        }
    }
    
    /**
     * Añade los distintos años al JComboBox en la vista
     */
    public void cargarAnios(){
        for(int i = 2022; i < 2035; i++){
            vista.addAnio(Integer.toString(i));
        }
    }
    
    /**
     * Añade las distintos horas del dia al JComboBox en la vista
     */
    public void cargarHora(){
        
        for(int i = 1; i < 10; i++){
            vista.addHoras(0 + Integer.toString(i));
        }
        
        for(int i = 10; i < 24; i++){
            vista.addHoras(Integer.toString(i));
        }
    }
    
    /**
     * Añade los distintos minutos de una hora al JComboBox en la vista
     */
    public void cargarMinutos(){
        vista.addMinutos("00");
        for(int i = 15; i < 60; i+=15){
            vista.addMinutos(Integer.toString(i));
        }
    }
    
    /**
     * Añade los servicios disponibles al JComboBox en la vista
     */
    public void cargarServicios() {        
        for (int i = 0; i < modelo.getCantidadServiciosRegistrados(); i++) {
            vista.addServicio(modelo.getServicioRegistrado(i));
        }
    }
    
    /**
     * Llena la tabla con todos los afiliados almacenados en el modelo
     */
    public void cargarAfiliados() {        
        for (int i = 0; i < modelo.getCantidadAfiliadosRegistrados(); i++) {
            vista.addAfiliado(modelo.getAfiliadoRegistrado(i));
        }
    }
    
    /**
     * Carga todas las citas existentes del modelo al JTable en la vista
     */
    public void cargarCitas(){
        for (int i = 0; i < modelo.getCantidadCitas(); i++) {
            dia = modelo.getDia(i);
            mes = modelo.getMes(i);
            anio = modelo.getAnio(i);
            horas = modelo.getHoras(i);
            minutos  = modelo.getMinutos(i);
            afiliado  = modelo.getAfiliado(i);
            especialista  = modelo.getEspecialista(i);
            servicio  = modelo.getServicio(i);
            consultorio  = modelo.getConsultorio(i);
        
            vista.nuevaFilaCita(dia, mes, anio, horas, minutos, afiliado, especialista, servicio);
        }
    }

    
    //              MODOS DE OPERACION               //
    /**
     * Habilita y deshabilita elementos en la interfaz para REGISTRAR nuevas citas
     */
    public void modoRegistrar() {
        vista.setGuiaModificar();
        vista.deshabilitarLimpiar();
        vista.deshabilitarModificar();
        vista.deshabilitarEliminar();
        vista.habilitarAgregar();
    }

    /**
     * Habilita y deshabilita elementos en la interfaz para HACER MODIFICACIONES en citas EXISTENTES (Modificar y eliminar)
     */
    public void modoModificar() {
        vista.setGuiaRegistrar();
        vista.deshabilitarAgregar();
        vista.habilitarModificar();
        vista.habilitarEliminar();
        vista.habilitarLimpiar();
    }
    
    
    //              FUNCIONES VARIADAS              //    
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    public void volverAlMenu() {
        VentanaPrincipalVista vpv = new VentanaPrincipalVista();
        VentanaPrincipalModelo vpm = new VentanaPrincipalModelo(modelo.getBDManager());
        VentanaPrincipalControlador vpc = new VentanaPrincipalControlador(vpm, vpv);
        vista.cerrar();
    }
    
    /**
     * Carga todos los datos sobre una cita en la vista hacia variables locales y luego se los pasa al modelo
     */
    public void cargarDatosVistaAModelo() {
        dia = vista.getDia();
        mes = vista.getMes();
        anio = vista.getAnio();
        horas = vista.getHoras();
        minutos = vista.getMinutos();
        especialista = vista.getEspecialista();
        servicio = vista.getServicio();
        afiliado = vista.getAfiliado();
        consultorio = vista.getConsultorio();

        modelo.setDia(dia);
        modelo.setMes(mes);
        modelo.setAnio(anio);
        modelo.setHoras(horas);
        modelo.setMinutos(minutos);
        modelo.setEspecialista(especialista);
        modelo.setServicio(servicio);
        modelo.setAfiliado(afiliado);
        modelo.setConsultorio(consultorio);

        modelo.generarID();
        
        // DESARROLLADOR
//        System.out.println("\nDATOS CARGADOS AL MODELO");
//        System.out.println("Id generado: " + modelo.tomarNuevoId());
//        System.out.println("Especialista cargado: " + especialista);
//        System.out.println("Afiliado cargado: " + afiliado);
    }
    
    /**
     * Recarga partes de la interfaz interfaz y datos
     */
    public void reinicioLimpio() {
        vista.limpiarTabla();
        cargarCitas();
        modoRegistrar();
    }
    
    
    //              LISTENERS               //
    /**
     * Registra una nueva cita
     */
    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                
                cargarDatosVistaAModelo();
                
                if(consultorio != "-"){
                    
                    modelo.agregarCita();
                    vista.nuevaFilaCita(dia, mes, anio, horas, minutos, afiliado, especialista, servicio);
                }
                else JOptionPane.showMessageDialog(null, "Error: Este especialista aún no tiene un consultorio asignado. ", "Error", JOptionPane.ERROR_MESSAGE);
                
            } catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Error: Puede que usted no haya registrado al menos un: Servicio, Especialista o Afiliado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    /**
     * Modifica una cita existente
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                
                cargarDatosVistaAModelo();

                modelo.modificarCita(modelo.tomarNuevoId());
                
                reinicioLimpio();
                
            } catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Error: Puede que usted no haya registrado al menos un: Servicio, Especialista o Afiliado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Este especialista aún no tiene un consultorio asignado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    /**
     * Regresa al Menu Principal
     */
    ActionListener oyenteVolver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            volverAlMenu();
        }
    };

    /**
     * Redirige al metodo de reinicioLimpio
     */
    ActionListener oyenteLimpiar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            reinicioLimpio();
        }
    };

    /**
     * Ordena al modelo eliminar la cita seleccionada
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                
            modelo.eliminarCita();
            
            }  catch(ConcurrentModificationException e){
                modelo.eliminarCita();
            }            
            
            reinicioLimpio();
        }
    };
    
    /**
     * Carga solo los especialistas que cumplan con el servicio elegido
     */
    ActionListener oyenteServicio = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                vista.removerEspecialistasCargados();  
                
                JComboBox box = (JComboBox) evt.getSource();
                String servicioSeleccionado = box.getSelectedItem().toString();            
                
                if(modelo.hayEspecialistaParaServicio(servicioSeleccionado)){
                    java.util.List<String> especialistasServicio = new ArrayList();
                    especialistasServicio = modelo.especialistasPara(servicioSeleccionado);
                    for(String especialistaActual: especialistasServicio){
                        vista.addEspecialista(especialistaActual);
                    }
                }
                
            } catch(NullPointerException e) {
                System.out.println("Error de punteros en oyenteServicio");
            }
        } 
    };

    /**
     * Carga el consultorio del especialista (en caso de tener)
     */
    ActionListener oyenteEspecialista = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                
                vista.setConsultorio("-");   
                
                JComboBox box = (JComboBox) evt.getSource();
                String especialistaSeleccionado = box.getSelectedItem().toString();
                
                if(modelo.hayConsultorioParaEspecialista(especialistaSeleccionado)){
                    String consultorioSeleccionado = modelo.consultorioEspecialista(especialistaSeleccionado);
                    vista.setConsultorio(consultorioSeleccionado);
                }
                
            } catch(NullPointerException e) {
                // No hay problema
            }
        }
    };

    /**
     * Gestiona los clics en las filas de citas, cargando algunos en la vista y en el modelo
     */
    MouseListener oyenteFila = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt) {
            
            JTable table = (JTable) Mouse_evt.getSource();
            selectedRow = table.getSelectedRow();

            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            
            if (Mouse_evt.getClickCount() == 1) {
                int indiceServicio = 0;
                vista.setDia(table.getValueAt(table.getSelectedRow(), 0).toString());                
                vista.setMes(table.getValueAt(table.getSelectedRow(), 1).toString());                
                vista.setAnio(table.getValueAt(table.getSelectedRow(), 2).toString());   
                vista.setHoras(table.getValueAt(table.getSelectedRow(), 3).toString());                
                vista.setMinutos(table.getValueAt(table.getSelectedRow(), 4).toString());  
                vista.setAfiliado(table.getValueAt(table.getSelectedRow(), 5).toString());        
                vista.setEspecialista(table.getValueAt(table.getSelectedRow(), 6).toString());                
                vista.setServicio(table.getValueAt(table.getSelectedRow(), 7).toString());  
                especialista = table.getValueAt(table.getSelectedRow(), 6).toString();
                vista.setConsultorio(modelo.buscarNumeroConsultorioRegistrado(especialista)); 
                
                modelo.setAfiliadoActual(vista.getAfiliado());
                modelo.setEspecialistaActual(vista.getEspecialista());
                
                cargarDatosVistaAModelo();
                
                modoModificar();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
}
