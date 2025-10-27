package cue.edu.co.patrones.estructurales.decorator;

// Implementación base de un animal
public class AnimalBase implements Animal {
    private String tipo;
    private double peso;
    private String estadoSalud;

    public AnimalBase(String tipo, double peso) {
        this.tipo = tipo;
        this.peso = peso;
        this.estadoSalud = "Saludable";
    }

    @Override
    public String getDescripcion() {
        return "Animal tipo: " + tipo;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public void alimentar() {
        System.out.println("Animal alimentado con comida estándar");
    }

    @Override
    public String getEstadoSalud() {
        return estadoSalud;
    }
}
