public class SlowPiece extends Piece {
    public SlowPiece(String name, String color, int posX, int posY){
        //Calls SuperClass
        super(name, color, posX, posY);
    }
    @Override
    public String toString(){
        //Adds the type after calling SuperClass
        return super.toString() + " (SlowPiece)";
    }

    //Moves the SlowPiece instance of piece
    //Can move left or right by one step regardless of step output
    //Prints error if piece ends up out of bounds
    //Places position back in previous position if error occurs
    public void move(String direction){
        int posX = getPosX();
        int posY = getPosY();
        int originalPosX = posX; 
        int originalPosY = posY;

        if (direction.equalsIgnoreCase("left") && posX > 0){
            posX--;
            System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by 1 spaces");
        }
        else if (direction.equalsIgnoreCase("right") && posX < 7){
            posX++;
            System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by 1 spaces");
        }
        else if (!(direction.equalsIgnoreCase("right")||direction.equalsIgnoreCase("left"))){
            System.out.println("Invalid Move");
        }
        else{
            System.out.println("Out of Bounds");
        }

        //finalizes and sets position
        setPosition(posX, posY);
    }
}
