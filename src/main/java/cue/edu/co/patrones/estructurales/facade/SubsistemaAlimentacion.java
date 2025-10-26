package cue.edu.co.patrones.estructurales.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import cue.edu.co.patrones.creacionales.singleton.AlimentadorGlobal;
import cue.edu.co.patrones.comportamentales.strategy.EstrategiaAlimentacion;
import cue.edu.co.patrones.comportamentales.strategy.EstrategiaVerano;
import cue.edu.co.patrones.comportamentales.strategy.EstrategiaInvierno;
import cue.edu.co.patrones.comportamentales.strategy.EstrategiaAhorro;
import cue.edu.co.patrones.comportamentales.strategy.Estacion;
/**
 * Subsistema responsable de la alimentación de los animales.
 * Encapsula la lógica de alimentación y control de comida.
 * Este subsistema puede integrarse con el patrón Strategy para
 * definir diferentes tipos de alimentación según especie o edad.
 */
public class SubsistemaAlimentacion {

    private static final Logger LOGGER = Logger.getLogger(SubsistemaAlimentacion.class.getName());
    private EstrategiaAlimentacion estrategia;
    private double baseKg = 50.0;

    public SubsistemaAlimentacion() {
        this.estrategia = new EstrategiaVerano();
    }

    /**
     * Distribuye alimento en un corral específico.
     * @param corral nombre del corral donde se realizará la distribución
     */
    public void distribuirAlimento(String corral) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.format("🍽️ Distribuyendo alimento en %s...", corral));
        }
        double cantidad = (estrategia != null) ? estrategia.calcularCantidad(baseKg) : baseKg;
        AlimentadorGlobal.getInstance().distribuirAlimento(corral, cantidad);
    }

    /**
     * Verifica la disponibilidad de alimento en inventario antes de distribuirlo.
     */
    public void verificarStock() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "📦 Verificando stock de alimento...");
        }
        AlimentadorGlobal.getInstance().verificarStock();
    }

    public void setEstrategia(EstrategiaAlimentacion estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategiaPorEstacion(Estacion estacion) {
        if (estacion == null) {
            this.estrategia = new EstrategiaVerano();
            return;
        }
        switch (estacion) {
            case INVIERNO:
                this.estrategia = new EstrategiaInvierno();
                break;
            case AHORRO:
                this.estrategia = new EstrategiaAhorro();
                break;
            case VERANO:
            default:
                this.estrategia = new EstrategiaVerano();
                break;
        }
    }
}