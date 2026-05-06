public class Reporte {

    // Método sin retorno
    public void generarEncabezado() {
        System.out.println("=== REPORTE ===");
    }

    // Método con retorno
    public String obtenerCuerpo() {
        return "Contenido del reporte...";
    }

    // Método con argumentos variables
    public void agregarSecciones(String... secciones) {
        for (String s : secciones) {
            System.out.println("Sección: " + s);
        }
    }
}