// Nodo.java
public class Nodo {
    Object dato;
    Nodo siguiente;
    Nodo anterior;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
        this.izquierdo = null;
        this.derecho = null;
    }
}
