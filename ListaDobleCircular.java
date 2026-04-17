public class ListaDobleCircular {

    Nodo head;

    public ListaDobleCircular() {
        this.head = null;
    }

    // ─────────────────────────────────────────
    // 6.1 Insertar al Inicio 
    // ─────────────────────────────────────────
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (head == null) {
            // Lista vacía: el nodo se apunta a sí mismo
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior  = nuevoNodo;
            head = nuevoNodo;
        } else {
            Nodo ultimo = head.anterior;   // último nodo de la lista

            nuevoNodo.siguiente = head;
            nuevoNodo.anterior  = ultimo;
            ultimo.siguiente    = nuevoNodo;
            head.anterior       = nuevoNodo;
            head                = nuevoNodo; // nuevo nodo pasa a ser la cabeza
        }

        System.out.println("✔ Insertado " + dato + " al inicio.");
    }

    // ─────────────────────────────────────────
    // 6.2 Insertar al Final 
    // ─────────────────────────────────────────
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (head == null) {
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior  = nuevoNodo;
            head = nuevoNodo;
        } else {
            Nodo ultimo = head.anterior;   // último nodo actual

            nuevoNodo.siguiente = head;
            nuevoNodo.anterior  = ultimo;
            ultimo.siguiente    = nuevoNodo;
            head.anterior       = nuevoNodo;
            // head NO se modifica
        }

        System.out.println("✔ Insertado " + dato + " al final.");
    }

    // ─────────────────────────────────────────
    // 6.3 Eliminar al Inicio 
    // ─────────────────────────────────────────
    public void eliminarAlInicio() {
        if (head == null) {
            System.out.println("✖ Error: la lista está vacía.");
            return;
        }

        if (head.siguiente == head) {
            // Un solo nodo
            System.out.println("✔ Eliminado " + head.dato + " del inicio.");
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            System.out.println("✔ Eliminado " + head.dato + " del inicio.");
            head          = head.siguiente;
            head.anterior = ultimo;
            ultimo.siguiente = head;
        }
    }

    // ─────────────────────────────────────────
    // 6.4 Eliminar al Final 
    // ─────────────────────────────────────────
    public void eliminarAlFinal() {
        if (head == null) {
            System.out.println("✖ Error: la lista está vacía.");
            return;
        }

        if (head.siguiente == head) {
            // Un solo nodo
            System.out.println("✔ Eliminado " + head.dato + " del final.");
            head = null;
        } else {
            Nodo ultimo    = head.anterior;
            Nodo penultimo = ultimo.anterior;
            System.out.println("✔ Eliminado " + ultimo.dato + " del final.");
            penultimo.siguiente = head;
            head.anterior       = penultimo;
        }
    }

    // ─────────────────────────────────────────
    // 6.5 Buscar un Elemento
    // ─────────────────────────────────────────
    public boolean buscar(int valor) {
        if (head == null) {
            System.out.println("✖ Lista vacía. No se puede buscar.");
            return false;
        }

        Nodo actual     = head;
        boolean encontrado = false;

        do {
            if (actual.dato == valor) {
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        } while (actual != head);

        if (encontrado) {
            System.out.println("✔ Elemento " + valor + " ENCONTRADO en la lista.");
        } else {
            System.out.println("✖ Elemento " + valor + " NO encontrado en la lista.");
        }

        return encontrado;
    }

    // ─────────────────────────────────────────
    // 6.6 Imprimir / Recorrer la Lista 
    // ─────────────────────────────────────────
    public void imprimir() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = head;
        System.out.print("Lista: ");
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != head);
        System.out.println("(circular -> " + head.dato + ")");
    }
}
