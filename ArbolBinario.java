// ArbolBinario.java
public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void agregar(Object datos) {
        raiz = agregarRec(raiz, datos);
    }

    private Nodo agregarRec(Nodo nodo, Object datos) {
        if (nodo == null) {
            return new Nodo(datos);
        }
        if (Math.random() < 0.5) {
            nodo.izquierdo = agregarRec(nodo.izquierdo, datos);
        } else {
            nodo.derecho = agregarRec(nodo.derecho, datos);
        }
        return nodo;
    }

    public void insertar(Object datos) {
        agregar(datos);
    }

    public void eliminar(Object datos) {
        raiz = eliminarRec(raiz, datos);
    }

    private Nodo eliminarRec(Nodo nodo, Object datos) {
        if (nodo == null) return null;
        if (nodo.dato.equals(datos)) {
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            Object minValue = encontrarMin(nodo.derecho);
            nodo.dato = minValue;
            nodo.derecho = eliminarRec(nodo.derecho, minValue);
            return nodo;
        }
        nodo.izquierdo = eliminarRec(nodo.izquierdo, datos);
        nodo.derecho = eliminarRec(nodo.derecho, datos);
        return nodo;
    }

    private Object encontrarMin(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.dato;
    }

    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.derecho);
        }
    }

    public void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }
}
