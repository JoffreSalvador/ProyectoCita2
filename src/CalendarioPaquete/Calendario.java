package CalendarioPaquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Calendario {

    private ArrayList<Año> años;

    public Calendario() {
        this.años = new ArrayList<>();

    }

    public void añadirTurno(Año año, String diaNumero, String mesNumero, String[] hora, String nombrePaciente) {
        if (this.años.size() == 0) {
            crearCalendario(año);
        }
        for (Año año1 : this.años){
            if (año1.getAñoNumero() != año.getAñoNumero()){
                crearCalendario(año);
                break;
            }
        }
        for (Año año2 : this.años) {
            if (año2.getAñoNumero() == año.getAñoNumero()) {
                año2.crearRecordatorio(diaNumero, mesNumero, hora, nombrePaciente);
            }
        }
    }

    public void crearCalendario(Año año) {
        this.años.add(año);
        for (Año año1 : this.años) {
            if(año1.getAñoNumero() == año.getAñoNumero()){
                año1.asignarAño();
            }
        }
    }

    public void mostrarCalendario() {
        mostrarAñoDelCalendario();
    }

    private void mostrarAñoDelCalendario() {
        Scanner ingresoDatos = new Scanner(System.in);
        if (this.años.size() > 1) {
            System.out.println("¿Qué año quiere imprimir?");
            for (Año año1 : this.años) {
                System.out.println(año1.getAñoNumero());
            }
            int añoAImprimir = ingresoDatos.nextInt();
            for (Año año2 : this.años) {
                if(añoAImprimir == año2.getAñoNumero()){
                    año2.mostrarAño(ingresoDatos);
                }
            }
        }else {
            for (Año año3 : this.años) {
                año3.mostrarAño(ingresoDatos);
            }
        }
    }


}


