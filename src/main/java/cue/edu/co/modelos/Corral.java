package cue.edu.co.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa un corral dentro de la granja.
 * Contiene animales y sensores asociados para monitorear condiciones.
 */
public class Corral {

    private static final Logger LOGGER = Logger.getLogger(Corral.class.getName());

    private String nombre;
    private List<Animal> animales;
    private List<Sensor> sensores;
    private double nivelAlimento;

    public Corral(String nombre) {
        this.nombre = nombre;
        this.animales = new ArrayList<>();
        this.sensores = new ArrayList<>();
        this.nivelAlimento = 100.0;
    }

    // Gestión de animales
    public void agregarAnimal(Animal animal) {
        animales.add(animal);
        LOGGER.log(Level.INFO, "🐮 Animal agregado al corral {0}: {1}", new Object[]{nombre, animal.getNombre()});
    }

    public void eliminarAnimal(Animal animal) {
        animales.remove(animal);
        LOGGER.log(Level.INFO, "❌ Animal eliminado del corral {0}: {1}", new Object[]{nombre, animal.getNombre()});
    }

    // Gestión de sensores
    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
        LOGGER.log(Level.INFO, "📡 Sensor agregado al corral {0}: {1}", new Object[]{nombre, sensor.getTipo()});
    }

    public void notificarSensores() {
        for (Sensor sensor : sensores) {
            sensor.detectarCambio(null, "Verificación general de corral");
        }
    }

    // Simulación de consumo de alimento
    public void reducirAlimento(double cantidad) {
        this.nivelAlimento = Math.max(0, nivelAlimento - cantidad);
        LOGGER.log(Level.INFO, "🍽️ Corral {0}: nivel de alimento reducido a {1}%", new Object[]{nombre, nivelAlimento});
        notificarSensores();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public double getNivelAlimento() {
        return nivelAlimento;
    }

    public void setNivelAlimento(double nivelAlimento) {
        this.nivelAlimento = nivelAlimento;
    }

    @Override
    public String toString() {
        return "Corral: " + nombre + " | Animales: " + animales.size() + " | Alimento: " + nivelAlimento + "%";
    }
}
