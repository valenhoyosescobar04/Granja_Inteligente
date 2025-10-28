package cue.edu.co.patrones.creacionales.abstractfactory;

import java.util.logging.Logger;

public class EntornoCorral implements Entorno {
    private static final Logger logger = Logger.getLogger(EntornoCorral.class.getName());

    @Override
    public void mostrarInfo() {
        logger.info("🏚️ Entorno: Corral seco y ventilado.");
    }
}