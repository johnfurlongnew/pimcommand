package pim.command;

import pim.model.AddressBook;
import pim.model.Pim;
import pim.util.Console;

public class ClearCommand implements Command
{
  private Pim pim;
  private Console console;
  private AddressBook addressBook;

  public ClearCommand(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
  }

  public void doCommand()
  {
    addressBook = pim.getAddressBook();
    pim.setAddressBook(new AddressBook());
  }

  public void undoCommand()
  {
    pim.setAddressBook(addressBook);
  }

  public void redoCommand()
  {
    doCommand();
  }

  public Command copy()
  {
    ClearCommand command = new ClearCommand(pim, console);
    command.addressBook = addressBook;
    return command;
  }
}
