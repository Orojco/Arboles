// ArbolAVL.java
public class ArbolAVL extends ArbolBinario {

    public ArbolAVL() {
        super();
    }

    @Override
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
        return balancear(nodo);
    }

    @Override
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
            return balancear(nodo);
        }
        nodo.izquierdo = eliminarRec(nodo.izquierdo, datos);
        nodo.derecho = eliminarRec(nodo.derecho, datos);
        return balancear(nodo);
    }
    
    private Object encontrarMin(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.izquierdo == null) {
            return nodo.dato;
        }
        return encontrarMin(nodo.izquierdo);
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;
    }

    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        return x;
    }

    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        return y;
    }

    private Nodo balancear(Nodo nodo) {
        int balance = altura(nodo.izquierdo) - altura(nodo.derecho);

        if (balance > 1) {
            if (altura(nodo.izquierdo.izquierdo) >= altura(nodo.izquierdo.derecho)) {
                nodo = rotarDerecha(nodo);
            } else {
                nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
                nodo = rotarDerecha(nodo);
            }
        } else if (balance < -1) {
            if (altura(nodo.derecho.derecho) >= altura(nodo.derecho.izquierdo)) {
                nodo = rotarIzquierda(nodo);
            } else {
                nodo.derecho = rotarDerecha(nodo.derecho);
                nodo = rotarIzquierda(nodo);
            }
        }

        return nodo;
    }
}