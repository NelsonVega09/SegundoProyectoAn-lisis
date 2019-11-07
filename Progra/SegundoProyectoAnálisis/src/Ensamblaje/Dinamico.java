
package Ensamblaje;

import Tarea.Tarea;
import java.util.ArrayList;


public class Dinamico {
        
        
        public void lineaEnsamblajeDinamica(Ensamblaje ensamblaje){
                int estacion = 1;
                int tiempo = ensamblaje.getTiempoCiclo();
                ArrayList<Tarea> linea = ensamblaje.getLineaEnsamblaje();
                
                for(int i=0 ; i<linea.size() ; i++){
                        if(tiempo >= linea.get(i).getTiempo()){
                                
                        }
                }
        }
        
}
