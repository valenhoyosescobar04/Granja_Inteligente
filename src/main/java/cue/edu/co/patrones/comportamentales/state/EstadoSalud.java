package cue.edu.co.patrones.comportamentales.state;

// Importa la clase 'Animal' del paquete donde está definida.
// Esto permite que las clases que implementen esta interfaz puedan interactuar con objetos de tipo Animal.
import cue.edu.co.modelos.Animal;

/**
 * Interfaz que define el comportamiento general relacionado con el estado de salud de un animal.
 * Representa el "contrato" que deberán cumplir las clases concretas que gestionen los distintos
 * estados de salud (por ejemplo: sano, enfermo, en tratamiento, etc.).
 */
public interface EstadoSalud {

    /**
     * Método que define cómo debe alimentarse un animal según su estado de salud.
     * @param animal objeto de tipo Animal que se va a alimentar.
     */
    void alimentarse(Animal animal);

    /**
     * Método que indica cómo emite sonido un animal en su estado actual.
     * @param animal objeto de tipo Animal que emitirá el sonido.
     */
    void emitirSonido(Animal animal);

    /**
     * Cambia el estado del animal a "enfermo".
     * @param animal objeto de tipo Animal que se enfermará.
     */
    void enfermar(Animal animal);

    /**
     * Inicia el tratamiento médico o de cuidado para el animal.
     * @param animal objeto de tipo Animal que comenzará su tratamiento.
     */
    void iniciarTratamiento(Animal animal);

    /**
     * Cambia el estado del animal a "curado" o "sano".
     * @param animal objeto de tipo Animal que ha sido curado.
     */
    void curar(Animal animal);
}

