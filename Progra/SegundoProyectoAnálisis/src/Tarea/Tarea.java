package Tarea;

import java.util.ArrayList;


public class Tarea {
    final String nombre;
    final int tiempo;
    boolean ultimo;
    ArrayList<String> precedentes;
    final ArrayList<String> allPrecedentes;

        public Tarea(String nombre, int tiempo, ArrayList<String> precedentes,ArrayList<String> allPrecedentes) {
                this.nombre = nombre;
                this.tiempo = tiempo;
                this.ultimo = true;
                this.precedentes = precedentes;
                this.allPrecedentes = allPrecedentes;
        }

    public void setToPrecedentes(String precedente) {
        this.precedentes.add(precedente);
    }

        
        
        public String getNombre() {
                return nombre;
        }

        public int getTiempo() {
                return tiempo;
        }

        public boolean isUltimo() {
                return ultimo;
        }

        public ArrayList<String> getPrecedentes() {
                return precedentes;
        }
        
        public ArrayList<String> getAllPrecedentes() {
                return allPrecedentes;
        }

        public void setUltimo(boolean ultimo) {
                this.ultimo = ultimo;
        }
        
        /*public void eliminaRepetidos(){
                for(int i=0 ; i<allPrecedentes.size() ; i++){
                        if(allPrecedentes.get(i)==null)
                                return;
                        if()
                }
        }*/
}
