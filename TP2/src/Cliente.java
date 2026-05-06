import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<Producto> compras = new ArrayList<>();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void comprar(Producto p) {
        compras.add(p);
    }

    public void mostrarCompras() {
        System.out.println("Compras de " + nombre + ":");
        for (Producto p : compras) {
            System.out.println(p);
        }
    }
}