package pim.command;

import pim.model.Pim;

public class NewCommand implements Command
{
  private Pim pim;

  public NewCommand(Pim pim)
  {
    this.pim = pim;
  }

  public void doCommand()
  {
    pim.newPim();
  }
}
