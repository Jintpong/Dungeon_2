import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private final char[][] map_1 = {
        "####################".toCharArray(),
        "#...............E..#".toCharArray(),
        "#...G..............#".toCharArray(),
        "#.........G........#".toCharArray(),
        "#..................#".toCharArray(),
        "#..................#".toCharArray(),
        "#...G..............#".toCharArray(),
        "#.............G....#".toCharArray(),
        "####################".toCharArray()
    };

    private final char[][] map_2 = {
        "####################".toCharArray(),
        "#.........G........#".toCharArray(),
        "#..................#".toCharArray(),
        "#.........G........#".toCharArray(),
        "#.........E........#".toCharArray(),
        "#................G.#".toCharArray(),
        "#..................#".toCharArray(),
        "#..G...............#".toCharArray(),
        "####################".toCharArray()
    };

    private final char[][] map_3 = {
        "####################".toCharArray(),
        "#..............GE..#".toCharArray(),
        "#...G..............#".toCharArray(),
        "#..................#".toCharArray(),
        "#.G................#".toCharArray(),
        "#...............G..#".toCharArray(),
        "#..................#".toCharArray(),
        "#....G.............#".toCharArray(),
        "####################".toCharArray()
    };

    // Return the map
    public char[][] get_Map(int mapNumber) {
        if(mapNumber == 1){
            return map_1;
        }
        else if (mapNumber == 2){
            return map_2;
        }
        else if(mapNumber == 3){
            return map_3;
        }
        else{
            System.out.println("Invalid map number, map 1 will be chosen by default");
            return map_1;
        }
    }

    // Load map from a file
    public char[][] loadMapFromFile(String filePath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            char[][] map = new char[100][];
            int rowIndex = 0;
            while ((line = reader.readLine()) != null){
                map[rowIndex++] = line.toCharArray();
            }

            char[][] resizedMap = new char[rowIndex][];
            System.arraycopy(map, 0, resizedMap, 0, rowIndex);
            return resizedMap;
        }
        catch (IOException e){
            System.out.println("Error loading the map file");
            return null;
        }
    }

}

