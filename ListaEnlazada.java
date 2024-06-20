// ListaEnlazada.java
public class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
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
        }
    }

    public void insertar(Object datos) {
        Nodo nuevo = new Nodo(datos);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void eliminar(Object datos) {
        if (cabeza == null) return;
        if (cabeza.dato.equals(datos)) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(datos)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
}
