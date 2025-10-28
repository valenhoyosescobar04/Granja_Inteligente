package cue.edu.co.patrones.creacionales.builder;

import java.util.logging.Logger;

/**
 * Clase producto final creada por el Builder.
 * Representa un animal con múltiples atributos personalizados.
 */
public class AnimalPersonalizado {
    private static final Logger logger = Logger.getLogger(AnimalPersonalizado.class.getName());

    private String tipo;
    private int edad;
    private double peso;
    private String historial;

    public AnimalPersonalizado(String tipo, int edad, double peso, String historial) {
        this.tipo = tipo;
        this.edad = edad;
        this.peso = peso;
        this.historial = historial;
    }

    public void mostrarInfo() {
        logger.info("Animal: " + tipo +
                " | Edad: " + edad +
                " | Peso: " + peso + " kg" +
                " | Historial: " + historial);
    }
}