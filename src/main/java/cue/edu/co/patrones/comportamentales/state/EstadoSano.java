package cue.edu.co.patrones.comportamentales.state;

// Importa la clase 'Animal' desde el paquete correspondiente,
// permitiendo que esta clase pueda interactuar con objetos de tipo Animal.
import cue.edu.co.modelos.Animal;

// Importaciones para el sistema de registro (logging) de eventos e información.
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el estado "Sano" de un animal dentro del sistema.
 * Implementa la interfaz EstadoSalud, definiendo el comportamiento específico
 * que tiene un animal cuando está saludable.
 */
public class EstadoSano implements EstadoSalud {

    // Logger para registrar mensajes informativos sobre el comportamiento del animal.
    private static final Logger LOGGER = Logger.getLogger(EstadoSano.class.getName());

    /**
     * Cuando el animal está sano, se alimenta normalmente.
     * @param animal el animal que realiza la acción.
     */
    @Override
    public void alimentarse(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "El animal {0} se alimenta normalmente.", animal.getNombre());
        }
    }

    /**
     * Un animal sano emite sonidos enérgicos y activos.
     * @param animal el animal que realiza la acción.
     */
    @Override
    public void emitirSonido(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "El animal {0} emite un sonido enérgico.", animal.getNombre());
        }
    }

    /**
     * Cambia el estado del animal de sano a enfermo.
     * Este método refleja una transición en el patrón State.
     * @param animal el animal que cambia de estado.
     */
    @Override
    public void enfermar(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} ha enfermado.", animal.getNombre());
        }
        // Se actualiza el estado del animal al nuevo estado "Enfermo".
        animal.setEstadoSalud(new EstadoEnfermo());
    }

    /**
     * Permite iniciar un tratamiento preventivo, aunque el animal esté sano.
     * Este cambio modifica su estado a "EnTratamiento".
     * @param animal el animal que inicia tratamiento.
     */
    @Override
    public void iniciarTratamiento(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} inicia tratamiento preventivo.", animal.getNombre());
        }
        // Cambia el estado del animal a "EnTratamiento".
        animal.setEstadoSalud(new EstadoEnTratamiento());
    }

    /**
     * Indica que el animal ya está sano, por lo que no se realiza ningún cambio.
     * @param animal el animal que intenta curarse.
     */
    @Override
    public void curar(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} ya está sano.", animal.getNombre());
        }
    }
}

