public class Piece{
    //Instance variables
    private String name;
    private String color;
    private int posX;
    private int posY;
    private int[] position = new int[2];
    public char[] getPosition;

    //Contructor
    public Piece(String name, String color,int posX, int posY){
        this.name = name;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
        //Sets position array
        position[0] = posX;
        position[1] = posY;
    }

    //Acessor Methods
    public String getName(){
        return this.name;
    }
    public String getColor(){
        return this.color;
    }
    public String getPosition(){
        return ("[" + this.posX + ", " + this.posY + "]");
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }

    //Mutator Methods
    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setPosition(int posX, int posY){
        this.posX = posX;
        this.posY = posY;

        position[0] = posX;
        position[1] = posY;
    }

    @Override
    public String toString(){
        return name + " (" + color + ") at position [" + position[0] + ", " + position[1] + "]";
    }
}
