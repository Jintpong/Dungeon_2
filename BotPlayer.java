import java.lang.Math;
import java.util.Random;

// The BotPlayer class will be use to represent the bot that will be move within a 2D grid
// It will track the bot current position and the bot will chase the player by comparing the bot's position and the player's position and move one step closer

public class BotPlayer{
    // Storing the bot current position
    // botX represents row and botY represent column
    private int botX;
    private int botY; 
    private int goldCollected;
    private int goldToWin;


    public BotPlayer(int start_X, int start_Y){
        this.botX = start_X;
        this.botY = start_Y;
        this.goldCollected = 0;
        this.goldToWin = 3;
        
    }
    //Return the bot current X position
    public int getBotX(){
        return botX;
    }

    //Return the bot current Y position
    public int getBotY(){
        return botY;
    }

    // checking that the move that will be make will be valid
    private boolean isValidMove(char[][] map, int x, int y) 
    {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != '#';
    }

    //checking if the gold is valid in the position
    private boolean isGold(char[][] map, int x, int y)
    {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == 'G';
    }

    public String getBotCommand(char[][] map, int playerX, int playerY)
    {
        // Clear the current position of the bot in the map
        map[botX][botY] = '.';

        if (goldCollected >= goldToWin)
        {
            return "The bot has collected enough gold";
        }

        // Check if the bot is in the same position as the gold
        if (map[botX][botY] == 'G')
        {
            goldCollected += 1;
            map[botX][botY] = '.';
            map[botX][botY] = 'B';
            return "Bot pickup Gold";
        }
        
        if (isGold(map, botX - 1, botY))
        {
            botX += 1;
            goldCollected += 1;
            map[botX][botY] = 'B';
            return "Bot pick up gold and move N";
        }
        else if (isGold(map, botX + 1, botY))
        {
            botX += 1;
            goldCollected += 1;
            map[botX][botY] = 'B';
            return "Bot pick up gold and move S";
        }
        else if (isGold(map, botX, botY - 1))
        {
            botY -= 1;
            goldCollected += 1;
            map[botX][botY] = 'B';
            return "Bot pick up gold and move W";
        }
        else if (isGold(map, botX, botY + 1))
        {
            botX += 1;
            goldCollected += 1;
            map[botX][botY] = 'B';
            return "Bot pick up gold and move E";
        }


        if (botX == playerX && botY == playerY)
        {
            return "Bot has caught the player";
        }

        // Make the bot move N and mark new position on the map
        if (botX > playerX && isValidMove(map, botX - 1, botY))
        {
            botX -= 1;
            map[botX][botY] = 'B';
            return "Move N";
        }

        // Make the bot move S and mark new position on the map
        else if (botX < playerX && isValidMove(map, botX + 1, botY)) 
        {
            botX += 1;
            map[botX][botY] = 'B';
            return "Move S";
        }

        // Make the bot move W and mark new position on the map
        else if (botY > playerY && isValidMove(map, botX, botY - 1)) 
        {
            botY -= 1;
            map[botX][botY] = 'B';
            return "Move W";
        }

        // Make the bot move E and mark new position on the map
        else if (botY < playerY && isValidMove(map, botX, botY + 1)) 
        {
            botY += 1;
            map[botX][botY] = 'B';
            return "Move E";
        }
        else
        {
            // If no move is valid mark the bot current position
            map[botX][botY] = 'B';
            return "No Move";
        }

    }



}