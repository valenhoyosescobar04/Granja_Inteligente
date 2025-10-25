package cue.edu.co.servicios;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio que representa la lógica del sistema de riego de la granja.
 * Aplica principios de bajo acoplamiento y alta cohesión.
 * Este servicio podría integrarse con los patrones Command o Singleton más adelante.
 */
public class ServicioRiego {

    private static final Logger LOGGER = Logger.getLogger(ServicioRiego.class.getName());
    private boolean riegoActivo = false;

    /**
     * Activa el sistema de riego en una zona específica.
     * @param zona zona donde se desea activar el riego
     */
    public void activarRiego(String zona) {
        if (!riegoActivo) {
            riegoActivo = true;
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, String.format("💦 Riego activado en la zona: %s", zona));
            }
        } else {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, String.format("⚙️ El riego ya estaba activo en la zona: %s", zona));
            }
        }
    }

    /**
     * Desactiva el sistema de riego en una zona específica.
     * @param zona zona donde se desea desactivar el riego
     */
    public void desactivarRiego(String zona) {
        if (riegoActivo) {
            riegoActivo = false;
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, String.format("🌤️ Riego desactivado en la zona: %s", zona));
            }
        } else {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, String.format("⚙️ El riego ya estaba desactivado en la zona: %s", zona));
            }
        }
    }

    /**
     * Consulta el estado actual del sistema de riego.
     */
    public void consultarEstado() {
        String estado = riegoActivo ? "ACTIVO" : "INACTIVO";
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("📈 Estado actual del riego: %s", estado));
        }
    }
}
