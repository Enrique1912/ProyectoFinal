package model;

public class Pacient {

    String nombrePaciente;
    String apellido1;
    String apellido2;
    String id;
    int telefono;
    String direccion;
    String enfermedadesAsociadas;
    String observaciones;
    String laFecha;

    public Pacient(){
        this.nombrePaciente="";
        this.apellido1="Sin definir";
        this.apellido2="Sin definir";
        this.id="Sin definir";
        this.telefono=0;
        this.direccion="Sin definir";
        this.enfermedadesAsociadas="Sin definir";
        this.observaciones="Sin definir";
        this.laFecha="Sin definir";
    }
    public Pacient(String a,String b,String c,String id,int d,String e,String g,String h,String i){
        this.nombrePaciente=a;
        this.apellido1=b;
        this.apellido2=c;
        this.id=id;
        this.telefono=d;
        this.direccion=e;
        this.enfermedadesAsociadas=g;
        this.observaciones=h;
        this.laFecha=i;
    }


    /**Inicio de los get */
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    public String getApellido1() {
        return apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public String getId(){return id;}
    public int getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getLaFecha() {
        return laFecha;
    }
    public String getEnfermedadesAsociadas() {
        return enfermedadesAsociadas;
    }
    public String getObservaciones() {
        return observaciones;
    }
    /**Inicio de los Sets*/
    public void setNombrePaciente(String a) {
        this.nombrePaciente = a;
    }
    public void setApellido1(String b) {
        this.apellido1 = b;
    }
    public void setApellido2(String c) {
        this.apellido2 = c;
    }
    public void setId(String id){this.id=id;}
    public void setTelefono(int d) {
        this.telefono = d;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setLaFecha(String laFecha) {
        this.laFecha = laFecha;
    }
    public void setEnfermedadesAsociadas(String enfermedadesAsociadas) {
        this.enfermedadesAsociadas = enfermedadesAsociadas;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    /**Metodo toString*/
    @Override
    public String toString() {
        return "Paciente{" +
                "nombrePaciente='" + nombrePaciente + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                "i,d='" + id + '\'' +
                ", telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", laFecha=" + laFecha +
                ", enfermedadesAsociadas='" + enfermedadesAsociadas + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}