public class Contador {

    private int valor = 0;

    // ❌ Versión SIN sincronización (produce error)
    public void incrementar() {
        valor++;
    }

    // ✔ Versión sincronizada (Ejercicio 3.1)
    public synchronized void incrementarSync() {
        valor++;
    }

    // ✔ Bloque sincronizado (Ejercicio 3.2)
    public void incrementarBloque() {
        synchronized (this) {
            valor++;
        }
    }

    public int getValor() {
        return valor;
    }
}