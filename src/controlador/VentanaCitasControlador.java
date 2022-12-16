package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaCitasControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
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
import java.util.ConcurrentModificationException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.*;
import vista.*;

public class VentanaCitasControlador {

    VentanaCitasModelo modelo;
    VentanaCitasVista vista;
    
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
    
    private int selectedRow;
    private int selectedID;
    
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
        vista.addEspecialistaListener(oyenteEspecialista);
        vista.addVolverListener(oyenteVolver);
        vista.addTableListener(oyenteFila);

        cargarMeses();
        cargarDias();
        cargarAnios();
        
        cargarHora();
        cargarMinutos();
        
        
        cargarServicios();
        cargarEspecialistas();
        cargarAfiliados();
        
        vista.setGuiaModificar();
    }
    
    public void cargarMeses(){
        for(int i = 0; i < 13; i++){
            vista.addMes(Integer.toString(i));
        }
    }
    
    public void cargarDias(){
        for(int i = 0; i < 32; i++){
            vista.addDia(Integer.toString(i));
        }
    }
    
    public void cargarAnios(){
        for(int i = 2022; i < 2035; i++){
            vista.addAnio(Integer.toString(i));
        }
    }
    
    public void cargarHora(){
        for(int i = 0; i < 24; i++){
            vista.addHoras(Integer.toString(i));
        }
    }
    
    public void cargarMinutos(){
        vista.addMinutos(Integer.toString(00));
        for(int i = 15; i < 60; i+=15){
            vista.addMinutos(Integer.toString(i));
        }
    }
    
    /**
     * Llena la tabla con todos los especialistas almacenados en el modelo
     */
    public void cargarServicios() {        
        for (int i = 0; i < modelo.getCantidadServiciosRegistrados(); i++) {
            vista.addServicio(modelo.getServicioRegistrado(i));
        }
    }
    
    /**
     * Llena la tabla con todos los especialistas almacenados en el modelo
     */
    public void cargarEspecialistas() {        
        for (int i = 0; i < modelo.getCantidadEspecialistasRegistrados(); i++) {
            vista.addEspecialista(modelo.getEspecialistaRegistrado(i));
        }
    }
    
    /**
     * Llena la tabla con todos los especialistas almacenados en el modelo
     */
    public void cargarAfiliados() {        
        for (int i = 0; i < modelo.getCantidadAfiliadosRegistrados(); i++) {
            vista.addAfiliado(modelo.getAfiliadoRegistrado(i));
        }
    }

    /**
     * Instancia una VentanaPrincipal
     */
    public void volverAlMenu() {
        VentanaPrincipalVista vpv = new VentanaPrincipalVista();
        VentanaPrincipalModelo vpm = new VentanaPrincipalModelo(modelo.getBDManager());
        VentanaPrincipalControlador vpc = new VentanaPrincipalControlador(vpm, vpv);
        vista.cerrar();
    }

    /**
     * Habilita y deshabilita elementos en la interfaz para REGISTRAR NUEVOS
     * AFILIADOS
     */
    public void modoRegistrar() {
        vista.setGuiaModificar();
        vista.deshabilitarLimpiar();
        vista.deshabilitarModificar();
        vista.deshabilitarEliminar();
        vista.habilitarAgregar();
    }

    /**
     * Habilita y deshabilita elementos en la interfaz para HACER MODIFICACIONES
     * EN AFILIADOS EXISTENTES (Modificar datos y eliminar)
     */
    public void modoModificar() {
        vista.setGuiaRegistrar();
        vista.deshabilitarAgregar();
        vista.habilitarModificar();
        vista.habilitarEliminar();
        vista.habilitarLimpiar();
    }
    
        //              LISTENERS               //
    /**
     * Registra un nuevo afiliado
     */
    ActionListener oyenteAgregar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                dia = Integer.parseInt(vista.getDia());
                mes = Integer.parseInt(vista.getMes());
                anio = Integer.parseInt(vista.getAnio());
                horas = Integer.parseInt(vista.getHoras());
                minutos = Integer.parseInt(vista.getMinutos());
                especialista = vista.getEspecialista();
                servicio = vista.getServicio();
                afiliado = vista.getAfiliado();
                Integer.parseInt(vista.getConsultorio()); // Prueba si ya se asignó un consultorio
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
                
                JOptionPane.showMessageDialog(null, "Opcion en desarrollo...");
            } catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Error: Puede que usted no haya registrado al menos un: Servicio, Especialista o Afiliado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Este especialista aún no tiene un consultorio asignado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    /**
     * Modifica un afiliado seleccionado que ya debe existir
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

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
     * Limpia los campos de texto y vuelve al modo de registrar
     */
    ActionListener oyenteLimpiar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            modoRegistrar();
        }
    };

    /**
     * Llama a la función eliminarAfiliado atrapando una excepción
     *
     * @see eliminarAfiliado
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

        }
    };
    
    /**
     * Llama a la función eliminarAfiliado atrapando una excepción
     *
     * @see eliminarAfiliado
     */
    ActionListener oyenteEspecialista = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            JComboBox box = (JComboBox) evt.getSource();
            String especialistaSeleccionado = box.getSelectedItem().toString();
            if(modelo.hayConsultorioParaEspecialista(especialistaSeleccionado)){
                String consultorioSeleccionado = modelo.consultorioEspecialista(especialistaSeleccionado);
                vista.setConsultorio(consultorioSeleccionado);
            }
            else vista.setConsultorio("-");
        }
    };

    /**
     * Gestiona los clics en las filas de Especialistas
     */
    MouseListener oyenteFila = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table = (JTable) Mouse_evt.getSource();
            selectedRow = table.getSelectedRow();
            try {
                selectedID = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: No se debe modificar directamente la tabla, guardando datos y redirigiendo...", "Error crítico", JOptionPane.ERROR_MESSAGE);
                volverAlMenu();
            }
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
                vista.setConsultorio(especialista);        
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
