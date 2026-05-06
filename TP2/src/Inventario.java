import java.util.*;

public class Inventario {

    // Lista de productos
    private List<Producto> productos = new ArrayList<>();

    // Set para evitar duplicados de nombres
    private Set<String> nombresUnicos = new HashSet<>();

    // Mapa nombre -> producto
    private Map<String, Producto> mapaProductos = new HashMap<>();

    public void agregarProducto(Producto p) {
        if (nombresUnicos.add(p.getNombre())) {
            productos.add(p);
            mapaProductos.put(p.getNombre(), p);
        } else {
            System.out.println("Producto duplicado: " + p.getNombre());
        }
    }

    public void mostrarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public Producto buscarPorNombre(String nombre) {
        return mapaProductos.get(nombre);
    }

    public void eliminarProducto(String nombre) {
        Producto p = mapaProductos.remove(nombre);
        if (p != null) {
            productos.remove(p);
            nombresUnicos.remove(nombre);
        }
    }
}