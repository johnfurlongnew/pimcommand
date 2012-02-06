package pim.main;

import pim.model.Contact;
import pim.model.Pim;
import pim.util.Console;

public class PimConsole
{
  private Pim pim;
  private Console console;

  public PimConsole(Pim pim, Console console)
  {
    this.console = console;
    this.pim = pim;
  }

  public void run()
  {
    console.putln("Address Book.");
    console.putln("Type 'help' for a list of commands.");

    String command;

    do
    {
      System.out.print(">");
      command = console.getNext();

      if (command.equals("open"))
      {
        open();
      }
      else if (command.equals("save"))
      {
        save();
      }
      else if (command.equals("add"))
      {
        add();
      }
      else if (command.equals("delete"))
      {
        delete();
      }
      else if (command.equals("list"))
      {
        list();
      }
      else if (command.equals("clear"))
      {
        clear();
      }
      else if (command.equals("help"))
      {
        help();
      }
      else
      {
        if (!command.equals("bye"))
        {
          console.putln("unknown command");
        }
      }
    }
    while (!(command.equals("bye")));

    console.putln("Goodbye.");
  }

  private void open()
  {
    if (console.hasCommands("filename"))
    {

      String fileName = console.getNext();

      try
      {
        pim.open(fileName);
      }
      catch (Exception e)
      {
        console.putln("Error opening file");
      }
    }
  }

  private void save()
  {
    if (console.hasCommands("filename"))
    {
      String fileName = console.getNext();

      try
      {
        pim.save(fileName);
      }
      catch (Exception e)
      {
        console.putln("Error saving file");
      }
    }
  }

  private void add()
  {
    if (console.hasCommands("firstname lastname email"))
    {
      String firstName = console.getNext();
      String lastName = console.getNext();
      String email = console.getNext();

      pim.getAddressBook().addContact(new Contact(firstName, lastName, email));
    }
  }

  private void delete()
  {
    if (console.hasCommands("email"))
    {
      String email = console.getNext();
      Contact contact = pim.getAddressBook().getContact(email);
      pim.getAddressBook().deleteContact(contact);
    }
  }

  private void list()
  {
    console.put(pim.getAddressBook().toString());
  }

  private void clear()
  {
    pim.getAddressBook().clear();
  }

  private void help()
  {
    console.putln("open, save, add, delete, list, clear, help, bye");
  }
}
