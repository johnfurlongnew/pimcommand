package pim.main;

import pim.model.Pim;
import pim.util.Console;
import pim.util.XMLSerializer;

public class Main
{
  public static void main(String[] args)
  {
    Pim pim = new Pim(new XMLSerializer());
    Console console = new Console(System.in, System.out);
    PimConsole pimConsoleApp = new PimConsole(pim, console);
    pimConsoleApp.run();
  }
}
