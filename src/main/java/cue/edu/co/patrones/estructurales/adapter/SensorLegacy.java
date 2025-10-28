package cue.edu.co.patrones.estructurales.adapter;

// Clase del sensor antiguo que necesitamos adaptar
public class SensorLegacy {
    public int getTemperaturaFahrenheit() {
        return 77; // Ejemplo
    }

    public int getHumedadRaw() {
        return 600; // Valor raw (necesita ser convertido a porcentaje)
    }

    public byte getEstadoSensor() {
        return 0x01; // 0x01: OK, 0x00: Error
    }

    public int[] getDatosAmbientales() {
        // Retorna array con: [CO2, NH3, Luz]
        return new int[]{400, 15, 800};
    }
}