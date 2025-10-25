package cue.edu.co.modelos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa un sensor dentro de la granja.
 * Usa Logger en lugar de System.out para cumplir con las buenas prácticas (SonarQube S106).
 */
public class Sensor {

    private static final Logger LOGGER = Logger.getLogger(Sensor.class.getName());

    private String tipo; // Ejemplo: "Peso", "Temperatura", "Alimento"
    private EstadoSensor estado;
    private double umbral; // Nivel crítico de activación

    public Sensor(String tipo, double umbral) {
        this.tipo = tipo;
        this.umbral = umbral;
        this.estado = EstadoSensor.NORMAL;
    }

    /**
     * Método que reacciona a cambios notificados por un animal observado.
     */
    public void detectarCambio(Animal animal, String evento) {
        if ("Peso".equalsIgnoreCase(tipo) && animal.getPeso() < umbral) {
            estado = EstadoSensor.ALERTA;
            LOGGER.log(Level.WARNING,
                    "🚨 Sensor de {0}: {1} está por debajo del peso umbral ({2} kg)",
                    new Object[]{tipo, animal.getNombre(), umbral});
        } else {
            estado = EstadoSensor.NORMAL;
            LOGGER.log(Level.INFO,
                    "✅ Sensor de {0}: Evento recibido de {1} → {2}",
                    new Object[]{tipo, animal.getNombre(), evento});
        }
    }

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public EstadoSensor getEstado() {
        return estado;
    }

    public double getUmbral() {
        return umbral;
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public String toString() {
        return "Sensor[" + tipo + "] - Estado: " + estado;
    }
}
