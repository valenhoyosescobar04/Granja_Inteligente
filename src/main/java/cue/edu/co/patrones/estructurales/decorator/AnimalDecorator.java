package cue.edu.co.patrones.estructurales.decorator;

public abstract class AnimalDecorator implements Animal {
    protected Animal animalDecorado;

    public AnimalDecorator(Animal animal) {
        this.animalDecorado = animal;
    }

    @Override
    public String getDescripcion() {
        return animalDecorado.getDescripcion();
    }

    @Override
    public double getPeso() {
        return animalDecorado.getPeso();
    }
}