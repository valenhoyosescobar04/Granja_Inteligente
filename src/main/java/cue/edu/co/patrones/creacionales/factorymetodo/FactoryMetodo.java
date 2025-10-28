package cue.edu.co.patrones.creacionales.factorymetodo;

public class FactoryMetodo {
    public static void main(String[] args) {
        AnimalFactory factory = new VacaFactory();
        Animal animal = factory.crearAnimal();
        animal.alimentar();
    }
}