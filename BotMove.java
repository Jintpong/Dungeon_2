import java.lang.Math;
import java.util.Random;

// The BotMove class will be use to represent the bot that will be move within a 2D grid
// It will track the bot current position and the bot will chase the player by comparing the bot's position and the player's position and move one step closer

public class BotMove{
    // Storing the bot current position
    // botX represents row and botY represent column
    private int botX;
    private int botY; 

    public BotMove(int start_X, int start_Y){
        this.botX = start_X;
        this.botY = start_Y;
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

    public String getBotCommand(char[][] map, int playerX, int playerY)
    {
        // Clear the current position of the bot in the map
        map[botX][botY] = '.';

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

        // If no move is valid mark the bot current position
        map[botX][botY] = 'B';
        return "No Move";
    }


}