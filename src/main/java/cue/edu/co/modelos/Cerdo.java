package cue.edu.co.modelos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa a un Cerdo dentro del sistema.
 * Extiende la clase abstracta Animal e implementa su comportamiento
 * específico en cuanto a emisión de sonido y alimentación.
 */
public class Cerdo extends Animal {
    // Logger utilizado para registrar las acciones del cerdo.
    private static final Logger LOGGER = Logger.getLogger(Cerdo.class.getName());

    /**
     * Constructor de la clase Cerdo.
     * @param nombre Nombre del cerdo.
     * @param peso Peso del cerdo en kilogramos.
     */
    public Cerdo(String nombre, double peso) {
        // Llama al constructor de la superclase Animal, indicando que el tipo es "Cerdo".
        super(nombre, peso, "Cerdo");
    }

    /**
     * Método que permite al cerdo emitir su sonido característico.
     * Registra el sonido mediante el Logger y, si el cerdo tiene un estado de salud,
     * también delega la acción de emitir sonido a dicho estado (patrón State).
     */
    @Override
    public void emitirSonido() {
        // Verifica si el nivel de log INFO está habilitado antes de registrar el mensaje.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} hace: Oink", getNombre());
        }
        // Si el cerdo tiene un estado de salud, delega la acción de emitir sonido a ese estado.
        if (getEstadoSalud() != null) {
            getEstadoSalud().emitirSonido(this);
        }
    }

    /**
     * Método que describe cómo el cerdo se alimenta.
     * Registra la acción mediante el Logger y, si existe un estado de salud asignado,
     * también delega el comportamiento de alimentación a ese estado (patrón State).
     */
    @Override
    public void alimentarse() {
        // Verifica si el nivel de log INFO está habilitado antes de registrar el mensaje.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} come en su comedero.", getNombre());
        }
        // Si el estado de salud no es nulo, delega la alimentación al estado actual.
        if (getEstadoSalud() != null) {
            getEstadoSalud().alimentarse(this);
        }
    }
}

