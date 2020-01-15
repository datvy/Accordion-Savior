import greenfoot.*;
public class Note extends Actor{
    private int row;//the row determines the key
    private boolean isHit;//true if correct key is hit
    private boolean inUse;
    private int scrollSpeed; //the speed the notes scroll at
    private static int numInUse;
    //constructor
    public Note(int row, boolean isHit, int scrollSpeed, boolean inUse){
        this.row=row;
        this.isHit=isHit;
        this.scrollSpeed=scrollSpeed;
        this.inUse=inUse;
        numInUse = 0;
    }
    
    //getters and setters
    public int getRow(){
        return row;
    }
    public boolean getIsHit(){ 
        return isHit; 
    }
    public int getScrollSpeed(){ 
        return scrollSpeed; 
    }
    public boolean getInUse() {
        return inUse;
    }
    public void setRow(int thisRow){ 
        row=thisRow; 
    }
    public void setisHit(boolean changeIsHit){ 
        isHit=changeIsHit; 
    }
    public void setScrollSpeed(int thisScrollSpeed){ 
        scrollSpeed=thisScrollSpeed; 
    }
    public void setInUse(boolean thisInUse) {
        inUse=thisInUse;
    }
    public static void incrementNumInUse() {
        numInUse++; 
    }
    public static void decrementNumInUse() {
        numInUse--;
    }
    public static int getNumInUse() {
        return numInUse;
    }
    //end getters and setters 
    
    public void move() {
    
        if (inUse) {
            setLocation(getX() + scrollSpeed, 400/(row+1)+50);
        }
        
    }
    
    public void incrementSpeed(){//increment speed
        int inc=5;//the change in the speed, subject to change
        scrollSpeed += inc;
    }
    
    public boolean hitNote() {
    
        if (Greenfoot.isKeyDown(""+row)) {
            
            return true;
            
        }else return false;
       
    }
    
    public void act() {
    
        move();
        
    }
}