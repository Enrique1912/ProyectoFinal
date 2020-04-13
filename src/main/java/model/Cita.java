package model;

public class Cita {

    private Pacient nombrePaciente;
    private Consultorio elConsultorio;
    private Hora horaInicio;
    private Hora horaFinal;
    private String confirmacion;

    public Cita(Pacient a,Consultorio b, Hora c,Hora d,String e){
        nombrePaciente=a;
        elConsultorio=b;
        horaInicio=c;
        horaFinal=d;
        confirmacion=e;
    }

    public Cita(){
        nombrePaciente=null;
        elConsultorio=null;
        horaInicio=null;
        horaFinal=null;
        confirmacion="";
    }

    public Pacient getNombrePaciente(){
        return nombrePaciente;
    }

    public Consultorio getElConsultorio(){
        return elConsultorio;
    }

    public Hora getHoraInicio(){
        return horaInicio;
    }

    public Hora getHoraFinal(){
        return horaFinal;
    }

    public String getConfirmacion(){ return confirmacion;}

    public void setNombrePaciente(Pacient x){
        nombrePaciente=x;
    }

    public void setElConsultorio(Consultorio x){
        elConsultorio=x;
    }

    public void setHoraInicio(Hora x){
        horaInicio=x;
    }

    public void setHoraFinal(Hora x){
        horaFinal=x;
    }

    public void setConfirmacion(String x){
        confirmacion=x;
    }


    @Override
    public String toString() {
        return "Cita{" +
                "nombrePaciente='" + nombrePaciente + '\'' +
                ", elConsultorio=" + elConsultorio +
                ", horaInicio=" + horaInicio +
                ", horaFinal=" + horaFinal +
                ", confirmacion='" + confirmacion + '\'' +
                '}';
    }

}
