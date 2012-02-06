package pim.command;

import java.util.Stack;

public class UndoCommand implements Command
{
  private Stack<Command> undoBuffer;
  private Stack<Command> redoBuffer;

  public UndoCommand(Stack<Command> undoBuffer, Stack<Command> redoBuffer)
  {
    this.undoBuffer = undoBuffer;
    this.redoBuffer = redoBuffer;
  }

  public void doCommand()
  {
    if (undoBuffer.size() > 0)
    {
      Command command = undoBuffer.pop();
      command.undoCommand();
      redoBuffer.push(command);
    }
  }

  public void undoCommand()
  {
  }

  public void redoCommand()
  {
  }

  public Command copy()
  {
    return null;
  }
}
