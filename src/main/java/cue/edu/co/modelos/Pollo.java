package cue.edu.co.modelos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa a un Pollo dentro del sistema.
 * Hereda de la clase abstracta Animal y define su comportamiento
 * específico en cuanto a alimentación y emisión de sonidos.
 */
public class Pollo extends Animal {
    // Logger para registrar las acciones del Pollo en consola o archivo de log.
    private static final Logger LOGGER = Logger.getLogger(Pollo.class.getName());

    /**
     * Constructor de la clase Pollo.
     * @param nombre Nombre del pollo.
     * @param peso Peso del pollo en kilogramos.
     */
    public Pollo(String nombre, double peso) {
        // Llama al constructor de la superclase Animal, indicando que el tipo es "Pollo".
        super(nombre, peso, "Pollo");
    }

    /**
     * Método que permite al pollo emitir su sonido característico.
     * Se utiliza el Logger para mostrar el sonido en los registros.
     * Si el pollo tiene un estado de salud asignado, también se delega
     * la acción de emitir sonido a dicho estado (patrón State).
     */
    @Override
    public void emitirSonido() {
        // Verifica si el nivel de log INFO está habilitado antes de registrar el mensaje.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} hace: Cocorocó", getNombre());
        }
        // Si existe un estado de salud, delega la acción de emitir sonido a ese estado.
        if (getEstadoSalud() != null) {
            getEstadoSalud().emitirSonido(this);
        }
    }

    /**
     * Método que describe cómo el pollo se alimenta.
     * Se utiliza el Logger para mostrar la acción en los registros.
     * Si el pollo tiene un estado de salud, se delega también el comportamiento
     * al objeto que representa dicho estado.
     */
    @Override
    public void alimentarse() {
        // Verifica si el nivel de log INFO está habilitado antes de registrar el mensaje.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0} picotea el alimento.", getNombre());
        }
        // Si el estado de salud no es nulo, delega la alimentación al estado actual.
        if (getEstadoSalud() != null) {
            getEstadoSalud().alimentarse(this);
        }
    }
}
