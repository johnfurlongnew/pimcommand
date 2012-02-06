package pim.main;

import pim.command.AddCommand;
import pim.command.ClearCommand;
import pim.command.CommandDispatcher;
import pim.command.DeleteCommand;
import pim.command.ListCommand;
import pim.command.NewCommand;
import pim.command.OpenCommand;
import pim.command.SaveCommand;

import pim.model.Pim;
import pim.util.Console;
 
public class PimConsole
{
  private Pim pim;
  private Console console;
  private CommandDispatcher commandDispatcher;

  public PimConsole(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
    this.commandDispatcher = new CommandDispatcher(console);
    loadCommands();
  }

  public void run()
  {
    console.putln("Address Book.");
    console.putln("Type 'help' for a list of commands.");

    String commandName;
    do
    {
      console.put(">");
      commandName = console.getNext();
      if (!commandDispatcher.dispatchCommand(commandName))
      {
        if (!commandName.equals("bye"))
        {
          console.putln("unknown command");
        }
      }
    }
    while (!(commandName.equals("bye")));
    System.out.println("Goodbye.");
  }

  private void loadCommands()
  {
    commandDispatcher.addCommand("new", new NewCommand(pim));
    commandDispatcher.addCommand("open", new OpenCommand(pim, console));
    commandDispatcher.addCommand("save", new SaveCommand(pim, console));
    commandDispatcher.addCommand("add", new AddCommand(pim, console));
    commandDispatcher.addCommand("list", new ListCommand(pim, console));
    commandDispatcher.addCommand("delete", new DeleteCommand(pim, console));
    commandDispatcher.addCommand("clear", new ClearCommand(pim, console));
  }
}
