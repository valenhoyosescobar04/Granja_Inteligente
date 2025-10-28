package cue.edu.co.patrones.creacionales.builder;

public class AnimalBuilder {
    private String tipo;
    private int edad;
    private double peso;
    private String historial;

    public AnimalBuilder tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public AnimalBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }

    public AnimalBuilder peso(double peso) {
        this.peso = peso;
        return this;
    }

    public AnimalBuilder historial(String historial) {
        this.historial = historial;
        return this;
    }

    // 👉 Método que crea el objeto final
    public AnimalPersonalizado build() {
        return new AnimalPersonalizado(tipo, edad, peso, historial);
    }
}
