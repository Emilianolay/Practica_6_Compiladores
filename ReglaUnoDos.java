public class ReglaUnoDos {

    public void verificar() {
        System.out.println("--- COMPROBANDO REGLAS UNO Y DOS ---");
        System.out.println("Actividad 1: Reglas UNO y DOS para M (las demas tienen 1 sola produccion)");
        System.out.println("Producciones de M:");
        System.out.println("1) M -> p s v m   => PRIMERO(1) = {p}");
        System.out.println("2) M -> s v m     => PRIMERO(2) = {s}");
        System.out.println("3) M -> v m       => PRIMERO(3) = {v}");
        System.out.println("Interseccion de primeros: {p} U {s} U {v} = Vacio (Disjuntos)");
        System.out.println("CONCLUSION: Se cumple la REGLA 1 (No hay problemas de prefijos comunes ni recursividad izquierda para M).");
        System.out.println("La REGLA 2 se cumple de facto porque ninguna produccion deriva en epsilon (vacio).");
        System.out.println("Por lo tanto, la gramatica es LL(1) y lista para la tabla.\n");
    }
}
