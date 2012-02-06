package pim.command;

import pim.util.Console;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CommandDispatcher
{
  private Map<String, Command> commands;
  private Stack<Command> undoBuffer;
  private Stack<Command> redoBuffer;

  public CommandDispatcher(Console console)
  {
    undoBuffer = new Stack<Command>();
    redoBuffer = new Stack<Command>();
    commands = new HashMap<String, Command>();

    commands.put("undo", new UndoCommand(undoBuffer, redoBuffer));
    commands.put("redo", new RedoCommand(undoBuffer, redoBuffer));
    commands.put("help", new HelpCommand(commands.keySet(), console));
  }

  public void addCommand(String commandName, Command command)
  {
    commands.put(commandName, command);
  }

  public boolean dispatchCommand(String commandName)
  {
    boolean commandDispatched = false;
    Command command = commands.get(commandName);

    if (command != null)
    {
      command.doCommand();
      commandDispatched = true;

      Command copy = command.copy();
      if (copy != null)
      {
        undoBuffer.push(copy);
      }
    }
    return commandDispatched;
  }
}
