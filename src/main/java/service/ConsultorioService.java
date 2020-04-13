package service;

import model.Consultorio;
import model.Hora;

import java.util.ArrayList;
import java.util.List;


public class ConsultorioService {

    private static ConsultorioService instance;
    private List<Consultorio> laLista;//Ojo, muy importante
    private Consultorio elConsultorio;

    private ConsultorioService()
    {

        laLista=new ArrayList<Consultorio>();

    }


    public List<Consultorio>getArray()
    {
        return laLista;
    }

    public static ConsultorioService getSingletonInstance(){//Metodo del patron sigleton
        if (instance == null){
            instance = new ConsultorioService();
        }
        else{
            System.out.println("Demostracion del Patron Singleton: No se puede crear el objeto porque ya existe");
        }

        return instance;
    }

   public Object[][] retornaEstCargados()
    {
        List<Consultorio> list=getArray();
        Object rowData[][]=new Object[laLista.size()][10];
        for(int i=0;i<list.size();i++){
            rowData[i][0]=list.get(i).getNombreConsultorio();
            rowData[i][1]=list.get(i).getLaFecha();
            rowData[i][2]=list.get(i).getHoraInicioAtencion().toString();
            rowData[i][3]=list.get(i).getHoraFinalizacionAtencion().toString();
            rowData[i][4]=list.get(i).getTelefonoContactos();

        }
        return rowData;
    }

    public void addConsultorio(String a, String b, Hora c,Hora c1, String id, int d){
        elConsultorio=new Consultorio(a,b,c,c1,id,d);
        laLista.add(elConsultorio);
        System.out.println(laLista.toString());
    }

    public void eliminarConsultorio (String identi,String fechaAtencion){
        if (!identi.trim().isEmpty()){

            List<Consultorio> toRemove = new ArrayList<Consultorio>();
            for ( Consultorio e : laLista ) {
                if ( (e.getNombreConsultorio().equals(identi)) && (e.getLaFecha().equals(fechaAtencion)) ) {
                    toRemove.add( e );
                }
            }
            laLista.removeAll( toRemove );
        }
    }

    public Consultorio buscarConsultorio(String identi,String fA){
        Consultorio elConsultorio=new Consultorio();
        if (!identi.trim().isEmpty()){
            for (Consultorio e:laLista){
                if ((e.getNombreConsultorio().equals(identi))&& (e.getLaFecha().equals(fA))){
                    elConsultorio=e;
                }
            }
        }
        return elConsultorio;
    }

    public boolean confirmaConsultorio(String identi,String fA){
        //Consultorio elConsultorio=new Consultorio();
        System.out.println("El nombre del consultorio INGRESADO ES: "+ identi);
        System.out.println("La fecha de atencion INGRESADA es: "+fA);
        if (!identi.trim().isEmpty()){
            for (Consultorio e:laLista){
                System.out.println("El nombre del consultorio INGRESADO ES: "+ e.getNombreConsultorio());
                System.out.println("La fecha de atencion INGRESADA es: "+e.getLaFecha());
                if ((e.getNombreConsultorio().equals(identi))&& (e.getLaFecha().equals(fA))){
                    System.out.println("SE METIO AL TRUE LINEA 91");
                    return true;
                }
            }

        }else{
            return false;
        }
        return false;
    }

    public void eliminaUnElemento(Consultorio x){
        laLista.remove(x);
    }

}