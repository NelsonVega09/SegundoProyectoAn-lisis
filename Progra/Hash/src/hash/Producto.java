package hash;

public class Producto {
        
        String nombre;
        int precio;

        public Producto(String nombre, int precio) {
                this.nombre = nombre;
                this.precio = precio;
        }
        
        @Override 
        public String toString(){
                return this.nombre+" - Precio: "+this.precio;
        }
        
}
