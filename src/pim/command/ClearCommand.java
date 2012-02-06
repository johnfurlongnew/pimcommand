package pim.command;

import pim.model.Pim;
import pim.util.Console;

public class ClearCommand implements Command
{
  private Pim pim;
  private Console console;

  public ClearCommand(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
  }

  public void doCommand()
  {
    pim.getAddressBook().clear();
  }
}
