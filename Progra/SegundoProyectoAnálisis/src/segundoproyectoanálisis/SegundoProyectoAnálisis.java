/*
 *Segundo proyecto programado de Analisis de algoritmos
 * Yuliana Rojas y Nelson Vega
 * Fecha inicio: Miercoles 23 de octubre
 * Fecha ultima modificacion: - - - - -
 */
package segundoproyectoanálisis;

import Ensamblaje.Ensamblaje;
import Tarea.Tarea;
import java.util.ArrayList;

public class SegundoProyectoAnálisis {

        // --Creacion de las variables para analisis
        public static int comp = 0;
        public static int asig = 0;
        public static int lin = 0;
        public static Ensamblaje ensamblaje1 = new Ensamblaje(14400,150);
        public static Ensamblaje ensamblaje2 = new Ensamblaje(18000,175);
        public static Ensamblaje ensamblaje3 = new Ensamblaje(21600,200);
        public static Ensamblaje ensamblaje4 = new Ensamblaje(28800,240);
        public static Ensamblaje ensamblaje5 = new Ensamblaje(36000,280);
        public static Ensamblaje ensamblaje6 = new Ensamblaje(43200,300);
        
        public static void main(String[] args) {
            crearEnsamblaje1();
            
            //ensamblaje5.crearTareas(600);
            //ensamblaje6.crearTareas(1200);
        }
        
        public static void crearEnsamblaje1(){
            
            ArrayList<String> precedentes1 = new ArrayList();
            ArrayList<String> precedentes2 = new ArrayList();
            ArrayList<String> precedentes3 = new ArrayList();
            ArrayList<String> precedentes4 = new ArrayList();
            ArrayList<String> precedentes5 = new ArrayList();
            ArrayList<String> precedentes6 = new ArrayList();
            ArrayList<String> precedentes7 = new ArrayList();
            ArrayList<String> precedentes8 = new ArrayList();
            ArrayList<String> precedentes9 = new ArrayList();
            ArrayList<String> precedentes10 = new ArrayList();

            Tarea tarea1 = new Tarea("Tarea1",30,precedentes1,null);
            Tarea tarea2 = new Tarea("Tarea2",20,precedentes2,null);
            Tarea tarea3 = new Tarea("Tarea3",15,precedentes3,null);
            Tarea tarea4 = new Tarea("Tarea4",60,precedentes4,null);
            Tarea tarea5 = new Tarea("Tarea5",70,precedentes5,null);
            Tarea tarea6 = new Tarea("Tarea6",30,precedentes6,null);
            Tarea tarea7 = new Tarea("Tarea7",20,precedentes7,null);
            Tarea tarea8 = new Tarea("Tarea8",10,precedentes8,null);
            Tarea tarea9 = new Tarea("Tarea9",5,precedentes9,null);
            Tarea tarea10 = new Tarea("Tarea10",23,precedentes10,null);
            
            tarea2.setToPrecedentes("Tarea1");
            tarea3.setToPrecedentes("Tarea2");
            tarea4.setToPrecedentes("Tarea1");
            tarea5.setToPrecedentes("Tarea4");
            tarea5.setToPrecedentes("Tarea3");
            tarea6.setToPrecedentes("Tarea3");
            tarea7.setToPrecedentes("Tarea5");
            tarea8.setToPrecedentes("Tarea4");
            tarea9.setToPrecedentes("Tarea8");
            tarea10.setToPrecedentes("Tarea9");
            tarea10.setToPrecedentes("Tarea7");
            tarea10.setToPrecedentes("Tarea6");
            
            ensamblaje1.setToEnsamblaje(tarea1);
            ensamblaje1.setToEnsamblaje(tarea2);
            ensamblaje1.setToEnsamblaje(tarea3);
            ensamblaje1.setToEnsamblaje(tarea4);
            ensamblaje1.setToEnsamblaje(tarea5);
            ensamblaje1.setToEnsamblaje(tarea6);
            ensamblaje1.setToEnsamblaje(tarea7);
            ensamblaje1.setToEnsamblaje(tarea8);
            ensamblaje1.setToEnsamblaje(tarea9);
            ensamblaje1.setToEnsamblaje(tarea10);
        }

