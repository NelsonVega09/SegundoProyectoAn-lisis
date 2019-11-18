package Genético;

import Ensamblaje.Ensamblaje;
import Ensamblaje.Estacion;
import Tarea.Tarea;
import java.util.ArrayList;
import java.util.Comparator;
import static segundoproyectoanálisis.SegundoProyectoAnálisis.asig;
import static segundoproyectoanálisis.SegundoProyectoAnálisis.comp;

/**
 * Clase del Algoritmo dinamico contiene las variables globales utilizadas para
 * su solucion y su debido constructor
 */
public class Genetico {

    private Ensamblaje ensamblaje;
    private ArrayList<Tarea> listaTareas = new ArrayList();
    private ArrayList<Estacion> listaEstaciones = new ArrayList<>();
    private ArrayList<Tarea> listaPosiblesTareas = new ArrayList();
    private ArrayList<Padre> listaPadres = new ArrayList();
    private ArrayList<Hijo> listaHijos = new ArrayList<>();
    private Hijo prodigio;
    private float eficiencia = 0;
    private int asignaciones = 0;
    private int comparaciones = 0;
    public long memoria = 0;

    public Genetico(Ensamblaje ensamblaje) {
        asig++;
        this.ensamblaje = ensamblaje;
        comp++;
        for (Tarea x : ensamblaje.getLineaEnsamblaje()) {
            asig += 2;
            comp++;
            listaTareas.add(x);
        }
        crearEstaciones(ensamblaje);
    }

    /**
     * Función que se encarga de realizar el balanceo de la linea de ensmablaje, 
     * esta es generada aleatoriamente para que cada padre sea diferente al anterior.
     */
    public void lineaEnsamblaje() {
        buscarPosibles();
        asig += 2;
        int estacionesS = listaEstaciones.size();
        for (Estacion estacion : listaEstaciones) {
            asig++;
            comp+=2;
            int ciclo = ensamblaje.getTiempoCiclo();
            if (estacionesS == listaTareas.size() + 1) {
                asig += 6;
                int x = (int) ((Math.random()) * (listaPosiblesTareas.size()));
                estacion.getTareas().add(listaPosiblesTareas.get(x).getNombre());
                estacion.setTiempoSobrante(ciclo - listaPosiblesTareas.get(x).getTiempo());
                listaPosiblesTareas.get(x).setIsEstacion(true);
                listaTareas.remove(listaPosiblesTareas.get(x));
                listaPosiblesTareas.remove(x);
                buscarPosibles();
            } else {
                asig++;
                comp++;
                int i = 0;
                while (i < listaPosiblesTareas.size()) {
                    comp += 2;
                    asig++;
                    int x = (int) ((Math.random()) * (listaPosiblesTareas.size()));
                    if (ciclo >= listaPosiblesTareas.get(x).getTiempo()) {
                        comp++;
                        if (estacionesS == listaTareas.size() + 1) {
                            asig++;
                            estacionesS++;
                            break;
                        }
                        asig += 7;
                        estacion.setTarea(listaPosiblesTareas.get(x).getNombre());
                        ciclo -= listaPosiblesTareas.get(x).getTiempo();
                        listaPosiblesTareas.get(x).setIsEstacion(true);
                        listaPosiblesTareas.get(x).setEstacion(estacion.getNombre());
                        listaTareas.remove(listaPosiblesTareas.get(x));
                        listaPosiblesTareas.remove(x);
                        buscarPosibles();
                        i = 0;
                    } else {
                        asig++;
                        i++;
                    }
                }
                asig++;
                estacion.setTiempoSobrante(ciclo);
            }
            asig++;
            estacionesS--;
        }

    }

