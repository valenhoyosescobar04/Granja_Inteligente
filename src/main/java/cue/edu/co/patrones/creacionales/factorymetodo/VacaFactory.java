package cue.edu.co.patrones.creacionales.factorymetodo;

public class VacaFactory extends AnimalFactory {
    @Override
    public Animal crearAnimal() {
        return new Vaca();
    }
}
