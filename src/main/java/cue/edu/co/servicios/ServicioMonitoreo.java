package cue.edu.co.servicios;
import cue.edu.co.controladores.ControladorObserver;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio que se encarga de la gestión general del monitoreo de la granja.
 * Aplica buenas prácticas de logging y se comunica con el ControladorObserver
 * para emitir alertas y registrar sensores.
 */
public class ServicioMonitoreo {

    private static final Logger LOGGER = Logger.getLogger(ServicioMonitoreo.class.getName());
    private final ControladorObserver controladorObserver;

    public ServicioMonitoreo(ControladorObserver controladorObserver) {
        this.controladorObserver = controladorObserver;
    }

    /**
     * Ejecuta una revisión general de todos los sensores activos en la granja.
     * Simula la lectura de datos y genera una notificación global.
     */
    public void revisarSensores() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "👀 Ejecutando revisión general de sensores...");
        }
        controladorObserver.notificarCambio("Monitoreo", "Revisión general del sistema completada.");
    }

    /**
     * Genera una alerta manual, ya sea provocada por un operador o por un evento detectado externamente.
     * @param tipo tipo de evento (ej: Temperatura, Humedad, etc.)
     * @param descripcion detalle de la alerta generada
     */
    public void generarAlerta(String tipo, String descripcion) {
        controladorObserver.notificarCambio(tipo, descripcion);
        if (LOGGER.isLoggable(Level.WARNING)) {
            LOGGER.log(Level.WARNING, String.format("🚨 Alerta generada manualmente: %s - %s", tipo, descripcion));
        }
    }

    /**
     * Muestra el estado actual de todos los sensores registrados en el sistema.
     * Este método puede extenderse para incluir métricas o un reporte consolidado.
     */
    public void mostrarEstadoSensores() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "📊 Consultando estado de sensores registrados...");
        }
    }
}