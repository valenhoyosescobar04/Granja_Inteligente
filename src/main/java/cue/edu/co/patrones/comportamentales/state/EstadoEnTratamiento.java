package cue.edu.co.patrones.comportamentales.state;

// Importa la clase 'Animal' para poder manipular sus instancias dentro de este estado.
import cue.edu.co.modelos.Animal;

// Importaciones para registrar eventos y mensajes en el sistema (logging).
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el estado "EnTratamiento" de un animal dentro del sistema.
 * Implementa la interfaz EstadoSalud y define el comportamiento específico de un animal
 * que se encuentra bajo tratamiento médico o veterinario.
 *
 * Esta clase es parte del Patrón de Diseño State, donde cada estado define
 * cómo responde el animal a las mismas acciones dependiendo de su condición actual.
 */
public class EstadoEnTratamiento implements EstadoSalud {

    // Logger utilizado para registrar información sobre el comportamiento del animal.
    private static final Logger LOGGER = Logger.getLogger(EstadoEnTratamiento.class.getName());

    /**
     * Cuando el animal está en tratamiento, su dieta suele ser controlada.
     * @param animal el animal bajo tratamiento.
     */
    @Override
    public void alimentarse(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "El animal {0} tiene una dieta controlada por tratamiento.", animal.getNombre());
        }
    }

    /**
     * Un animal en tratamiento generalmente se encuentra en reposo o bajo observación,
     * por lo que su comportamiento es más calmado.
     * @param animal el animal bajo tratamiento.
     */
    @Override
    public void emitirSonido(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "El animal {0} está en observación y se mantiene calmado.", animal.getNombre());
        }
    }

    /**
     * Si el tratamiento no funciona o el animal empeora, su estado cambia a "Enfermo".
     * @param animal el animal que empeora durante el tratamiento.
     */
    @Override
    public void enfermar(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} empeora y se considera enfermo.", animal.getNombre());
        }
        // Transición al estado "Enfermo"
        animal.setEstadoSalud(new EstadoEnfermo());
    }

    /**
     * Si se intenta iniciar un tratamiento cuando el animal ya está en él,
     * no se realiza ningún cambio, solo se registra el evento.
     * @param animal el animal que ya está recibiendo tratamiento.
     */
    @Override
    public void iniciarTratamiento(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} ya está en tratamiento.", animal.getNombre());
        }
    }

    /**
     * Cuando el animal se recupera exitosamente, su estado cambia de "EnTratamiento" a "Sano".
     * @param animal el animal que se ha curado.
     */
    @Override
    public void curar(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} ha completado el tratamiento y está sano.", animal.getNombre());
        }
        // Transición al estado "Sano"
        animal.setEstadoSalud(new EstadoSano());
    }
}

