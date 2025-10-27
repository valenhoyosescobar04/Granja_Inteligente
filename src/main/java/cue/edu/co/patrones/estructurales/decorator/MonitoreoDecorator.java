package cue.edu.co.patrones.estructurales.decorator;

// Decorador para añadir monitoreo de salud
public class MonitoreoDecorator extends AnimalDecorator {
    private String dispositivoMonitoreo;

    public MonitoreoDecorator(Animal animal, String dispositivo) {
        super(animal);
        this.dispositivoMonitoreo = dispositivo;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " con monitoreo por " + dispositivoMonitoreo;
    }

    @Override
    public double getPeso() {
        return 0;
    }

    @Override
    public void alimentar() {

    }

    @Override
    public String getEstadoSalud() {
        // Añade funcionalidad de monitoreo
        return "Monitoreando salud con " + dispositivoMonitoreo + ": " + super.getEstadoSalud();
    }
}
