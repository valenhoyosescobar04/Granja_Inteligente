package cue.edu.co.patrones.comportamentales.state;

// Importa la clase 'Animal' desde el paquete de modelos,
// permitiendo manipular instancias de animales dentro de este estado.
import cue.edu.co.modelos.Animal;

// Importa las clases necesarias para el sistema de registro (logging).
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el estado "Enfermo" de un animal dentro del sistema.
 * Implementa la interfaz EstadoSalud, definiendo el comportamiento que
 * tiene un animal cuando se encuentra enfermo.
 *
 * Forma parte del Patrón de Diseño State, en el que cada clase concreta
 * representa un estado distinto con su propio comportamiento.
 */
public class EstadoEnfermo implements EstadoSalud {

    // Logger para registrar mensajes sobre el estado y acciones del animal.
    private static final Logger LOGGER = Logger.getLogger(EstadoEnfermo.class.getName());

    /**
     * Cuando el animal está enfermo, su apetito disminuye.
     * Este método refleja ese comportamiento reduciendo o
     * limitando la alimentación normal.
     * @param animal el animal que se encuentra enfermo.
     */
    @Override
    public void alimentarse(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "El animal {0} come poco por estar enfermo.", animal.getNombre());
        }
    }

    /**
     * Un animal enfermo emite sonidos débiles o de malestar.
     * @param animal el animal que se encuentra enfermo.
     */
    @Override
    public void emitirSonido(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "El animal {0} emite un sonido débil.", animal.getNombre());
        }
    }

    /**
     * Si se intenta volver a enfermar al animal, no ocurre ningún cambio,
     * ya que este estado ya representa la enfermedad.
     * @param animal el animal que ya está enfermo.
     */
    @Override
    public void enfermar(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} ya está enfermo.", animal.getNombre());
        }
    }

    /**
     * Inicia un tratamiento para el animal enfermo, cambiando su estado
     * a "EnTratamiento" dentro del sistema.
     * @param animal el animal que comienza tratamiento médico.
     */
    @Override
    public void iniciarTratamiento(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} inicia tratamiento.", animal.getNombre());
        }
        // Cambia el estado del animal a "EnTratamiento"
        animal.setEstadoSalud(new EstadoEnTratamiento());
    }

    /**
     * Cuando el animal se recupera completamente, cambia su estado
     * de "Enfermo" a "Sano".
     * @param animal el animal que se ha curado.
     */
    @Override
    public void curar(Animal animal) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} se ha curado y ahora está sano.", animal.getNombre());
        }
        // Transición al estado "Sano"
        animal.setEstadoSalud(new EstadoSano());
    }
}

