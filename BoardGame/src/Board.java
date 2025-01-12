public class Board{
    private Piece[][] boardEntity;

    //Constructor
    public Board(){
        //Makes a new 8x8 board
        boardEntity = new Piece[8][8];
    }

    //Checks if the point in the board is occupied
    //If yes, then prints error messages
    //Otherwise adds a new piece
    public void addPiece(Piece piece){
        int posX = piece.getPosX();
        int posY = piece.getPosY();

        if (isPositionValid(posX, posY)){
            if (boardEntity[posX][posY] == null){
                boardEntity[posX][posY] = piece;
            }
            else{
                System.out.println("Error: Position (" + posX + ", " + posY + ") is already occupied.");
            }
        }
        else{
            System.out.println("Error: Invalid Position Out Of Bounds");
        }     
    }
    
    //Moves piece according to the piece type
    //Takes in steps input regardless of piece type
    //Checks for piece instance and redirects it to a different class method
    public void movePiece(int posX, int posY, String direction, int steps){
        if (isPositionValid(posX, posY) && boardEntity[posX][posY] != null) {
            Piece piece = boardEntity[posX][posY];
            boardEntity[posX][posY] = null;
    
            if (piece instanceof SlowPiece && !(piece instanceof SlowFlexible)) {
                ((SlowPiece) piece).move(direction);
                
            } 
            else if (piece instanceof FastPiece && !(piece instanceof FastFlexible)) {
                ((FastPiece) piece).move(direction, steps);
            } 
            else if (piece instanceof SlowFlexible) {
                ((SlowFlexible) piece).move(direction);
            } 
            else if (piece instanceof FastFlexible) {
                ((FastFlexible) piece).move(direction, steps);
            }
            
            //variable to save new position values
            int newPosX = piece.getPosX();
            int newPosY = piece.getPosY();
    
            //Depending on whether or not the piece is within bounds
            //Prints an error message or finalizes the placement using newPosition variables
            if (isPositionValid(newPosX, newPosY)) {
                boardEntity[newPosX][newPosY] = piece; 

                
            } 
            else {
                System.out.println("Invalid Move: Out of bounds");
                boardEntity[posX][posY] = piece; 
            }
        } 
        else{
            System.out.println("Error: No Piece At (" + posX + ", " + posY + ")");
        }   
    }

    //Prints the board
    //Uses two nested for loops to loop through whole 2D array
    //Print depends on the piece type
    //Fixed 20 space gap between each column
    public void printBoard(){
        for (int posY = 0; posY < 8; posY++){
            for (int posX = 0; posX < 8; posX++){
                if (boardEntity[posX][posY] != null){
                    Piece piece = boardEntity[posX][posY];
                    if (piece instanceof FastFlexible){
                        System.out.printf("%-20s", piece.getName() + piece.getColor() + "FF");
                    } 
                    else if (piece instanceof SlowFlexible){
                        System.out.printf("%-20s", piece.getName() + piece.getColor() + "SF");
                    } 
                    else if (piece instanceof SlowPiece){
                        System.out.printf("%-20s", piece.getName() + piece.getColor() + "S");
                    } 
                    else if (piece instanceof FastPiece){
                        System.out.printf("%-20s", piece.getName() + piece.getColor() + "F");
                    }
                } 
                else{
                    System.out.printf("%-20s", "-");
                }
            }
            //Creates a new line
            System.out.println();
        }
    }
    
    //Checks if the position is within bounds
    public boolean isPositionValid(int posX, int posY) {
        return posX >= 0 && posX < 8 && posY >= 0 && posY < 8;
    }
}
    