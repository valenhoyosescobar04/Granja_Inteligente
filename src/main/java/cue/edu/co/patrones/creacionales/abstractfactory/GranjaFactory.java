package cue.edu.co.patrones.creacionales.abstractfactory;

public interface GranjaFactory {
    Animal crearAnimal();
    Alimento crearAlimento();
    Entorno crearEntorno();
}