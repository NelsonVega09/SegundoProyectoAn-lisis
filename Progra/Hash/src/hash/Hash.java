package hash;


import java.util.Enumeration;
import java.util.Hashtable;

public class Hash {

        static Hashtable h = new Hashtable(10);
        
        public static void main(String[] args) {
                llenadoDatos();
                //primerMetodo();
                segundoMetodo();
        }
        
        static void llenadoDatos(){
                Producto p1 = new Producto("Camisa",5000);
                Producto p2 = new Producto("Camiseta",2000);
                Producto p3 = new Producto("Pantalon",7500);
                Producto p4 = new Producto("Medias",500);
                Producto p5 = new Producto("Zapatos",15000);
                Producto p6 = new Producto("Sombrero",4000);
                Producto p7 = new Producto("Gorro",3500);
                Producto p8 = new Producto("Short",7500);
                Producto p9 = new Producto("Saco",52100);
                Producto p10 = new Producto("Corbata",2500);
                
                h.put(1, p1);
                h.put(2, p2);
                h.put(3, p3);
                h.put(4, p4);
                h.put(5, p5);
                h.put(6, p6);
                h.put(7, p7);
                h.put(8, p8);
                h.put(9, p9);
                h.put(10, p10);
                
                //h.put(9,p9);
                //h.put(10,p10);
        }
        
        static void primerMetodo(){
                  System.out.println("\n****Imprimir Datos Individualmente*****"
                            +"\nproducto1 " + h.get(1)
                            +"\nproducto2 " + h.get(2)
                            +"\nproducto3 " + h.get(3)
                            +"\nproducto4 " + h.get(4)
                            +"\nproducto5 " + h.get(5)
                            +"\nproducto6 " + h.get(6)
                            +"\nproducto7 " + h.get(7)
                            +"\nproducto8 " + h.get(8)
                            +"\nproducto9 " + h.get(9)
                            +"\nproducto10 " + h.get(10));
                }
        
        static void segundoMetodo(){
                System.out.println("\n***Segundo Metodo***");
                Enumeration enu = h.elements();
                while(enu.hasMoreElements())
                        System.out.println(enu.nextElement());
        }
        
        static void imprimirDatos(){
                System.out.println("HashTable: "+h);
                primerMetodo();
                segundoMetodo();
        }
}
