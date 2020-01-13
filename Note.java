import greenfoot.*;
public class Note extends Actor{
    private int row;//the row determines the key
    private boolean isHit;//true if correct key is hit
    private int scrollSpeed;//the speed the notes scroll at
    
    //constructor
    public Note(int row, boolean isHit, int scrollSpeed){
        this.row=row;
        this.isHit=isHit;
        this.scrollSpeed=scrollSpeed;
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
    public void setRow(int thisRow){
        row=thisRow;
    }
    public void setisHit(boolean changeIsHit){
        isHit=changeIsHit;
    }
    public void setScrollSpeed(int thisScrollSpeed){
        scrollSpeed=thisScrollSpeed;
    }
    //end getters and setters
    
    public void incrementSpeed(){//increment speed
        int inc=5;//the change in the speed, subject to change
        scrollSpeed += inc;
    }
    public boolean verifyPlayerInput(String key){//verifies if the player has pressed the correct key
        if(Greenfoot.isKeyDown("key")){
            return true;
        }
        else {
            return false;
        }
    }
}