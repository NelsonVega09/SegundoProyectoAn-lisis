
package grafo;

import java.util.ArrayList;

/**
 * La clase vertice incluye el nombre con el que el nodo se va a identificar
 * Las variables, visitado, marcar y notM. las cuales son para efectos de uso en 
 * los algortimos.
 * Y incluye una variable beneficio que es donde se almacena el beneficio de cada
 * lugar
 * @author Yuli y Nelson
 */
public class Vertice {
    public int beneficio;
    public boolean visitado;
    public boolean marcar;
    public String nombre;
    public boolean notM;
        
    public ArrayList<Arco> listaArcos = new ArrayList<Arco>();
    
    /**
     * Constructor del vertice
     * @param beneficio
     * @param lugar 
     */
    public Vertice(int beneficio, String lugar) {
        this.visitado = false;
        this.beneficio = beneficio;
        this.marcar = false;
        this.nombre = lugar;
    }
    
}

