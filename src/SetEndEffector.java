import java.util.PriorityQueue;

public class SetEndEffector extends Command{
    PriorityQueue<Boolean> oldPosition=new PriorityQueue<Boolean>();
    public  boolean offen;

    public SetEndEffector(Robot robot) {
        super(robot);
    }

    public Boolean getOffen() {
        return offen;
    }
    public final void setOffen(Boolean value)
    {
        offen = value;
    }







    @Override
    public void execute() {
        robot.setEndEffector(offen);
        oldPosition.add(offen);
    }

    @Override
    public void undo() {

        System.out.println("back to position "+ oldPosition.poll());
    }


}
