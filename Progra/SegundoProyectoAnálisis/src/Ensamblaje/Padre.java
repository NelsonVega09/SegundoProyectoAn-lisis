/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensamblaje;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Padre {
        private ArrayList<Estacion> padre = new ArrayList<>();
        private String nombre;
        private int sobrante = 0;

        public Padre(ArrayList<Estacion> padre, String nombre) {
                this.padre.addAll(padre);
                this.nombre = nombre;
        }

        public ArrayList<Estacion> getPadre() {
                return padre;
        }

        public void setPadre(ArrayList<Estacion> padre) {
                this.padre = padre;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public int getSobrante() {
                return sobrante;
        }

        public void setSobrante(int sobrante) {
                this.sobrante = sobrante;
        }
        
        public void sobranteT(){
                int cant = 0;
                for(Estacion estacion : this.padre){
                        cant += estacion.getTiempoSobrante();
                }
                this.sobrante = cant;
        }
        
}
