import java.util.*;

public class AnalizadorLL1 {
    private ConstruccionTablaLL1 tabla;

    public AnalizadorLL1(ConstruccionTablaLL1 tabla) {
        this.tabla = tabla;
    }

    public void analizar(List<String> entrada) {
        System.out.println("--- ANALISIS DE LA CADENA (Cuestionario Pregunta 2) ---");
        System.out.println("Cadena original: psvm(Str[] args){int c;}");
        System.out.println("Tokens mapeados: " + String.join(" ", entrada));
        System.out.println();
        
        Stack<String> pila = new Stack<>();
        pila.push("$");
        pila.push("S");
        
        int indiceEntrada = 0;
        
        System.out.println(String.format("%-45s | %-45s | %s", "PILA", "ENTRADA", "ACCION"));
        System.out.println("-".repeat(110));

        while (!pila.isEmpty()) {
            String X = pila.peek();
            String a = entrada.get(indiceEntrada);
            
            // Construir representacion de pila (de fondo a tope)
            List<String> pilaList = new ArrayList<>(pila);
            String pilaStr = String.join(" ", pilaList);
            
            String entradaStr = String.join(" ", entrada.subList(indiceEntrada, entrada.size()));
            
            if (X.equals(a)) {
                if (X.equals("$")) {
                    System.out.println(String.format("%-45s | %-45s | %s", pilaStr, entradaStr, "ACEPTAR (Analisis Exitoso)"));
                    break;
                } else {
                    System.out.println(String.format("%-45s | %-45s | %s", pilaStr, entradaStr, "Coincide " + a));
                    pila.pop();
                    indiceEntrada++;
                }
            } else if (!esNoTerminal(X)) {
                System.out.println(String.format("%-45s | %-45s | %s", pilaStr, entradaStr, "ERROR: Se esperaba " + a + " pero hay " + X));
                break;
            } else {
                String produccion = tabla.getProduccion(X, a);
                if (produccion == null || produccion.isEmpty()) {
                    System.out.println(String.format("%-45s | %-45s | %s", pilaStr, entradaStr, "ERROR: M[" + X + ", " + a + "] esta vacia"));
                    break;
                } else {
                    System.out.println(String.format("%-45s | %-45s | %s", pilaStr, entradaStr, produccion));
                    pila.pop();
                    List<String> simbolos = obtenerSimbolos(produccion);
                    // Insertar en la pila en orden inverso
                    for (int i = simbolos.size() - 1; i >= 0; i--) {
                        pila.push(simbolos.get(i));
                    }
                }
            }
        }
        System.out.println();
    }

    private boolean esNoTerminal(String X) {
        return Arrays.asList("S", "M", "P", "C", "D").contains(X);
    }

    private List<String> obtenerSimbolos(String produccion) {
        switch (produccion) {
            case "S->M(P)C": return Arrays.asList("M", "(", "P", ")", "C");
            case "M->psvm": return Arrays.asList("p", "s", "v", "m");
            case "M->svm": return Arrays.asList("s", "v", "m");
            case "M->vm": return Arrays.asList("v", "m");
            case "P->Str[]args": return Arrays.asList("Str", "[", "]", "args");
            case "C->{D}": return Arrays.asList("{", "D", "}");
            case "D->tid;": return Arrays.asList("t", "id", ";");
            default: return new ArrayList<>();
        }
    }
}
