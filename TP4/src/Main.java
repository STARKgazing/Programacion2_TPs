import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    // Ejercicio 2.1 y 2.2
    public static void registrarUsuario(String nombre, int edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }

        System.out.println("Usuario registrado: " + nombre);
    }

    // Ejercicio 1.2
    public static void divisionConFinally() {
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Limpieza final");
        }
    }

    public static void main(String[] args) {

        // 1.1 NumberFormatException
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Tipo: " + e.getClass().getName());
        }

        // 1.2 finally
        divisionConFinally();

        // 1.3 multi-catch
        try {
            String input = "0"; // prueba también con "abc"
            int num = Integer.parseInt(input);
            int resultado = 100 / num;
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Error de cálculo o conversión");
        }

        // 2.2 captura específica
        try {
            registrarUsuario("", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3.1 excepción checked
        CuentaBancaria cuenta = new CuentaBancaria(100);

        try {
            cuenta.retirar(200);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3.2 excepción unchecked
        try {
            Producto p = new Producto("Laptop", -10);
        } catch (ProductoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4.1 try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("personas.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}
