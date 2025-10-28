package cue.edu.co.patrones.comportamentales.command;

// Clase que realiza la acción real de dispensar
public class Dispensador {
    private double[] nivelesAlimento;
    private String[] tiposAlimento = {"Pienso", "Forraje", "Grano"};

    public Dispensador() {
        nivelesAlimento = new double[tiposAlimento.length];
        // Inicializar con 100kg de cada tipo
        for (int i = 0; i < nivelesAlimento.length; i++) {
            nivelesAlimento[i] = 100.0;
        }
    }

    public void dispensarAlimento(double cantidad, String tipo) {
        int index = getTipoIndex(tipo);
        if (index >= 0 && nivelesAlimento[index] >= cantidad) {
            nivelesAlimento[index] -= cantidad;
            System.out.println("Dispensando " + cantidad + "kg de " + tipo);
        } else {
            System.out.println("Error: No hay suficiente " + tipo);
        }
    }

    public void retirarAlimento(double cantidad, String tipo) {
        int index = getTipoIndex(tipo);
        if (index >= 0) {
            nivelesAlimento[index] += cantidad;
            System.out.println("Retirando " + cantidad + "kg de " + tipo);
        }
    }

    private int getTipoIndex(String tipo) {
        for (int i = 0; i < tiposAlimento.length; i++) {
            if (tiposAlimento[i].equalsIgnoreCase(tipo)) return i;
        }
        return -1;
    }
}
