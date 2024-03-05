package CalendarioPaquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Mes {
    private String ROJO = "\u001B[31m";
    private String nombreMes;
    private ArrayList<Dia> dias;
    private Boolean mesConRecordatorios;

    public Mes(String nombreMes) {
        this.nombreMes = nombreMes;
        this.dias = new ArrayList<>();
        this.mesConRecordatorios = false;


    }

    public int diasMes(int mesNumero, boolean esBisiesto) {
        if (mesNumero == 1 || mesNumero == 3 || mesNumero == 5 || mesNumero == 7 || mesNumero == 8 || mesNumero == 10 || mesNumero == 12) {
            return 31;
        } else if (mesNumero == 2) {
            if (esBisiesto) {
                return 29;
            }
            return 28;
        } else {
            return 30;
        }
    }

    public int funcionZeller(int añoNumero, int mesNumero) {
        int a = (14 - mesNumero) / 12;
        int y = añoNumero - a;
        int m = mesNumero + 12 * a - 2;
        int dia = 0;
        return ((dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7);
    }

    public void mostrarMes(int añoNumero, int mesNumero) {
        System.out.println("\nMes: " + getNombre());
        System.out.println("Lun\tMar\tMie\tJue\tVie\tSab\tDom\t");
        int espacioEnBlanco = funcionZeller(añoNumero, mesNumero);
        int contadorDias = 0;
        for (int i = 0; i < espacioEnBlanco; i++) {
            contadorDias++;
            System.out.print("\t");
        }
        imprimirDias(contadorDias);
    }

    public void asignarDiasAlMes(boolean esBisiesto, int mesNumero, int añoNumero) {
        int espacioEnBlanco = funcionZeller(añoNumero, mesNumero);
        int diasTotalesDelMes = diasMes(mesNumero, esBisiesto);
        int posicionDias = espacioEnBlanco;
        for (int j = 1; j <= diasTotalesDelMes; j++) {
            if (posicionDias > 6) {
                posicionDias = 0;
            }
            this.dias.add(new Dia(j, obtenerNombreDia(posicionDias), new String[]{"",""}, ""));
            posicionDias++;

        }
    }

    public void imprimirDias(int contadorDias) {
        for (Dia dia : this.dias) {
            System.out.print(dia.getColor() + dia.getValor() + "\u001B[0m" + "\t");
            contadorDias++;
            if (contadorDias == 7) {
                System.out.println();
                contadorDias = 0;
            }
        }
    }

    public String obtenerNombreDia(int clave) {
        switch (clave) {
            case 0:
                return "Lunes";
            case 1:
                return "Martes";
            case 2:
                return "Miércoles";
            case 3:
                return "Jueves";
            case 4:
                return "Viernes";
            case 5:
                return "Sábado";
            case 6:
                return "Domingo";
            default:
                System.out.println("El número no existe");
                break;
        }
        return "";
    }

    public String getNombre() {
        return this.nombreMes;
    }

    public void crearRecordatorio(String diaNumero, String[] hora, String nombrePaciente) {
        int diaNumeroInt = Integer.parseInt(diaNumero);
        for (Dia dia : this.dias) {
            if (diaNumeroInt == dia.getValor()) {
                dia.setColor(ROJO);
                dia.setHora(hora);
                dia.setNombrePaciente(nombrePaciente);
            }
        }
        mesConRecordatorios = true;
    }
    public boolean getMesConRecordatorio (){
        return this.mesConRecordatorios;
    }

    public void mostrarRecordatorios() {
        Scanner ingresoDatos1 = new Scanner(System.in);
        System.out.println("Que dia quiere ver su contenido: ");
        for (Dia dia1 : this.dias) {
            if(dia1.getColor() == this.ROJO){
                System.out.println(dia1.getValor());
            }
        }
        int diaVerRecordatorio = ingresoDatos1.nextInt();
        for (Dia dia2 : this.dias) {
            if(dia2.getValor() == diaVerRecordatorio){
                System.out.println(dia2.toString());
            }
        }

    }
}
