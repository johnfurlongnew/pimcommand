package pim.command;

import java.util.Stack;

public class RedoCommand implements Command
{
  private Stack<Command> undoBuffer;
  private Stack<Command> redoBuffer;

  public RedoCommand(Stack<Command> undoBuffer, Stack<Command> redoBuffer)
  {
    this.undoBuffer = undoBuffer;
    this.redoBuffer = redoBuffer;
  }

  public void doCommand()
  {
    if (redoBuffer.size() > 0)
    {
      Command command = redoBuffer.pop();
      command.redoCommand();
      undoBuffer.push(command);
    }
  }

  public void undoCommand()
  {
  }

  public void redoCommand()
  {
  }
}
