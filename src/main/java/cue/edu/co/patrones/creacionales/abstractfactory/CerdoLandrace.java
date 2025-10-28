package cue.edu.co.patrones.creacionales.abstractfactory;

import java.util.logging.Logger;

public class CerdoLandrace implements Animal {
    private static final Logger logger = Logger.getLogger(CerdoLandrace.class.getName());

    @Override
    public void mostrarInfo() {
        logger.info("🐖 Cerdo raza Landrace, ideal para carne magra.");
    }
}
