package cue.edu.co.patrones.comportamentales.strategy;

// Clase concreta que implementa la interfaz EstrategiaAlimentacion
// Representa una estrategia de alimentación específica para la época de invierno.
public class EstrategiaInvierno implements EstrategiaAlimentacion {

    // Sobrescribe el método definido en la interfaz EstrategiaAlimentacion.
    // En esta estrategia, los animales consumen más alimento
    // debido a las bajas temperaturas o a la menor disponibilidad de recursos.
    @Override
    public double calcularCantidad(double baseKg) {
        // Aumenta la cantidad base de alimento en un 20%.
        // Multiplica la cantidad base (baseKg) por 1.20 para reflejar ese incremento.
        return baseKg * 1.20; // +20%
    }
}

