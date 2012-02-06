package pim.command;

public interface Command
{
  void doCommand();

  void undoCommand();

  void redoCommand();
}
