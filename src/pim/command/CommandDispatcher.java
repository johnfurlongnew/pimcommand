package pim.command;

import pim.util.Console;

import java.util.HashMap;
import java.util.Map;


public class CommandDispatcher
{
  private Map<String, Command> commands;

  public CommandDispatcher(Console console)
  {
    commands = new HashMap<String, Command>();
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
    }
    return commandDispatched;
  }
}
