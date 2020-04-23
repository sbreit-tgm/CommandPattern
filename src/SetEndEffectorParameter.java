import java.util.PriorityQueue;

/**
 * ` which endeffector to use
 *
 * - beim Förderband 0 bis 8 ; welches Bauteil-Fach geöffnet wird (Zuordnung dokumentieren!)
 */
public class SetEndEffectorParameter extends Command{
    PriorityQueue<Integer> oldPosition=new PriorityQueue<Integer>();
    public  Integer id;

    public SetEndEffectorParameter(Robot robot) {
        super(robot);
    }

    public Integer getId() {
        return id;
    }
    public final void setId(Integer value)
    {
        id = value;
    }







    @Override
    public void execute() {
        robot.setEndEffectorParameter(id);
        oldPosition.add(id);
    }

    @Override
    public void undo() {

        System.out.println("back to position "+ oldPosition.poll());
    }


}
