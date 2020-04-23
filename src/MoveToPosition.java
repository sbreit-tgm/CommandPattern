import java.util.PriorityQueue;

public class MoveToPosition extends Command{
    PriorityQueue<String> oldPosition=new PriorityQueue<String>();
    public  String position;

    public MoveToPosition(Robot robot) {
        super(robot);
    }

    public String getPosition() {
        return position;
    }
    public final void setPosition(String value)
    {
        position = value;
    }





    

    @Override
    public void execute() {
        robot.move(position);
        oldPosition.add(position);
    }

    @Override
    public void undo() {

        System.out.println("back to position "+ oldPosition.poll());
    }


}
