package cue.edu.co.controladores;


import cue.edu.co.patrones.comportamentales.observer.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador que encapsula la lógica del patrón Observer.
 */
public class ControladorObserver {

    private static final Logger LOGGER = Logger.getLogger(ControladorObserver.class.getName());
    private final SistemaAlertas sistemaAlertas;

    public ControladorObserver(String nombreSistema) {
        this.sistemaAlertas = new SistemaAlertas(nombreSistema);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🛰️ Sistema de alertas '%s' inicializado.", nombreSistema));
        }
    }

    public void registrarSensor(SensorObserver sensor) {
        sistemaAlertas.registrarObserver(sensor);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("✅ Sensor registrado: %s", sensor.getTipo()));
        }
    }

    public void eliminarSensor(SensorObserver sensor) {
        sistemaAlertas.eliminarObserver(sensor);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("❌ Sensor eliminado: %s", sensor.getTipo()));
        }
    }

    public void notificarCambio(String tipo, String descripcion) {
        EventoGranja evento = new EventoGranja(tipo, descripcion);
        sistemaAlertas.notificarObservers(evento);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("📡 Evento notificado: %s", evento));
        }
    }

    public SistemaAlertas getSistemaAlertas() {
        return sistemaAlertas;
    }
}
