public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        if (precio <= 0) {
            throw new ProductoInvalidoException("El precio no puede ser <= 0");
        }
        this.nombre = nombre;
        this.precio = precio;
    }
}