        public static void crearEnsamblaje2(){
            ArrayList<String> precedentes1 = new ArrayList();
            ArrayList<String> precedentes2 = new ArrayList();
            ArrayList<String> precedentes3 = new ArrayList();
            ArrayList<String> precedentes4 = new ArrayList();
            ArrayList<String> precedentes5 = new ArrayList();
            ArrayList<String> precedentes6 = new ArrayList();
            ArrayList<String> precedentes7 = new ArrayList();
            ArrayList<String> precedentes8 = new ArrayList();
            ArrayList<String> precedentes9 = new ArrayList();
            ArrayList<String> precedentes10 = new ArrayList();
            ArrayList<String> precedentes11 = new ArrayList();
            ArrayList<String> precedentes12 = new ArrayList();
            ArrayList<String> precedentes13 = new ArrayList();
            ArrayList<String> precedentes14 = new ArrayList();
            ArrayList<String> precedentes15 = new ArrayList();
            ArrayList<String> precedentes16 = new ArrayList();
            ArrayList<String> precedentes17 = new ArrayList();
            ArrayList<String> precedentes18 = new ArrayList();
            ArrayList<String> precedentes19 = new ArrayList();
            ArrayList<String> precedentes20 = new ArrayList();

            Tarea tarea1 = new Tarea("Tarea1",10,precedentes1,null);
            Tarea tarea2 = new Tarea("Tarea2",20,precedentes2,null);
            Tarea tarea3 = new Tarea("Tarea3",25,precedentes3,null);
            Tarea tarea4 = new Tarea("Tarea4",15,precedentes4,null);
            Tarea tarea5 = new Tarea("Tarea5",30,precedentes5,null);
            Tarea tarea6 = new Tarea("Tarea6",40,precedentes6,null);
            Tarea tarea7 = new Tarea("Tarea7",15,precedentes7,null);
            Tarea tarea8 = new Tarea("Tarea8",10,precedentes8,null);
            Tarea tarea9 = new Tarea("Tarea9",19,precedentes9,null);
            Tarea tarea10 = new Tarea("Tarea10",32,precedentes10,null);
            Tarea tarea11 = new Tarea("Tarea11",40,precedentes11,null);
            Tarea tarea12 = new Tarea("Tarea12",23,precedentes12,null);
            Tarea tarea13 = new Tarea("Tarea13",27,precedentes13,null);
            Tarea tarea14 = new Tarea("Tarea14",40,precedentes14,null);
            Tarea tarea15 = new Tarea("Tarea15",35,precedentes15,null);
            Tarea tarea16 = new Tarea("Tarea16",20,precedentes16,null);
            Tarea tarea17 = new Tarea("Tarea17",10,precedentes17,null);
            Tarea tarea18 = new Tarea("Tarea18",17,precedentes18,null);
            Tarea tarea19 = new Tarea("Tarea19",24,precedentes19,null);
            Tarea tarea20 = new Tarea("Tarea20",50,precedentes20,null);
            
            tarea2.setToPrecedentes("Tarea1");
            tarea3.setToPrecedentes("Tarea1");
            tarea4.setToPrecedentes("Tarea1");
            tarea5.setToPrecedentes("Tarea2");
            tarea6.setToPrecedentes("Tarea2");
            tarea7.setToPrecedentes("Tarea3");
            tarea8.setToPrecedentes("Tarea4");
            tarea9.setToPrecedentes("Tarea5");
            tarea10.setToPrecedentes("Tarea6");
            tarea11.setToPrecedentes("Tarea9");
            tarea11.setToPrecedentes("Tarea10");
            tarea12.setToPrecedentes("Tarea6");
            tarea12.setToPrecedentes("Tarea7");
            tarea13.setToPrecedentes("Tarea8");
            tarea14.setToPrecedentes("Tarea13");
            tarea15.setToPrecedentes("Tarea8");
            tarea16.setToPrecedentes("Tarea13");
            tarea16.setToPrecedentes("Tarea14");
            tarea17.setToPrecedentes("Tarea7");
            tarea18.setToPrecedentes("Tarea11");
            tarea18.setToPrecedentes("Tarea12");
            tarea19.setToPrecedentes("Tarea18");
            tarea19.setToPrecedentes("Tarea17");
            tarea20.setToPrecedentes("Tarea19");
            tarea20.setToPrecedentes("Tarea16");
            System.out.println("ROBERTH FEO");
            ensamblaje2.setToEnsamblaje(tarea1);
            ensamblaje2.setToEnsamblaje(tarea2);
            ensamblaje2.setToEnsamblaje(tarea3);
            ensamblaje2.setToEnsamblaje(tarea4);
            ensamblaje2.setToEnsamblaje(tarea5);
            ensamblaje2.setToEnsamblaje(tarea6);
            ensamblaje2.setToEnsamblaje(tarea7);
            ensamblaje2.setToEnsamblaje(tarea8);
            ensamblaje2.setToEnsamblaje(tarea9);
            ensamblaje2.setToEnsamblaje(tarea10);
            ensamblaje2.setToEnsamblaje(tarea11);
            ensamblaje2.setToEnsamblaje(tarea12);
            ensamblaje2.setToEnsamblaje(tarea13);
            ensamblaje2.setToEnsamblaje(tarea14);
            ensamblaje2.setToEnsamblaje(tarea15);
            ensamblaje2.setToEnsamblaje(tarea16);
            ensamblaje2.setToEnsamblaje(tarea17);
            ensamblaje2.setToEnsamblaje(tarea18);
            ensamblaje2.setToEnsamblaje(tarea19);
            ensamblaje2.setToEnsamblaje(tarea20);
              
        }

