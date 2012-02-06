package pim.command;

import pim.model.Pim;
import pim.util.Console;

public class ListCommand implements Command
{
  private Pim pim;
  private Console console;

  public ListCommand(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
  }

  public void doCommand()
  {
    console.putln(pim.getAddressBook());
  }

  public void undoCommand()
  {
  }

  public void redoCommand()
  {
  }

  public Command copy()
  {
    return null;
  }
}
