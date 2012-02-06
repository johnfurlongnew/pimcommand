package pim.command;

import pim.util.Console;


import java.util.Set;


public class HelpCommand implements Command
{
  private Console console;
  private Set<String> commandNames;

  public HelpCommand(Set<String> commandNames, Console console)
  {
    this.console = console;
    this.commandNames = commandNames;
  }

  public void doCommand()
  {
    console.putln(commandNames);
  }

  public void undoCommand()
  {
  }

  public void redoCommand()
  {
    console.putln(commandNames);
  }
}
