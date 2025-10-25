package cue.edu.co.patrones.estructurales.facade;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Subsistema responsable de la alimentación de los animales.
 * Encapsula la lógica de alimentación y control de comida.
 * Este subsistema puede integrarse con el patrón Strategy para
 * definir diferentes tipos de alimentación según especie o edad.
 */
public class SubsistemaAlimentacion {

    private static final Logger LOGGER = Logger.getLogger(SubsistemaAlimentacion.class.getName());

    /**
     * Distribuye alimento en un corral específico.
     * @param corral nombre del corral donde se realizará la distribución
     */
    public void distribuirAlimento(String corral) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🍽️ Distribuyendo alimento en %s...", corral));
        }
        // Aquí podría aplicarse el patrón Strategy para definir el tipo de alimentación
    }

    /**
     * Verifica la disponibilidad de alimento en inventario antes de distribuirlo.
     */
    public void verificarStock() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "📦 Verificando stock de alimento...");
        }
    }
}