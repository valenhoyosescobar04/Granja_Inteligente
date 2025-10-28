package cue.edu.co.patrones.creacionales.abstractfactory;

public class GranjaLecheraFactory implements GranjaFactory {
    @Override
    public Animal crearAnimal() {
        return new VacaLechera("Holstein");
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoLechero();
    }

    @Override
    public Entorno crearEntorno() {
        return new EntornoPradera();
    }
}
