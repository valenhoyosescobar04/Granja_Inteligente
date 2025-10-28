package cue.edu.co.patrones.creacionales.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Fábrica concreta 1: vacas lecheras
        GranjaFactory granjaLechera = new GranjaLecheraFactory();
        Animal vaca = granjaLechera.crearAnimal();
        Alimento alimentoLechero = granjaLechera.crearAlimento();
        Entorno entornoLechero = granjaLechera.crearEntorno();

        vaca.mostrarInfo();
        alimentoLechero.mostrarInfo();
        entornoLechero.mostrarInfo();

        System.out.println("--------------------------------");

        // Fábrica concreta 2: cerdos
        GranjaFactory granjaPorcina = new GranjaPorcinaFactory();
        Animal cerdo = granjaPorcina.crearAnimal();
        Alimento alimentoMaiz = granjaPorcina.crearAlimento();
        Entorno entornoCorral = granjaPorcina.crearEntorno();

        cerdo.mostrarInfo();
        alimentoMaiz.mostrarInfo();
        entornoCorral.mostrarInfo();
    }
}