    /**
     * Función que se encarga de devolver true si todos los presendente de una tarea 
     * se encuntra utilizado y false si falta aunque sea uno.
     */
    public boolean precedentesUsados(Tarea tarea) {
        comp++;
        asig++;
        for (int i = 0; i < tarea.getPrecedentes().size(); i++) {
            asig++;
            comp+=2;
            if (!ensamblaje.getTarea(tarea.getPrecedentes().get(i)).isIsEstacion()) {
                return false;
            }
        }
        return true;
    }

    
    /**
     * Función que se encarga de buscar las posibles tareas que se 
     * pueden utilizar para introducirlas en la estacion
     */
    public void buscarPosibles() {
        asig++;
        comp++;
        for (int i = 0; i < listaTareas.size(); i++) {
            comp += 4;
            asig++;
            if ((precedentesUsados(listaTareas.get(i)))
                    && (!listaTareas.get(i).isIsEstacion())
                    && (!listaPosiblesTareas.contains(listaTareas.get(i)))) {
                listaPosiblesTareas.add(listaTareas.get(i));
                asig++;
            }
        }
    }

    /**
     * Función que se encarga de generar las estaciones de una linea de ensamblaje,
     * cada linea de ensamblaje tiene distintas estaciones y estan se determinan a partir de una formula
     */
    public void crearEstaciones(Ensamblaje ensamblaje) {
        asig += 2;
        comp++;
        int estac = (int) (ensamblaje.getLineaEnsamblaje().size() * 0.7);
        for (int i = 0; i < estac; i++) {
            asig += 2;
            comp++;
            listaEstaciones.add(new Estacion("Estacion" + String.valueOf(i + 1), ensamblaje.getTiempoCiclo()));
        }
    }

    
    /**
     * Función que se encarga de imprimir los padres del algoritmo genético
     */
    public void imprimirPadres() {
        
        System.out.println("lista   " + listaPadres.size());
        for (Padre x : listaPadres) {
            System.out.println("----------------------------------- " + x.getNombre() + " -----------------------------------\n");
            for (int i = 0; i < x.getPadre().size(); i++) {
                System.out.println("---------------- Nombre " + x.getPadre().get(i).getNombre()
                        + " ----------------Tiempo Sobrante " + x.getPadre().get(i).getTiempoSobrante());
                String tareas = "";
                for (int e = 0; e < x.getPadre().get(i).getTareas().size(); e++) {
                    tareas += x.getPadre().get(i).getTareas().get(e) + "  ";
                }
                System.out.println(tareas);
            }
        }
    }

    
    /**
     * Función que se encarga de imprimir los hijos proveniente del cruce de los padres
     */
    public void imprimirHijos() {
        for (Hijo x : listaHijos) {
            System.out.println("----------------------------------- " + x.getNombre() + " -----------------------------------\n");
            for (int i = 0; i < x.getHijo().size(); i++) {
                System.out.println("---------------- Nombre " + x.getHijo().get(i).getNombre()
                        + " ----------------Tiempo Sobrante " + x.getHijo().get(i).getTiempoSobrante());
                String tareas = "";
                for (int e = 0; e < x.getHijo().get(i).getTareas().size(); e++) {
                    tareas += x.getHijo().get(i).getTareas().get(e) + "  ";
                }
                System.out.println(tareas);
            }
        }
    }

    
    /**
     * Función que se encarga de crear 5 padres llamando a LineaEnsamblaje y limpiando las listas
     */
    public void crearPadres() {
        comp=1;
        asig=1;
        limpiarListas();
        for (int i = 0; i < 5; i++) {
            asig += 3;
            comp++;
            limpiarListas();
            lineaEnsamblaje();
            Padre padre = new Padre(listaEstaciones, "Padre " + (i + 1));
            listaPadres.add(padre);
        }
        crearHijos();
    }

    
    /**
     * Función que se encarga de limpiar las listas
     */
    public void limpiarListas() {
        asig += 5;
        comp++;
        listaTareas.clear();
        for (Tarea x : ensamblaje.getLineaEnsamblaje()) {
            asig++;
            comp++;
            x.setIsEstacion(false);
        }
        for (Tarea x : ensamblaje.getLineaEnsamblaje()) {
            asig++;
            comp++;
            listaTareas.add(x);
        }
        listaEstaciones.clear();
        listaPosiblesTareas.clear();
        crearEstaciones(ensamblaje);
    }

    
    /**
     * Función que se encarga de crear los hijos a partir de los tres mejores padres
     */
    public void crearHijos() {
        asig += 12;
        ArrayList<Padre> padres = fitnessPadre(this.listaPadres);
        this.listaPadres = padres;
        Hijo hijo1 = crearHijo(padres.get(0), padres.get(1));
        Hijo hijo2 = crearHijo(padres.get(1), padres.get(2));
        Hijo hijo3 = crearHijo(padres.get(0), padres.get(2));
        hijo1.setNombre("Hijo1");
        hijo2.setNombre("Hijo2");
        hijo3.setNombre("Hijo3");
        this.listaHijos.add(hijo1);
        this.listaHijos.add(hijo2);
        this.listaHijos.add(hijo3);
        Hijo mejorHijo = fitnessHijo(listaHijos);
        mutacion(mejorHijo);
    }

    
    /**
     * Función que se encarga de crear un hijo a partir de dos padres
     */
    public Hijo crearHijo(Padre padre1n, Padre padre2n) {
        asig += 12;
        ArrayList<Estacion> esta1 = new ArrayList<>();
        ArrayList<Estacion> esta2 = new ArrayList<>();
        for (Estacion estacion : padre1n.getPadre()) {
            asig += 6;
            comp++;
            ArrayList<String> tareas = new ArrayList<>();
            tareas.addAll(estacion.getTareas());
            Estacion nueva = new Estacion(estacion.getNombre(), estacion.getTiempoSobrante());
            nueva.setTareas(tareas);
            esta1.add(nueva);
        }
        for (Estacion estacion : padre2n.getPadre()) {
            asig += 6;
            comp++;
            ArrayList<String> tareas = new ArrayList<>();
            tareas.addAll(estacion.getTareas());
            Estacion nueva = new Estacion(estacion.getNombre(), estacion.getTiempoSobrante());
            nueva.setTareas(tareas);
            esta2.add(nueva);
        }
        Padre padre1 = new Padre(esta1, padre1n.getNombre());
        Padre padre2 = new Padre(esta2, padre2n.getNombre());
        ArrayList<String> noUsadosTemp = new ArrayList<>();
        ArrayList<String> usados = new ArrayList<>();
        ArrayList<Estacion> estacionesH = new ArrayList<>();
        for (Estacion estacion : padre1.getPadre()) {
            asig += 2;
            comp++;
            Estacion estacionN = new Estacion(estacion.getNombre(), ensamblaje.getTiempoCiclo());
            estacionesH.add(estacionN);
        }
        Hijo hijo = new Hijo("", padre1.getNombre(), padre2.getNombre(), estacionesH);
        for (int i = 0; i < hijo.getHijo().size(); i++) {
            asig += 4;
            comp += 5;
            for (String tarea : noUsadosTemp) {
                asig++;
                comp+=2;
                if (hijo.getHijo().get(i).getTiempoSobrante() >= ensamblaje.getTarea(tarea).getTiempo()) {
                    asig += 3;
                    hijo.getHijo().get(i).getTareas().add(tarea);
                    hijo.getHijo().get(i).setTiempoSobrante(hijo.getHijo().get(i).getTiempoSobrante() - ensamblaje.getTarea(tarea).getTiempo());
                    usados.add(tarea);
                }
            }

            for (String tarea : usados) {
                asig++;
                comp += 2;
                if (noUsadosTemp.contains(tarea)) {
                    asig++;
                    noUsadosTemp.remove(tarea);
                }
            }

            for (int t = 0; t < padre1.getPadre().get(i).getTareas().size(); t++) {
                asig++;
                comp += 2;
                if (usados.contains(padre1.getPadre().get(i).getTareas().get(t))) {
                    asig += 3;
                    int tiempoSobrante = padre1.getPadre().get(i).getTiempoSobrante() + ensamblaje.getTarea(padre1.getPadre().get(i).getTareas().get(t)).getTiempo();
                    padre1.getPadre().get(i).setTiempoSobrante(tiempoSobrante);
                    padre1.getPadre().get(i).getTareas().remove(padre1.getPadre().get(i).getTareas().get(t));
                }
            }

            for (int t = 0; t < padre2.getPadre().get(i).getTareas().size(); t++) {
                asig++;
                comp += 2;
                if (usados.contains(padre2.getPadre().get(i).getTareas().get(t))) {
                    asig += 3;
                    int tiempoSobrante = padre2.getPadre().get(i).getTiempoSobrante() + ensamblaje.getTarea(padre2.getPadre().get(i).getTareas().get(t)).getTiempo();
                    padre2.getPadre().get(i).setTiempoSobrante(tiempoSobrante);
                    padre2.getPadre().get(i).getTareas().remove(padre2.getPadre().get(i).getTareas().get(t));
                }
            }
            if (padre1.getPadre().get(i).getTiempoSobrante() >= padre2.getPadre().get(i).getTiempoSobrante()) {
                asig += 2;
                comp += 2;
                for (String tarea : padre1.getPadre().get(i).getTareas()) {
                    comp += 2;
                    asig++;
                    if (!usados.contains(ensamblaje.getTarea(tarea))) {
                        asig += 3;
                        hijo.getHijo().get(i).getTareas().add(tarea);
                        hijo.getHijo().get(i).setTiempoSobrante(hijo.getHijo().get(i).getTiempoSobrante() - ensamblaje.getTarea(tarea).getTiempo());
                        usados.add(tarea);
                    }
                }
                for (String tarea : padre2.getPadre().get(i).getTareas()) {
                    asig++;
                    comp += 2;
                    if (!usados.contains(ensamblaje.getTarea(tarea))) {
                        asig++;
                        noUsadosTemp.add(tarea);
                    }
                }
            } else {
                comp += 2;
                asig += 2;
                for (String tarea : padre2.getPadre().get(i).getTareas()) {
                    comp += 2;
                    asig++;
                    if (!usados.contains(ensamblaje.getTarea(tarea))) {
                        asig += 3;
                        hijo.getHijo().get(i).getTareas().add(tarea);
                        hijo.getHijo().get(i).setTiempoSobrante(hijo.getHijo().get(i).getTiempoSobrante() - ensamblaje.getTarea(tarea).getTiempo());
                        usados.add(tarea);
                    }
                }
                for (String tarea : padre1.getPadre().get(i).getTareas()) {
                    comp += 2;
                    asig++;
                    if (!usados.contains(ensamblaje.getTarea(tarea))) {
                        asig++;
                        noUsadosTemp.add(tarea);
                    }
                }
            }
        }
        return hijo;
    }

    
    /**
     * Función que se encarga de mutar un hijo, los hijos tienen muchas estaciones con el proposito de 
     * aumentar la información genética y es por esto que la mutación se encarga de aliminar todas las estaciones
     * que se consideren innecesarias.
     */
    public void mutacion(Hijo hijo) {
        asig += 10;
        comp += 3;
        listaTareas.clear();
        listaPosiblesTareas.clear();
        for (Tarea x : ensamblaje.getLineaEnsamblaje()) {
            asig += 2;
            comp++;
            listaTareas.add(x);
        }

        ArrayList<Estacion> estacionesH = new ArrayList<>();
        for (Estacion estacion : hijo.getHijo()) {
            asig += 3;
            comp++;
            Estacion estacionN = new Estacion(estacion.getNombre(), ensamblaje.getTiempoCiclo());
            estacionesH.add(estacionN);
        }

        buscarPosiblesMutantes();
        Hijo hijoMutado = new Hijo(hijo.getNombre(), hijo.getNombreP1(), hijo.getNombreP2(), estacionesH);
        ArrayList<String> usados = new ArrayList<>();
        for (Estacion estacionM : hijoMutado.getHijo()) {
            asig += 2;
            comp++;
            for (Estacion estacionN : hijo.getHijo()) {
                asig += 2;
                comp++;
                for (String tarea : estacionN.getTareas()) {
                    asig++;
                    comp += 4;
                    if ((!usados.contains(tarea))
                            && (estacionM.getTiempoSobrante() >= ensamblaje.getTarea(tarea).getTiempo())
                            && (listaPosiblesTareas.contains(ensamblaje.getTarea(tarea)))) {
                        asig += 4;
                        usados.add(tarea);
                        estacionM.getTareas().add(tarea);
                        estacionM.setTiempoSobrante(estacionM.getTiempoSobrante() - ensamblaje.getTarea(tarea).getTiempo());
                        ensamblaje.getTarea(tarea).setIsMutado(true);
                        buscarPosiblesMutantes();
                    }
                }
            }
        }
        this.prodigio = hijoMutado;
        eficiencia();
        this.asignaciones += asig;
        this.comparaciones += comp;
    }

