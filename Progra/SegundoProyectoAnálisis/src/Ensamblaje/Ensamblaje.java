package Ensamblaje;

import Tarea.Tarea;
import java.util.ArrayList;


public class Ensamblaje {
    private int tiempoDiario;
    private int tareasDiarias;
    private int tiempoCiclo;
    private int cantEstaciones;
    private ArrayList<Tarea> ensamblaje = new ArrayList<>();
    private ArrayList<String> precedentes = new ArrayList<>();
    private ArrayList<String> allPrecedentes = new ArrayList<>();
    private ArrayList<String> posiblesPrecedentes = new ArrayList<>();
    private ArrayList<Estacion> estaciones = new ArrayList<>();
    

    public Ensamblaje(int tiempoDiario, int tareasDiarias) {
        this.tiempoDiario = tiempoDiario;
        this.tareasDiarias = tareasDiarias;
        this.tiempoCiclo = tiempoDiario/tareasDiarias;        
    }

    /*
    Método que permite insertar tareas en la linea de ensamblaje
    */
    public void setToEnsamblaje(Tarea tarea) {
        ensamblaje.add(tarea);
    }
        
    /*
    Método que se encarga de crear las tareas y agregarlas a la lista de ensamblaje
    */        
    public void crearTareas(int cant){
            String nombre = "Tarea"+ String.valueOf(ensamblaje.size()+1);
            int tiempo = (int) (Math.random()*(tiempoCiclo/2));
            ensamblaje.add(new Tarea(nombre, tiempo, new ArrayList<>(),new ArrayList<>()));
            for(int i=1 ; i<cant ; i++){
                    ArrayList<String> preced = new ArrayList<>();
                    ArrayList<String> allPreced = new ArrayList<>();
                    nombre = "Tarea"+ String.valueOf(ensamblaje.size()+1);
                    tiempo = (int) (Math.random()*(tiempoCiclo/2));
                    if(i+1==cant){
                            for(int e=0 ; e<ensamblaje.size() ; e++){
                                    if(ensamblaje.get(e).isUltimo()){
                                            preced.add(ensamblaje.get(e).getNombre());
                                            allPreced.addAll(ensamblaje.get(e).getAllPrecedentes());
                                            allPreced.add(ensamblaje.get(e).getNombre());
                                    }
                            }
                            ensamblaje.add(new Tarea(nombre, tiempo, preced,allPreced));
                            return;
                    }

                    if(ensamblaje.size() == 1){
                            preced.add(ensamblaje.get(0).getNombre());
                            allPreced.add(ensamblaje.get(0).getNombre());
                            ensamblaje.get(0).setUltimo(false);
                            ensamblaje.add(new Tarea(nombre, tiempo, preced,allPreced));

                    }else{
                            //System.out.println(nombre+" -----------------------");

                            buscarPrecedentes();
                            preced.addAll(precedentes);
                            allPreced.addAll(allPrecedentes);
                            ensamblaje.add(new Tarea(nombre, tiempo, preced, allPreced));
                            limpiarListas();
                    }
            }
    } 

    /*
    Método que permite buscar los precedentes de cada tarea 
    */
    public void buscarPrecedentes(){
            for(int e=0 ; e < this.ensamblaje.size() ; e++){
                    posiblesPrecedentes.add(ensamblaje.get(e).getNombre());
            }

            for(int i=0 ; i<posiblesPrecedentes.size() ; i++){
                    int p = (int)((Math.random())*(posiblesPrecedentes.size()));
                    boolean is = true;
                    //System.out.println("R "+p);
                    //System.out.println(posiblesPrecedentes.size());
                    for(int k=0 ; k<getTarea(posiblesPrecedentes.get(p)).getAllPrecedentes().size() ; k++){                        
                            if(precedentes.contains(getTarea(posiblesPrecedentes.get(p)).getAllPrecedentes().get(k))){
                                    is = false;
                                    break;
                            }
                    }

                    if(is){
                           if(!precedentes.contains(posiblesPrecedentes.get(p))){
                                    precedentes.add(posiblesPrecedentes.get(p));
                                    getTarea(posiblesPrecedentes.get(p)).setUltimo(false);
                                    for(int j=0; j<getTarea(posiblesPrecedentes.get(p)).getAllPrecedentes().size() ; j++){
                                            if(!allPrecedentes.contains(getTarea(posiblesPrecedentes.get(p)).getAllPrecedentes().get(j))){
                                                    allPrecedentes.add(getTarea(posiblesPrecedentes.get(p)).getAllPrecedentes().get(j));
                                            }
                                    }
                                    allPrecedentes.add(getTarea(posiblesPrecedentes.get(p)).getNombre());
                                    eliminaPosibles(getTarea(posiblesPrecedentes.get(p)));
                                    //System.out.println(posiblesPrecedentes);
                                    //System.out.println(allPrecedentes);        
                            }     
                    }                   
            }
    }

