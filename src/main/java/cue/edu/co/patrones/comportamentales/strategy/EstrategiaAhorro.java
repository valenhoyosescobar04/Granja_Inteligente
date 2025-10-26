package cue.edu.co.patrones.comportamentales.strategy;

// Clase concreta que implementa la interfaz EstrategiaAlimentacion
// Representa una estrategia específica de alimentación basada en el ahorro de alimento
public class EstrategiaAhorro implements EstrategiaAlimentacion {

    // Sobrescribe el método definido en la interfaz EstrategiaAlimentacion
    // Este método calcula la cantidad de alimento que se debe usar
    // según la estrategia "Ahorro", que busca reducir el consumo en un 30%
    @Override
    public double calcularCantidad(double baseKg) {
        // Aplica la lógica de ahorro: reduce la cantidad base de alimento en un 30%
        // Multiplica la cantidad base (baseKg) por 0.70 → queda el 70% del total
        return baseKg * 0.70; // Retorna la cantidad reducida (-30%)
    }
}



