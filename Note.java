    import greenfoot.*;
    public class Note extends Actor{
        private int row;//the row determines the key
        private boolean inUse;
        private int scrollSpeed; //the speed the notes scroll at
        private final String[] key = {"2","w","s","x"};
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
        public int getScrollSpeed(){ 
            return scrollSpeed; 
        }
        public boolean getInUse() {
            return inUse;
        }
        public void setRow(int thisRow){ 
            row=thisRow; 
        }
        public void setScrollSpeed(int thisScrollSpeed){ 
            scrollSpeed=thisScrollSpeed; 
        }
        public void setInUse(boolean thisInUse) {
            inUse=thisInUse;
        }
        //end getters and setters 
        
        public void move() {
        
            if (inUse) {
                setLocation(getX() + scrollSpeed, 100*row+50);
            }
            
        }
        
        public void incrementSpeed(){//increment speed
            int inc=1;//the change in the speed, subject to change
            scrollSpeed += inc;
        }
        
        public boolean hitNote() {
            
        if (this.getInUse()&&Greenfoot.isKeyDown(key[this.row])&&this.getX()>500) {
            
            cheatTimer = 0;
            
            return true;
            
        }else return false;
       
    }
    
    public boolean cheatCatch() {
    
        if (Greenfoot.isKeyDown(key[this.row])) {
        
            cheatTimer++;
        
        }
        
        if (cheatTimer>20) {
        
            cheatTimer = 0;
            
            return true;
        
        }
        
        return false;
    
    }
    
    public void act() {
    
        move();
        
        if (hitNote()&&!cheatCatch()) {
            
            this.getWorld().removeObject(this);
        
            this.setRow((int)Math.random()*3);
            
            this.setInUse(false);
            
        }
        
        if (timer%500==0) {
        
            incrementSpeed();
            
            timer = 0;
        
        }
        
        timer++;
        
    }
}