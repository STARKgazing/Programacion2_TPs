public class Usuario {

    private String nombre;
    private int edad;
    private String correo;
    private int telefono;

    // Constructor por defecto
    public Usuario() {}

    // Constructor con nombre
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    // Constructor completo
    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrecarga de métodos
    public void actualizarPerfil(String correo) {
        this.correo = correo;
    }

    public void actualizarPerfil(String correo, int telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }
}