package model;

public class Hora {

    String hora;
    String minutos;

    public Hora(String a,String b){
        hora=a;
        minutos=b;
    }

    public Hora(){
        hora="";
        minutos="";
    }

    public String getHora(){
        return hora;
    }

    public String getMinutos(){
        return minutos;
    }

    public void setHora(String a){
        hora=a;
    }

    public void setMinutos(String b){
        minutos=b;
    }

    @Override
    public String toString() {
        return  hora + " : " +
                minutos;
    }

}
