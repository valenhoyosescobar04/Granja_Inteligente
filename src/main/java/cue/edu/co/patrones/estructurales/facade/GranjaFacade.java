package cue.edu.co.patrones.estructurales.facade;

import cue.edu.co.controladores.ControladorObserver;
import cue.edu.co.patrones.comportamentales.observer.SensorObserver;
import cue.edu.co.servicios.ServicioMonitoreo;
import cue.edu.co.servicios.ServicioRiego;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fachada principal del sistema de la Granja Inteligente.
 * Proporciona una interfaz única para manejar alimentación, riego y monitoreo.
 *
 * Integra varios patrones:
 *  - Facade → Simplifica el acceso a subsistemas.
 *  - Observer → Gestiona eventos y sensores.
 *  - (Preparado para agregar Strategy, State, etc.)
 */
public class GranjaFacade {

    private static final Logger LOGGER = Logger.getLogger(GranjaFacade.class.getName());

    // --- Dependencias internas ---
    private final SubsistemaAlimentacion alimentacion;
    private final ServicioMonitoreo servicioMonitoreo;
    private final ServicioRiego servicioRiego;
    private final ControladorObserver controladorObserver;

    /**
     * Constructor: inicializa los servicios y el sistema de alertas.
     */
    public GranjaFacade() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "🚜 Iniciando fachada principal de la Granja Inteligente...");
        }

        // Crear el controlador del patrón Observer
        controladorObserver = new ControladorObserver("Alertas Generales");

        // Crear los subsistemas o servicios
        alimentacion = new SubsistemaAlimentacion();
        servicioMonitoreo = new ServicioMonitoreo(controladorObserver);
        servicioRiego = new ServicioRiego();

        // Registrar sensores por defecto
        registrarSensoresPorDefecto();
    }

    /**
     * Registra sensores básicos para el monitoreo inicial del sistema.
     */
    private void registrarSensoresPorDefecto() {
        SensorObserver sensorPeso = new SensorObserver("Peso", 200);
        SensorObserver sensorTemperatura = new SensorObserver("Temperatura", 0);
        SensorObserver sensorHumedad = new SensorObserver("Humedad", 0);

        controladorObserver.registrarSensor(sensorPeso);
        controladorObserver.registrarSensor(sensorTemperatura);
        controladorObserver.registrarSensor(sensorHumedad);

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "✅ Sensores registrados correctamente en el sistema de alertas.");
        }
    }

    // ---------------------------------------------------------
    // MÉTODOS DE ALTO NIVEL EXPUESTOS POR LA FACHADA
    // ---------------------------------------------------------

    /**
     * Alimenta un corral específico y genera un evento en el sistema.
     */
    public void alimentarCorral(String nombreCorral) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🍽️ Iniciando proceso de alimentación para %s", nombreCorral));
        }

        alimentacion.verificarStock();
        alimentacion.distribuirAlimento(nombreCorral);
        servicioMonitoreo.generarAlerta("Alimentación", String.format("Se alimentó el corral: %s", nombreCorral));

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("✅ Alimentación del %s completada.", nombreCorral));
        }
    }

    /**
     * Activa el riego en una zona y genera un evento de monitoreo.
     */
    public void activarRiego(String zona) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("💧 Solicitando activación de riego en %s", zona));
        }

        servicioRiego.activarRiego(zona);
        servicioMonitoreo.generarAlerta("Riego", String.format("El riego fue activado en %s", zona));

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("✅ Riego activado en %s", zona));
        }
    }

    /**
     * Desactiva el riego en una zona y genera un evento de monitoreo.
     */
    public void desactivarRiego(String zona) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🌤️ Solicitando desactivación de riego en %s", zona));
        }

        servicioRiego.desactivarRiego(zona);
        servicioMonitoreo.generarAlerta("Riego", String.format("El riego fue desactivado en %s", zona));

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("✅ Riego desactivado en %s", zona));
        }
    }

    /**
     * Realiza un monitoreo general de los sensores registrados.
     */
    public void monitorearSensores() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "📡 Iniciando monitoreo general de sensores...");
        }

        servicioMonitoreo.revisarSensores();
        servicioMonitoreo.mostrarEstadoSensores();

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "✅ Monitoreo general completado.");
        }
    }

    /**
     * Permite crear manualmente una alerta personalizada (por ejemplo, desde una interfaz).
     */
    public void generarAlertaManual(String tipo, String descripcion) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("⚠️ Generando alerta manual: [%s] %s", tipo, descripcion));
        }

        servicioMonitoreo.generarAlerta(tipo, descripcion);

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "✅ Alerta manual procesada.");
        }
    }

    /**
     * Simula una rutina diaria completa de la granja.
     * Este método demuestra la coordinación de todos los subsistemas a través de la fachada.
     */
    public void ejecutarRutinaDiaria() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "🌅 Iniciando rutina diaria de la granja...");
        }

        alimentarCorral("Corral de Vacas");
        activarRiego("Zona Norte");
        monitorearSensores();
        desactivarRiego("Zona Norte");

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "🌇 Rutina diaria finalizada correctamente.");
        }
    }

    // ---------------------------------------------------------
    // MÉTODOS AUXILIARES
    // ---------------------------------------------------------

    public ControladorObserver getControladorObserver() {
        return controladorObserver;
    }

    public ServicioMonitoreo getServicioMonitoreo() {
        return servicioMonitoreo;
    }

    public ServicioRiego getServicioRiego() {
        return servicioRiego;
    }

    public SubsistemaAlimentacion getAlimentacion() {
        return alimentacion;
    }
}
