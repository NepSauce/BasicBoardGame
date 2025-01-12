import java.util.Scanner;

public class GameDemo{
    public static void main(String[] args){
        Board board = new Board();
        try (Scanner input = new Scanner(System.in)) {
            boolean gameStatus = true;

            //Runs the while loop as long as "exit" isn't a command
            while (gameStatus){
                System.out.println("Enter a command (type help for details): ");
                String command = input.nextLine();

                //Breaks and exits program if "exit" is input
                if (command.equalsIgnoreCase("exit")){
                    System.out.println("Done.");
                    System.exit(0);
                    break;
                } 

                //Printing block for "help" command
                if (command.equalsIgnoreCase("help")){
                    System.out.println("Possible Commands Are As Follows:");
                    System.out.println("create x y [fast][flexible] - Creates a new piece.");
                    System.out.println("move x y direction [spaces] - Moves a piece.");
                    System.out.println("print - Displays the board.");
                    System.out.println("exit - Exits the program.");
                } 
                //If "create" is the first word of the input then splits the line
                //Split line gets converted into Int and String for filtration
                else if (command.toLowerCase().startsWith("create")){
                    String[] lineParts = command.split(" ");
                    if (lineParts.length < 3 || lineParts.length > 5){
                        System.out.println("Invalid Command. Type 'help' For A List Of Commands");
                        return;
                    }
                    
                    //Checks if "create x y [fast][flexible]" format is followed
                    //Otherwise catches and prints the error
                    try{
                        int posX = Integer.parseInt(lineParts[1]);
                        int posY = Integer.parseInt(lineParts[2]);
                
                        System.out.println("Input a name for the new piece:");
                        String name = input.nextLine();
                        System.out.println("Input a color for the new piece:");
                        String color = input.nextLine();
                
                        Piece piece;
                        boolean isFast = command.contains("fast");
                        boolean isFlexible = command.contains("flexible");
                
                        if (isFast && isFlexible) {
                            piece = new FastFlexible(name, color, posX, posY);
                        } else if (isFast) {
                            piece = new FastPiece(name, color, posX, posY);
                        } else if (isFlexible) {
                            piece = new SlowFlexible(name, color, posX, posY);
                        } else {
                            piece = new SlowPiece(name, color, posX, posY);
                        }
                        
                        //Adds a piece to the Board class if no errors encountered
                        board.addPiece(piece);
                    } 
                    catch (NumberFormatException e){
                        System.out.println("Invalid Command. Type 'help' For A List Of Commands");
                    }
                } 
                //Checks the line if the first input consists of "move"
                //splits input into coordinates, direction and steps
                else if (command.toLowerCase().startsWith("move")){
                    String[] lineParts = command.split(" ");
                    if (lineParts.length < 4){
                        System.out.println("Invalid Command. Type 'help' For A List Of Commands");
                        continue;
                    }
                    
                    //Checks if "move x y direction [spaces]" format is followed
                    //Otherwise catches and handles the exception
                    try {
                        int posX = Integer.parseInt(lineParts[1]);
                        int posY = Integer.parseInt(lineParts[2]);
                        String direction = lineParts[3];
                
                        int steps;
                        if (lineParts.length == 5){
                            steps = Integer.parseInt(lineParts[4]); 
                        } 
                        else{
                            steps = 1; 
                        }
                        board.movePiece(posX, posY, direction, steps);
                    } 
                    catch (NumberFormatException e){
                        System.out.println("Invalid Command. Type 'help' For A List Of Commands");
                    }
                } 
                //Method for displaying board
                else if (command.equalsIgnoreCase("print")) {
                    board.printBoard();
                } 
                else {
                    System.out.println("Invalid Command. Type 'help' For A List Of Commands");
                }
            }
        }
    }
}