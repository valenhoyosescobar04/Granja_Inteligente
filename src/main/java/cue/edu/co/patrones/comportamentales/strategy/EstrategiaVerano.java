package cue.edu.co.patrones.comportamentales.strategy;

// Clase concreta que implementa la interfaz EstrategiaAlimentacion
// Representa la estrategia de alimentación correspondiente a la época de verano.
public class EstrategiaVerano implements EstrategiaAlimentacion {

    // Sobrescribe el método de la interfaz EstrategiaAlimentacion.
    // En la estrategia de verano, se asume que las condiciones son estables
    // (por ejemplo, hay suficiente alimento o la temperatura no exige más consumo),
    // por lo que no se modifica la cantidad base.
    @Override
    public double calcularCantidad(double baseKg) {
        // Retorna la misma cantidad de alimento que la base,
        // sin aplicar aumentos ni reducciones.
        return baseKg; // Sin cambio
    }
}

