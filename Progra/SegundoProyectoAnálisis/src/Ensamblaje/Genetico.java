package Ensamblaje;
import Tarea.Tarea;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * Clase del Algoritmo dinamico
 * contiene las variables globales utilizadas para su solucion
 * y su debido constructor
 */
public class Genetico {
    Ensamblaje ensamblaje;
    ArrayList<Tarea> listaTareas;
    ArrayList<Tarea> listaPosiblesTareas = new ArrayList();
    int comp;
    int asig;
    int lin;

    public Genetico(Ensamblaje ensamblaje) {
        this.ensamblaje = ensamblaje;
        this.listaTareas = ensamblaje.getLineaEnsamblaje();
    }

    public void lineaEnsamblaje(){      
        
    }

    public void imprimirDatos(){
        System.out.println("Comparaciones: "+comp);
        System.out.println("Asignaciones: "+asig);
        System.out.println("Lineas de codigo: "+lin);
    }
}
