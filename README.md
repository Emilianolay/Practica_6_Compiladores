Práctica 6 - Generador y Analizador de Tabla LL(1)

--Descripción de la Gramática
La gramática evaluada en esta práctica es la siguiente:

S -> M(P)C
M -> p s v m | s v m | v m
P -> Str [ ] args
C -> { D }
D -> t id ;

Contenido del Repositorio
El código está estructurado para la practica:
- DriverTLL1.java: Punto de entrada principal (el main).
- TLL1.java: Clase orquestadora que manda a llamar a todos los componentes.
- TablaPrimeroSiguiente.java: Calcula y almacena los conjuntos PRIMERO y SIGUIENTE de la gramática.
- ReglaUnoDos.java: Se encarga de comprobar analíticamente que la gramática cumple la Regla 1 (Primeros disjuntos) y la Regla 2 (Transiciones Epsilon) para ser LL(1).
- ConstruccionTablaLL1.java: Construye y formatea en consola la matriz LL(1) a partir de las reglas.
- AnalizadorLL1.java: Analizador sintáctico descendente predictivo que utiliza una Pila y la tabla LL(1) para evaluar paso a paso si la cadena de entrada `psvm(Str[] args){int c;}` es válida.

--Instrucciones de Compilación y Ejecución

1. Abrir CMD.
2. Navegar hasta la carpeta donde estan los archivos.
3. Compila todos los archivos Java ejecutando el siguiente comando:
   javac *.java
4. Una vez compilado, ejecuta la clase principal con:
   java DriverTLL1
Asi se compilara todo. y listooooo
