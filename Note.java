    import greenfoot.*;
    public class Note extends Actor{
        private int row;//the row determines the key
        private boolean inUse;
        private static int scrollSpeed; //the speed the notes scroll at
        private final String[] noteKey = {"2","q","a","z"};
        private final String[] colorKey = {"BlueNote.png", "GreenNote.png",
                                           "RedNote.png", "YellowNote.png"};
        private final int[] postitionKey = {62,154,246,337};
        private int timer;
        private int cheatTimer;
        //constructor
        public Note(int row, boolean isHit, int scrollSpeed, boolean inUse){
            this.row=row;
            this.scrollSpeed=scrollSpeed;
            this.inUse=inUse;
            timer = 0;
            cheatTimer = 0;
        }
        
        //getters and setters
        public int getRow(){
            return row;
        }
        public static int getScrollSpeed(){ 
            return scrollSpeed; 
        }
        public boolean getInUse() {
            return inUse;
        }
        public void setRow(int thisRow){ 
            row=thisRow; 
        }
        public static void setScrollSpeed(int thisScrollSpeed){ 
            scrollSpeed=thisScrollSpeed; 
        }
        public void setInUse(boolean thisInUse) {
            inUse=thisInUse;
        }
        //end getters and setters 
        
        public void move() {
        
            if (inUse) {
                setLocation(getX() + scrollSpeed, postitionKey[row]);
            }
            
        }
        
        public void incrementSpeed(){//increment speed
            int inc=1;//the change in the speed, subject to change
            scrollSpeed += inc;
        }
        
        public boolean checkCheat() {
        
            if (this.getInUse()&&Greenfoot.isKeyDown(noteKey[this.row])&&this.getX()>400&&
                Greenfoot.isKeyDown(noteKey[this.row])&&this.getX()<406) {
            
                 return true;
            
            }else return false;
        
        }
        
        public boolean hitNote() {
            
        if (this.getInUse()&&Greenfoot.isKeyDown(noteKey[this.row])&&this.getX()>450) {
            
            return true;
            
        }else return false;
       
    }
    
    public void act() {
    
        move();
        
        if (hitNote()) {
            
            this.getWorld().removeObject(this);
        
            this.setRow((int)Math.random()*3);
            
            this.setInUse(false);
            
        }
        
        setImage(colorKey[row]);
        
        if (timer>1000) {
            
            incrementSpeed();
            
            timer = 0;
        
        }
        
        timer++;
        
    }
}