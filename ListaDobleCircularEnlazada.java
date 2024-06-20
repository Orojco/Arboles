// ListaDobleCircularEnlazada.java
public class ListaDobleCircularEnlazada {
    Nodo cabeza;

    public ListaDobleCircularEnlazada() {
        this.cabeza = null;
    }

    public void agregar(Object datos) {
        Nodo nuevo = new Nodo(datos);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
    }

    public void insertar(Object datos) {
        Nodo nuevo = new Nodo(datos);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
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
                cabeza.siguiente.anterior = temp;
                cabeza = cabeza.siguiente;
            }
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != cabeza && !actual.siguiente.dato.equals(datos)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != cabeza) {
            actual.siguiente.siguiente.anterior = actual;
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
}