    /*
    Método que elimina los precedentes que no se pueden utilizar
    */
    public void eliminaPosibles(Tarea tarea){
            for(int i=0 ; i< tarea.getAllPrecedentes().size(); i++ ){
                    if(posiblesPrecedentes.contains(tarea.getAllPrecedentes().get(i))){
                            posiblesPrecedentes.remove(tarea.getAllPrecedentes().get(i));
                    }
            }
            //System.out.println(posiblesPrecedentes.size());
    }

    /*
    Método para determinar las cantidad de estaciones que posee una linea de ensamblaje
    basandonos en la formula sumaTiempoTareas / tiempoCiclo
    */
    public void cantidadEstaciones(){
            int tiempoTotal = 0;
            for (int i=0 ; i<ensamblaje.size() ; i++){
                    tiempoTotal += ensamblaje.get(i).getTiempo();
            }
           this.cantEstaciones = (tiempoTotal / tiempoCiclo)+1;
            for(int i=0; i<this.cantEstaciones ; i++){
                    estaciones.add(new Estacion("Estacion"+String.valueOf(i+1),this.tiempoCiclo));
            }
    }

    /*
    Método para vaciar las lisatas y evitar guardar basura
    */
    public void limpiarListas(){
            precedentes.clear();
            posiblesPrecedentes.clear();
            allPrecedentes.clear();
    }

    /*
    Método para buscar una tarea en la lista ensamblaje
    */
    public Tarea getTarea(String nombre){
            for(int i=0 ; i<ensamblaje.size() ; i++){
                    if(ensamblaje.get(i).getNombre() == nombre){
                            return ensamblaje.get(i); 
                    }
            }
            return null;
    }

    /*
    Método que devuelve la cantidad de estaciones de la linea de ensamblaje
    */
    public int getCantEstaciones(){
            return this.cantEstaciones;
    }
    
    /*
    Método que devuelve el tiempo de ciclo de la linea de ensamblaje
    */
    public int getTiempoCiclo(){
            return this.tiempoCiclo;
    }
    
    /*
    Método que retorna la linea de ensamblaje
    */
    public ArrayList<Tarea> getLineaEnsamblaje(){
            return this.ensamblaje;
    }
    
    /*
    Método para imprimir todas las tareas de la lista ensamblaje
    */
    public void imprimirInfo(){
        System.out.println("TIEMPO TRABAJO DIARIO: "+tiempoDiario);
        System.out.println("TRABAJO DIARIO: "+tareasDiarias);
        System.out.println("TIEMPO DE CICLO: "+tiempoCiclo);
        System.out.println("CANTIDAD ESTACIONES: "+cantEstaciones);
    }

    /*
    Método para imprimir todas las tareas de la lista ensamblaje
    */
    public void imprimir(){
        System.out.println("TIEMPO TRABAJO DIARIO: "+tiempoDiario);
        System.out.println("TRABAJO DIARIO: "+tareasDiarias);
        System.out.println("TIEMPO DE CICLO: "+tiempoCiclo);
        System.out.println("CANTIDAD ESTACIONES: "+cantEstaciones);
        for(int i=0 ; i<ensamblaje.size() ; i++){
            String preced = "";
            for(int e=0 ; e<ensamblaje.get(i).getPrecedentes().size() ; e++){
                preced += "  "+ensamblaje.get(i).getPrecedentes().get(e);
            }
            System.out.println(ensamblaje.get(i).getNombre()+"    "+ensamblaje.get(i).getTiempo()+"    "+preced);
        }
    }
    
    /*
    Método para imprimir las estaciones y sus tares.
    */
    public void imprimirEstaciones(){
        for(int i=0 ; i<this.estaciones.size() ; i++){
            System.out.println("\n"+this.estaciones.get(i).getNombre()+" ------------------- ");
            System.out.println("Tiempo sobrante de la estacion: "+this.estaciones.get(i).getTiempoSobrante());
            for(int e=0 ; e<this.estaciones.get(i).getTareas().size() ; e++){
                System.out.print(this.estaciones.get(i).getTareas().get(e)+"\t");
            }
            System.out.println("\n");
        }
    }
    
    public boolean allUsed(){
        for(int i=0 ; i<ensamblaje.size() ; i++)
            if(!ensamblaje.get(i).isIsEstacion())
                return false;            
        return true;
    }

    public ArrayList<Estacion> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ArrayList<Estacion> estaciones) {
        this.estaciones = estaciones;
    }
    
    public void resetearSolucion(){
            this.estaciones.clear();
            for(Tarea x : ensamblaje){
                    x.setIsEstacion(false);
            }
    }
}
