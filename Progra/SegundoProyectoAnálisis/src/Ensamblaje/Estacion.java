package Ensamblaje;

import java.util.ArrayList;


public class Estacion {
        
        private ArrayList<String> tareas = new ArrayList<>();
        private int tiempoSobrante;
        private String nombre; 

        public Estacion(String nombre, int tiempoSobrante) {
                this.tiempoSobrante = tiempoSobrante;
                this.nombre = nombre;
        }

        public ArrayList<String> getTareas() {
                return tareas;
        }

        public void setTarea(String tareas) {
                this.tareas.add(tareas);
        }

        public int getTiempoSobrante() {
                return tiempoSobrante;
        }

        public void setTiempoSobrante(int tiempoSobrante) {
                this.tiempoSobrante = tiempoSobrante;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }           
        
}
