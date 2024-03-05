import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner ingresoDeDatos = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Solicitar turno");
            System.out.println("2. Mostrar calendario de turnos");
            System.out.println("3. Salir");
            System.out.print("Ingrese su elección: ");

            int opcion = ingresoDeDatos.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    ingresoDeDatos.nextLine();  // Consumir el salto de línea pendiente
                    String nombrePaciente = ingresoDeDatos.nextLine();
                    String fechaHoraString = "";
                    while (true) {
                        System.out.print("Ingrese la fecha y hora del turno (DD/MM/AAAA HH:mm): ");
                        fechaHoraString = ingresoDeDatos.nextLine();
                        if (esValidoFormato(fechaHoraString)) {
                            break;
                        }
                    }
                    Paciente paciente = new Paciente(nombrePaciente);
                    hospital.solicitarTurno(paciente, fechaHoraString);
                    break;
                case 2:
                    hospital.mostrarCalendario();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static boolean esValidoFormato(String fechaHoraString) {
        return fechaHoraString.matches("^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(\\d{4}) (?:[01]\\d|2[0-3]):[0-5]\\d$");
    }

}


