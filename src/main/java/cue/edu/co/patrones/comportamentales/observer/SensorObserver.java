package cue.edu.co.patrones.comportamentales.observer;

import cue.edu.co.modelos.EstadoSensor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase concreta que implementa el patrón Observer.
 * Representa un sensor que reacciona a los eventos notificados por los sujetos (animales, corrales, etc.).
 */
public class SensorObserver implements Observer {

    private static final Logger LOGGER = Logger.getLogger(SensorObserver.class.getName());

    private final String tipo;
    private final double umbral;
    private EstadoSensor estado;

    public SensorObserver(String tipo, double umbral) {
        this.tipo = tipo;
        this.umbral = umbral;
        this.estado = EstadoSensor.NORMAL;
    }

    /**
     * Método llamado cuando ocurre un evento en el sistema.
     * Dependiendo del tipo de sensor y del evento recibido, puede cambiar su estado.
     */
    @Override
    public void update(EventoGranja evento) {
        boolean esEventoCritico = "Peso".equalsIgnoreCase(tipo) && evento.getDescripcion().toLowerCase().contains("peso");

        if (esEventoCritico) {
            this.estado = EstadoSensor.ALERTA;
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.log(Level.WARNING, String.format("🚨 %s detectó cambio crítico → %s", tipo, evento));
            }
        } else {
            this.estado = EstadoSensor.NORMAL;
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, String.format("✅ %s recibió notificación → %s", tipo, evento));
            }
        }
    }

    public EstadoSensor getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }

    public double getUmbral() {
        return umbral;
    }
}
