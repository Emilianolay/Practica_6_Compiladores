import java.util.*;

public class TablaPrimeroSiguiente {
    Map<String, Set<String>> primeros = new LinkedHashMap<>();
    Map<String, Set<String>> siguientes = new LinkedHashMap<>();

    public void calcular() {

        // Primeros calculados a mano segun la gramatica
        primeros.put("S", new HashSet<>(Arrays.asList("p", "s", "v")));
        primeros.put("M", new HashSet<>(Arrays.asList("p", "s", "v")));
        primeros.put("P", new HashSet<>(Arrays.asList("Str")));
        primeros.put("C", new HashSet<>(Arrays.asList("{")));
        primeros.put("D", new HashSet<>(Arrays.asList("t")));

        // Siguientes calculados a mano
        siguientes.put("S", new HashSet<>(Arrays.asList("$")));
        siguientes.put("M", new HashSet<>(Arrays.asList("(")));
        siguientes.put("P", new HashSet<>(Arrays.asList(")")));
        siguientes.put("C", new HashSet<>(Arrays.asList("$")));
        siguientes.put("D", new HashSet<>(Arrays.asList("}")));
    }

    public void imprimir() {
        System.out.println("--- CONJUNTOS PRIMERO ---");
        for (String nt : primeros.keySet()) {
            System.out.println("PRIMERO(" + nt + ") = " + primeros.get(nt));
        }
        System.out.println("\n--- CONJUNTOS SIGUIENTE ---");
        for (String nt : siguientes.keySet()) {
            System.out.println("SIGUIENTE(" + nt + ") = " + siguientes.get(nt));
        }
        System.out.println();
    }
}
