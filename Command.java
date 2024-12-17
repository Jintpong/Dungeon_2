import java.util.Random;

public class Command {
    private char[][] map;
    // Create the amount of gold to win
    private int goldtowin;
    private int playergold;
    // The position of the player 
    private int playerX ;
    private int playerY;
    //The position of the bot
    private int botX;
    private int botY;
    // Use this to keep track of the position of 'G'
    private boolean[][] positionGold;
    //Use this to keep track of the position of 'E'
    private boolean[][] positionExit;
    //Will use this in the while loop to keep track that as long as the game is not over continue asking the player
    private boolean endgame;
    private BotMove bot;

    // Constructor
    public Command(char[][] map) {
        this.map = map;
        this.bot = new BotMove(botX, botY);
        // Initialise the position of gold
        this.positionGold = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == 'G'){
                    positionGold[i][j] = true;
                }

            }
        }

        //Initialise the position of Exit
        this.positionExit = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == 'E'){
                    positionGold[i][j] = true;
                }

            }
        }

        // Make the player spawn in the random location 
        Random random = new Random();
        do {
            this.playerX = random.nextInt(map.length);
            this.playerY = random.nextInt(map[0].length);
        } while (map[playerX][playerY] != '.' || positionGold[playerX][playerY] || positionExit[playerX][playerY]);

        this.botX = 4;
        this.botY = 2;
        this.goldtowin = 3;
        this.playergold = 0;
        this.endgame = false;
        map[playerX][playerY] = 'P';
        map[botX][botY] = 'B';

    }


    public void HumanCommand(String command) {
        if (command.equals("QUIT")) {
            System.out.println("Player quit the game.");
            endgame = true; // End the game loop
        } 
        else if (command.equals("HELLO")) {
            System.out.println("Gold to win: " + goldtowin);
            } 

        else if (command.startsWith("MOVE")) 
        {
            // Existing MOVE logic
            String direction = command.substring(5).toUpperCase().trim(); // Extract direction
            int new_x = playerX;
            int new_y = playerY;

            // Update position based on direction
            if (direction.equals("N")) {
                new_x -= 1;
            } 
            else if (direction.equals("S")) {
                new_x += 1;
            } 
            else if (direction.equals("E")) {
                new_y += 1;
            } 
            else if (direction.equals("W")) {
                new_y -= 1;
            } 
            else {
                System.out.println("Invalid Direction");
                return; // Exit early on invalid direction
            }

            // Check new position
            if (new_x >= 0 && new_x < map.length && new_y >= 0 && new_y < map[0].length) {
                // Check that it's not a wall
                if (map[new_x][new_y] != '#') {
                    // Handle moving to exit
                    if (positionExit[new_x][new_y]) {
                        map[new_x][new_y] = 'P';
                    }
                    // Handle moving to gold
                    else if (map[new_x][new_y] == 'G') {
                        map[new_x][new_y] = 'P';
                    }

                    // Clear old position
                    map[playerX][playerY] = '.';
                    playerX = new_x;
                    playerY = new_y;

                    // Mark the new position
                    map[playerX][playerY] = 'P';
                    System.out.println("Success");

                    // Print the updated map
                    for (char[] row : map) {
                        System.out.println(new String(row));
                    }
                } else {
                    System.out.println("Fail! Cannot move into a wall.");
                }
            } else {
                System.out.println("Fail! The position is out of bounds.");
            }
        } 
        else if (command.equals("PICKUP")) {
            // Handle PICKUP logic
            if (positionGold[playerX][playerY]) {
                playergold += 1;
                positionGold[playerX][playerY] = false; // Remove gold from the map
                System.out.println("Success! Gold owned: " + playergold);
            } else {
                System.out.println("Fail. No gold to pick up.");
            }
        } 
        else if (command.equals("GOLD")) {
            System.out.println("Gold owned: " + playergold);
            }

        else if (command.equals("LOOK")) {
                // Display 5x5 grid around the player
                for (int row = -2; row <= 2; row++) {
                    for (int col = -2; col <= 2; col++) {
                        int x = playerX + row;
                        int y = playerY + col;

                    if(x >= 0 && x < map.length && y >= 0 && y < map[0].length)
                        if (x == playerX && y == playerY) {
                            System.out.print("P");
                        } 
                        else if (x == botX && y == botY) {
                            System.out.print("B");
                        } 
                        else if (positionGold[x][y]){
                            System.out.print("G");
                        }
                        else if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
                            System.out.print(map[x][y]);
                        } 
                        else 
                        {
                            System.out.print("#");
                        }
                    }
                    System.out.println();
                }
            }
 
        else 
         {
            System.out.println("Unknown command");
        }
    }

//Need to create a while loop to keep asking the user until the game is finnished
    // Creating a method to process user input
    public void UserInput() {
        while (!endgame) {
            System.out.println("Enter a command: ");
            String command;

            if (System.console() != null) {
                command = System.console().readLine().trim().toUpperCase();
                // Human Player turn
                HumanCommand(command);
                if (endgame) break;



                // Bot turn 
                String botCommand = bot.getBotCommand(map, playerX, playerY);
                System.out.println("Bot command: " + botCommand);

                
            }

            else 
            {
                System.out.println("Please run in a terminal.");
                break; 
            }
        }
    }


}
