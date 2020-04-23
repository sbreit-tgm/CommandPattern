public abstract class  Command {
    protected Robot robot;

    public Command(Robot robot)
    {
        this.robot = robot;
    }

    public abstract void execute();

    public abstract void undo();
}
