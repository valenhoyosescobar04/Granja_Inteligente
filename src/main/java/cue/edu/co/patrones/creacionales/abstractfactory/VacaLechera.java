package cue.edu.co.patrones.creacionales.abstractfactory;

import java.util.logging.Logger;

public class VacaLechera implements Animal {
    private static final Logger logger = Logger.getLogger(VacaLechera.class.getName());
    private final String raza;

    public VacaLechera(String raza) {
        this.raza = raza;
    }

    @Override
    public void mostrarInfo() {
        logger.info("🐄 Vaca lechera de raza " + raza + " lista para producción de leche.");
    }
}
