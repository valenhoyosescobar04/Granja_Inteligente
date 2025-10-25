package cue.edu.co.config;

import java.io.IOException;
import java.util.logging.*;

/**
 * Configuración centralizada del sistema de logs para la aplicación Granja Inteligente.
 *
 * <p>Esta clase define el formato, nivel y destino de los logs.
 * Se puede reutilizar en cualquier parte del proyecto mediante:</p>
 *
 * <pre>
 *     LoggerConfig.configurar();
 * </pre>
 *
 * <p>Permite mantener un control unificado del registro de eventos y errores,
 * facilitando la trazabilidad y el mantenimiento del sistema.</p>
 */
public final class LoggerConfig {

    // Evita inicialización repetida del sistema de logs
    private static boolean isLoggerInitialized = false;

    private LoggerConfig() {
        // Evitar instanciación
    }

    /**
     * Inicializa el sistema de logging con formato y niveles personalizados.
     * Debe llamarse una sola vez al iniciar la aplicación.
     */
    public static void configurar() {
        if (isLoggerInitialized) {
            return; // Evita reconfigurar el logger si ya fue inicializado
        }
        isLoggerInitialized = true;

        // Reinicia configuración previa de los loggers globales
        LogManager.getLogManager().reset();
        Logger rootLogger = Logger.getLogger("");

        // Formato personalizado para consola
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format(
                        "[%1$tF %1$tT] [%2$-7s] %3$s %n",
                        record.getMillis(),
                        record.getLevel().getName(),
                        record.getMessage()
                );
            }
        });

        // Salida a archivo
        try {
            FileHandler fileHandler = new FileHandler("granja_inteligente.log", true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);
        } catch (IOException e) {
            Logger.getLogger(LoggerConfig.class.getName())
                    .log(Level.WARNING, "⚠️ No se pudo crear el archivo de log: {0}", e.getMessage());
        }

        // Añadir handler de consola
        rootLogger.addHandler(consoleHandler);

        // Nivel global de logs
        rootLogger.setLevel(Level.INFO);
    }
}
