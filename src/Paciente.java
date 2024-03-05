public class Paciente {
    String nombre;

    Paciente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
