package cue.edu.co.patrones.creacionales.singleton;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlimentadorGlobal {

        private static final Logger LOGGER = Logger.getLogger(AlimentadorGlobal.class.getName());
        private static volatile AlimentadorGlobal instance;

        private double stockDisponibleKg;

        private AlimentadorGlobal() {
            this.stockDisponibleKg = 500.0;
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, String.format("📦 AlimentadorGlobal inicializado con stock: %.2f kg", stockDisponibleKg));
            }
        }

        public static AlimentadorGlobal getInstance() {
            if (instance == null) {
                synchronized (AlimentadorGlobal.class) {
                    if (instance == null) {
                        instance = new AlimentadorGlobal();
                    }
                }
            }
            return instance;
        }

        public void verificarStock() {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, String.format("📊 Stock de alimento disponible: %.2f kg", stockDisponibleKg));
            }
        }

        public void distribuirAlimento(String corral, double cantidadKg) {
            if (cantidadKg <= 0) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.log(Level.INFO, "Cantidad solicitada debe ser mayor a 0 kg");
                }
                return;
            }

            if (stockDisponibleKg >= cantidadKg) {
                stockDisponibleKg -= cantidadKg;
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.log(Level.INFO, String.format("🍽️ Distribuidos %.2f kg en %s. Stock restante: %.2f kg", cantidadKg, corral, stockDisponibleKg));
                }
            } else {
                if (LOGGER.isLoggable(Level.WARNING)) {
                    LOGGER.log(Level.WARNING, String.format("🚨 Stock insuficiente. Solicitado: %.2f kg, Disponible: %.2f kg", cantidadKg, stockDisponibleKg));
                }
            }
        }

        public void recargarStock(double cantidadKg) {
            if (cantidadKg > 0) {
                stockDisponibleKg += cantidadKg;
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.log(Level.INFO, String.format("✅ Stock recargado en %.2f kg. Total: %.2f kg", cantidadKg, stockDisponibleKg));
                }
            }
        }

        public double getStockDisponibleKg() {
            return stockDisponibleKg;
        }
    }

