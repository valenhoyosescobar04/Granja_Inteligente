package cue.edu.co.patrones.comportamentales.strategy;

// Definición de la interfaz EstrategiaAlimentacion
// Esta interfaz define el contrato o comportamiento general
// que deben seguir todas las estrategias de alimentación.
public interface EstrategiaAlimentacion {

    // Método que deben implementar todas las clases concretas
    // Recibe como parámetro la cantidad base de alimento (en kilogramos)
    // y devuelve la cantidad final calculada según la estrategia aplicada.
    double calcularCantidad(double baseKg);
}