package cue.edu.co.patrones.estructurales.facade;

import cue.edu.co.patrones.comportamentales.observer.EventoGranja;
import cue.edu.co.patrones.comportamentales.observer.SistemaAlertas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Subsistema de monitoreo y alertas.
 * Encapsula la lógica de generación y propagación de eventos,
 * apoyándose en el patrón Observer para notificar a los sensores.
 */
public class SubsistemaMonitoreo {

    private static final Logger LOGGER = Logger.getLogger(SubsistemaMonitoreo.class.getName());
    private final SistemaAlertas sistemaAlertas;

    public SubsistemaMonitoreo(SistemaAlertas sistemaAlertas) {
        this.sistemaAlertas = sistemaAlertas;
    }

    /**
     * Ejecuta una revisión general de los sensores registrados.
     * Puede usarse como punto de control periódico o parte de una rutina.
     */
    public void revisarSensores() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "👀 Revisando sensores del sistema...");
        }
        // En una implementación futura, aquí se podrían consultar lecturas reales de sensores.
    }

    /**
     * Genera un evento dentro del sistema de monitoreo y lo notifica a todos los observadores registrados.
     * @param tipo tipo de evento generado (por ejemplo, "Riego", "Temperatura", "Humedad")
     * @param descripcion detalle o mensaje del evento
     */
    public void generarEvento(String tipo, String descripcion) {
        EventoGranja evento = new EventoGranja(tipo, descripcion);
        sistemaAlertas.notificarObservers(evento);

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("📡 Evento generado → %s", evento));
        }
    }
}
