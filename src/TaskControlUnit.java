
public class TaskControlUnit {
    public static void main (String[]args) {
        Kuka kuka = new Kuka();
        Festo festo = new Festo();
        RobotController robotControllerFesto = new RobotController();
        RobotController robotControllerKuka = new RobotController();

        MoveToPosition moveF = new MoveToPosition(festo);
        moveF.setPosition("\"Pose\" : {\n" +
                "            \"X\": -60.0,\n" +
                "            \"Y\": 120.0,\n" +
                "            \"Z\": 90.0,\n" +
                "            \"A\": -80.0,\n" +
                "            \"B\": 100.0,\n" +
                "            \"C\": 130.0\n" +
                "        },");


        robotControllerFesto.Commands.offer(moveF);
        moveF.setPosition("\"Pose\" : {\n" +
                "            \"X\": -2.0,\n" +
                "            \"Y\": 30.0,\n" +
                "            \"Z\": 40.0,\n" +
                "            \"A\": -50.0,\n" +
                "            \"B\": 500.0,\n" +
                "            \"C\": 930.0\n" +
                "        },");


        robotControllerFesto.Commands.offer(moveF);
        robotControllerFesto.ExecuteCommands();
        moveF.setPosition("\"Pose\" : {\n" +
                "            \"X\": 0.0,\n" +
                "            \"Y\": 0.0,\n" +
                "            \"Z\": 0.0,\n" +
                "            \"A\": 0.0,\n" +
                "            \"B\": 0.0,\n" +
                "            \"C\": 0.0\n" +
                "        },");


        robotControllerFesto.Commands.offer(moveF);
        robotControllerFesto.ExecuteCommands();
        robotControllerFesto.UndoCommands(2);

        SetEndEffector seKuka = new SetEndEffector(kuka);
        // Werkzeug öffnen
        seKuka.setOffen(true);
        robotControllerKuka.Commands.offer(seKuka);
        // Wekrzeug wechseln
        SetEndEffectorParameter seeKuka = new SetEndEffectorParameter(kuka);
        seeKuka.setId(1);
        robotControllerKuka.Commands.offer(seeKuka);
        robotControllerKuka.ExecuteCommands();


    }

}
