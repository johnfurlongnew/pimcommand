package pim.command;

import pim.model.Contact;
import pim.util.Console;
import pim.model.Pim;

public class AddCommand implements Command
{
  private Pim pim;
  private Console console;

  public AddCommand(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
  }

  public void doCommand()
  {
    if (console.hasCommands("firstname lastname email"))
    {
      String firstName = console.getNext();
      String lastName = console.getNext();
      String email = console.getNext();
      if (pim.getAddressBook().getContact(email) == null)
      {
        Contact contact = new Contact(firstName, lastName, email);
        pim.getAddressBook().addContact(contact);
      }
      else
      {
        console.putln("Contact with that email already exists.");
      }
    }
  }
}
