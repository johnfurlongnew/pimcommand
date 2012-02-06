package pim.util;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Console
{
  private Queue<String> commandWords;
  private Scanner scanner;
  private PrintStream out;

  public Console(InputStream in, PrintStream out)
  {
    this.scanner = new Scanner(in);
    this.out = out;
    commandWords = new LinkedList<String>();
  }

  public void reset()
  {
    commandWords.clear();
  }

  public String getNext()
  {
    while (commandWords.isEmpty())
    {
      readNextCommandString();
    }
    return commandWords.remove();
  }

  public boolean hasCommands(String commands)
  {
    boolean success = true;
    StringTokenizer tokens = new StringTokenizer(commands);

    if (commandWords.size() != tokens.countTokens())
    {
      out.println("Usage: " + commands);
      commandWords.clear();
      success = false;
    }
    return success;
  }

  public void put(String str)
  {
    out.print(str);
  }

  public void putln(String str)
  {
    out.println(str);
  }

  public void putln(Object o)
  {
    out.println(o.toString());
  }

  private void readNextCommandString()
  {
    String commandLine = scanner.nextLine();
    while (commandLine.length() == 0)
    {
      commandLine = scanner.nextLine();
    }

    StringTokenizer tokens = new StringTokenizer(commandLine);
    while (tokens.hasMoreTokens())
    {
      commandWords.offer(tokens.nextToken());
    }
  }

  public boolean hasAnotherCommand()
  {
    return commandWords.size() > 0;
  }
}
