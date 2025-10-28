package cue.edu.co.app;

import cue.edu.co.config.LoggerConfig;
import cue.edu.co.patrones.estructurales.facade.GranjaFacade;
import cue.edu.co.patrones.comportamentales.strategy.Estacion;

// 🐄 Modelos base
import cue.edu.co.modelos.Vaca;
import cue.edu.co.modelos.Pollo;
import cue.edu.co.modelos.Cerdo;

import cue.edu.co.patrones.creacionales.factorymetodo.*;
import cue.edu.co.patrones.creacionales.builder.*;
import cue.edu.co.patrones.creacionales.abstractfactory.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que ejecuta la simulación de la Granja Inteligente.
 * Integra los patrones: Facade, Strategy, State, Factory Method, Builder y Abstract Factory.
 */
public class MainGranja {

    private static final Logger LOGGER = Logger.getLogger(MainGranja.class.getName());

    public static void main(String[] args) {

        // Configuración inicial del logger
        LoggerConfig.configurar();
        LOGGER.info("🐓 --- SIMULACIÓN GRANJA INTELIGENTE ---");

        // Crear fachada principal
        GranjaFacade fachada = new GranjaFacade();

        String animal;
        String estacionInput;

        try (Scanner sc = new Scanner(System.in)) {
            LOGGER.info("Seleccione animal a alimentar [vaca/pollo/cerdo] (Enter para omitir): ");
            animal = sc.nextLine();
            LOGGER.info("Seleccione estación [verano/invierno] (Enter para usar propiedades/env): ");
            estacionInput = sc.nextLine();
        }

        // Determinar estación (entrada, variable de entorno o sistema)
        String estacionProp = System.getProperty("estacion");
        if (estacionProp == null || estacionProp.isBlank()) {
            estacionProp = System.getenv("ESTACION");
        }

        Estacion est = Estacion.VERANO;
        String criterioEstacion = estacionInput != null && !estacionInput.isBlank()
                ? estacionInput
                : estacionProp;

        if (criterioEstacion != null) {
            switch (criterioEstacion.trim().toUpperCase()) {
                case "INVIERNO":
                    est = Estacion.INVIERNO;
                    break;
                case "VERANO":
                default:
                    est = Estacion.VERANO;
                    break;
            }
        }

        // ==============================================================
        // 🧩 PATRONES CREACIONALES
        // ==============================================================

        // 🏭 FACTORY METHOD → crear animales según selección del usuario
        if (animal != null && !animal.isBlank()) {
            AnimalFactory factory;
            switch (animal.trim().toLowerCase()) {
                case "vaca":
                    factory = new VacaFactory();
                    break;
                case "cerdo":
                    factory = new CerdoFactory();
                    break;
                default:
                    factory = new VacaFactory();
                    break;
            }

            cue.edu.co.patrones.creacionales.factorymetodo.Animal animalCreado = factory.crearAnimal();
            animalCreado.alimentar();

            // 🧱 BUILDER → construir un animal personalizado
            AnimalPersonalizado personalizado = new AnimalBuilder()
                    .tipo(animalCreado.getClass().getSimpleName())
                    .edad((int) (Math.random() * 10 + 1))
                    .peso(Math.random() * 500)
                    .historial("Vacunado, sensor IoT activo.")
                    .build();
            personalizado.mostrarInfo();

            // 🏗️ ABSTRACT FACTORY → crear familias de objetos coherentes
            GranjaFactory granjaFactory;
            if (animal.equalsIgnoreCase("vaca")) {
                granjaFactory = new GranjaLecheraFactory();
            } else {
                granjaFactory = new GranjaPorcinaFactory();
            }

            cue.edu.co.patrones.creacionales.abstractfactory.Animal afAnimal = granjaFactory.crearAnimal();
            Alimento afAlimento = granjaFactory.crearAlimento();
            Entorno afEntorno = granjaFactory.crearEntorno();

            afAnimal.mostrarInfo();
            afAlimento.mostrarInfo();
            afEntorno.mostrarInfo();

            // 🧩 FACADE → rutina combinada
            String corral;
            switch (animal.trim().toLowerCase()) {
                case "vaca":
                    corral = "Corral de Vacas";
                    break;
                case "pollo":
                    corral = "Corral de Pollos";
                    break;
                case "cerdo":
                    corral = "Corral de Cerdos";
                    break;
                default:
                    corral = "Corral de Vacas";
                    break;
            }

            fachada.alimentarCorralSegunEstacion(corral, est);
            fachada.monitorearSensores();

        } else {
            fachada.seleccionarEstrategiaAlimentacion(est);
            fachada.ejecutarRutinaDiaria();
        }

        // ==============================================================
        // 🧪 DEMOSTRACIÓN DE ESTADOS Y ESTRATEGIAS
        // ==============================================================

        // 🐄 Vaca
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

        // 🐔 Pollo
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

        // 🐖 Cerdo
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

        LOGGER.log(Level.INFO, "✅ --- SIMULACIÓN COMPLETADA ---");
    }
}