package pim.main;

import pim.model.Pim;
import pim.util.Console;

public class Main
{
  public static void main(String[] args)
  {
    Pim pim = new Pim();
    Console console = new Console(System.in, System.out);
    PimConsole pimConsoleApp = new PimConsole(pim, console);
    pimConsoleApp.run();
  }
}
