public class Main {

    public static void main(String[] args) {

        Inventario inv = new Inventario();

        Producto p1 = new Producto("Teclado", 100);
        Producto p2 = new Producto("Mouse", 50);
        Producto p3 = new Producto("Monitor", 300);
        Producto p4 = new Producto("Mouse", 60); // duplicado

        inv.agregarProducto(p1);
        inv.agregarProducto(p2);
        inv.agregarProducto(p3);
        inv.agregarProducto(p4); // debería rechazar

        System.out.println("\nInventario:");
        inv.mostrarProductos();

        System.out.println("\nBuscar producto:");
        System.out.println(inv.buscarPorNombre("Mouse"));

        inv.eliminarProducto("Mouse");

        System.out.println("\nInventario después de eliminar:");
        inv.mostrarProductos();

        // Cliente
        Cliente c = new Cliente("Storm");
        c.comprar(p1);
        c.comprar(p3);

        System.out.println();
        c.mostrarCompras();
    }
}