    /**
     * Función que se encarga de recibir una lista de padres y devolver los mejores 3 padres
     */
    public ArrayList<Padre> fitnessPadre(ArrayList<Padre> padres) {
        comp++;
        asig+=6;
        for (Padre padre : padres) {
            comp++;
            asig+=2;
            padre.sobranteT();
        }
        padres.sort(Comparator.comparing(Padre::getSobrante));
        ArrayList<Padre> nuevosP = new ArrayList<>();
        nuevosP.add(padres.get(0));
        nuevosP.add(padres.get(1));
        nuevosP.add(padres.get(2));
        return nuevosP;
    }

    
    /**
     * Función que se encarga de recibir una lista de hijos y retornar el mejor
     */
    public Hijo fitnessHijo(ArrayList<Hijo> hijos) {
        comp++;
        asig+=2;
        for (Hijo hijo : hijos) {
            comp++;
            asig+=2;
            hijo.sobranteT();
        }
        hijos.sort(Comparator.comparing(Hijo::getSobrante));
        return hijos.get(0);
    }

    
    /**
     * Función que se encarga de devolver true si todos los presendente de una tarea 
     * se encuntra utilizado y false si falta aunque sea uno. Esta funcion es unicamente utilizada para la mutación
     */
    public boolean precedentesUsadosM(Tarea tarea) {
        comp++;
        asig++;
        for (int i = 0; i < tarea.getPrecedentes().size(); i++) {
            comp+=2;
            asig++;
            if (!ensamblaje.getTarea(tarea.getPrecedentes().get(i)).isIsMutado()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Función que se encarga de buscar las posibles tareas que se 
     * pueden utilizar para introducirlas en la estacion. Esta funcion es unicamente utilizada para la mutación
     */
    public void buscarPosiblesMutantes() {
        comp++;
        asig++;
        for (int i = 0; i < listaTareas.size(); i++) {
            comp+=2;
            asig++;
            if ((precedentesUsados(listaTareas.get(i)))
                    && (!listaTareas.get(i).isIsMutado())
                    && (!listaPosiblesTareas.contains(listaTareas.get(i)))) {
                asig++;
                listaPosiblesTareas.add(listaTareas.get(i));
            }
        }
    }

    /**
     * Función que se encarga de imprimir el mejor hijo
     */
    public void imprimirProdigio() {
        System.out.println("--------------------------------  Genético  -------------------------------- Eficiencia " + this.eficiencia + " --------------------------------");
        for (Estacion estacion : this.prodigio.getHijo()) {
            if (estacion.getTareas().isEmpty()) {
                return;
            }
            System.out.println("*********************   " + estacion.getNombre() + "   *********************   Tiempo " + estacion.getTiempoSobrante() + "   *********************");
            String tareas = "";
            for (String nombre : estacion.getTareas()) {
                tareas += nombre + " ";
            }
            System.out.println(tareas);
        }
    }

    /**
     * Función que se encarga de averiguar la eficiencia de la linea de ensamblaje
     */
    public void eficiencia() {
        float T = 0;
        float Nr = 0;
        float C = ensamblaje.getTiempoCiclo();
        for (Estacion estacion : prodigio.getHijo()) {
            if (!estacion.getTareas().isEmpty()) {
                Nr++;
            }
        }
        for (Tarea tarea : ensamblaje.getLineaEnsamblaje()) {
            T += tarea.getTiempo();
        }
        this.eficiencia = ((float) (T / (Nr * C))) * 100;
    }
    
    /**
     * Función que se encarga de imprimir las mediciones del algoritmo genético
     */
    public void imprimirDatos() {
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Memoria Utilizada: " +  (this.memoria/1000) +" KB");
    }
}
