package service;

import model.Cita;
import model.Consultorio;
import model.Hora;
import model.Pacient;

import java.util.ArrayList;
import java.util.List;


public class CitaService {

    private static CitaService instance; //Parte del patron Singleton
    private List<Cita> laLista;//Ojo, muy importante
    private Cita laCita;

    private CitaService()
    {
        laLista=new ArrayList<Cita>();
    } //Muy importante que este privado el constructor


    public List<Cita>getArray()
    {
        return laLista;
    }

    public static CitaService getSingletonInstance(){//Metodo del patron sigleton
        if (instance == null){
            instance = new CitaService();
        }
        else{
            System.out.println("Demostracion del Patron Singleton: No se puede crear el objeto porque ya existe");
        }

        return instance;
    }


    public Object[][] retornaEstCargados()
    {
        List<Cita> list=getArray();
        Object rowData[][]=new Object[laLista.size()][10];
        for(int i=0;i<list.size();i++){
           rowData[i][0]=list.get(i).getNombrePaciente().getId();
            rowData[i][1]=list.get(i).getElConsultorio().getNombreConsultorio();
            rowData[i][2]=list.get(i).getElConsultorio().getLaFecha();
            rowData[i][3]=list.get(i).getHoraInicio();
            rowData[i][4]=list.get(i).getHoraFinal();
            rowData[i][5]=list.get(i).getConfirmacion();

        }
        return rowData;
    }

    public void addCita(Pacient a, Consultorio b, Hora c, Hora id, String d){
        laCita=new Cita(a,b,c,id,d);
        laLista.add(laCita);
        System.out.println(laLista.toString());
    }

    public void eliminarCita (String identi,String fechaAtencion,Hora inicioCita,Hora finCita){
        if (!identi.trim().isEmpty() && !fechaAtencion.trim().isEmpty() && !inicioCita.getHora().trim().isEmpty() &&
                !inicioCita.getMinutos().trim().isEmpty() && !finCita.getHora().trim().isEmpty() &&
        !finCita.getMinutos().trim().isEmpty()){

            List<Cita> toRemove = new ArrayList<Cita>();
            for ( Cita e : laLista ) {
                if ( (e.getElConsultorio().getNombreConsultorio().equals(identi))/** && (e.getElConsultorio().getLaFecha().
                        equals(fechaAtencion))&& (e.getHoraInicio().getHora().equals(inicioCita.getHora())) && (e.getHoraFinal().getHora().
                 equals(finCita)) &&  (e.getHoraInicio().getMinutos().equals(inicioCita.getMinutos())) && (e.getHoraFinal().getMinutos().
                        equals(finCita.getMinutos()))*/) {
                    System.out.println("El elemento a BORRAR ES: " + e.toString());
                    toRemove.add( e );
                }
            }
            laLista.removeAll( toRemove );
            System.out.println("El la lista nueva corresponde a: " + laLista.toString());
        }
    }

    public Cita buscarCita(String identi,String fA,Hora laHoraIncial, Hora laFinalHora){
        Cita elConsultorio=new Cita();
        if (!identi.trim().isEmpty()){
            for (Cita e:laLista){
                if ((e.getElConsultorio().getNombreConsultorio().equals(identi)) && (e.getElConsultorio().getLaFecha().equals(fA)) &&
                        (e.getHoraInicio().getHora().equals(laHoraIncial.getHora())) && (e.getHoraFinal().getHora().equals(laFinalHora.getHora()))
                        && (e.getHoraInicio().getMinutos().equals(laHoraIncial.getMinutos())) && (e.getHoraFinal().getMinutos().equals(laFinalHora.getMinutos()))){
                    elConsultorio=e;
                }
            }
        }
        return elConsultorio;
    }

    public boolean buscarCitaX(String identi,String fA,Hora laHoraInicial,Hora laFinalHora){
        if (!identi.trim().isEmpty()){
            for (Cita e:laLista){
                if ((e.getElConsultorio().getNombreConsultorio().equals(identi)) && (e.getElConsultorio().getLaFecha().equals(fA)) &&
                 (e.getHoraInicio().getHora().equals(laHoraInicial.getHora())) && (e.getHoraFinal().getHora().equals(laFinalHora.getHora()))
                        && (e.getHoraInicio().getMinutos().equals(laHoraInicial.getMinutos())) && (e.getHoraFinal().getMinutos().equals(laFinalHora.getMinutos()))){
                    System.out.println("Se metio en el TRUE");
                    return true;
                }
            }
        }
        System.out.println("Se metio en el false");
        return false;
    }
    public Cita buscarCitaPorId(String identi){
        Cita elConsultorio=new Cita();
        if (!identi.trim().isEmpty()){
            for (Cita e:laLista){
                if ((e.getNombrePaciente().getId().equals(identi))){
                    elConsultorio=e;
                }
            }
        }
        return elConsultorio;
    }

    public boolean verificaCitaPorId(String identi){
        Cita elConsultorio=new Cita();
        if (!identi.trim().isEmpty()){
            for (Cita e:laLista){
                if ((e.getNombrePaciente().getId().equals(identi))){
                    System.out.println("El id analizado corresponde a: "+e.getNombrePaciente().getId());
                    return true;
                }
            }
        }
        return false;
    }

    public void eliminaUnElemento(Cita x){
        laLista.remove(x);
    }

}