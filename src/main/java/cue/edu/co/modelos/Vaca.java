package cue.edu.co.modelos;

// Importaciones necesarias para registrar mensajes e información
// sobre el comportamiento de la clase usando el sistema de logging.
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa a una Vaca dentro del sistema de la Granja Inteligente.
 * Hereda de la clase abstracta Animal, por lo que adopta sus atributos y métodos base.
 *
 * Define el comportamiento particular de una vaca al emitir sonidos y alimentarse.
 * Además, integra la lógica del patrón State al delegar parte del comportamiento
 * a su estado de salud actual (EstadoSano, EstadoEnfermo o EstadoEnTratamiento).
 */
public class Vaca extends Animal {

    // Logger utilizado para registrar mensajes sobre el comportamiento de la vaca.
    private static final Logger LOGGER = Logger.getLogger(Vaca.class.getName());

    /**
     * Constructor que inicializa una instancia de Vaca con nombre y peso.
     * Llama al constructor de la superclase Animal, especificando el tipo como "Vaca".
     *
     * @param nombre nombre del animal.
     * @param peso peso del animal en kilogramos.
     */
    public Vaca(String nombre, double peso) {
        super(nombre, peso, "Vaca");
    }

    /**
     * Define el comportamiento al emitir el sonido característico de una vaca.
     * Primero, se registra el sonido "Muuu" en los logs.
     * Luego, si el animal tiene un estado de salud definido,
     * se delega al método emitirSonido() del estado correspondiente.
     */
    @Override
    public void emitirSonido() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} hace: Muuu", getNombre());
        }
        // Si el estado de salud no es nulo, el estado actual también emite su propio sonido.
        if (getEstadoSalud() != null) {
            getEstadoSalud().emitirSonido(this);
        }
    }

    /**
     * Define el comportamiento de alimentación de la vaca.
     * Primero registra en los logs que la vaca se acerca al comedero.
     * Luego, si el animal tiene un estado de salud definido,
     * delega la acción de alimentarse a dicho estado (que puede modificar su comportamiento).
     */
    @Override
    public void alimentarse() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} se acerca al comedero.", getNombre());
        }
        // Delegación del comportamiento según el estado actual del animal.
        if (getEstadoSalud() != null) {
            getEstadoSalud().alimentarse(this);
        }
    }
}
