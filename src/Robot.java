import javax.swing.text.Position;

public interface Robot {
    public void move(String position);
    public void setEndEffector(boolean offen);
    public void setEndEffectorParameter(int id);

}
