# Dungeon_2
Running the game 
First ensure that all the .java files are in the same directory by using the command to compile them which is: javac *.java

Once the program has been compile you can run the program by using: java Main.java

Once the game is running you will be ask to select the map by entering a number 1, 2, or 3. The selected map will be displayed and the game will begin 


Objected Oriented Design Principles
The program utilise the principles of object oriented programing by using encapsulation as shown in the class HumanPlayer, BotPlayer and Map manage it owns data and game logic. For instance BotPlayer class encapsulates bot specific logic that include tracking its position while the HumanPlayer manages the command from the user which include Move and Gold. 

Additionally, abstaction is showcased in the Map class which abstract map creation and the selection with the getMap method. This will allow the users to select from the map created.

 Lastly, the program ensures the reusability of the code as the design allows for an easy implementation and extension such as adding new maps in the Map class or improving the bot behavior in the BotPlayer. 