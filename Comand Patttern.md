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

Da die Informationen zum ausführen 

Scheduler kann bei Liste schauen welche isFinsished parallel laufen dürfen etc









