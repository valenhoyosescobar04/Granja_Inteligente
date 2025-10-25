package cue.edu.co.patrones.estructurales.facade;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Subsistema encargado del control de riego de la granja.
 * Encapsula las operaciones de activación y desactivación del riego.
 *
 * Este subsistema puede integrarse posteriormente con los patrones:
 * - Command → para ejecutar acciones de riego programadas.
 * - Singleton → para centralizar el control del sistema de riego.
 */
public class SubsistemaRiego {

    private static final Logger LOGGER = Logger.getLogger(SubsistemaRiego.class.getName());

    /**
     * Activa el sistema de riego en una zona específica.
     * @param zona nombre o identificador de la zona
     */
    public void activarRiego(String zona) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("💦 Activando riego automático en %s...", zona));
        }
        // Aquí podría integrarse lógica real de sensores o válvulas inteligentes.
    }

    /**
     * Desactiva el sistema de riego en una zona específica.
     * @param zona nombre o identificador de la zona
     */
    public void desactivarRiego(String zona) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🌤️ Riego desactivado en %s.", zona));
        }
    }
}
