/*
 *Segundo proyecto programado de Analisis de algoritmos
 * Yuliana Rojas y Nelson Vega
 * Fecha inicio: Miercoles 23 de octubre
 * Fecha ultima modificacion: - - - - -
 */
package segundoproyectoanálisis;

import Ensamblaje.Ensamblaje;

public class SegundoProyectoAnálisis {

        // --Creacion de las variables para analisis
        public static int comp = 0;
        public static int asig = 0;
        public static int lin = 0;
        public static Ensamblaje ensamblaje = new Ensamblaje(25500,240);
        
        public static void main(String[] args) {
                ensamblaje.crearTareas(20);
                ensamblaje.imprimir();
                //ensamblaje.imprimirAllPre();
        }
        
}
