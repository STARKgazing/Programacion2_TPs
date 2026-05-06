/**
 * Clase SistemaGestor
 * --------------------
 * Esta clase representa un sistema gestor básico.
 * Se utiliza para demostrar:
 * - Uso de comentarios (// para una línea)
 * - Uso de comentarios de múltiples líneas
 * - Uso de comentarios de documentación (Javadoc)
 */
public class SistemaGestor {

    /*
     * BLOQUE DE CONFIGURACIÓN
     * ------------------------
     * Aquí se definen parámetros generales del sistema.
     * Estos valores suelen ser constantes que no cambian durante la ejecución.
     */

    // Constante que define el máximo de conexiones permitidas
    public static final int MAX_CONEXIONES = 10;

    public static void main(String[] args) {

        // Variable local para pruebas
        int conexionesActuales = 5;

        // Mostrar el valor de la constante
        mostrarMaxConexiones();

        // Crear una cuenta bancaria y probar encapsulación
        CuentaBancaria cuenta = new CuentaBancaria("12345", 1000.0);

        // Intento de depósito válido
        cuenta.depositar(500);

        // Intento de depósito inválido
        cuenta.depositar(-200);

        // Mostrar saldo final
        System.out.println("Saldo actual: " + cuenta.getSaldo());
    }

    /**
     * Método que imprime el valor de MAX_CONEXIONES
     */
    public static void mostrarMaxConexiones() {
        System.out.println("Máximo de conexiones: " + MAX_CONEXIONES);

        // MAX_CONEXIONES pertenece a la clase (static),
        // no a una instancia específica de SistemaGestor.

        // Además, es final, por lo que su valor no puede cambiar:
        // MAX_CONEXIONES = 20; // ❌ Esto daría error de compilación
    }
}

/**
 * Clase CuentaBancaria
 * ---------------------
 * Ejemplo de encapsulación:
 * - Los atributos son privados
 * - El acceso se controla mediante métodos públicos
 */
class CuentaBancaria {

    // Atributos privados (no accesibles directamente desde otras clases)
    private double saldo;
    private String numeroCuenta;

    /**
     * Constructor de la cuenta bancaria
     */
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    /**
     * Método para depositar dinero
     * Valida que el monto sea positivo
     */
    public void depositar(double monto) {

        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso: " + monto);
        } else {
            System.out.println("Error: no se pueden depositar montos negativos");
        }
    }

    /**
     * Método getter para consultar el saldo
     */
    public double getSaldo() {
        return saldo;
    }
}
