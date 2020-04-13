package model;

//import java.util.Calendar;
public class Consultorio {
    private String nombreConsultorio;
    private String laFecha;
    private Hora horaInicioAtencion;
    private String minutoAtencion;
    private int telefonoContactos;
    private Hora horaFinalizacionAtencion;

    public Consultorio(){
        this.nombreConsultorio="Sin definir";
        this.laFecha=null;
        this.horaInicioAtencion=null;
        this.horaFinalizacionAtencion=null;
        this.minutoAtencion="Sin definir";
        this.telefonoContactos=0;
    }

    public Consultorio(String a,String b,Hora c,Hora c1,String d,int e){
        this.nombreConsultorio=a;
        this.laFecha=b;
        this.horaInicioAtencion=c;
        this.horaFinalizacionAtencion=c1;
        this.minutoAtencion=d;
        this.telefonoContactos=e;
    }
    /**-----------------------Inician metodos gets------------------*/
    public String getNombreConsultorio(){return nombreConsultorio;}
    public String getLaFecha(){return laFecha;}
   // public String getLaFecha(){return laFecha.toString();}
    public Hora getHoraInicioAtencion(){return horaInicioAtencion;}
    public Hora getHoraFinalizacionAtencion(){return horaFinalizacionAtencion;}
    public String getMinutoAtencion(){return minutoAtencion;}
    public int getTelefonoContactos(){return telefonoContactos;}
    /**----------------------Inician metodos sets-----------------*/
    void setNombreConsultorio(String x){nombreConsultorio=x;}
    void setLaFecha(String x){laFecha=x;}
    void setHoraInicioAtencion(Hora x){horaInicioAtencion=x;}
    void setHoraFinalizacionAtencion(Hora x){horaFinalizacionAtencion=x;}
    void setMinutoAtencion(String x){minutoAtencion=x;}
    void setTelefonoContactos(int x){telefonoContactos=x;}
    /**------------------toString------------------------------*/
    @Override
    public String toString() {
        return "Consultorio{" +
                "nombreConsultorio='" + nombreConsultorio + '\'' +
                ", laFecha=" + laFecha.toString() +
                ", horaInicio=" + horaInicioAtencion +
                ", horaFinalizacion=" + horaFinalizacionAtencion +
                ", minutoAtencion=" + minutoAtencion +
                ", telefonoContactos=" + telefonoContactos +
                '}';
    }

}
