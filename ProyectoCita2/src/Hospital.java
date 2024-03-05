import CalendarioPaquete.Año;
import CalendarioPaquete.Calendario;

import java.util.ArrayList;

public class Hospital {
    ArrayList<Turno> listaTurnos = new ArrayList<>();
    Calendario calendario = new Calendario();

    void solicitarTurno(Paciente paciente, String fechaHora) {
        Turno turno = new Turno(paciente, fechaHora);
        String[] fechaYHora = dividirFechaHora(fechaHora);
        String[] fecha = obtenerFecha(fechaYHora[0]);
        String[] hora = obtenerHora(fechaYHora[1]);
        listaTurnos.add(turno);
        calendario.añadirTurno(new Año(fecha[2]), fecha[0], fecha[1], hora, paciente.nombre);
        System.out.println("Turno asignado: " + turno);
    }

    public String[] dividirFechaHora(String fechaHora) {
        return fechaHora.split(" ");
    }

    private String[] obtenerHora(String horaUnida) {
        return horaUnida.split(":");
    }

    private String[] obtenerFecha(String fechaUnida) {
        return fechaUnida.split("/");
    }

    void mostrarCalendario() {
        calendario.mostrarCalendario();

    }
}
