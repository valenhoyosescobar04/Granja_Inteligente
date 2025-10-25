package cue.edu.co.patrones.comportamentales.observer;


/**
 * Interfaz Observer: representa cualquier entidad que observe un sujeto.
 * Define el método update() para reaccionar a los eventos.
 */
public interface Observer {
    void update(EventoGranja evento);
}
