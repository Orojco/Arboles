// ListaDobleEnlazada.java
public class ListaDobleEnlazada {
    Nodo cabeza;

    public ListaDobleEnlazada() {
        this.cabeza = null;
    }

    public void agregar(Object datos) {
        Nodo nuevo = new Nodo(datos);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
        }
    }

    public void insertar(Object datos) {
        Nodo nuevo = new Nodo(datos);
        nuevo.siguiente = cabeza;
        if (cabeza != null) {
            cabeza.anterior = nuevo;
        }
        cabeza = nuevo;
    }

    public void eliminar(Object datos) {
        if (cabeza == null) return;
        if (cabeza.dato.equals(datos)) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(datos)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual;
            }
        }
    }
}
