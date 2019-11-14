package Ensamblaje;

import java.util.ArrayList;


public class Hijo {
        private String nombreP1;
        private String nombreP2;
        private String nombre;
        private ArrayList<Estacion> hijo = new ArrayList<>();

        public Hijo(String nombre, String nombreP1, String nombreP2,ArrayList<Estacion> hijos) {
                this.nombreP1 = nombreP1;
                this.nombreP2 = nombreP2;
                this.nombre = nombre;
                this.hijo.addAll(hijos);
        }

        public String getNombreP1() {
                return nombreP1;
        }

        public void setNombreP1(String nombreP1) {
                this.nombreP1 = nombreP1;
        }

        public String getNombreP2() {
                return nombreP2;
        }

        public void setNombreP2(String nombreP2) {
                this.nombreP2 = nombreP2;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public ArrayList<Estacion> getHijo() {
                return hijo;
        }

        public void setHijo(ArrayList<Estacion> hijos) {
                this.hijo = hijos;
        }
}
