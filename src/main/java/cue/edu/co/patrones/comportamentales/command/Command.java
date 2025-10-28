package cue.edu.co.patrones.comportamentales.command;

/**
 * Patrón Command
 * Encapsula acciones como objetos para ejecutar, deshacer o programar
 */

// Interfaz base para todos los comandos
public interface Command {
    void execute();
    void undo();
}