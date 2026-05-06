public class Factura extends Documento implements Exportable, Auditable {

    @Override
    public void procesar() {
        System.out.println("Procesando factura...");
    }

    // Sobrecarga (NO override)
    public void procesar(boolean esUrgente) {
        if (esUrgente) {
            System.out.println("Procesando factura urgente...");
        } else {
            procesar();
        }
    }

    @Override
    public void exportar() {
        System.out.println("Exportando factura...");
    }

    @Override
    public void registrarAuditoria() {
        System.out.println("Registrando auditoría de factura...");
    }
}