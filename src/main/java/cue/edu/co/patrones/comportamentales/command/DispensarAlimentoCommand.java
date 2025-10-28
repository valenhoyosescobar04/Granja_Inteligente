package cue.edu.co.patrones.comportamentales.command;

// Comando específico para dispensar alimento
public class DispensarAlimentoCommand implements Command {
    private final Dispensador dispensador;
    private final double cantidad;
    private final String tipoAlimento;

    public DispensarAlimentoCommand(Dispensador dispensador, double cantidad, String tipoAlimento) {
        this.dispensador = dispensador;
        this.cantidad = cantidad;
        this.tipoAlimento = tipoAlimento;
    }

    @Override
    public void execute() {
        dispensador.dispensarAlimento(cantidad, tipoAlimento);
    }

    @Override
    public void undo() {
        // Permite deshacer la acción de dispensar
        dispensador.retirarAlimento(cantidad, tipoAlimento);
    }
}