package hospital;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio #
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Cita.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Cita {
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

    public Cita(int id, int dia, int mes, int anio, int horas, int minutos, String afiliado, String especialista, String servicio, String consultorio) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.horas = horas;
        this.minutos = minutos;
        this.afiliado = afiliado;
        this.especialista = especialista;
        this.servicio = servicio;
        this.consultorio = consultorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(String afiliado) {
        this.afiliado = afiliado;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
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
}
