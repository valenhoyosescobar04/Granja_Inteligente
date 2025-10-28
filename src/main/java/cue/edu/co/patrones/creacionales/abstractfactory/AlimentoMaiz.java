package cue.edu.co.patrones.creacionales.abstractfactory;

import java.util.logging.Logger;

public class AlimentoMaiz implements Alimento {
    private static final Logger logger = Logger.getLogger(AlimentoMaiz.class.getName());

    @Override
    public void mostrarInfo() {
        logger.info("🌽 Alimento a base de maíz y vitaminas.");
    }
}
