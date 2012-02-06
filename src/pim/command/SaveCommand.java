package pim.command;

import pim.model.Pim;
import pim.util.Console;

public class SaveCommand implements Command
{
  private Pim pim;
  private Console console;
  private String fileName;

  public SaveCommand(Pim pim, Console console)
  {
    this.pim = pim;
    this.console = console;
  }

  public void doCommand()
  {
    if (console.hasCommands("filename"))
    {
      fileName = console.getNext();
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

  public void undoCommand()
  {
  }

  public void redoCommand()
  {
    try
    {
      pim.save(fileName);
    }
    catch (Exception e)
    {
      console.putln("Error saving file");
    }
  }

  public Command copy()
  {
    return null;
  }
}
