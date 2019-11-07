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
        ensamblaje5.crearTareas(600);
        ensamblaje6.crearTareas(1200);
        crearEnsamblaje3();
        crearEnsamblaje2();
        crearEnsamblaje1();
        
        System.out.println("\n\n------------------------------      10      ------------------------------------");
        ensamblaje1.imprimir();
        System.out.println("\n\n------------------------------      20      ------------------------------------");
        ensamblaje2.imprimir();
        System.out.println("\n\n------------------------------      30      ------------------------------------");
        ensamblaje3.imprimir();
        System.out.println("\n\n------------------------------      60      ------------------------------------");
        ensamblaje4.imprimir();
        System.out.println("----------------------------------      600     ------------------------------------");
        ensamblaje5.imprimir();
        System.out.println("\n\n------------------------------      1200    ------------------------------------");
        ensamblaje6.imprimir();
        
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
        ArrayList<String> precedentes21 = new ArrayList();
        ArrayList<String> precedentes22 = new ArrayList();
        ArrayList<String> precedentes23 = new ArrayList();
        ArrayList<String> precedentes24 = new ArrayList();
        ArrayList<String> precedentes25 = new ArrayList();
        ArrayList<String> precedentes26 = new ArrayList();
        ArrayList<String> precedentes27 = new ArrayList();
        ArrayList<String> precedentes28 = new ArrayList();
        ArrayList<String> precedentes29 = new ArrayList();
        ArrayList<String> precedentes30 = new ArrayList();

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
        Tarea tarea21 = new Tarea("Tarea11",40,precedentes21,null);
        Tarea tarea22 = new Tarea("Tarea12",23,precedentes22,null);
        Tarea tarea23 = new Tarea("Tarea13",27,precedentes23,null);
        Tarea tarea24 = new Tarea("Tarea14",40,precedentes24,null);
        Tarea tarea25 = new Tarea("Tarea15",35,precedentes25,null);
        Tarea tarea26 = new Tarea("Tarea16",20,precedentes26,null);
        Tarea tarea27 = new Tarea("Tarea17",10,precedentes27,null);
        Tarea tarea28 = new Tarea("Tarea18",17,precedentes28,null);
        Tarea tarea29 = new Tarea("Tarea19",24,precedentes29,null);
        Tarea tarea30 = new Tarea("Tarea30",50,precedentes30,null);

        tarea2.setToPrecedentes("Tarea1");
        tarea3.setToPrecedentes("Tarea2");
        tarea4.setToPrecedentes("Tarea3");
        tarea5.setToPrecedentes("Tarea2");
        tarea6.setToPrecedentes("Tarea2");
        tarea7.setToPrecedentes("Tarea1");
        tarea8.setToPrecedentes("Tarea7");
        tarea9.setToPrecedentes("Tarea4");
        tarea10.setToPrecedentes("Tarea6");
        tarea10.setToPrecedentes("Tarea8");
        tarea11.setToPrecedentes("Tarea5");
        tarea11.setToPrecedentes("Tarea9");
        tarea12.setToPrecedentes("Tarea9");
        tarea13.setToPrecedentes("Tarea4");
        tarea14.setToPrecedentes("Tarea13");
        tarea14.setToPrecedentes("Tarea12");
        tarea15.setToPrecedentes("Tarea14");
        tarea16.setToPrecedentes("Tarea12");
        tarea17.setToPrecedentes("Tarea14");
        tarea18.setToPrecedentes("Tarea17");
        tarea18.setToPrecedentes("Tarea16");
        tarea19.setToPrecedentes("Tarea11");
        tarea20.setToPrecedentes("Tarea10");
        tarea21.setToPrecedentes("Tarea20");
        tarea22.setToPrecedentes("Tarea21");
        tarea23.setToPrecedentes("Tarea22");
        tarea24.setToPrecedentes("Tarea8");
        tarea25.setToPrecedentes("Tarea24");
        tarea26.setToPrecedentes("Tarea25");
        tarea27.setToPrecedentes("Tarea26");
        tarea28.setToPrecedentes("Tarea27");
        tarea29.setToPrecedentes("Tarea28");
        tarea30.setToPrecedentes("Tarea29");
        tarea30.setToPrecedentes("Tarea25");
        tarea30.setToPrecedentes("Tarea23");

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
        ensamblaje2.setToEnsamblaje(tarea21);
        ensamblaje2.setToEnsamblaje(tarea22);
        ensamblaje2.setToEnsamblaje(tarea23);
        ensamblaje2.setToEnsamblaje(tarea24);
        ensamblaje2.setToEnsamblaje(tarea25);
        ensamblaje2.setToEnsamblaje(tarea26);
        ensamblaje2.setToEnsamblaje(tarea27);
        ensamblaje2.setToEnsamblaje(tarea28);
        ensamblaje2.setToEnsamblaje(tarea29);
        ensamblaje2.setToEnsamblaje(tarea30);
    }        
    
    
    
    
    public static void crearEnsamblaje4(){            
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
        
        ArrayList<String> precedentes21 = new ArrayList();
        ArrayList<String> precedentes22 = new ArrayList();
        ArrayList<String> precedentes23 = new ArrayList();
        ArrayList<String> precedentes24 = new ArrayList();
        ArrayList<String> precedentes25 = new ArrayList();
        ArrayList<String> precedentes26 = new ArrayList();
        ArrayList<String> precedentes27 = new ArrayList();
        ArrayList<String> precedentes28 = new ArrayList();
        ArrayList<String> precedentes29 = new ArrayList();
        ArrayList<String> precedentes210 = new ArrayList();
        ArrayList<String> precedentes211 = new ArrayList();
        ArrayList<String> precedentes212 = new ArrayList();
        ArrayList<String> precedentes213 = new ArrayList();
        ArrayList<String> precedentes214 = new ArrayList();
        ArrayList<String> precedentes215 = new ArrayList();
        ArrayList<String> precedentes216 = new ArrayList();
        ArrayList<String> precedentes217 = new ArrayList();
        ArrayList<String> precedentes218 = new ArrayList();
        ArrayList<String> precedentes219 = new ArrayList();
        ArrayList<String> precedentes220 = new ArrayList();
        
        ArrayList<String> precedentes31 = new ArrayList();
        ArrayList<String> precedentes32 = new ArrayList();
        ArrayList<String> precedentes33 = new ArrayList();
        ArrayList<String> precedentes34 = new ArrayList();
        ArrayList<String> precedentes35 = new ArrayList();
        ArrayList<String> precedentes36 = new ArrayList();
        ArrayList<String> precedentes37 = new ArrayList();
        ArrayList<String> precedentes38 = new ArrayList();
        ArrayList<String> precedentes39 = new ArrayList();
        ArrayList<String> precedentes310 = new ArrayList();
        ArrayList<String> precedentes311 = new ArrayList();
        ArrayList<String> precedentes312 = new ArrayList();
        ArrayList<String> precedentes313 = new ArrayList();
        ArrayList<String> precedentes314 = new ArrayList();
        ArrayList<String> precedentes315 = new ArrayList();
        ArrayList<String> precedentes316 = new ArrayList();
        ArrayList<String> precedentes317 = new ArrayList();
        ArrayList<String> precedentes318 = new ArrayList();
        ArrayList<String> precedentes319 = new ArrayList();
        ArrayList<String> precedentes320 = new ArrayList();
        ArrayList<String> precedentes321 = new ArrayList();
        ArrayList<String> precedentes322 = new ArrayList();
        ArrayList<String> precedentes323 = new ArrayList();
        ArrayList<String> precedentes324 = new ArrayList();
        ArrayList<String> precedentes325 = new ArrayList();
        ArrayList<String> precedentes326 = new ArrayList();
        ArrayList<String> precedentes327 = new ArrayList();
        ArrayList<String> precedentes328 = new ArrayList();
        ArrayList<String> precedentes329 = new ArrayList();
        ArrayList<String> precedentes330 = new ArrayList();

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

        Tarea tarea21 = new Tarea("Tarea21",10,precedentes21,null);
        Tarea tarea22 = new Tarea("Tarea22",20,precedentes22,null);
        Tarea tarea23 = new Tarea("Tarea23",25,precedentes23,null);
        Tarea tarea24 = new Tarea("Tarea24",15,precedentes24,null);
        Tarea tarea25 = new Tarea("Tarea25",30,precedentes25,null);
        Tarea tarea26 = new Tarea("Tarea26",40,precedentes26,null);
        Tarea tarea27 = new Tarea("Tarea27",15,precedentes27,null);
        Tarea tarea28 = new Tarea("Tarea28",10,precedentes28,null);
        Tarea tarea29 = new Tarea("Tarea29",19,precedentes29,null);
        Tarea tarea210 = new Tarea("Tarea210",32,precedentes210,null);
        Tarea tarea211 = new Tarea("Tarea211",40,precedentes211,null);
        Tarea tarea212 = new Tarea("Tarea212",23,precedentes212,null);
        Tarea tarea213 = new Tarea("Tarea213",27,precedentes213,null);
        Tarea tarea214 = new Tarea("Tarea214",40,precedentes214,null);
        Tarea tarea215 = new Tarea("Tarea215",35,precedentes215,null);
        Tarea tarea216 = new Tarea("Tarea216",20,precedentes216,null);
        Tarea tarea217 = new Tarea("Tarea217",10,precedentes217,null);
        Tarea tarea218 = new Tarea("Tarea218",17,precedentes218,null);
        Tarea tarea219 = new Tarea("Tarea219",24,precedentes219,null);
        Tarea tarea220 = new Tarea("Tarea220",50,precedentes220,null);
        
        Tarea tarea31 = new Tarea("Tarea31",10,precedentes31,null);
        Tarea tarea32 = new Tarea("Tarea32",20,precedentes32,null);
        Tarea tarea33 = new Tarea("Tarea33",25,precedentes33,null);
        Tarea tarea34 = new Tarea("Tarea34",15,precedentes34,null);
        Tarea tarea35 = new Tarea("Tarea35",30,precedentes35,null);
        Tarea tarea36 = new Tarea("Tarea36",40,precedentes36,null);
        Tarea tarea37 = new Tarea("Tarea37",15,precedentes37,null);
        Tarea tarea38 = new Tarea("Tarea38",10,precedentes38,null);
        Tarea tarea39 = new Tarea("Tarea39",19,precedentes39,null);
        Tarea tarea310 = new Tarea("Tarea310",32,precedentes310,null);
        Tarea tarea311 = new Tarea("Tarea311",40,precedentes311,null);
        Tarea tarea312 = new Tarea("Tarea312",23,precedentes312,null);
        Tarea tarea313 = new Tarea("Tarea313",27,precedentes313,null);
        Tarea tarea314 = new Tarea("Tarea314",40,precedentes314,null);
        Tarea tarea315 = new Tarea("Tarea315",35,precedentes315,null);
        Tarea tarea316 = new Tarea("Tarea316",20,precedentes316,null);
        Tarea tarea317 = new Tarea("Tarea317",10,precedentes317,null);
        Tarea tarea318 = new Tarea("Tarea318",17,precedentes318,null);
        Tarea tarea319 = new Tarea("Tarea319",24,precedentes319,null);
        Tarea tarea320 = new Tarea("Tarea320",50,precedentes320,null);
        Tarea tarea321 = new Tarea("Tarea311",40,precedentes321,null);
        Tarea tarea322 = new Tarea("Tarea312",23,precedentes322,null);
        Tarea tarea323 = new Tarea("Tarea313",27,precedentes323,null);
        Tarea tarea324 = new Tarea("Tarea314",40,precedentes324,null);
        Tarea tarea325 = new Tarea("Tarea315",35,precedentes325,null);
        Tarea tarea326 = new Tarea("Tarea316",20,precedentes326,null);
        Tarea tarea327 = new Tarea("Tarea317",10,precedentes327,null);
        Tarea tarea328 = new Tarea("Tarea318",17,precedentes328,null);
        Tarea tarea329 = new Tarea("Tarea319",24,precedentes329,null);
        Tarea tarea330 = new Tarea("Tarea330",50,precedentes330,null);

        tarea1.setToPrecedentes("Tarea330");
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

        tarea21.setToPrecedentes("Tarea325");
        tarea22.setToPrecedentes("Tarea21");
        tarea23.setToPrecedentes("Tarea21");
        tarea24.setToPrecedentes("Tarea21");
        tarea25.setToPrecedentes("Tarea22");
        tarea26.setToPrecedentes("Tarea22");
        tarea27.setToPrecedentes("Tarea23");
        tarea28.setToPrecedentes("Tarea24");
        tarea29.setToPrecedentes("Tarea25");
        tarea210.setToPrecedentes("Tarea26");
        tarea211.setToPrecedentes("Tarea29");
        tarea211.setToPrecedentes("Tarea210");
        tarea212.setToPrecedentes("Tarea26");
        tarea212.setToPrecedentes("Tarea27");
        tarea213.setToPrecedentes("Tarea28");
        tarea214.setToPrecedentes("Tarea213");
        tarea215.setToPrecedentes("Tarea28");
        tarea216.setToPrecedentes("Tarea213");
        tarea216.setToPrecedentes("Tarea214");
        tarea217.setToPrecedentes("Tarea27");
        tarea218.setToPrecedentes("Tarea211");
        tarea218.setToPrecedentes("Tarea212");
        tarea219.setToPrecedentes("Tarea218");
        tarea219.setToPrecedentes("Tarea217");
        tarea220.setToPrecedentes("Tarea219");
        tarea220.setToPrecedentes("Tarea216");
        tarea220.setToPrecedentes("Tarea10");
        
        tarea32.setToPrecedentes("Tarea31");
        tarea33.setToPrecedentes("Tarea32");
        tarea34.setToPrecedentes("Tarea33");
        tarea35.setToPrecedentes("Tarea32");
        tarea36.setToPrecedentes("Tarea32");
        tarea37.setToPrecedentes("Tarea31");
        tarea38.setToPrecedentes("Tarea37");
        tarea39.setToPrecedentes("Tarea34");
        tarea310.setToPrecedentes("Tarea36");
        tarea310.setToPrecedentes("Tarea38");
        tarea311.setToPrecedentes("Tarea35");
        tarea311.setToPrecedentes("Tarea39");
        tarea312.setToPrecedentes("Tarea39");
        tarea313.setToPrecedentes("Tarea34");
        tarea314.setToPrecedentes("Tarea313");
        tarea314.setToPrecedentes("Tarea312");
        tarea315.setToPrecedentes("Tarea314");
        tarea316.setToPrecedentes("Tarea312");
        tarea317.setToPrecedentes("Tarea314");
        tarea318.setToPrecedentes("Tarea317");
        tarea318.setToPrecedentes("Tarea316");
        tarea319.setToPrecedentes("Tarea311");
        tarea320.setToPrecedentes("Tarea310");
        tarea321.setToPrecedentes("Tarea320");
        tarea322.setToPrecedentes("Tarea321");
        tarea323.setToPrecedentes("Tarea322");
        tarea324.setToPrecedentes("Tarea38");
        tarea325.setToPrecedentes("Tarea324");
        tarea326.setToPrecedentes("Tarea325");
        tarea327.setToPrecedentes("Tarea326");
        tarea328.setToPrecedentes("Tarea327");
        tarea329.setToPrecedentes("Tarea328");
        tarea330.setToPrecedentes("Tarea329");
        tarea330.setToPrecedentes("Tarea325");
        tarea330.setToPrecedentes("Tarea323");

        ensamblaje3.setToEnsamblaje(tarea1);
        ensamblaje3.setToEnsamblaje(tarea2);
        ensamblaje3.setToEnsamblaje(tarea3);
        ensamblaje3.setToEnsamblaje(tarea4);
        ensamblaje3.setToEnsamblaje(tarea5);
        ensamblaje3.setToEnsamblaje(tarea6);
        ensamblaje3.setToEnsamblaje(tarea7);
        ensamblaje3.setToEnsamblaje(tarea8);
        ensamblaje3.setToEnsamblaje(tarea9);
        ensamblaje3.setToEnsamblaje(tarea10);
                
        ensamblaje3.setToEnsamblaje(tarea21);
        ensamblaje3.setToEnsamblaje(tarea22);
        ensamblaje3.setToEnsamblaje(tarea23);
        ensamblaje3.setToEnsamblaje(tarea24);
        ensamblaje3.setToEnsamblaje(tarea25);
        ensamblaje3.setToEnsamblaje(tarea26);
        ensamblaje3.setToEnsamblaje(tarea27);
        ensamblaje3.setToEnsamblaje(tarea28);
        ensamblaje3.setToEnsamblaje(tarea29);
        ensamblaje3.setToEnsamblaje(tarea210);
        ensamblaje3.setToEnsamblaje(tarea211);
        ensamblaje3.setToEnsamblaje(tarea212);
        ensamblaje3.setToEnsamblaje(tarea213);
        ensamblaje3.setToEnsamblaje(tarea214);
        ensamblaje3.setToEnsamblaje(tarea215);
        ensamblaje3.setToEnsamblaje(tarea216);
        ensamblaje3.setToEnsamblaje(tarea217);
        ensamblaje3.setToEnsamblaje(tarea218);
        ensamblaje3.setToEnsamblaje(tarea219);
        ensamblaje3.setToEnsamblaje(tarea220);
        
        ensamblaje3.setToEnsamblaje(tarea31);
        ensamblaje3.setToEnsamblaje(tarea32);
        ensamblaje3.setToEnsamblaje(tarea33);
        ensamblaje3.setToEnsamblaje(tarea34);
        ensamblaje3.setToEnsamblaje(tarea35);
        ensamblaje3.setToEnsamblaje(tarea36);
        ensamblaje3.setToEnsamblaje(tarea37);
        ensamblaje3.setToEnsamblaje(tarea38);
        ensamblaje3.setToEnsamblaje(tarea39);
        ensamblaje3.setToEnsamblaje(tarea310);
        ensamblaje3.setToEnsamblaje(tarea311);
        ensamblaje3.setToEnsamblaje(tarea312);
        ensamblaje3.setToEnsamblaje(tarea313);
        ensamblaje3.setToEnsamblaje(tarea314);
        ensamblaje3.setToEnsamblaje(tarea315);
        ensamblaje3.setToEnsamblaje(tarea316);
        ensamblaje3.setToEnsamblaje(tarea317);
        ensamblaje3.setToEnsamblaje(tarea318);
        ensamblaje3.setToEnsamblaje(tarea319);
        ensamblaje3.setToEnsamblaje(tarea320);
        ensamblaje3.setToEnsamblaje(tarea321);
        ensamblaje3.setToEnsamblaje(tarea322);
        ensamblaje3.setToEnsamblaje(tarea323);
        ensamblaje3.setToEnsamblaje(tarea324);
        ensamblaje3.setToEnsamblaje(tarea325);
        ensamblaje3.setToEnsamblaje(tarea326);
        ensamblaje3.setToEnsamblaje(tarea327);
        ensamblaje3.setToEnsamblaje(tarea328);
        ensamblaje3.setToEnsamblaje(tarea329);
        ensamblaje3.setToEnsamblaje(tarea330);
    
    }
        
}
