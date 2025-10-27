package cue.edu.co.patrones.estructurales.decorator;

// Interfaz base para todos los animales
public interface Animal {
    String getDescripcion();
    double getPeso();
    void alimentar();

    default String getEstadoSalud() {
        return null;
    }
}