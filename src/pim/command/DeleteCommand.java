package pim.command;

import pim.model.Contact;
import pim.model.Pim;
import pim.util.Console;

public class DeleteCommand implements Command
{
  private Pim pim;
  private Console console;

  public DeleteCommand(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
  }

  public void doCommand()
  {
    if (console.hasCommands("lastname"))
    {
      String email = console.getNext();
      Contact contact = pim.getAddressBook().getContact(email);
      if (contact != null)
      {
        pim.getAddressBook().deleteContact(contact);
      }
    }
  }
}
