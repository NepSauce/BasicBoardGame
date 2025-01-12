public class SlowFlexible extends SlowPiece{
    public SlowFlexible(String name, String color, int posX, int posY){
        //Calls SuperClass
        super(name, color, posX, posY);
    }

    @Override 
    public String toString(){
        //Adds the type after calling SuperClass
        return super.toString() + "(Flexible)";
    }

    //Moves the SlowFlexible instance of piece
    //Can move up,down,left and right without and by one step regardless of step input
    //Prints error if piece ends up out of bounds
    //Places position back in previous position if error occurs
    @Override
    public void move(String direction){
        int posX = getPosX();
        int posY = getPosY();
        int originalPosX = posX; 
        int originalPosY = posY;

        //Matches input with command to move piece
        if (direction.equalsIgnoreCase("left")){
            if (posX > 0){ 
                posX--;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by 1 spaces");
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else if (direction.equalsIgnoreCase("right")){
            if (posX < 7){
                posX++;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by 1 spaces");
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else if (direction.equalsIgnoreCase("up")){
            if (posY > 0){ 
                posY--;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by 1 spaces");
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else if (direction.equalsIgnoreCase("down")){
            if (posY < 7){
                posY++;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by 1 spaces");;
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else{
            System.out.println("Invalid Move");
            return;
        }
         //finalizes and sets position
        setPosition(posX, posY);
    }
}