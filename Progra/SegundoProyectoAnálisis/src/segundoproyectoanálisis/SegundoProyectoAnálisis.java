/**
 * Segundo proyecto programado de Analisis de algoritmos
 * Yuliana Rojas Serrano  y Nelson Vega Soto
 * Fecha inicio: 23 de octubre
 * Fecha ultima modificacion: Domingo 17 de noviembre
 */
package segundoproyectoanálisis;

import Dinámico.Dinamico;
import Ensamblaje.Ensamblaje;
import Genético.Genetico;
import Tarea.Tarea;
import java.util.ArrayList;
import java.util.Scanner;

public class SegundoProyectoAnálisis {

    // --Creacion de las variables para analisis
    public static int comp = 0;
    public static int asig = 0;
    public static int lin = 0;
    

    // --Crea los ensamblajes y sus respectivas respuestas
    public static Ensamblaje ensamblaje1 = new Ensamblaje(14400, 150);
    public static Ensamblaje ensamblaje2 = new Ensamblaje(18000, 175);
    public static Ensamblaje ensamblaje3 = new Ensamblaje(21600, 200);
    public static Ensamblaje ensamblaje4 = new Ensamblaje(28800, 240);
    public static Ensamblaje ensamblaje5 = new Ensamblaje(36000, 280);
    public static Ensamblaje ensamblaje6 = new Ensamblaje(43200, 300);
    public static Dinamico dinamico1 = new Dinamico(ensamblaje1);
    public static Dinamico dinamico2 = new Dinamico(ensamblaje2);
    public static Dinamico dinamico3 = new Dinamico(ensamblaje3);
    public static Dinamico dinamico4 = new Dinamico(ensamblaje4);
    public static Dinamico dinamico5 = new Dinamico(ensamblaje5);
    public static Dinamico dinamico6 = new Dinamico(ensamblaje6);
    public static Genetico genetico1;
    public static Genetico genetico2;
    public static Genetico genetico3;
    public static Genetico genetico4;
    public static Genetico genetico5;
    public static Genetico genetico6;

