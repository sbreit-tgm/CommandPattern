public class Kuka implements Robot{
    @Override
    public void move(String position) {
        System.out.println("The KUKA Robot moved to Positstion "+position);
    }

    @Override
    public void setEndEffector(boolean offen) {
        if (offen){
            System.out.println("The KUKA  Robot  opend its Effector");
        }
        else {
            System.out.println("The KUKA  Robot  closed its Effector");
        }
    }

    @Override
    public void setEndEffectorParameter(int id) {
        System.out.println("The KUKA  Robot changed its tool to"+id);
    }


}
