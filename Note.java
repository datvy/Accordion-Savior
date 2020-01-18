import greenfoot.*;
public class Note extends Actor {
    private int row; //the row determines the key
    private boolean inUse;
    private static int scrollSpeed; //the speed the notes scroll at
    private final String[] noteKey = {  //keys to read
        "2",
        "q",
        "a",
        "z"
    };
    private final String[] colorKey = { //all possible note colors
        "BlueNote.png",
        "GreenNote.png",
        "RedNote.png",
        "YellowNote.png"
    };
    private final int[] postitionKey = {    //all possible note positions
        62,
        154,
        246,
        337
    };
    private final String[] soundKey = { //all possible note sounds
        "C.mp3",
        "E.mp3",
        "G.mp3",
        "C2.mp3"
    };
    private int timer;
    private int cheatTimer;
    //constructor
    public Note(int row, boolean isHit, int scrollSpeed, boolean inUse) {
        this.row = row;
        this.scrollSpeed = scrollSpeed;
        this.inUse = inUse;
        timer = 0;
        cheatTimer = 0;
    }

    //getters and setters
    public int getRow() {
        return row;
    }
    public static int getScrollSpeed() {
        return scrollSpeed;
    }
    public boolean getInUse() {
        return inUse;
    }
    public void setRow(int thisRow) {
        row = thisRow;
    }
    public static void setScrollSpeed(int thisScrollSpeed) {
        scrollSpeed = thisScrollSpeed;
    }
    public void setInUse(boolean thisInUse) {
        inUse = thisInUse;
    }
    //end getters and setters 

    public void move() {    //note descend animation

        if (inUse) {
            setLocation(getX() + scrollSpeed, postitionKey[row]);
        }

    }

    public void incrementSpeed() { //increment speed
        int inc = 1; //the change in the speed, subject to change
        scrollSpeed += inc;
    }

    public boolean checkCheat() {

        // if (this.getInUse()&&Greenfoot.isKeyDown(noteKey[this.row])&&this.getX()>400&
        // Greenfoot.isKeyDown(noteKey[this.row])&&this.getX()<425) {

        // return true;

        // }else return false;

        if (cheatTimer > 45) {

            return true;

        }

        if (this.getInUse() && Greenfoot.isKeyDown(noteKey[this.row])) {

            cheatTimer++;

        } else cheatTimer = 0;

        return false;

    }

    public boolean hitNote() {  //detect if the current note is hit or not

        if (this.getInUse() && Greenfoot.isKeyDown(noteKey[this.row]) && this.getX() > 450) {

            return true;

        } else return false;

    }

    public void act() { //main loop

        move();

        if (hitNote()) {    //if the current note is hit

            Greenfoot.playSound(soundKey[row]); //play corresponding note sound
            
            this.getWorld().removeObject(this); //remove note

            this.setRow((int) Math.random() * 3);   //change lane

            this.setInUse(false);   //note is no longer in use

        }

        setImage(colorKey[row]); //note sprite

        if (timer > 1000) { //speed will increase every 1000 frames

            incrementSpeed();

            timer = 0;

        }

        timer++;    //increment timer

    }
}