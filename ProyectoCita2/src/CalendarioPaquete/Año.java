package CalendarioPaquete;

import java.util.Scanner;

public class Año {
    private String añoNumero;
    private Mes[] meses;

    public Año(String añoNumero) {
        this.añoNumero = añoNumero;
        this.meses = new Mes[12];
        meses[0] = new Mes("Enero");
        meses[1] = new Mes("Febrero");
        meses[2] = new Mes("Marzo");
        meses[3] = new Mes("Abril");
        meses[4] = new Mes("Mayo");
        meses[5] = new Mes("Junio");
        meses[6] = new Mes("Julio");
        meses[7] = new Mes("Agosto");
        meses[8] = new Mes("Septiembre");
        meses[9] = new Mes("Octubre");
        meses[10] = new Mes("Noviembre");
        meses[11] = new Mes("Diciembre");
    }

    public void mostrarAño(Scanner ingresoDatos) {
        int añoNumeroInt = Integer.parseInt(this.añoNumero);
        for (int i = 0; i < meses.length; i++) {
            meses[i].mostrarMes(añoNumeroInt, (i + 1));
        }
        System.out.println("Desea ver los recordatorios de este año (Si o No): ");
        String respuesta = ingresoDatos.next();
        if (respuesta.toLowerCase().equals("si")){
            mostrarRecordatorios();
        }

    }

    public void mostrarRecordatorios() {
        for (Mes mes : meses) {
            if(mes.getMesConRecordatorio()){
                mes.mostrarRecordatorios();
            }
        }
    }

    public boolean esBisiesto(int año) {
        if (año % 4 == 0) {
            if (año % 100 == 0) {
                if (año % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public void crearRecordatorio(String diaNumero, String mesNumero, String[] hora, String nombrePaciente) {
        int diaNumeroInt = (Integer.parseInt(mesNumero) - 1);
        this.meses[diaNumeroInt].crearRecordatorio(diaNumero, hora, nombrePaciente);


    }

    public void asignarAño() {
        int añoNumeroInt = Integer.parseInt(this.añoNumero);
        for (int i = 0; i < meses.length; i++) {
            meses[i].asignarDiasAlMes(esBisiesto(añoNumeroInt), (i + 1), añoNumeroInt);
        }
    }

    public int getAñoNumero() {
        return Integer.parseInt(this.añoNumero);
    }

}
