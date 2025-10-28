package cue.edu.co.patrones.creacionales.abstractfactory;

public class GranjaPorcinaFactory implements GranjaFactory {
    @Override
    public Animal crearAnimal() {
        return new CerdoLandrace();
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoMaiz();
    }

    @Override
    public Entorno crearEntorno() {
        return new EntornoCorral();
    }
}
