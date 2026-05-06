public class Main {

    public static void main(String[] args) {

        // 🔹 1.1 Thread
        TareaHilo h1 = new TareaHilo("Hilo 1");
        TareaHilo h2 = new TareaHilo("Hilo 2");

        h1.setPriority(1);
        h2.setPriority(10);

        h1.start();
        h2.start();

        // 🔹 1.2 Runnable
        TareaRunnable tarea = new TareaRunnable("Runnable");

        Thread t1 = new Thread(tarea);
        Thread t2 = new Thread(tarea);

        t1.start();
        t2.start();

        // 🔹 2.1 Race condition
        Contador contador = new Contador();

        Thread c1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador.incrementar(); // sin sync
            }
        });

        Thread c2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador.incrementar(); // sin sync
            }
        });

        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor sin sincronización: " + contador.getValor());

        // 🔹 3.1 Sincronización método
        Contador contador2 = new Contador();

        Thread s1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador2.incrementarSync();
            }
        });

        Thread s2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador2.incrementarSync();
            }
        });

        s1.start();
        s2.start();

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor sincronizado (método): " + contador2.getValor());

        // 🔹 3.2 Bloque sincronizado
        Contador contador3 = new Contador();

        Thread b1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador3.incrementarBloque();
            }
        });

        Thread b2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador3.incrementarBloque();
            }
        });

        b1.start();
        b2.start();

        try {
            b1.join();
            b2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor sincronizado (bloque): " + contador3.getValor());

        // 🔹 4.2 join + interrupt
        Thread largo = new Thread(() -> {
            try {
                System.out.println("Tarea larga iniciada...");
                Thread.sleep(5000);
                System.out.println("Tarea larga finalizada.");
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido!");
            }
        });

        largo.start();

        try {
            Thread.sleep(1000);
            largo.interrupt(); // prueba interrupción
            largo.join(); // espera
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main terminado.");
    }
}