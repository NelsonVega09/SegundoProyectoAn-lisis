package Ensamblaje;

import Tarea.Tarea;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * Clase del Algoritmo dinamico contiene las variables globales utilizadas para su solucion y su debido
 * constructor
 */
public class Genetico {
        private Ensamblaje ensamblaje;
        private ArrayList<Tarea> listaTareas = new ArrayList();
        private ArrayList<Estacion> listaEstaciones = new ArrayList<>();
        private ArrayList<Tarea> listaPosiblesTareas = new ArrayList();
        private ArrayList<Padre> listaPadres = new ArrayList();
        private ArrayList<Hijo> listaHijos = new ArrayList<>();
               
        int comp;
        int asig;
        int lin;

        public Genetico(Ensamblaje ensamblaje) {
                this.ensamblaje = ensamblaje;
                for(Tarea x : ensamblaje.getLineaEnsamblaje())
                        listaTareas.add(x);
                crearEstaciones(ensamblaje);
        }

        public void lineaEnsamblaje() {
                buscarPosibles();
                int estacionesS = listaEstaciones.size();
                for(Estacion estacion : listaEstaciones){
                        int ciclo = ensamblaje.getTiempoCiclo();
                        if(estacionesS == listaTareas.size()+1){
                                int x =(int)((Math.random())*(listaPosiblesTareas.size()));
                                estacion.getTareas().add(listaPosiblesTareas.get(x).getNombre());
                                estacion.setTiempoSobrante(ciclo-listaPosiblesTareas.get(x).getTiempo());
                                listaPosiblesTareas.get(x).setIsEstacion(true);
                                listaTareas.remove(listaPosiblesTareas.get(x));
                                listaPosiblesTareas.remove(x);
                                buscarPosibles();
                        }else{
                                int i = 0;
                                while(i < listaPosiblesTareas.size()){
                                        int x = (int)((Math.random())*(listaPosiblesTareas.size()));

                                        if(ciclo >=listaPosiblesTareas.get(x).getTiempo()){
                                                if(estacionesS == listaTareas.size()+1){
                                                        estacionesS++;
                                                        break;
                                                }
                                                estacion.setTarea(listaPosiblesTareas.get(x).getNombre());
                                                ciclo -= listaPosiblesTareas.get(x).getTiempo();
                                                listaPosiblesTareas.get(x).setIsEstacion(true);
                                                listaPosiblesTareas.get(x).setEstacion(estacion.getNombre());
                                                listaTareas.remove(listaPosiblesTareas.get(x));
                                                listaPosiblesTareas.remove(x);
                                                buscarPosibles();
                                                i = 0;
                                        }else{
                                                i++;
                                        }
                                }
                                estacion.setTiempoSobrante(ciclo);
                        }
                        estacionesS --;
                }
                
        }

        public boolean precedentesUsados(Tarea tarea) {
                comp++;
                asig++;
                for (int i = 0; i < tarea.getPrecedentes().size(); i++) {
                        asig++;
                        comp++;
                        if (!ensamblaje.getTarea(tarea.getPrecedentes().get(i)).isIsEstacion()) {
                                return false;
                        }
                }
                return true;
        }

        public void buscarPosibles() {
                for (int i = 0; i < listaTareas.size(); i++) {
                        if ((precedentesUsados(listaTareas.get(i)))
                                && (!listaTareas.get(i).isIsEstacion())
                                && (!listaPosiblesTareas.contains(listaTareas.get(i)))) {//------------------------------------
                                
                                listaPosiblesTareas.add(listaTareas.get(i));
                        }
                }
        }

        public void imprimirDatos() {
                System.out.println("Comparaciones: " + comp);
                System.out.println("Asignaciones: " + asig);
                System.out.println("Lineas de codigo: " + lin);
        }
        
        public void crearEstaciones(Ensamblaje ensamblaje){
                        int estac = (int)(ensamblaje.getLineaEnsamblaje().size() * 0.7);
                        for(int i=0; i < estac ; i++){
                                listaEstaciones.add(new Estacion("Estacion"+String.valueOf(i+1),ensamblaje.getTiempoCiclo()));
                        }
    }
            
        public void imprimirPadres(){
                    for(Padre x : listaPadres){
                            System.out.println("----------------------------------- "+x.getNombre()+" -----------------------------------\n");
                            for(int i=0 ; i<x.getPadre().size() ; i++){
                                    System.out.println("---------------- Nombre "+x.getPadre().get(i).getNombre()+
                                                                                                        " ----------------Tiempo Sobrante "+x.getPadre().get(i).getTiempoSobrante());
                                    String tareas = "";
                                    for(int e = 0; e < x.getPadre().get(i).getTareas().size() ; e++){
                                            tareas += x.getPadre().get(i).getTareas().get(e)+"  ";
                                    }
                                    System.out.println(tareas);
                            }
                    }
            }
          
