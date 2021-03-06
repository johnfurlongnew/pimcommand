package pim.command;

import pim.model.Contact;
import pim.util.Console;
import pim.model.Pim;

public class AddCommand implements Command, Cloneable
{
  private Pim pim;
  private Console console;
  private Contact contact;

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
        contact = new Contact(firstName, lastName, email);
        pim.getAddressBook().addContact(contact);
      }
      else
      {
        console.putln("Contact with that email already exists.");
      }
    }
  }

  public void undoCommand()
  {
    pim.getAddressBook().deleteContact(contact);
  }

  public void redoCommand()
  {
    pim.getAddressBook().addContact(contact);
  }

  public Command copy()
  {
    AddCommand command = new AddCommand(pim, console);
    command.contact = contact;
    return command;
  }
}
