public class Festo implements Robot{
    @Override
    public void move(String position) {
        System.out.println("The Festo Robot moved to Positstion "+position);
    }

    @Override
    public void setEndEffector(boolean offen) {
        if (offen){
            System.out.println("The Festo  Robot  opend its Effector");
        }
        else {
            System.out.println("The Festo  Robot  closed its Effector");
        }
    }

    @Override
    public void setEndEffectorParameter(int id) {

        System.out.println("The Festo  Robot changed its tool to"+id);
    }

  
}
