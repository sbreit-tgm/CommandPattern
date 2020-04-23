

import java.util.LinkedList;
import java.util.Stack;

public class RobotController {
    public LinkedList<Command> Commands;
    private Stack<Command> undo;

    public RobotController()
    {
        Commands = new LinkedList<Command>();
        undo = new Stack<Command>();
    }

    public final void ExecuteCommands()
    {
        System.out.println("EXECUTING COMMANDS.");

        while (!Commands.isEmpty())
        {
            Command command = Commands.poll();
            command.execute();
            undo.push(command);
        }
    }

    public final void UndoCommands(int numUndos)
    {
        System.out.printf("REVERSING %1$s COMMAND(S)." + "\r\n", numUndos);

        while (numUndos > 0 && undo.size() > 0)
        {
            Command command = undo.pop();
            command.undo();
            numUndos--;
        }
    }
}