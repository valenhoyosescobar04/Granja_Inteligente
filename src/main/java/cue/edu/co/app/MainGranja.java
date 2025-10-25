package cue.edu.co.app;

import cue.edu.co.config.LoggerConfig;
import cue.edu.co.patrones.estructurales.facade.GranjaFacade;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que ejecuta la simulación de la Granja Inteligente.
 * Inicia el sistema, coordina la fachada y gestiona el flujo general de eventos.
 */
public class MainGranja {

    private static final Logger LOGGER = Logger.getLogger(MainGranja.class.getName());

    public static void main(String[] args) {
        // Inicializar logs globales (configuración personalizada)
        LoggerConfig.configurar();

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "🐓 --- SIMULACIÓN GRANJA INTELIGENTE ---");
        }

        GranjaFacade fachada = new GranjaFacade();

        // Ejecutar flujo principal de la simulación
        fachada.ejecutarRutinaDiaria();
        fachada.generarAlertaManual("Temperatura", "Sensor marcó 39°C en corral de ovejas");
        fachada.monitorearSensores();

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "✅ --- SIMULACIÓN COMPLETADA ---");
        }
    }
}
