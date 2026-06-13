import java.util.Arrays;

public class TLL1 {
    public void ejecutarTodo() {
        System.out.println("=== INICIO DEL PROCESO DE TABLA LL(1) ===\n");
        
        TablaPrimeroSiguiente tablaPS = new TablaPrimeroSiguiente();
        tablaPS.calcular();
        tablaPS.imprimir();
        
        ReglaUnoDos regla12 = new ReglaUnoDos();
        regla12.verificar();
        
        ConstruccionTablaLL1 tablaLL1 = new ConstruccionTablaLL1();
        tablaLL1.construir();
        tablaLL1.imprimir();
        
        AnalizadorLL1 analizador = new AnalizadorLL1(tablaLL1);
        analizador.analizar(Arrays.asList("p", "s", "v", "m", "(", "Str", "[", "]", "args", ")", "{", "t", "id", ";", "}", "$"));
    }
}
