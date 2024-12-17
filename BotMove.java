import java.lang.Math;
import java.util.Random;


public class BotMove{
    private int botX;
    private int botY; 

    public BotMove(int start_X, int start_Y){
        this.botX = start_X;
        this.botY = start_Y;
    }

    public int getBotX(){
        return botX;
    }

    public int getBotY(){
        return botY;
    }

    private boolean isValidMove(char[][] map, int x, int y) 
    {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != '#';
    }

    public String getBotCommand(char[][] map, int playerX, int playerY)
    {
        map[botX][botY] = '.';

        if (botX > playerX && isValidMove(map, botX - 1, botY))
        {
            botX -= 1;
            map[botX][botY] = 'B';
            return "Move N";
        }
        else if (botX < playerX && isValidMove(map, botX + 1, botY)) 
        {
            botX += 1;
            map[botX][botY] = 'B';
            return "Move S";
        }
        else if (botY > playerY && isValidMove(map, botX, botY - 1)) 
        {
            botY -= 1;
            map[botX][botY] = 'B';
            return "Move W";
        }
        else if (botY < playerY && isValidMove(map, botX, botY + 1)) 
        {
            botY += 1;
            map[botX][botY] = 'B';
            return "Move E";
        }
        map[botX][botY] = 'B';
        return "No Move";
    }


}