package cue.edu.co.app;

import cue.edu.co.config.LoggerConfig;
import cue.edu.co.patrones.estructurales.facade.GranjaFacade;
import cue.edu.co.patrones.comportamentales.strategy.Estacion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase principal que ejecuta la simulación de la Granja Inteligente.
 * Inicia el sistema, coordina la fachada y gestiona el flujo general de eventos.
 */
public class MainGranja {

    // Logger principal de la clase. Permite registrar mensajes informativos, advertencias o errores.
    // Facilita el monitoreo y depuración del comportamiento del sistema.
    private static final Logger LOGGER = Logger.getLogger(MainGranja.class.getName());

    // Método principal: punto de entrada de la aplicación.
    // Desde aquí se inicializa la configuración, se solicitan entradas al usuario
    // y se ejecuta la simulación completa de la granja.
    public static void main(String[] args) {

        // Inicializar configuración personalizada del logger (nivel, formato, etc.).
        LoggerConfig.configurar();

        // Registrar un mensaje inicial informando que comienza la simulación.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "🐓 --- SIMULACIÓN GRANJA INTELIGENTE ---");
        }


        // La clase GranjaFacade centraliza la lógica principal del sistema (patrón Facade),
        // de modo que MainGranja solo coordina y no se ocupa de los detalles internos.
        GranjaFacade fachada = new GranjaFacade();

        // Variables para guardar los datos de entrada del usuario.
        String animal;
        String estacionInput;

        // Se utiliza un Scanner para capturar entradas desde consola.
        // El bloque try-with-resources asegura que el Scanner se cierre automáticamente.
        try (Scanner sc = new Scanner(System.in)) {

            // Solicita al usuario el tipo de animal que desea alimentar.
            // Se usa el logger en lugar de System.out.println para mantener consistencia en la salida.
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, "Seleccione animal a alimentar [vaca/pollo/cerdo] (Enter para omitir): ");
            }
            animal = sc.nextLine();

            // Solicita al usuario la estación del año o permite usar una configuración por defecto.
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, "Seleccione estación [verano/invierno] (Enter para usar propiedades/env): ");
            }
            estacionInput = sc.nextLine();
        }

        // Intenta obtener la estación desde propiedades del sistema (por ejemplo, argumentos de ejecución).
        String estacionProp = System.getProperty("estacion");

        // Si no está definida como propiedad, intenta obtenerla desde las variables de entorno del sistema operativo.
        if (estacionProp == null || estacionProp.isBlank()) {
            estacionProp = System.getenv("ESTACION");
        }

        // Por defecto, la estación será VERANO (valor inicial del enum).
        Estacion est = Estacion.VERANO;

        // Determina el criterio de estación a partir de la entrada del usuario o las propiedades del sistema.
        String criterioEstacion = estacionInput;
        if (criterioEstacion == null || criterioEstacion.isBlank()) {
            criterioEstacion = estacionProp;
        }

        // Convierte el texto recibido a un valor del enum Estacion.
        // Si no coincide con ninguna opción, se mantiene VERANO como valor por defecto.
        if (criterioEstacion != null) {
            switch (criterioEstacion.trim().toUpperCase()) {
                case "INVIERNO":
                    est = Estacion.INVIERNO;
                    break;
                case "VERANO":
                    est = Estacion.VERANO;
                    break;
                default:
                    est = Estacion.VERANO;
                    break;
            }
        }

        // Si el usuario especificó un animal, se determina a qué corral pertenece.
        if (animal != null && !animal.isBlank()) {
            String corral;

            // Asigna el corral correspondiente según el tipo de animal indicado.
            switch (animal.trim().toLowerCase()) {
                case "vaca":
                case "vacas":
                    corral = "Corral de Vacas";
                    break;
                case "pollo":
                case "pollos":
                    corral = "Corral de Pollos";
                    break;
                case "cerdo":
                case "cerdos":
                    corral = "Corral de Cerdos";
                    break;
                default:
                    // Si el valor no coincide con ninguna categoría, se asume por defecto el corral de vacas.
                    corral = "Corral de Vacas";
                    break;
            }

            // Usa la fachada para alimentar el corral según la estación seleccionada.
            fachada.alimentarCorralSegunEstacion(corral, est);

            // Luego inicia el monitoreo de sensores (por ejemplo: temperatura, humedad, movimiento, etc.).
            fachada.monitorearSensores();

        } else {
            // Si el usuario no especificó un animal,
            // el sistema selecciona una estrategia de alimentación global según la estación.
            fachada.seleccionarEstrategiaAlimentacion(est);

            // Ejecuta la rutina diaria general de la granja:
            // puede incluir tareas como alimentar, limpiar, monitorear, registrar datos, etc.
            fachada.ejecutarRutinaDiaria();
        }

        // Al finalizar la ejecución, se registra un mensaje de cierre exitoso.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "✅ --- SIMULACIÓN COMPLETADA ---");
        }
    }
}

