package cue.edu.co.patrones.creacionales.abstractfactory;

import java.util.logging.Logger;

public class AlimentoLechero implements Alimento {
    private static final Logger logger = Logger.getLogger(AlimentoLechero.class.getName());

    @Override
    public void mostrarInfo() {
        logger.info("🥛 Alimento balanceado lechero, alto en proteínas.");
    }
}
