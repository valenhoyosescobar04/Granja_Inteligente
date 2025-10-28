package cue.edu.co.patrones.creacionales.factorymetodo;

public class CerdoFactory extends AnimalFactory {
    @Override
    public Animal crearAnimal() {
        return new Cerdo();
    }
}