package cue.edu.co.patrones.comportamentales.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase concreta que implementa el patrón Observer (Subject).
 * Representa un sistema de alertas que notifica a los sensores (observers)
 * cuando ocurre un evento en la granja (cambios de estado, alimentación, riego, etc.).
 */
public class SistemaAlertas implements Subject {

    private static final Logger LOGGER = Logger.getLogger(SistemaAlertas.class.getName());

    private final List<Observer> observers;
    private final String nombreSistema;

    public SistemaAlertas(String nombreSistema) {
        this.nombreSistema = nombreSistema;
        this.observers = new ArrayList<>();

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🛰️ Sistema de alertas '%s' inicializado correctamente.", nombreSistema));
        }
    }

    @Override
    public void registrarObserver(Observer observer) {
        observers.add(observer);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🛰️ %s registrado en el sistema %s",
                    observer.getClass().getSimpleName(), nombreSistema));
        }
    }

    @Override
    public void eliminarObserver(Observer observer) {
        observers.remove(observer);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("❌ %s eliminado del sistema %s",
                    observer.getClass().getSimpleName(), nombreSistema));
        }
    }

    @Override
    public void notificarObservers(EventoGranja evento) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("📢 %s notificando a %d observadores...",
                    nombreSistema, observers.size()));
        }

        for (Observer observer : observers) {
            observer.update(evento);
        }
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }
}
