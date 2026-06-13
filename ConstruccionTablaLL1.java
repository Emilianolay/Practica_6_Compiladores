import java.util.*;

public class ConstruccionTablaLL1 {
    private String[][] matriz;
    private List<String> noTerminales = Arrays.asList("S", "M", "P", "C", "D");
    private List<String> terminales = Arrays.asList(
        "p", "s", "v", "m", "(", ")", "Str", "[", "]", "args", "{", "}", "t", "id", ";", "$"
    );

    public ConstruccionTablaLL1() {
        matriz = new String[noTerminales.size()][terminales.size()];
    }

    public void construir() {
        System.out.println("--- CONSTRUYENDO TABLA LL(1) ---");
        // Inicializar matriz con vacios
        for(int i=0; i<noTerminales.size(); i++){
            for(int j=0; j<terminales.size(); j++){
                matriz[i][j] = "";
            }
        }

        // --- Llenar tabla iterativamente en base a las reglas LL(1) ---
        // S -> M ( P ) C (Los primeros de S son p, s, v)
        ponerEnMatriz("S", "p", "S->M(P)C");
        ponerEnMatriz("S", "s", "S->M(P)C");
        ponerEnMatriz("S", "v", "S->M(P)C");

        // M -> p s v m | s v m | v m
        ponerEnMatriz("M", "p", "M->psvm");
        ponerEnMatriz("M", "s", "M->svm");
        ponerEnMatriz("M", "v", "M->vm");

        // P -> Str [ ] args
        ponerEnMatriz("P", "Str", "P->Str[]args");

        // C -> { D }
        ponerEnMatriz("C", "{", "C->{D}");

        // D -> t id ;
        ponerEnMatriz("D", "t", "D->tid;");
    }

    private void ponerEnMatriz(String nt, String t, String prod) {
        int fila = noTerminales.indexOf(nt);
        int col = terminales.indexOf(t);
        if (fila != -1 && col != -1) {
            matriz[fila][col] = prod;
        }
    }

    public String getProduccion(String nt, String t) {
        int fila = noTerminales.indexOf(nt);
        int col = terminales.indexOf(t);
        if (fila != -1 && col != -1) {
            return matriz[fila][col];
        }
        return "";
    }

    public void imprimir() {
        System.out.print(String.format("%-3s", "N.T") + "|");
        for (String t : terminales) {
            System.out.print(String.format("%-12s", t) + "|");
        }
        System.out.println("\n" + "-".repeat(13*terminales.size() + 5));

        for (int i = 0; i < noTerminales.size(); i++) {
            System.out.print(String.format("%-3s", noTerminales.get(i)) + "|");
            for (int j = 0; j < terminales.size(); j++) {
                System.out.print(String.format("%-12s", matriz[i][j]) + "|");
            }
            System.out.println();
        }
        System.out.println();
    }
}
