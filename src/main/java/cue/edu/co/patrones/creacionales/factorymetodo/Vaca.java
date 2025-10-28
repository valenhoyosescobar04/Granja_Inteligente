package cue.edu.co.patrones.creacionales.factorymetodo;

import java.util.logging.Logger;

public class Vaca extends Animal {
    private static final Logger logger = Logger.getLogger(Vaca.class.getName());

    public Vaca() {
        this.nombre = "Vaca";
    }

    @Override
    public void alimentar() {
        logger.info("🐄 Alimentando vaca con pasto.");
    }
}
