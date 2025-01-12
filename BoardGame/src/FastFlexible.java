public class FastFlexible extends FastPiece{
    public FastFlexible(String name, String color, int posX, int posY){
        //Calls Superclass
        super(name, color, posX, posY);
    }

    @Override 
    public String toString(){
        //Adds the type after calling SuperClass
        return super.toString() + "(Flexible)"; 
    }

    //Moves the FastFlexible instance of piece
    //Can move up,down,left and right without and step restrictions
    //Prints error if piece ends up out of bounds
    //Places position back in previous position if error occurs
    @Override
    public void move(String direction, int steps){
        int posX = getPosX();
        int posY = getPosY();
        int originalPosX = posX; 
        int originalPosY = posY;

        if (direction.equalsIgnoreCase("left")){
            if (posX - steps >= 0){
                posX -= steps;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by " + steps + " spaces");
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else if (direction.equalsIgnoreCase("right")){
            if (posX + steps < 8){ 
                posX += steps;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by " + steps + " spaces");
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else if (direction.equalsIgnoreCase("up")){
            if (posY - steps >= 0){ 
                posY -= steps;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by " + steps + " spaces");
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else if (direction.equalsIgnoreCase("down")){
            if (posY + steps < 8){  
                posY += steps;
                System.out.println("Piece at (" + originalPosX + "," + originalPosY + ") moved " + direction + " by " + steps + " spaces");
            } 
            else{
                System.out.println("Out of Bounds");
                return;
            }
        } 
        else {
            System.out.println("Invalid Move");
            return;
        }

         //finalizes and sets position
        setPosition(posX, posY);
    }
}