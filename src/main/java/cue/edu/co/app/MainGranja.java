package cue.edu.co.app;

import cue.edu.co.config.LoggerConfig;
import cue.edu.co.patrones.estructurales.facade.GranjaFacade;
import cue.edu.co.patrones.comportamentales.strategy.Estacion;
import cue.edu.co.modelos.Vaca;
import cue.edu.co.modelos.Pollo;
import cue.edu.co.modelos.Cerdo;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que ejecuta la simulación de la Granja Inteligente.
 * Utiliza el patrón *Facade* para orquestar las acciones generales
 * y coordina el comportamiento de los animales según su estado y la estación.
 */
public class MainGranja {

    // Logger para registrar los eventos de la simulación.
    private static final Logger LOGGER = Logger.getLogger(MainGranja.class.getName());

    public static void main(String[] args) {
        // Inicializa la configuración global del logger (colores, formato, niveles, etc.)
        LoggerConfig.configurar();

        // Mensaje de inicio de la simulación.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "🐓 --- SIMULACIÓN GRANJA INTELIGENTE ---");
        }

        // Se crea la fachada que centraliza la lógica principal de la granja.
        GranjaFacade fachada = new GranjaFacade();

        // Variables para guardar los datos ingresados por el usuario.
        String animal;
        String estacionInput;

        // Se utiliza un Scanner para recibir datos desde consola.
        try (Scanner sc = new Scanner(System.in)) {
            // Se pide al usuario que seleccione un animal para alimentar.
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, "Seleccione animal a alimentar [vaca/pollo/cerdo] (Enter para omitir): ");
            }
            animal = sc.nextLine();

            // Se pide al usuario que seleccione una estación del año.
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, "Seleccione estación [verano/invierno] (Enter para usar propiedades/env): ");
            }
            estacionInput = sc.nextLine();
        }

        // Se busca una configuración de estación desde propiedades del sistema o variables de entorno.
        String estacionProp = System.getProperty("estacion");
        if (estacionProp == null || estacionProp.isBlank()) {
            estacionProp = System.getenv("ESTACION");
        }

        // Por defecto se usa la estación VERANO.
        Estacion est = Estacion.VERANO;

        // Determina el criterio de estación, priorizando la entrada del usuario.
        String criterioEstacion = estacionInput;
        if (criterioEstacion == null || criterioEstacion.isBlank()) {
            criterioEstacion = estacionProp;
        }

        // Evalúa el valor ingresado o configurado y asigna la estación correspondiente.
        if (criterioEstacion != null) {
            switch (criterioEstacion.trim().toUpperCase()) {
                case "INVIERNO":
                    est = Estacion.INVIERNO;
                    break;
                case "VERANO":
                    est = Estacion.VERANO;
                    break;
                default:
                    est = Estacion.VERANO;
                    break;
            }
        }

        // Si el usuario especificó un animal, se alimenta su corral según la estación.
        if (animal != null && !animal.isBlank()) {
            String corral;
            switch (animal.trim().toLowerCase()) {
                case "vaca":
                case "vacas":
                    corral = "Corral de Vacas";
                    break;
                case "pollo":
                case "pollos":
                    corral = "Corral de Pollos";
                    break;
                case "cerdo":
                case "cerdos":
                    corral = "Corral de Cerdos";
                    break;
                default:
                    corral = "Corral de Vacas";
                    break;
            }

            // Se ejecutan las acciones del patrón Facade: alimentar y monitorear.
            fachada.alimentarCorralSegunEstacion(corral, est);
            fachada.monitorearSensores();

        } else {
            // Si no se especificó animal, se aplica una rutina general para toda la granja.
            fachada.seleccionarEstrategiaAlimentacion(est);
            fachada.ejecutarRutinaDiaria();
        }

        // ---------------- DEMOSTRACIÓN DE FUNCIONALIDADES ----------------
        // A continuación se crean instancias de animales para simular sus estados y acciones.

        // 🐄 Simulación con una vaca
        Vaca demo = new Vaca("Lola", 350.0);
        demo.mostrarInfo();
        demo.emitirSonido();
        demo.alimentarse();
        demo.enfermar();
        demo.emitirSonido();
        demo.iniciarTratamiento();
        demo.alimentarse();
        demo.curar();
        demo.emitirSonido();

        // 🐔 Simulación con un pollo
        Pollo demoPollo = new Pollo("Pepa", 2.3);
        demoPollo.mostrarInfo();
        demoPollo.emitirSonido();
        demoPollo.alimentarse();
        demoPollo.enfermar();
        demoPollo.emitirSonido();
        demoPollo.iniciarTratamiento();
        demoPollo.alimentarse();
        demoPollo.curar();
        demoPollo.emitirSonido();

        // 🐖 Simulación con un cerdo
        Cerdo demoCerdo = new Cerdo("Toto", 120.0);
        demoCerdo.mostrarInfo();
        demoCerdo.emitirSonido();
        demoCerdo.alimentarse();
        demoCerdo.enfermar();
        demoCerdo.emitirSonido();
        demoCerdo.iniciarTratamiento();
        demoCerdo.alimentarse();
        demoCerdo.curar();
        demoCerdo.emitirSonido();

        // Mensaje final de cierre de simulación.
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "✅ --- SIMULACIÓN COMPLETADA ---");
        }
    }
}
