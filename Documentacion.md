# Lista Doblemente Enlazada Circular — Documentación

## Descripción General

Este proyecto implementa una **lista doblemente enlazada circular** en Java. En esta estructura, cada nodo tiene referencia al nodo anterior y al siguiente, y el último nodo se conecta de vuelta al primero formando un ciclo. Esto permite recorrer la lista en ambas direcciones sin encontrar un final.

El proyecto se divide en tres clases: `Nodo`, `ListaDobleCircular` y `Main`.

---

## Clase `Nodo`

### ¿Qué hace?

Representa la unidad mínima de la lista. Cada nodo almacena:

- `dato` (int): el valor entero que guarda el nodo.
- `anterior` (Nodo): referencia al nodo previo en la lista.
- `siguiente` (Nodo): referencia al nodo que le sigue.

### ¿Cómo se hizo?

Se definió una clase simple con tres atributos y un constructor que recibe el valor entero. Las referencias `anterior` y `siguiente` se inicializan en `null` porque al momento de crear el nodo aún no está enlazado a ninguna lista.

```java
public Nodo(int dato) {
    this.dato = dato;
    this.anterior = null;
    this.siguiente = null;
}
```

### ¿Por qué?

Separar el nodo en su propia clase respeta el principio de responsabilidad única: el nodo solo se encarga de almacenar un dato y sus enlaces. Esto mantiene el código limpio y permite que `ListaDobleCircular` se enfoque exclusivamente en la lógica de la estructura.

---

## Clase `ListaDobleCircular`

### ¿Qué hace?

Contiene toda la lógica de la lista doblemente enlazada circular. Expone las siguientes operaciones:

| Método | Descripción |
|---|---|
| `insertarAlInicio(int dato)` | Agrega un nodo al principio de la lista. |
| `insertarAlFinal(int dato)` | Agrega un nodo al final de la lista. |
| `eliminarAlInicio()` | Elimina el primer nodo de la lista. |
| `eliminarAlFinal()` | Elimina el último nodo de la lista. |
| `buscar(int valor)` | Busca un valor y retorna `true` si existe, `false` si no. |
| `imprimir()` | Recorre e imprime todos los elementos de la lista. |

### ¿Cómo se hizo?

La clase mantiene una única referencia: `head` (la cabeza de la lista). Gracias a la naturaleza circular, el último nodo siempre es `head.anterior`, lo que permite acceder al final en O(1) sin recorrer toda la lista.

#### Insertar al inicio

1. Se crea un nuevo nodo.
2. Si la lista está vacía, el nodo se apunta a sí mismo en ambas direcciones y pasa a ser `head`.
3. Si no, se enlaza entre el último nodo (`head.anterior`) y la cabeza actual, luego `head` se actualiza al nuevo nodo.

#### Insertar al final

Funciona igual que insertar al inicio, con la diferencia clave de que `head` no se modifica. El nuevo nodo queda entre el último actual y `head`, convirtiéndose en el nuevo último.

#### Eliminar al inicio

1. Si hay un solo nodo, `head` se vuelve `null`.
2. Si hay más, `head` avanza al siguiente nodo y se re-enlazan las referencias con el último para mantener la circularidad.

#### Eliminar al final

1. Si hay un solo nodo, `head` se vuelve `null`.
2. Si hay más, se obtiene el penúltimo nodo (`ultimo.anterior`) y se re-enlaza directamente con `head`.

#### Buscar

Recorre la lista con un ciclo `do-while` desde `head` hasta volver a `head`, comparando cada `dato` con el valor buscado. Retorna `true` si lo encuentra.

#### Imprimir

Recorre la lista de la misma forma, imprimiendo cada dato con el formato `dato <-> ` e indica al final que es circular mostrando la referencia de vuelta a `head`.

### ¿Por qué?

- Usar `head.anterior` para acceder al último nodo en O(1) es una de las ventajas principales de la lista doblemente enlazada circular frente a una lista simplemente enlazada.
- El ciclo `do-while` es la forma natural de recorrer una lista circular: se ejecuta al menos una vez y se detiene al volver al punto de partida.
- Cada método imprime un mensaje de confirmación para dar retroalimentación inmediata al usuario desde consola.

---

## Clase `Main`

### ¿Qué hace?

Es el punto de entrada del programa. Presenta un menú interactivo en consola que permite al usuario ejecutar todas las operaciones de la lista.

### ¿Cómo se hizo?

Se implementó un ciclo `do-while` que muestra las 7 opciones del menú y lee la selección del usuario con `Scanner`. Un `switch` dirige la ejecución al método correspondiente de `ListaDobleCircular`. El ciclo se repite hasta que el usuario elige la opción 7 (Salir).

```
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
```

### ¿Por qué?

- Separar la interfaz de usuario (`Main`) de la lógica de datos (`ListaDobleCircular`) permite que la estructura sea reutilizable en otros contextos sin depender de la consola.
- El menú con `do-while` + `switch` es un patrón clásico y directo para aplicaciones de consola en Java, fácil de entender y mantener.
- Se usa `Scanner` por ser la forma estándar de leer entrada del usuario en Java.

---

## Resumen de la Arquitectura

```
Main (interfaz de usuario)
  └── ListaDobleCircular (lógica de la estructura)
        └── Nodo (unidad de almacenamiento)
```

Tres clases, cada una con una responsabilidad clara: almacenar datos, manipular la estructura e interactuar con el usuario.
