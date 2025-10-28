package cue.edu.co.patrones.creacionales.abstractfactory;

import java.util.logging.Logger;

public class EntornoPradera implements Entorno {
    private static final Logger logger = Logger.getLogger(EntornoPradera.class.getName());

    @Override
    public void mostrarInfo() {
        logger.info("🌾 Entorno: Pradera templada con sombra natural.");
    }
}
