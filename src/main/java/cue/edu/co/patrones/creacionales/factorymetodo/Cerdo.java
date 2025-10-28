package cue.edu.co.patrones.creacionales.factorymetodo;

import java.util.logging.Logger;

public class Cerdo extends Animal {
    private static final Logger logger = Logger.getLogger(Cerdo.class.getName());

    public Cerdo() {
        this.nombre = "Cerdo";
    }

    @Override
    public void alimentar() {
        logger.info("Alimentando cerdo con maíz.");
    }
}
