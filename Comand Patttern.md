```

```

# Command Pattern



Das Command Pattern ist ein Behaviorial Pattern. 

Beim  Command Pattern werden  alle  Informationen, die zur Ausführung einer Methode benötigt werden, in einem Objekt gekapselt sind, das sofort verwendet oder für eine spätere Verwendung aufbewahrt werden könnte. Dieses Objekt führt nichts aus, es enthält nur Informationen.



![image-20200423234557750](Comand%20Patttern.assets/image-20200423234557750.png)

Quelle: https://de.wikibooks.org/wiki/Muster:_Command

* Client erstellt  Command Objekte die mit dem Reciver verbindet. 

* Reciver Diese Klasse weiß wie man die Commandos ausführt. (Zum Beispiel ein Move Befehl beim Festo ist was anderes als beim Kuka)
* CommandBase ist meist eine Abstrakte Klasse kann aber auch ein Interface sein welches als Grundlagen für alle Commands gilt. Sie enthält immer die Methode execute
* ConcreteCommand ist der Spezielle Command zb. Move im Beispeil unten.
* Invoker der entscheidet wann die Commands wirklich ausgeführt werden.





### Vorteile

Dadurch das das executen der Tasks abgekapselt ist ermöglicht dies für eine bessere Schedulen der Tasks. Wenn wir wieder auf das Beispiel Robotik eingehen kan mann bei einer Liste von Commands die bereit zum Ausführen sind einfach entscheiden welche Paralell von einander ablaufen können und welche Aufgaben priorität bekommen. So macht es Sinn die Berechnung eines Bewegunsablaufes vor zu ziehen da der Rechnerintensiv ist.  

Ein weiterer Vorteil ist das leichte inplementieren von undo() Methoden.



## Konkretes Beispiel



Das Beispiel ist unsere Diplomarbeit angelehnt. In der Diplomarbeit bekommen der Kuka und Festo Roboter von der Taskkontrolunit Befehle gesendet und müssen diese dann jeweils anders Interpretieren.

![image-20200424001121554](Comand%20Patttern.assets/image-20200424001121554.png)

![image-20200424000945823](Comand%20Patttern.assets/image-20200424000945823.png)





Speziell für dieses Beispiel gilt:



* Die Klasse Command ist sie schreibt allen Commands vor eine execute Methode und eine undo Methode zu haben. 

* MoveToPosition,SetEndefektor und SetEndEffectorParameter sind alle Conkrete Commands die von Command erben.

* Robot ist die Superklasse unserer für die beiden Reciver Kuka und Festo. Daher je nach dem welchen Reciver ich nacher erstelle wird der Move befehl anders Ausgeführt.

* Wie auch in echt ist der RobotControleler der Invoker 

* TaskControl Unit ist unsere Testklasse.

  

## Beispielhafter Aufruf eines Comands 



```java
//Zuerst muss ein Festo Reciver erstellt werden
Festo festo = new Festo();
// Danach ein oder mehrere Commands die man später ausführen möchte
// Als Parameter gebe ich hier den Reciver Festo an dh. der Command wird später auch dort ausgeführt 
MoveToPosition moveF = new MoveToPosition(festo);
// In diesem Fall setzte ich nun die Position des eben erstellten Commands
moveF.setPosition("\"Pose\" : {\n" +
                "            \"X\": -60.0,\n" +
                "            \"Y\": 120.0,\n" +
                "            \"Z\": 90.0,\n" +
                "            \"A\": -80.0,\n" +
                "            \"B\": 100.0,\n" +
                "            \"C\": 130.0\n" +
                "        },");
// Danach muss der Invoker erstellt werden damit wir den Command danch executen können
RobotController robotControllerFesto = new RobotController();
// Nun füge ich den Command der linkList Commands in Invoker hinzu 
obotControllerFesto.Commands.offer(moveF);

// Zwischen dem erstlen und den Ausführen des Commands kann soviel Zeit vergehen wie man möchte
// Nun wird der Command executed
 robotControllerFesto.ExecuteCommands();


```



Beispiel Ausgabe:

Hier sieht man die ausgabe back to position ....

Dadurch das die  Reihenfolge der Ausführung der Commands abgespeichert wurde und jedes Command eine undo() Methode hat kann man Commands leicht "rückgäng" machen.

```
robotControllerFesto.UndoCommands(2);
```



![image-20200424003653836](Comand%20Patttern.assets/image-20200424003653836.png)

