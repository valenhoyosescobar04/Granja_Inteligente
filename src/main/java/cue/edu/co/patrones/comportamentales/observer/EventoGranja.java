package cue.edu.co.patrones.comportamentales.observer;

import java.time.LocalDateTime;

/**
 * Clase simple que representa un evento en la granja que será notificado a los observadores.
 */
public class EventoGranja {

    private String tipo;
    private String descripcion;
    private LocalDateTime fechaHora;

    public EventoGranja(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaHora = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "[" + fechaHora + "] " + tipo + ": " + descripcion;
    }
}
