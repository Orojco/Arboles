// ListaCircularEnlazada.java
public class ListaCircularEnlazada {
    Nodo cabeza;

    public ListaCircularEnlazada() {
        this.cabeza = null;
    }

    public void agregar(Object datos) {
        Nodo nuevo = new Nodo(datos);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
    }

    public void insertar(Object datos) {
        Nodo nuevo = new Nodo(datos);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
    }

    public void eliminar(Object datos) {
        if (cabeza == null) return;
        if (cabeza.dato.equals(datos)) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                Nodo temp = cabeza;
                while (temp.siguiente != cabeza) {
                    temp = temp.siguiente;
                }
                temp.siguiente = cabeza.siguiente;
                cabeza = cabeza.siguiente;
            }
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != cabeza && !actual.siguiente.dato.equals(datos)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != cabeza) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
}
