package grafo;

/**
 * El arco esta conformado por una variable con el nombre del grafo al
 * que conecta y una variable visitado que indica si este ya ha sido visitado
 * @author Yul
 */
public class Arco {
    public String destino;
    public boolean visitado;

    /**
     * Constructor
     * @param destino 
     */
    public Arco(String destino) {
        this.destino = destino;
        this.visitado = false;
    }
}
