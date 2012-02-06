package pim.command;

import pim.model.Pim;
import pim.util.Console;

public class OpenCommand implements Command
{
  private Pim     pim;
  private Console console;

  public OpenCommand(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
  }

  public void doCommand()
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
}
