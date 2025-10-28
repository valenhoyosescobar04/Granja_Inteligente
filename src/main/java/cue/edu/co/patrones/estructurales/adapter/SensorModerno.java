package cue.edu.co.patrones.estructurales.adapter;

import java.util.Map;

// Interfaz que espera nuestro sistema moderno
public interface SensorModerno {
    double obtenerTemperatura(); // En Celsius
    double obtenerHumedad(); // En porcentaje
    Map<String, Double> obtenerParametrosAmbientales();
    boolean necesitaMantenimiento();
}
