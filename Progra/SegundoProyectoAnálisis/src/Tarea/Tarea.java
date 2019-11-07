package Tarea;

import java.util.ArrayList;


public class Tarea {
    private final String nombre;
    private final int tiempo;
    private boolean ultimo;
    private ArrayList<String> precedentes;
    private final ArrayList<String> allPrecedentes;
    private boolean isEstacion = false;
    private String estacion = "";

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

        public boolean isIsEstacion() {
                return isEstacion;
        }

        public void setIsEstacion(boolean isEstacion) {
                this.isEstacion = isEstacion;
        }

        public String getEstacion() {
                return estacion;
        }

        public void setEstacion(String estacion) {
                this.estacion = estacion;
        }      
        
}
