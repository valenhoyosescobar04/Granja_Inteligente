package cue.edu.co.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase base que representa un animal dentro de la granja inteligente.
 * Cada animal puede ser observado por sensores que reaccionan ante cambios en su estado.
 */
public abstract class Animal {

    private static final Logger LOGGER = Logger.getLogger(Animal.class.getName());

    private final String id;
    private String nombre;
    private double peso;
    private String especie;
    private final List<Sensor> sensores; // Sensores asociados a este animal

    protected Animal(String nombre, double peso, String especie) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.peso = peso;
        this.especie = especie;
        this.sensores = new ArrayList<>();
    }

    // Asociación de sensores
    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
        LOGGER.log(Level.INFO, "📡 Sensor agregado al animal {0}: {1}", new Object[]{nombre, sensor.getTipo()});
    }

    public void eliminarSensor(Sensor sensor) {
        sensores.remove(sensor);
        LOGGER.log(Level.INFO, "❌ Sensor eliminado del animal {0}: {1}", new Object[]{nombre, sensor.getTipo()});
    }

    /**
     * Notifica a todos los sensores asociados sobre un cambio en el animal.
     */
    protected void notificarSensores(String evento) {
        for (Sensor sensor : sensores) {
            sensor.detectarCambio(this, evento);
        }
        LOGGER.log(Level.INFO, "📢 Notificación enviada por {0} a {1} sensores → {2}",
                new Object[]{nombre, sensores.size(), evento});
    }

    // Simulación de un cambio observable
    public void actualizarPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
        notificarSensores("Cambio de peso: " + nuevoPeso + " kg");
    }

    // Métodos abstractos que las subclases deben implementar
    public abstract void emitirSonido();
    public abstract void alimentarse();

    // Métodos de utilidad
    public void mostrarInfo() {
        LOGGER.log(Level.INFO, "🐾 Animal: {0} ({1}) - Peso: {2} kg", new Object[]{nombre, especie, peso});
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return especie + " - " + nombre + " (" + peso + " kg)";
    }
}