        public static void crearEnsamblaje3(){
            ArrayList<String> precedentes1 = new ArrayList();
            ArrayList<String> precedentes2 = new ArrayList();
            ArrayList<String> precedentes3 = new ArrayList();
            ArrayList<String> precedentes4 = new ArrayList();
            ArrayList<String> precedentes5 = new ArrayList();
            ArrayList<String> precedentes6 = new ArrayList();
            ArrayList<String> precedentes7 = new ArrayList();
            ArrayList<String> precedentes8 = new ArrayList();
            ArrayList<String> precedentes9 = new ArrayList();
            ArrayList<String> precedentes10 = new ArrayList();
            ArrayList<String> precedentes11 = new ArrayList();
            ArrayList<String> precedentes12 = new ArrayList();
            ArrayList<String> precedentes13 = new ArrayList();
            ArrayList<String> precedentes14 = new ArrayList();
            ArrayList<String> precedentes15 = new ArrayList();
            ArrayList<String> precedentes16 = new ArrayList();
            ArrayList<String> precedentes17 = new ArrayList();
            ArrayList<String> precedentes18 = new ArrayList();
            ArrayList<String> precedentes19 = new ArrayList();
            ArrayList<String> precedentes20 = new ArrayList();

            Tarea tarea1 = new Tarea("Tarea1",10,precedentes1,null);
            Tarea tarea2 = new Tarea("Tarea2",20,precedentes2,null);
            Tarea tarea3 = new Tarea("Tarea3",25,precedentes3,null);
            Tarea tarea4 = new Tarea("Tarea4",15,precedentes4,null);
            Tarea tarea5 = new Tarea("Tarea5",30,precedentes5,null);
            Tarea tarea6 = new Tarea("Tarea6",40,precedentes6,null);
            Tarea tarea7 = new Tarea("Tarea7",15,precedentes7,null);
            Tarea tarea8 = new Tarea("Tarea8",10,precedentes8,null);
            Tarea tarea9 = new Tarea("Tarea9",19,precedentes9,null);
            Tarea tarea10 = new Tarea("Tarea10",32,precedentes10,null);
            Tarea tarea11 = new Tarea("Tarea11",40,precedentes11,null);
            Tarea tarea12 = new Tarea("Tarea12",23,precedentes12,null);
            Tarea tarea13 = new Tarea("Tarea13",27,precedentes13,null);
            Tarea tarea14 = new Tarea("Tarea14",40,precedentes14,null);
            Tarea tarea15 = new Tarea("Tarea15",35,precedentes15,null);
            Tarea tarea16 = new Tarea("Tarea16",20,precedentes16,null);
            Tarea tarea17 = new Tarea("Tarea17",10,precedentes17,null);
            Tarea tarea18 = new Tarea("Tarea18",17,precedentes18,null);
            Tarea tarea19 = new Tarea("Tarea19",24,precedentes19,null);
            Tarea tarea20 = new Tarea("Tarea20",50,precedentes20,null);
            
            tarea2.setToPrecedentes("Tarea1");
            tarea3.setToPrecedentes("Tarea1");
            tarea4.setToPrecedentes("Tarea1");
            tarea5.setToPrecedentes("Tarea2");
            tarea6.setToPrecedentes("Tarea2");
            tarea7.setToPrecedentes("Tarea3");
            tarea8.setToPrecedentes("Tarea4");
            tarea9.setToPrecedentes("Tarea5");
            tarea10.setToPrecedentes("Tarea6");
            tarea11.setToPrecedentes("Tarea9");
            tarea11.setToPrecedentes("Tarea10");
            tarea12.setToPrecedentes("Tarea6");
            tarea12.setToPrecedentes("Tarea7");
            tarea13.setToPrecedentes("Tarea8");
            tarea14.setToPrecedentes("Tarea13");
            tarea15.setToPrecedentes("Tarea8");
            tarea16.setToPrecedentes("Tarea13");
            tarea16.setToPrecedentes("Tarea14");
            tarea17.setToPrecedentes("Tarea7");
            tarea18.setToPrecedentes("Tarea11");
            tarea18.setToPrecedentes("Tarea12");
            tarea19.setToPrecedentes("Tarea18");
            tarea19.setToPrecedentes("Tarea17");
            tarea20.setToPrecedentes("Tarea19");
            tarea20.setToPrecedentes("Tarea16");
            
            ensamblaje2.setToEnsamblaje(tarea1);
            ensamblaje2.setToEnsamblaje(tarea2);
            ensamblaje2.setToEnsamblaje(tarea3);
            ensamblaje2.setToEnsamblaje(tarea4);
            ensamblaje2.setToEnsamblaje(tarea5);
            ensamblaje2.setToEnsamblaje(tarea6);
            ensamblaje2.setToEnsamblaje(tarea7);
            ensamblaje2.setToEnsamblaje(tarea8);
            ensamblaje2.setToEnsamblaje(tarea9);
            ensamblaje2.setToEnsamblaje(tarea10);
            ensamblaje2.setToEnsamblaje(tarea11);
            ensamblaje2.setToEnsamblaje(tarea12);
            ensamblaje2.setToEnsamblaje(tarea13);
            ensamblaje2.setToEnsamblaje(tarea14);
            ensamblaje2.setToEnsamblaje(tarea15);
            ensamblaje2.setToEnsamblaje(tarea16);
            ensamblaje2.setToEnsamblaje(tarea17);
            ensamblaje2.setToEnsamblaje(tarea18);
            ensamblaje2.setToEnsamblaje(tarea19);
            ensamblaje2.setToEnsamblaje(tarea20);
              
        }        
        
        
        
}
