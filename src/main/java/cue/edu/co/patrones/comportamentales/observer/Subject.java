package cue.edu.co.patrones.comportamentales.observer;

import java.util.List;

/**
 * Interfaz Subject: define el comportamiento de los objetos observables.
 * Permite registrar, eliminar y notificar a los observadores.
 */
public interface Subject {

    void registrarObserver(Observer observer);

    void eliminarObserver(Observer observer);

    void notificarObservers(EventoGranja evento);

    List<Observer> getObservers();
}