    public static void main(String[] args) {

        System.out.println("Creando las lineas de ensamblajes...");
        crearEnsamblaje1();
        ensamblaje1.cantidadEstaciones();
        crearEnsamblaje2();
        ensamblaje2.cantidadEstaciones();
        crearEnsamblaje3();
        ensamblaje3.cantidadEstaciones();
        crearEnsamblaje4();
        ensamblaje4.cantidadEstaciones();
        ensamblaje5.crearTareas(120);
        ensamblaje5.cantidadEstaciones();
        ensamblaje6.crearTareas(1200);
        ensamblaje6.cantidadEstaciones();

        genetico1 = new Genetico(ensamblaje1);
        genetico2 = new Genetico(ensamblaje2);
        genetico3 = new Genetico(ensamblaje3);
        genetico4 = new Genetico(ensamblaje4);
        genetico5 = new Genetico(ensamblaje5);
        genetico6 = new Genetico(ensamblaje6);
        
        correrAlgortimos();
        
        while (true) {
            
            System.out.println("Digite un numero segun la opcion que desee");
            System.out.println("0.Salir");
            System.out.println("1.Imprimir los ensamblajes");
            System.out.println("2.Imprimir las estaciones dinamicas");
            System.out.println("3.Imprimir las estaciones geneticas");
            System.out.println("4.Imprimir los hijos del algoritmo genetico");
            System.out.println("5.Imprimir los padres del algoritmo genetico");
            System.out.println("6.Imprimir las fases dinamicas");
            System.out.println("7.Imprimir mediciones dinamicas");
            System.out.println("8.Imprimir mediciones geneticas");
            
            Scanner teclado = new Scanner(System.in);
            int opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 0:
                    return;
                case 1:
                    ensamblajes();
                    break;
                case 2:
                    dinamico();
                    break;
                case 3:
                    genetico();
                    break;
                case 4:
                    hijos();
                    break;
                case 5:
                    padres();
                    break;
                case 6:
                    fasesDinamicas();
                    break;
                case 7:
                    medicionesDinamico();
                    break;
                case 8:
                    medicionesGenetico();
                    break;
                default:
                    System.out.println("Ingrese un numero valido");
            }

        }
    }
    
    private static void correrAlgortimos(){
        System.out.println("Corriendo el algortimo dinamico...");
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        dinamico1.lineaEnsamblaje();
        dinamico2.lineaEnsamblaje();
        dinamico3.lineaEnsamblaje();
        dinamico4.lineaEnsamblaje();
        dinamico5.lineaEnsamblaje();
        dinamico6.lineaEnsamblaje();
        System.out.println("Corriendo el algortimo genetico...");
        genetico1.crearPadres();
        genetico2.crearPadres();
        genetico3.crearPadres();
        genetico4.crearPadres();
        genetico5.crearPadres();
        genetico6.crearPadres();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        dinamico1.memoria = afterUsedMem - beforeUsedMem;
        dinamico2.memoria = afterUsedMem - beforeUsedMem;
        dinamico3.memoria = afterUsedMem - beforeUsedMem;
        dinamico4.memoria = afterUsedMem - beforeUsedMem;
        dinamico5.memoria = afterUsedMem - beforeUsedMem;
        dinamico6.memoria = afterUsedMem - beforeUsedMem;
        genetico1.memoria = afterUsedMem - beforeUsedMem;
        genetico2.memoria = afterUsedMem - beforeUsedMem;
        genetico3.memoria = afterUsedMem - beforeUsedMem;
        genetico4.memoria = afterUsedMem - beforeUsedMem;
        genetico5.memoria = afterUsedMem - beforeUsedMem;   
        genetico6.memoria = afterUsedMem - beforeUsedMem;
    }

    private static void padres() {
        System.out.println("**IMPRESION DE LOS PADRES");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        genetico1.imprimirPadres();
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        genetico2.imprimirPadres();
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        genetico3.imprimirPadres();
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        genetico4.imprimirPadres();
        System.out.println("------------------------------      120 TAREAS      -----------------------------------");
        genetico5.imprimirPadres();
        System.out.println("-----------------------------      1200 TAREAS      -----------------------------------");
        genetico6.imprimirPadres();
    }

    private static void hijos() {
        System.out.println("**IMPRESION DE LOS HIJOS");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        genetico1.imprimirPadres();
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        genetico2.imprimirPadres();
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        genetico3.imprimirPadres();
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        genetico4.imprimirPadres();
        System.out.println("------------------------------      120 TAREAS      -----------------------------------");
        genetico5.imprimirPadres();
        System.out.println("-----------------------------      1200 TAREAS      -----------------------------------");
        genetico6.imprimirPadres();
    }

    private static void fasesDinamicas() {
        System.out.println("**IMPRESION DE LAS FASES DEL ALGORTIMO DINAMICO");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        System.out.println("------------------------------      120 TAREAS      ------------------------------------");
        System.out.println("------------------------------      1200 TAREAS      ------------------------------------");
    }

    private static void ensamblajes() {
        System.out.println("**IMPRESION DE LOS ENSAMBLAJES");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        ensamblaje1.imprimir();
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        ensamblaje2.imprimir();
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        ensamblaje3.imprimir();
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        ensamblaje4.imprimir();
        System.out.println("------------------------------      120 TAREAS      -----------------------------------");
        ensamblaje5.imprimir();
        System.out.println("-----------------------------      1200 TAREAS      -----------------------------------");
        ensamblaje6.imprimir();
    }

    private static void dinamico() {
        System.out.println("**IMPRESION DE LAS ESTACIONES DINAMICAS");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        ensamblaje1.imprimirEstaciones();
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        ensamblaje2.imprimirEstaciones();
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        ensamblaje3.imprimirEstaciones();
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        ensamblaje4.imprimirEstaciones();
        System.out.println("------------------------------      120 TAREAS      ------------------------------------");
        ensamblaje5.imprimirEstaciones();
        System.out.println("------------------------------      1200 TAREAS      ------------------------------------");
        ensamblaje6.imprimirEstaciones();
    }

    private static void genetico() {
        System.out.println("**IMPRESION DE LAS ESTACIONES GENETICAS");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        genetico1.imprimirProdigio();
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        genetico2.imprimirProdigio();
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        genetico3.imprimirProdigio();
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        genetico4.imprimirProdigio();
        System.out.println("------------------------------      120 TAREAS      ------------------------------------");
        genetico5.imprimirProdigio();
        System.out.println("------------------------------      1200 TAREAS      ------------------------------------");
        genetico6.imprimirProdigio();
    }
    
    private static void medicionesDinamico() {
        System.out.println("**IMPRESION DE LAS MEDICIONES DINAMICAS");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        dinamico1.imprimirDatos();
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        dinamico2.imprimirDatos();
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        dinamico3.imprimirDatos();
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        dinamico4.imprimirDatos();
        System.out.println("------------------------------      120 TAREAS      ------------------------------------");
        dinamico5.imprimirDatos();
        System.out.println("------------------------------      1200 TAREAS      ------------------------------------");
        dinamico6.imprimirDatos();
    }

    private static void medicionesGenetico() {
        System.out.println("**IMPRESION DE LAS MEDICIONES GENETICAS");
        System.out.println("------------------------------      10 TAREAS      ------------------------------------");
        genetico1.imprimirDatos();
        System.out.println("------------------------------      20 TAREAS      ------------------------------------");
        genetico2.imprimirDatos();
        System.out.println("------------------------------      30 TAREAS      ------------------------------------");
        genetico3.imprimirDatos();
        System.out.println("------------------------------      60 TAREAS      ------------------------------------");
        genetico4.imprimirDatos();
        System.out.println("------------------------------      120 TAREAS      ------------------------------------");
        genetico5.imprimirDatos();
        System.out.println("------------------------------      1200 TAREAS      ------------------------------------");
        genetico6.imprimirDatos();
    }

    public static void crearEnsamblaje1() {
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

        Tarea tarea1 = new Tarea("Tarea1", 30, precedentes1, null);
        Tarea tarea2 = new Tarea("Tarea2", 24, precedentes2, null);
        Tarea tarea3 = new Tarea("Tarea3", 15, precedentes3, null);
        Tarea tarea4 = new Tarea("Tarea4", 40, precedentes4, null);
        Tarea tarea5 = new Tarea("Tarea5", 25, precedentes5, null);
        Tarea tarea6 = new Tarea("Tarea6", 30, precedentes6, null);
        Tarea tarea7 = new Tarea("Tarea7", 15, precedentes7, null);
        Tarea tarea8 = new Tarea("Tarea8", 10, precedentes8, null);
        Tarea tarea9 = new Tarea("Tarea9", 49, precedentes9, null);
        Tarea tarea10 = new Tarea("Tarea10", 38, precedentes10, null);

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

    public static void crearEnsamblaje2() {
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

        Tarea tarea1 = new Tarea("Tarea1", 10, precedentes1, null);
        Tarea tarea2 = new Tarea("Tarea2", 20, precedentes2, null);
        Tarea tarea3 = new Tarea("Tarea3", 25, precedentes3, null);
        Tarea tarea4 = new Tarea("Tarea4", 15, precedentes4, null);
        Tarea tarea5 = new Tarea("Tarea5", 30, precedentes5, null);
        Tarea tarea6 = new Tarea("Tarea6", 31, precedentes6, null);
        Tarea tarea7 = new Tarea("Tarea7", 15, precedentes7, null);
        Tarea tarea8 = new Tarea("Tarea8", 10, precedentes8, null);
        Tarea tarea9 = new Tarea("Tarea9", 19, precedentes9, null);
        Tarea tarea10 = new Tarea("Tarea10", 32, precedentes10, null);
        Tarea tarea11 = new Tarea("Tarea11", 40, precedentes11, null);
        Tarea tarea12 = new Tarea("Tarea12", 23, precedentes12, null);
        Tarea tarea13 = new Tarea("Tarea13", 27, precedentes13, null);
        Tarea tarea14 = new Tarea("Tarea14", 40, precedentes14, null);
        Tarea tarea15 = new Tarea("Tarea15", 35, precedentes15, null);
        Tarea tarea16 = new Tarea("Tarea16", 20, precedentes16, null);
        Tarea tarea17 = new Tarea("Tarea17", 10, precedentes17, null);
        Tarea tarea18 = new Tarea("Tarea18", 17, precedentes18, null);
        Tarea tarea19 = new Tarea("Tarea19", 24, precedentes19, null);
        Tarea tarea20 = new Tarea("Tarea20", 57, precedentes20, null);

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
        tarea16.setToPrecedentes("Tarea15");
        tarea16.setToPrecedentes("Tarea14");
        tarea17.setToPrecedentes("Tarea7");
        tarea18.setToPrecedentes("Tarea11");
        tarea18.setToPrecedentes("Tarea12");
        tarea19.setToPrecedentes("Tarea18");
        tarea19.setToPrecedentes("Tarea17");
        tarea20.setToPrecedentes("Tarea16");
        tarea20.setToPrecedentes("Tarea19");

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

    public static void crearEnsamblaje3() {
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

        Tarea tarea1 = new Tarea("Tarea1", 10, precedentes1, null);
        Tarea tarea2 = new Tarea("Tarea2", 20, precedentes2, null);
        Tarea tarea3 = new Tarea("Tarea3", 25, precedentes3, null);
        Tarea tarea4 = new Tarea("Tarea4", 15, precedentes4, null);
        Tarea tarea5 = new Tarea("Tarea5", 30, precedentes5, null);
        Tarea tarea6 = new Tarea("Tarea6", 30, precedentes6, null);
        Tarea tarea7 = new Tarea("Tarea7", 15, precedentes7, null);
        Tarea tarea8 = new Tarea("Tarea8", 10, precedentes8, null);
        Tarea tarea9 = new Tarea("Tarea9", 19, precedentes9, null);
        Tarea tarea10 = new Tarea("Tarea10", 32, precedentes10, null);
        Tarea tarea11 = new Tarea("Tarea11", 12, precedentes11, null);
        Tarea tarea12 = new Tarea("Tarea12", 23, precedentes12, null);
        Tarea tarea13 = new Tarea("Tarea13", 27, precedentes13, null);
        Tarea tarea14 = new Tarea("Tarea14", 32, precedentes14, null);
        Tarea tarea15 = new Tarea("Tarea15", 35, precedentes15, null);
        Tarea tarea16 = new Tarea("Tarea16", 20, precedentes16, null);
        Tarea tarea17 = new Tarea("Tarea17", 10, precedentes17, null);
        Tarea tarea18 = new Tarea("Tarea18", 17, precedentes18, null);
        Tarea tarea19 = new Tarea("Tarea19", 24, precedentes19, null);
        Tarea tarea20 = new Tarea("Tarea20", 39, precedentes20, null);
        Tarea tarea21 = new Tarea("Tarea21", 40, precedentes21, null);
        Tarea tarea22 = new Tarea("Tarea22", 23, precedentes22, null);
        Tarea tarea23 = new Tarea("Tarea23", 27, precedentes23, null);
        Tarea tarea24 = new Tarea("Tarea24", 35, precedentes24, null);
        Tarea tarea25 = new Tarea("Tarea25", 35, precedentes25, null);
        Tarea tarea26 = new Tarea("Tarea26", 20, precedentes26, null);
        Tarea tarea27 = new Tarea("Tarea27", 10, precedentes27, null);
        Tarea tarea28 = new Tarea("Tarea28", 17, precedentes28, null);
        Tarea tarea29 = new Tarea("Tarea29", 24, precedentes29, null);
        Tarea tarea30 = new Tarea("Tarea30", 62, precedentes30, null);

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
        tarea20.setToPrecedentes("Tarea19");
        tarea21.setToPrecedentes("Tarea20");
        tarea22.setToPrecedentes("Tarea21");
        tarea23.setToPrecedentes("Tarea18");
        tarea23.setToPrecedentes("Tarea22");
        tarea24.setToPrecedentes("Tarea8");
        tarea25.setToPrecedentes("Tarea24");
        tarea26.setToPrecedentes("Tarea25");
        tarea27.setToPrecedentes("Tarea26");
        tarea28.setToPrecedentes("Tarea27");
        tarea29.setToPrecedentes("Tarea28");
        tarea30.setToPrecedentes("Tarea29");
        tarea30.setToPrecedentes("Tarea15");
        tarea30.setToPrecedentes("Tarea23");

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
        ensamblaje3.setToEnsamblaje(tarea11);
        ensamblaje3.setToEnsamblaje(tarea12);
        ensamblaje3.setToEnsamblaje(tarea13);
        ensamblaje3.setToEnsamblaje(tarea14);
        ensamblaje3.setToEnsamblaje(tarea15);
        ensamblaje3.setToEnsamblaje(tarea16);
        ensamblaje3.setToEnsamblaje(tarea17);
        ensamblaje3.setToEnsamblaje(tarea18);
        ensamblaje3.setToEnsamblaje(tarea19);
        ensamblaje3.setToEnsamblaje(tarea20);
        ensamblaje3.setToEnsamblaje(tarea21);
        ensamblaje3.setToEnsamblaje(tarea22);
        ensamblaje3.setToEnsamblaje(tarea23);
        ensamblaje3.setToEnsamblaje(tarea24);
        ensamblaje3.setToEnsamblaje(tarea25);
        ensamblaje3.setToEnsamblaje(tarea26);
        ensamblaje3.setToEnsamblaje(tarea27);
        ensamblaje3.setToEnsamblaje(tarea28);
        ensamblaje3.setToEnsamblaje(tarea29);
        ensamblaje3.setToEnsamblaje(tarea30);
    }

    public static void crearEnsamblaje4() {
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
        ArrayList<String> precedentes31 = new ArrayList();
        ArrayList<String> precedentes32 = new ArrayList();
        ArrayList<String> precedentes33 = new ArrayList();
        ArrayList<String> precedentes34 = new ArrayList();
        ArrayList<String> precedentes35 = new ArrayList();
        ArrayList<String> precedentes36 = new ArrayList();
        ArrayList<String> precedentes37 = new ArrayList();
        ArrayList<String> precedentes38 = new ArrayList();
        ArrayList<String> precedentes39 = new ArrayList();
        ArrayList<String> precedentes40 = new ArrayList();
        ArrayList<String> precedentes41 = new ArrayList();
        ArrayList<String> precedentes42 = new ArrayList();
        ArrayList<String> precedentes43 = new ArrayList();
        ArrayList<String> precedentes44 = new ArrayList();
        ArrayList<String> precedentes45 = new ArrayList();
        ArrayList<String> precedentes46 = new ArrayList();
        ArrayList<String> precedentes47 = new ArrayList();
        ArrayList<String> precedentes48 = new ArrayList();
        ArrayList<String> precedentes49 = new ArrayList();
        ArrayList<String> precedentes50 = new ArrayList();
        ArrayList<String> precedentes51 = new ArrayList();
        ArrayList<String> precedentes52 = new ArrayList();
        ArrayList<String> precedentes53 = new ArrayList();
        ArrayList<String> precedentes54 = new ArrayList();
        ArrayList<String> precedentes55 = new ArrayList();
        ArrayList<String> precedentes56 = new ArrayList();
        ArrayList<String> precedentes57 = new ArrayList();
        ArrayList<String> precedentes58 = new ArrayList();
        ArrayList<String> precedentes59 = new ArrayList();
        ArrayList<String> precedentes60 = new ArrayList();

        Tarea tarea1 = new Tarea("Tarea1", 10, precedentes1, null);
        Tarea tarea2 = new Tarea("Tarea2", 20, precedentes2, null);
        Tarea tarea3 = new Tarea("Tarea3", 25, precedentes3, null);
        Tarea tarea4 = new Tarea("Tarea4", 15, precedentes4, null);
        Tarea tarea5 = new Tarea("Tarea5", 30, precedentes5, null);
        Tarea tarea6 = new Tarea("Tarea6", 40, precedentes6, null);
        Tarea tarea7 = new Tarea("Tarea7", 15, precedentes7, null);
        Tarea tarea8 = new Tarea("Tarea8", 10, precedentes8, null);
        Tarea tarea9 = new Tarea("Tarea9", 19, precedentes9, null);
        Tarea tarea10 = new Tarea("Tarea10", 32, precedentes10, null);
        Tarea tarea11 = new Tarea("Tarea11", 40, precedentes11, null);
        Tarea tarea12 = new Tarea("Tarea12", 23, precedentes12, null);
        Tarea tarea13 = new Tarea("Tarea13", 27, precedentes13, null);
        Tarea tarea14 = new Tarea("Tarea14", 40, precedentes14, null);
        Tarea tarea15 = new Tarea("Tarea15", 35, precedentes15, null);
        Tarea tarea16 = new Tarea("Tarea16", 20, precedentes16, null);
        Tarea tarea17 = new Tarea("Tarea17", 10, precedentes17, null);
        Tarea tarea18 = new Tarea("Tarea18", 17, precedentes18, null);
        Tarea tarea19 = new Tarea("Tarea19", 24, precedentes19, null);
        Tarea tarea20 = new Tarea("Tarea20", 50, precedentes20, null);
        Tarea tarea21 = new Tarea("Tarea21", 40, precedentes21, null);
        Tarea tarea22 = new Tarea("Tarea22", 23, precedentes22, null);
        Tarea tarea23 = new Tarea("Tarea23", 27, precedentes23, null);
        Tarea tarea24 = new Tarea("Tarea24", 40, precedentes24, null);
        Tarea tarea25 = new Tarea("Tarea25", 35, precedentes25, null);
        Tarea tarea26 = new Tarea("Tarea26", 20, precedentes26, null);
        Tarea tarea27 = new Tarea("Tarea27", 10, precedentes27, null);
        Tarea tarea28 = new Tarea("Tarea28", 17, precedentes28, null);
        Tarea tarea29 = new Tarea("Tarea29", 24, precedentes29, null);
        Tarea tarea30 = new Tarea("Tarea30", 50, precedentes30, null);
        Tarea tarea31 = new Tarea("Tarea31", 30, precedentes31, null);
        Tarea tarea32 = new Tarea("Tarea32", 20, precedentes32, null);
        Tarea tarea33 = new Tarea("Tarea33", 15, precedentes33, null);
        Tarea tarea34 = new Tarea("Tarea34", 60, precedentes34, null);
        Tarea tarea35 = new Tarea("Tarea35", 70, precedentes35, null);
        Tarea tarea36 = new Tarea("Tarea36", 30, precedentes36, null);
        Tarea tarea37 = new Tarea("Tarea37", 20, precedentes37, null);
        Tarea tarea38 = new Tarea("Tarea38", 10, precedentes38, null);
        Tarea tarea39 = new Tarea("Tarea39", 5, precedentes39, null);
        Tarea tarea40 = new Tarea("Tarea40", 43, precedentes40, null);
        Tarea tarea41 = new Tarea("Tarea41", 10, precedentes41, null);
        Tarea tarea42 = new Tarea("Tarea42", 20, precedentes42, null);
        Tarea tarea43 = new Tarea("Tarea43", 25, precedentes43, null);
        Tarea tarea44 = new Tarea("Tarea44", 15, precedentes44, null);
        Tarea tarea45 = new Tarea("Tarea45", 30, precedentes45, null);
        Tarea tarea46 = new Tarea("Tarea46", 40, precedentes46, null);
        Tarea tarea47 = new Tarea("Tarea47", 15, precedentes47, null);
        Tarea tarea48 = new Tarea("Tarea48", 10, precedentes48, null);
        Tarea tarea49 = new Tarea("Tarea49", 19, precedentes49, null);
        Tarea tarea50 = new Tarea("Tarea50", 32, precedentes50, null);
        Tarea tarea51 = new Tarea("Tarea51", 40, precedentes51, null);
        Tarea tarea52 = new Tarea("Tarea52", 23, precedentes52, null);
        Tarea tarea53 = new Tarea("Tarea53", 27, precedentes53, null);
        Tarea tarea54 = new Tarea("Tarea54", 40, precedentes54, null);
        Tarea tarea55 = new Tarea("Tarea55", 35, precedentes55, null);
        Tarea tarea56 = new Tarea("Tarea56", 20, precedentes56, null);
        Tarea tarea57 = new Tarea("Tarea57", 10, precedentes57, null);
        Tarea tarea58 = new Tarea("Tarea58", 17, precedentes58, null);
        Tarea tarea59 = new Tarea("Tarea59", 24, precedentes59, null);
        Tarea tarea60 = new Tarea("Tarea60", 75, precedentes60, null);

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
        tarea20.setToPrecedentes("Tarea19");
        tarea21.setToPrecedentes("Tarea20");
        tarea22.setToPrecedentes("Tarea21");
        tarea23.setToPrecedentes("Tarea18");
        tarea23.setToPrecedentes("Tarea22");
        tarea24.setToPrecedentes("Tarea8");
        tarea25.setToPrecedentes("Tarea24");
        tarea26.setToPrecedentes("Tarea25");
        tarea27.setToPrecedentes("Tarea26");
        tarea28.setToPrecedentes("Tarea27");
        tarea29.setToPrecedentes("Tarea28");
        tarea30.setToPrecedentes("Tarea29");
        tarea30.setToPrecedentes("Tarea15");
        tarea30.setToPrecedentes("Tarea23");

        tarea31.setToPrecedentes("Tarea30");
        tarea32.setToPrecedentes("Tarea31");
        tarea33.setToPrecedentes("Tarea32");
        tarea34.setToPrecedentes("Tarea31");
        tarea35.setToPrecedentes("Tarea33");
        tarea35.setToPrecedentes("Tarea34");
        tarea36.setToPrecedentes("Tarea33");
        tarea37.setToPrecedentes("Tarea35");
        tarea38.setToPrecedentes("Tarea34");
        tarea39.setToPrecedentes("Tarea38");
        tarea40.setToPrecedentes("Tarea36");
        tarea40.setToPrecedentes("Tarea37");
        tarea40.setToPrecedentes("Tarea39");

        tarea41.setToPrecedentes("Tarea25");
        tarea42.setToPrecedentes("Tarea41");
        tarea43.setToPrecedentes("Tarea41");
        tarea44.setToPrecedentes("Tarea41");
        tarea45.setToPrecedentes("Tarea42");
        tarea46.setToPrecedentes("Tarea42");
        tarea47.setToPrecedentes("Tarea43");
        tarea48.setToPrecedentes("Tarea44");
        tarea49.setToPrecedentes("Tarea45");
        tarea50.setToPrecedentes("Tarea46");
        tarea51.setToPrecedentes("Tarea49");
        tarea51.setToPrecedentes("Tarea50");
        tarea52.setToPrecedentes("Tarea46");
        tarea52.setToPrecedentes("Tarea47");
        tarea53.setToPrecedentes("Tarea48");
        tarea54.setToPrecedentes("Tarea53");
        tarea55.setToPrecedentes("Tarea48");
        tarea56.setToPrecedentes("Tarea55");
        tarea56.setToPrecedentes("Tarea54");
        tarea57.setToPrecedentes("Tarea47");
        tarea58.setToPrecedentes("Tarea51");
        tarea58.setToPrecedentes("Tarea52");
        tarea59.setToPrecedentes("Tarea57");
        tarea59.setToPrecedentes("Tarea58");
        tarea60.setToPrecedentes("Tarea40");
        tarea60.setToPrecedentes("Tarea56");
        tarea60.setToPrecedentes("Tarea59");

        ensamblaje4.setToEnsamblaje(tarea1);
        ensamblaje4.setToEnsamblaje(tarea2);
        ensamblaje4.setToEnsamblaje(tarea3);
        ensamblaje4.setToEnsamblaje(tarea4);
        ensamblaje4.setToEnsamblaje(tarea5);
        ensamblaje4.setToEnsamblaje(tarea6);
        ensamblaje4.setToEnsamblaje(tarea7);
        ensamblaje4.setToEnsamblaje(tarea8);
        ensamblaje4.setToEnsamblaje(tarea9);
        ensamblaje4.setToEnsamblaje(tarea10);
        ensamblaje4.setToEnsamblaje(tarea11);
        ensamblaje4.setToEnsamblaje(tarea12);
        ensamblaje4.setToEnsamblaje(tarea13);
        ensamblaje4.setToEnsamblaje(tarea14);
        ensamblaje4.setToEnsamblaje(tarea15);
        ensamblaje4.setToEnsamblaje(tarea16);
        ensamblaje4.setToEnsamblaje(tarea17);
        ensamblaje4.setToEnsamblaje(tarea18);
        ensamblaje4.setToEnsamblaje(tarea19);
        ensamblaje4.setToEnsamblaje(tarea20);
        ensamblaje4.setToEnsamblaje(tarea21);
        ensamblaje4.setToEnsamblaje(tarea22);
        ensamblaje4.setToEnsamblaje(tarea23);
        ensamblaje4.setToEnsamblaje(tarea24);
        ensamblaje4.setToEnsamblaje(tarea25);
        ensamblaje4.setToEnsamblaje(tarea26);
        ensamblaje4.setToEnsamblaje(tarea27);
        ensamblaje4.setToEnsamblaje(tarea28);
        ensamblaje4.setToEnsamblaje(tarea29);
        ensamblaje4.setToEnsamblaje(tarea30);
        ensamblaje4.setToEnsamblaje(tarea31);
        ensamblaje4.setToEnsamblaje(tarea32);
        ensamblaje4.setToEnsamblaje(tarea33);
        ensamblaje4.setToEnsamblaje(tarea34);
        ensamblaje4.setToEnsamblaje(tarea35);
        ensamblaje4.setToEnsamblaje(tarea36);
        ensamblaje4.setToEnsamblaje(tarea37);
        ensamblaje4.setToEnsamblaje(tarea38);
        ensamblaje4.setToEnsamblaje(tarea39);
        ensamblaje4.setToEnsamblaje(tarea40);
        ensamblaje4.setToEnsamblaje(tarea41);
        ensamblaje4.setToEnsamblaje(tarea42);
        ensamblaje4.setToEnsamblaje(tarea43);
        ensamblaje4.setToEnsamblaje(tarea44);
        ensamblaje4.setToEnsamblaje(tarea45);
        ensamblaje4.setToEnsamblaje(tarea46);
        ensamblaje4.setToEnsamblaje(tarea47);
        ensamblaje4.setToEnsamblaje(tarea48);
        ensamblaje4.setToEnsamblaje(tarea49);
        ensamblaje4.setToEnsamblaje(tarea50);
        ensamblaje4.setToEnsamblaje(tarea51);
        ensamblaje4.setToEnsamblaje(tarea52);
        ensamblaje4.setToEnsamblaje(tarea53);
        ensamblaje4.setToEnsamblaje(tarea54);
        ensamblaje4.setToEnsamblaje(tarea55);
        ensamblaje4.setToEnsamblaje(tarea56);
        ensamblaje4.setToEnsamblaje(tarea57);
        ensamblaje4.setToEnsamblaje(tarea58);
        ensamblaje4.setToEnsamblaje(tarea59);
        ensamblaje4.setToEnsamblaje(tarea60);
    }
}
