package grafo;
import java.util.ArrayList;

import static segundoproyectoanálisis.SegundoProyectoAnálisis.asig;
import static segundoproyectoanálisis.SegundoProyectoAnálisis.comp;
import static segundoproyectoanálisis.SegundoProyectoAnálisis.lin;

/**
 * El grafo consta de una lista donde estan almacenados todos sus vertices
 * @author Yul
 */
public class Grafo {
    
    public ArrayList<Vertice> grafo = new ArrayList<>();
   
    /**
     * Inserta un vertice al grafo, ordenandolo segun beneficio
     * @param beneficio
     * @param lugar 
     */
    public void insercionVertices(int beneficio, String lugar){
        Vertice nuevoVertice = new Vertice(beneficio, lugar);
        if(grafo.isEmpty()){
                grafo.add(nuevoVertice);
                return;
        }
        for(int i=0 ; i<grafo.size() ; i++){
                if(nuevoVertice.beneficio > grafo.get(i).beneficio){
                        grafo.add(i, nuevoVertice);
                        return;
                }
        }
        grafo.add(nuevoVertice);
    }
   
    /**
     * inserta arco al grafo
     * @param lugar
     * @param destino 
     */
    public void insertarArco(String lugar, String destino){
        Arco nuevoArco = new Arco(destino);
        Vertice vOrigen = buscarVertice(lugar);
        vOrigen.listaArcos.add(nuevoArco);
    }

    /**
     * Retorna un vertice del grafo
     * @param lugar
     * @return 
     */
    public Vertice buscarVertice(String lugar){
        comp++;
        asig++;
        lin+=2;
        for (int i=0; i<grafo.size() ; i++){
            comp++;
            comp++;
            asig++;
            lin+=3;
            if(grafo.get(i).nombre == lugar)
                return grafo.get(i);
        }
        return null;
    }

    /**
     * Limpia el grafo, reinicia los valores de marcar y visitar.
     */
    public void desmarcar(){
        lin++;
        comp++;
        asig+=2;
        for (int i=0; i<grafo.size() ; i++){
                lin+=4;
                grafo.get(i).visitado = false;
                grafo.get(i).marcar = false;
                grafo.get(i).notM = false;
                comp++;
                asig+=2;
                for(int e=0 ; e < grafo.get(i).listaArcos.size() ; e++){
                        lin++;
                        asig++;
                        grafo.get(i).listaArcos.get(e).visitado = false;
                }
        }
    }
    
    /**
     * Imprime la lista de vertices que tiene cada grafo, 
     * con su respectivo beneficio
     */
    public void imprimir(){
            for(int i=0 ; i<grafo.size() ; i++){
                    System.out.println(grafo.get(i).nombre+" = "+grafo.get(i).beneficio+"     ");
            }
    }
    
    /**
     * Esta funcion ordena el grafo segun la cantidad de
     * arcos que tiene, para utulizar en el algortimo C
     */
    public Grafo ordenarGrafo(){
        asig+=3;
        comp++;
        lin+=4;
        ArrayList<Vertice> grafoOrdenado = new ArrayList<>();
        for(int j = 0; j<grafo.size();j++){
            asig++;
            comp+=3;
            lin+=3;
            if(grafoOrdenado.isEmpty()){
                lin++;
                grafoOrdenado.add(grafo.get(j));
            }
            else{
                asig++;
                comp++;
                lin+=2;
                for(int i = 0; i<grafoOrdenado.size(); i++){
                    comp+=3;
                    asig++;
                    lin+=3;
                    if(grafo.get(j).listaArcos.size() <= grafoOrdenado.get(i).listaArcos.size()){
                        lin++;
                        asig++;
                        grafoOrdenado.add(i, grafo.get(j));
                        break;
                    }                    
                }
                lin++;
                asig++;
                grafoOrdenado.add(grafo.get(j));
            }        
        }
        lin +=3;
        asig += 2;
        Grafo grafoA = new Grafo();
        grafoA.grafo = grafoOrdenado;
        return grafoA;
    }    
}
