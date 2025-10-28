package cue.edu.co.patrones.estructurales.adapter;

import java.util.HashMap;
import java.util.Map;

// Adaptador que convierte las lecturas del sensor antiguo al formato moderno
public class SensorAdapter implements SensorModerno {
    private SensorLegacy sensorLegacy;

    public SensorAdapter(SensorLegacy sensorLegacy) {
        this.sensorLegacy = sensorLegacy;
    }

    @Override
    public double obtenerTemperatura() {
        // Convertir de Fahrenheit a Celsius
        return (sensorLegacy.getTemperaturaFahrenheit() - 32) * 5.0/9.0;
    }

    @Override
    public double obtenerHumedad() {
        // Convertir el valor raw a porcentaje (600 = 60.0%)
        return sensorLegacy.getHumedadRaw() / 10.0;
    }

    @Override
    public Map<String, Double> obtenerParametrosAmbientales() {
        int[] datosLegacy = sensorLegacy.getDatosAmbientales();
        Map<String, Double> parametros = new HashMap<>();
        parametros.put("CO2_ppm", (double) datosLegacy[0]);
        parametros.put("NH3_ppm", (double) datosLegacy[1]);
        parametros.put("Intensidad_Luz", (double) datosLegacy[2]);
        return parametros;
    }

    @Override
    public boolean necesitaMantenimiento() {
        return sensorLegacy.getEstadoSensor() != 0x01;
    }
}
