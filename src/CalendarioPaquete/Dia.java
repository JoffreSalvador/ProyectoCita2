package CalendarioPaquete;

import java.util.Arrays;

public class Dia {
    private int numeroDia;
    private String nombre;
    private String[] hora;
    private String nombrePaciente;
    private String color;

    public Dia(int numeroDia, String nombre, String[] hora, String nombrePaciente) {
        this.numeroDia = numeroDia;
        this.nombre = nombre;
        this.hora = hora;
        this.nombrePaciente = nombrePaciente;
        this.color = "";
    }

    public int getValor() {
        return this.numeroDia;
    }

    public void setColor(String rojo) {
        this.color = rojo;
    }

    public String getColor() {
        return this.color;
    }

    public void setHora(String[] hora) {
        this.hora = hora;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public String toString() {
        return "Este dia esta agendado para {" +
                nombrePaciente +
                ", a la hora de " + Arrays.toString(hora) + '\'' +
                '}';
    }
}
