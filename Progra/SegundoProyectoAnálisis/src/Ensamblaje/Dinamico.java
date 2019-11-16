package Ensamblaje;

import Tarea.Tarea;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import static segundoproyectoanálisis.SegundoProyectoAnálisis.asig;
import static segundoproyectoanálisis.SegundoProyectoAnálisis.comp;
import static segundoproyectoanálisis.SegundoProyectoAnálisis.mem;

/**
 * Clase del Algoritmo dinamico contiene las variables globales utilizadas para
 * su solucion y su debido constructor
 */
public class Dinamico {

    Ensamblaje ensamblaje;
    ArrayList<Tarea> listaTareas;
    ArrayList<Tarea> listaPosiblesTareas = new ArrayList();
    private int comparaciones = 0;
    private int asignaciones = 0;
    private int memoria = 0;
    
    public Dinamico(Ensamblaje ensamblaje) {
        this.ensamblaje = ensamblaje;
        this.listaTareas = ensamblaje.getLineaEnsamblaje();
    }

    public void lineaEnsamblaje() {
        comp = 2;
        mem = 0;
        asig = 1;
        buscarPosibles();
        for (int e = 0; e < ensamblaje.getEstaciones().size(); e++) {
            comp += 2;
            asig += 4;
            Estacion estacionT = ensamblaje.getEstaciones().get(e);
            int tiempo = ensamblaje.getTiempoCiclo();
            int i = 0;
            while (i < listaPosiblesTareas.size()) {
                comp += 2;
                if (tiempo >= listaPosiblesTareas.get(i).getTiempo()) {
                    asig += 6;
                    estacionT.setTarea(listaPosiblesTareas.get(i).getNombre());
                    tiempo -= listaPosiblesTareas.get(i).getTiempo();
                    listaPosiblesTareas.get(i).setIsEstacion(true);
                    listaPosiblesTareas.get(i).setEstacion(estacionT.getNombre());
                    listaPosiblesTareas.remove(i);
                    buscarPosibles();
                    i = 0;
                } else {
                    asig++;
                    i++;
                }
            }
            asig++;
            estacionT.setTiempoSobrante(tiempo);
        }
        eficiencia();
        this.asignaciones += asig;        
        this.comparaciones += comp;
        this.memoria += mem;
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
        asig++;
        comp++;
        for (int i = 0; i < listaTareas.size(); i++) {
            comp += 4;
            asig++;
            if ((precedentesUsados(listaTareas.get(i)))
                    && (!listaTareas.get(i).isIsEstacion())
                    && (!listaPosiblesTareas.contains(listaTareas.get(i)))) {
                asig++;
                listaPosiblesTareas.add(listaTareas.get(i));
            }
        }
        asig += 2;
        listaPosiblesTareas.sort(Comparator.comparing(Tarea::getTiempo));
        Collections.reverse(listaPosiblesTareas);
    }

    public void eficiencia() {
        float T = 0;
        float Nr = ensamblaje.getCantEstaciones();
        float C = ensamblaje.getTiempoCiclo();
        for (Tarea tarea : ensamblaje.getLineaEnsamblaje()) {
            T += tarea.getTiempo();
        }
        float eficiencia = ((float) (T / (Nr * C))) * 100;
        ensamblaje.setEficiencia(eficiencia);
    }
    
    public void imprimirDatos() {
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
    }
}
