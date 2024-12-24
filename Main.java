import java.util.Scanner;


public class Main {
    public static void Main(String[] args) {
        // Create an instance of the Map class
        Scanner scanner = new Scanner(System.in);
        Map gameMap = new Map();


        System.out.println("Select how you want to load the map: ");
        System.out.println("1 Choose a predifined map");
        System.out.println("2 Load a custom map from a file");
        System.out.println("Enter you choice: ");

        int user_choice = scanner.nextInt();
        scanner.nextLine();

        if (user_choice == 1){
            // Ask the user to select the predefined map
            System.out.println("Choose a predefined map: ");
            System.out.println("Choose 1 for Map 1 ");
            System.out.println("Choose 2 for Map 2 ");
            System.out.println("Choose 3 for Map 3 ");
            System.out.println("Enter your choice:  ");

            // check the user input 
            int choice = scanner.nextInt();

            //Get the map base on the chosen choice
            char[][] chosenMap = gameMap.get_Map(choice);
            break;


        }
        else if (user_choice == 2){
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            chosenMap = gameMap.loadMapFromFile(filePath);
            break;
        }
        else{
            System.out.println("Invalid Choice");
        }


        //display map
        for (char[] row : chosenMap){
            System.out.println(new String(row));
        }

        HumanPlayer command = new HumanPlayer(chosenMap);
        command.UserInput();

    }
}


