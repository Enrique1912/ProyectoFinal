package service;
import model.Pacient;

import java.util.ArrayList;
import java.util.List;


public class PacientService {

    private static PacientService instance;
    private ArrayList<Pacient> laLista;//Ojo, muy importante
    Pacient elPaciente;

    private PacientService()
    {
        laLista=new ArrayList<Pacient>();
    }


    public ArrayList<Pacient>getArray()
    {
        return laLista;
    }

    public static PacientService getSingletonInstance(){//Metodo del patron sigleton
        if (instance == null){
            instance = new PacientService();
        }
        else{
            System.out.println("Demostracion del Patron Singleton: No se puede crear el objeto porque ya existe");
        }

        return instance;
    }

    public Object[][] retornaEstCargados()
    {
        /**System.out.println("antes de ingresar nuevos datos");
        System.out.println(laLista.toString());
        Pacient a1=new Pacient("Enrique","Mata","Parajeles","117590577",85835867,"Heredia","Asma","Ninguna");
        laLista.add(a1);
        Pacient a2=new Pacient("Donald","Mata","Parajeles","40120959",70707070,"Alajuela","Asma","Ninguna");
        laLista.add(a2);
        Pacient a3=new Pacient("Maria","Mora","Arce","7855555",80808080,"Guanacaste","Gripe","Complicacion respiratoria");
        laLista.add(a3);
        System.out.println("DESPUES de ingresar nuevos datos");
        System.out.println(laLista.toString());*/
        ArrayList<Pacient> list=getArray();
        Object rowData[][]=new Object[laLista.size()][10];
        for(int i=0;i<list.size();i++){
            rowData[i][0]=list.get(i).getApellido1();
            rowData[i][1]=list.get(i).getApellido2();
            rowData[i][2]=list.get(i).getNombrePaciente();
            rowData[i][3]=list.get(i).getId();
            rowData[i][4]=list.get(i).getTelefono();
            rowData[i][5]=list.get(i).getDireccion();
            rowData[i][6]=list.get(i).getLaFecha();
            rowData[i][7]=list.get(i).getEnfermedadesAsociadas();
            rowData[i][8]=list.get(i).getObservaciones();
        }
        return rowData;
    }

    public void addPacient(String a,String b,String c,String id,int d,String e,String g,String h,String i){
        elPaciente=new Pacient(a,b,c,id,d,e,g,h,i);
        laLista.add(elPaciente);
        System.out.println(laLista.toString());
    }

    public void eliminarPaciente (String identi){
        List<Pacient> toRemove = new ArrayList<Pacient>();
        if (!identi.trim().isEmpty()){
            for (Pacient e:laLista){
                if (e.getId().equals(identi)){
                    toRemove.add( e );
                }
            }
            laLista.removeAll( toRemove );
        }
    }

    public Pacient buscarPaciente(String identi){
        Pacient elPaciente=new Pacient();
        if (!identi.trim().isEmpty()){
            for (Pacient e:laLista){
                if (e.getId().equals(identi)){
                    elPaciente=e;
                }
            }
        }
        return elPaciente;
    }

    public boolean confirmaPaciente(String identi){
        if (!identi.trim().isEmpty()){
            for (Pacient e:laLista){
                if ((e.getId().equals(identi))){
                    return true;
                }
            }

        }else{
            return false;
        }
        return false;
    }

    public void eliminaUnElemento(Pacient x){
        laLista.remove(x);
    }

}
