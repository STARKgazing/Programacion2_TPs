import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<Producto> productos = Arrays.asList(
            new Producto("Teclado", 100, "Tecnologia"),
            new Producto("Mouse", 50, "Tecnologia"),
            new Producto("Monitor", 300, "Tecnologia"),
            new Producto("Silla", 150, "Hogar"),
            new Producto("Mesa", 200, "Hogar")
        );

        // 1. Filtrar productos caros (>100)
        System.out.println("Productos caros:");
        productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .forEach(System.out::println);

        // 2. Mapear nombres
        System.out.println("\nNombres de productos:");
        List<String> nombres = productos.stream()
                .map(Producto::getNombre)
                .collect(Collectors.toList());
        nombres.forEach(System.out::println);

        // 3. Suma total (reduce)
        double total = productos.stream()
                .map(Producto::getPrecio)
                .reduce(0.0, Double::sum);

        System.out.println("\nTotal precios: " + total);

        // 4. Buscar un producto (Optional)
        Optional<Producto> encontrado = productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase("Mouse"))
                .findFirst();

        encontrado.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No encontrado")
        );

        // 5. Agrupar por categoría
        Map<String, List<Producto>> agrupados = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

        System.out.println("\nAgrupados:");
        agrupados.forEach((cat, lista) -> {
            System.out.println(cat + ":");
            lista.forEach(System.out::println);
        });

        // 6. Ordenar por precio
        System.out.println("\nOrdenados por precio:");
        productos.stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .forEach(System.out::println);
    }
}