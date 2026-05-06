public class Main {

    public static void enviarAImpresion(Exportable doc) {
        doc.exportar();
    }

    public static void main(String[] args) {

        // SistemaGestor
        SistemaGestor.mostrarMaxConexiones();

        // CuentaBancaria
        CuentaBancaria cuenta = new CuentaBancaria("123", 1000);
        cuenta.depositar(500);
        System.out.println("Saldo: " + cuenta.getSaldo());

        // Reporte
        Reporte rep = new Reporte();
        rep.generarEncabezado();
        System.out.println(rep.obtenerCuerpo());
        rep.agregarSecciones("Intro", "Datos", "Conclusión");
        rep.agregarSecciones(); // sin argumentos

        // Usuario
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario("Storm");
        Usuario u3 = new Usuario("Storm", 20);

        u3.actualizarPerfil("mail@test.com");
        u3.actualizarPerfil("mail@test.com", 123456);

        // Polimorfismo
        Documento doc1 = new Factura();
        Documento doc2 = new Recibo();

        doc1.procesar();
        doc2.procesar();

        // Sobrecarga en hijo
        Factura f = new Factura();
        f.procesar(true);

        // Interfaces
        enviarAImpresion(f);

        f.registrarAuditoria();
    }
}