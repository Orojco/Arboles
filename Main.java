// Main.java
public class Main {
    public static void main(String[] args) {
        // Prueba de ListaEnlazada
        ListaEnlazada listaEnlazada = new ListaEnlazada();
        listaEnlazada.agregar("Elemento 1");
        listaEnlazada.agregar("Elemento 2");
        listaEnlazada.insertar("Elemento 3");
        listaEnlazada.eliminar("Elemento 2");

        System.out.println("Lista Enlazada:");
        Nodo temp = listaEnlazada.cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();

        // Prueba de ArbolBinario
        ArbolBinario arbolBinario = new ArbolBinario();
        arbolBinario.agregar("Elemento A");
        arbolBinario.agregar("Elemento B");
        arbolBinario.agregar("Elemento C");

        System.out.println("Recorrido inOrden del Árbol Binario:");
        arbolBinario.inOrden(arbolBinario.raiz);
        System.out.println();
    }
}
