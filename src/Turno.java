public class Turno {
    Paciente paciente;
    String fechaHora;

    Turno(Paciente paciente, String fechaHora) {
        this.paciente = paciente;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Turno [Paciente: " + paciente + ", Fecha y Hora: " + fechaHora + "]";
    }
}
