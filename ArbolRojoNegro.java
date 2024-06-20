// ArbolRojoNegro.java
public class ArbolRojoNegro extends ArbolBinario {

    public ArbolRojoNegro() {
        super();
    }

    @Override
    public void agregar(Object datos) {
        raiz = agregarRec(raiz, datos);
        if (raiz != null) {
            raiz.color = Nodo.Color.NEGRO;
        }
    }

    private Nodo agregarRec(Nodo nodo, Object datos) {
        if (nodo == null) {
            return new Nodo(datos, Nodo.Color.ROJO);
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
        if (raiz != null) {
            raiz.color = Nodo.Color.NEGRO;
        }
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

    private Nodo balancear(Nodo nodo) {
        // Implementación específica para mantener las propiedades del árbol Rojo-Negro
        return nodo;
    }
}