        public void imprimirHijos(){
                    for(Hijo x : listaHijos){
                            System.out.println("----------------------------------- "+x.getNombre()+" -----------------------------------\n");
                            for(int i=0 ; i<x.getHijo().size() ; i++){
                                    System.out.println("---------------- Nombre "+x.getHijo().get(i).getNombre()+
                                                                                                        " ----------------Tiempo Sobrante "+x.getHijo().get(i).getTiempoSobrante());
                                    String tareas = "";
                                    for(int e = 0; e < x.getHijo().get(i).getTareas().size() ; e++){
                                            tareas += x.getHijo().get(i).getTareas().get(e)+"  ";
                                    }
                                    System.out.println(tareas);
                            }
                    }
            }
          
        public void crearPadres(){
                    for(int i=0 ; i < 5 ; i++){
                            limpiarListas();
                            lineaEnsamblaje();
                            Padre padre = new Padre(listaEstaciones,"Padre "+ (i+1));
                            listaPadres.add(padre);
                            
                    }
            }
           
        public void limpiarListas(){
                    listaTareas.clear();
                    for(Tarea x : ensamblaje.getLineaEnsamblaje())
                            x.setIsEstacion(false);
                    for(Tarea x : ensamblaje.getLineaEnsamblaje())
                        listaTareas.add(x);
                    listaEstaciones.clear();
                    listaPosiblesTareas.clear();
                    crearEstaciones(ensamblaje);
                    
            }
           
        public void crearHijos(){
                int [] padre1 = {1,2,3,4,0,3};
                int [] padre2 = {2,3,4,0,1,0};
                for(int i=0 ; i < 6 ; i++){
                        Hijo hijo = crearHijo(padre1[i],padre2[i]);
                        hijo.setNombre("Hijo"+(i+1));
                        listaHijos.add(hijo);
                }
            }
        
        
        public Hijo crearHijo(int padre1n, int padre2n){
                Padre padre1 = new Padre(listaPadres.get(padre1n).getPadre(), listaPadres.get(padre1n).getNombre() );
                Padre padre2 = new Padre(listaPadres.get(padre2n).getPadre(), listaPadres.get(padre2n).getNombre() );
                ArrayList<String> usados = new ArrayList<>();
                for(int e = 0; e < padre1.getPadre().size(); e++){
                        System.out.println(e);
                        
                        for(int t = 0; t < padre1.getPadre().get(e).getTareas().size(); t++){
                                if(usados.contains(padre1.getPadre().get(e).getTareas().get(t))){
                                        int tiempoSobrante = padre1.getPadre().get(e).getTiempoSobrante() + ensamblaje.getTarea(padre1.getPadre().get(e).getTareas().get(t)).getTiempo();
                                        padre1.getPadre().get(e).setTiempoSobrante(tiempoSobrante);
                                        padre1.getPadre().get(e).getTareas().remove(padre1.getPadre().get(e).getTareas().get(t));
                                }
                        }
                        
                        for(int t = 0; t < padre2.getPadre().get(e).getTareas().size(); t++){
                                if(usados.contains(padre2.getPadre().get(e).getTareas().get(t))){
                                        int tiempoSobrante = padre2.getPadre().get(e).getTiempoSobrante() + ensamblaje.getTarea(padre2.getPadre().get(e).getTareas().get(t)).getTiempo();
                                        padre2.getPadre().get(e).setTiempoSobrante(tiempoSobrante);
                                        padre2.getPadre().get(e).getTareas().remove(padre2.getPadre().get(e).getTareas().get(t));

                                }
                        }
                        
                        Estacion estacionT = new Estacion(padre1.getPadre().get(e).getNombre(),padre1.getPadre().get(e).getTiempoSobrante());
                        estacionT.setTareas(padre1.getPadre().get(e).getTareas());
                        if(padre1.getPadre().get(e).getTiempoSobrante()>padre2.getPadre().get(e).getTiempoSobrante()){
                                 estacionT = new Estacion(padre2.getPadre().get(e).getNombre(),padre2.getPadre().get(e).getTiempoSobrante());
                                estacionT.setTareas(padre2.getPadre().get(e).getTareas());
                        }
                        
                                padre1.getPadre().get(e).getTareas().clear();
                        for(int i = 0; i < estacionT.getTareas().size(); i++){
                                System.out.println("Estacion: "+ e  + "Tarea: " + estacionT.getTareas().get(i));
                                usados.add(estacionT.getTareas().get(i));
                                padre1.getPadre().get(e).getTareas().add(estacionT.getTareas().get(i));                                
                }
                        
                
                        
                }
                
                return new Hijo("",padre1.getNombre(),padre2.getNombre(),padre1.getPadre());                
        }
        
}
