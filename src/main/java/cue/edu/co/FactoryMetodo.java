package cue.edu.co;

import java.util.logging.Logger;

// Clase principal con método main
public class FactoryMetodo {
    public static void main(String[] args) {
        AnimalFactory factory = new VacaFactory(); // Crear la fábrica
        Animal animal = factory.crearAnimal();     // Crear el animal
        animal.alimentar();                        // Usar el método del animal
    }
}

// Producto abstracto
abstract class Animal {
    protected String nombre;
    public abstract void alimentar();
}

// Productos concretos con Logger
class Vaca extends Animal {
    private static final Logger logger = Logger.getLogger(Vaca.class.getName());

    public Vaca() {
        this.nombre = "Vaca";
    }

    @Override
    public void alimentar() {
        logger.info("Alimentando vaca con pasto.");
    }
}

class Cerdo extends Animal {
    private static final Logger logger = Logger.getLogger(Cerdo.class.getName());

    public Cerdo() {
        this.nombre = "Cerdo";
    }

    @Override
    public void alimentar() {
        logger.info("Alimentando cerdo con maíz.");
    }
}

// Fábrica abstracta
abstract class AnimalFactory {
    public abstract Animal crearAnimal();
}

// Fábricas concretas
class VacaFactory extends AnimalFactory {
    @Override
    public Animal crearAnimal() {
        return new Vaca();
    }
}

class CerdoFactory extends AnimalFactory {
    @Override
    public Animal crearAnimal() {
        return new Cerdo();
    }
}
