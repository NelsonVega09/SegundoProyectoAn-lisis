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
        private Hijo prodigio;
               
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
                    crearHijos();
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
                ArrayList<Padre> padres = fitnessPadre(this.listaPadres);
                this.listaPadres = padres;
                Hijo hijo1 = crearHijo(padres.get(0),padres.get(1));
                Hijo hijo2 = crearHijo(padres.get(1),padres.get(2));
                Hijo hijo3 = crearHijo(padres.get(0),padres.get(2));
                hijo1.setNombre("Hijo1");
                hijo2.setNombre("Hijo2");
                hijo3.setNombre("Hijo3");
                this.listaHijos.add(hijo1);
                this.listaHijos.add(hijo2);
                this.listaHijos.add(hijo3);
                
                Hijo mejorHijo = fitnessHijo(listaHijos);
                mutacion(mejorHijo);
            }

        public Hijo crearHijo(Padre padre1n, Padre padre2n){
                Padre padre1 = new Padre(padre1n.getPadre(), padre1n.getNombre() );
                Padre padre2 = new Padre(padre2n.getPadre(), padre2n.getNombre() );
                ArrayList<String> usados = new ArrayList<>();
                ArrayList<Estacion> estacionesH = new ArrayList<>();
                for(Estacion estacion : padre1.getPadre()){
                        Estacion estacionN = new Estacion(estacion.getNombre(),ensamblaje.getTiempoCiclo());
                        estacionesH.add(estacionN);
                }
                Hijo hijo = new Hijo("",padre1.getNombre(),padre2.getNombre(),estacionesH);
                
                for(int i=0 ; i<padre1.getPadre().size() ; i++){
                        if(padre1.getPadre().get(i).getTiempoSobrante() >= padre2.getPadre().get(i).getTiempoSobrante()){
                                for(String tarea : padre1.getPadre().get(i).getTareas()){
                                        if(!usados.contains(ensamblaje.getTarea(tarea))){
                                                hijo.getHijo().get(i).getTareas().add(tarea);
                                                hijo.getHijo().get(i).setTiempoSobrante(hijo.getHijo().get(i).getTiempoSobrante() - ensamblaje.getTarea(tarea).getTiempo());
                                        }
                                }
                        }else{
                                for(String tarea : padre2.getPadre().get(i).getTareas()){
                                        if(!usados.contains(ensamblaje.getTarea(tarea))){
                                                hijo.getHijo().get(i).getTareas().add(tarea);
                                                hijo.getHijo().get(i).setTiempoSobrante(hijo.getHijo().get(i).getTiempoSobrante() - ensamblaje.getTarea(tarea).getTiempo());
                                        }
                                } 
                        }
                }
                return hijo;                
        }
        
        public void mutacion(Hijo hijo){
                listaTareas.clear();
                listaPosiblesTareas.clear();
                for(Tarea x : ensamblaje.getLineaEnsamblaje())
                        listaTareas.add(x);
                    
                ArrayList<Estacion> estacionesH = new ArrayList<>();
                for(Estacion estacion : hijo.getHijo()){
                        Estacion estacionN = new Estacion(estacion.getNombre(),ensamblaje.getTiempoCiclo());
                        estacionesH.add(estacionN);
                }
                
                buscarPosiblesMutantes();
                Hijo hijoMutado = new Hijo(hijo.getNombre(),hijo.getNombreP1(),hijo.getNombreP2(),estacionesH);                
                ArrayList<String> usados = new ArrayList<>();
                for(Estacion estacionM : hijoMutado.getHijo()){
                        for(Estacion estacionN : hijo.getHijo()){
                                for(String tarea : estacionN.getTareas()){
                                        if((!usados.contains(tarea))&&(estacionM.getTiempoSobrante() >= ensamblaje.getTarea(tarea).getTiempo())&&(listaPosiblesTareas.contains(ensamblaje.getTarea(tarea)))){
                                                usados.add(tarea);
                                                estacionM.getTareas().add(tarea);
                                                estacionM.setTiempoSobrante(estacionM.getTiempoSobrante() - ensamblaje.getTarea(tarea).getTiempo());
                                                ensamblaje.getTarea(tarea).setIsMutado(true);
                                                buscarPosiblesMutantes();
                                        }
                                }
                        }
                }
                ArrayList<Integer> estacionesV = new ArrayList<>();
                int x=0;
                for(Estacion estacion : hijoMutado.getHijo()){
                        if(estacion.getTareas().isEmpty())
                                estacionesV.add(x);
                        x++;
                }
                for(Integer z : estacionesV){
                        hijoMutado.getHijo().remove(z);
                }
                this.prodigio = hijoMutado;
        }
        
        public Hijo crearHijo2(Padre padre1n, Padre padre2n){
                Padre padre1 = new Padre(padre1n.getPadre(), padre1n.getNombre() );
                Padre padre2 = new Padre(padre2n.getPadre(), padre2n.getNombre() );
                ArrayList<String> usados = new ArrayList<>();
                for(int e = 0; e < padre1.getPadre().size(); e++){
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
        
        public ArrayList<Padre> fitnessPadre(ArrayList<Padre> padres){
                for(Padre padre : padres){
                        padre.sobranteT();
                }
                padres.sort(Comparator.comparing(Padre::getSobrante));
                ArrayList<Padre> nuevosP = new ArrayList<>();
                nuevosP.add(padres.get(0));
                nuevosP.add(padres.get(1));
                nuevosP.add(padres.get(2));
                return nuevosP;
        }
        
        public Hijo fitnessHijo(ArrayList<Hijo> hijos){
                for(Hijo hijo : hijos){
                        hijo.sobranteT();
                }
                hijos.sort(Comparator.comparing(Hijo::getSobrante));
                return hijos.get(0);
        }
        
        public boolean precedentesUsadosM(Tarea tarea) {
                for (int i = 0; i < tarea.getPrecedentes().size(); i++) {
                        if (!ensamblaje.getTarea(tarea.getPrecedentes().get(i)).isIsMutado()) {
                                return false;
                        }
                }
                return true;
        }

        public void buscarPosiblesMutantes() {
                for (int i = 0; i < listaTareas.size(); i++) {
                        if ((precedentesUsados(listaTareas.get(i)))
                                && (!listaTareas.get(i).isIsMutado())
                                && (!listaPosiblesTareas.contains(listaTareas.get(i)))) {
                                
                                listaPosiblesTareas.add(listaTareas.get(i));
                        }
                }
        }
        
        public void imprimirProdigio(){
                System.out.println("-----------------------------------------------  Genético  -----------------------------------------------");
                for(Estacion estacion : this.prodigio.getHijo()){
                        System.out.println("*********************   "+estacion.getNombre() +"   *********************   Tiempo "+estacion.getTiempoSobrante()+"   *********************");
                        String tareas = "";
                        for(String nombre : estacion.getTareas()){
                                tareas += nombre+" ";
                        }
                        System.out.println(tareas);
                }
        }
}
