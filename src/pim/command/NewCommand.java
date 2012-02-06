package pim.command;

import pim.model.AddressBook;
import pim.model.Pim;

public class NewCommand implements Command
{
  private Pim pim;
  private AddressBook addressBook;

  public NewCommand(Pim pim)
  {
    this.pim = pim;
  }

  public void doCommand()
  {
    addressBook = pim.getAddressBook();
    pim.newPim();
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
    NewCommand command = new NewCommand(pim);
    command.addressBook = addressBook;
    return command;
  }
}
