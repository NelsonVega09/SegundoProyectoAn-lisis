
package Ensamblaje;

import Tarea.Tarea;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class Dinamico {
        Ensamblaje ensamblaje;
        ArrayList<Tarea> listaTareas;
        ArrayList<Tarea> listaPosiblesTareas = new ArrayList();
        
                
        public Dinamico(Ensamblaje ensamblaje) {
                this.ensamblaje = ensamblaje;
                 this.listaTareas = ensamblaje.getLineaEnsamblaje();
        }
        
        
        public void lineaEnsamblajeDinamica(){
                
                buscarPosibles();
        
                
                for(int e = 0 ; e < ensamblaje.getEstaciones().size() ; e++){
                        Estacion estacionT = ensamblaje.getEstaciones().get(e);
                        int tiempo = ensamblaje.getTiempoCiclo();
                        int i=0;        
                        while(i < listaPosiblesTareas.size()){       
                                if(tiempo >= listaPosiblesTareas.get(i).getTiempo()){
                                        estacionT.setTarea(listaPosiblesTareas.get(i).getNombre());
                                        tiempo -= listaPosiblesTareas.get(i).getTiempo();
                                        listaPosiblesTareas.get(i).setIsEstacion(true);
                                        listaPosiblesTareas.get(i).setEstacion(estacionT.getNombre());
                                        listaPosiblesTareas.remove(i);
                                        buscarPosibles();
                                        i=0;
                                }else{
                                        i++;
                                }
                                
                        }
                        
                        estacionT.setTiempoSobrante(tiempo);
                        
                }
        }
        
        public boolean precedentesUsados(Tarea tarea){
                for(int i=0 ; i < tarea.getPrecedentes().size() ; i++){
                        if(!ensamblaje.getTarea(tarea.getPrecedentes().get(i)).isIsEstacion())
                                return false;
                }                
                return true;
        }
        
        public void buscarPosibles(){
                
                for(int i=0 ; i < listaTareas.size() ; i++){
                        if((precedentesUsados(listaTareas.get(i))) 
                                        && (!listaTareas.get(i).isIsEstacion()) 
                                        && (!listaPosiblesTareas.contains(listaTareas.get(i)))){
                                listaPosiblesTareas.add(listaTareas.get(i));
                        }
                }
                
                listaPosiblesTareas.sort(Comparator.comparing(Tarea::getTiempo));
                Collections.reverse(listaPosiblesTareas);

        }
        
        
}
