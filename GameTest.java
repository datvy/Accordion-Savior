
import greenfoot.*;
import java.util.ArrayList;
import java.util.Random;

public class GameTest extends World{
    
    private Note note0;
    private Note note1;
    private Note note2;
    private Note note3;
    private Note note4;
    private Note note5;
    private Note note6;
    private Note note7;
    private Note note8;
    private Note note9;
    private Note[] noteArray;
    private int addTimer;
    private int speedTimer;
    private int score;
    
    public GameTest(){
     
        super(600, 400, 1);
        note0 = new Note(0, false, 3, false);
        note1 = new Note(0, false, 3, false);
        note2 = new Note(0, false, 3, false);
        note3 = new Note(0, false, 3, false);
        note4 = new Note(0, false, 3, false);
        note5 = new Note(0, false, 3, false);
        note6 = new Note(0, false, 3, false);
        note7 = new Note(0, false, 3, false);
        note8 = new Note(0, false, 3, false);
        note9 = new Note(0, false, 3, false);

        
        noteArray = new Note[10];
        noteArray[0] = note0;
        noteArray[1] = note1;
        noteArray[2] = note2;
        noteArray[3] = note3;
        noteArray[4] = note4;
        noteArray[5] = note5;
        noteArray[6] = note6;
        noteArray[7] = note7;
        noteArray[8] = note8;
        noteArray[9] = note9;
        
        addTimer = 0;
        speedTimer = 0;
        score = 0;
    }
    
    public void act() {
    
        if (addTimer%calcAddTime()==0) {
        
            addObject(getNote(), 0, 0);
            addTimer = 0;
            
            checkCheat();
            
            updateScore();
        
        }
        
        showText("Score: "+score, 40, 20);
        
        checkMiss();
    
        addTimer++;
        
    }
    
    public int calcAddTime() {
    
        if (50-noteArray[0].getScrollSpeed()>10) {
        
            return 50-(noteArray[0].getScrollSpeed()*3);
        
        }else return 10;
    
    }
    
    public void updateScore() {
        
       score++;
        
    }
    
    public void checkMiss() {
    
        for (int i = 0; i<noteArray.length; i++) {
        
            if (noteArray[i].getInUse()&&noteArray[i].getX()==599) {
            
                endGame();
                
            }
        
        }
    
    }
    
    public Note getNote() {
    
        for (int i = 0; i<noteArray.length; i++) {
        
            if (!noteArray[i].getInUse()) {
            
                noteArray[i].setRow(randomRow());
                noteArray[i].setInUse(true);
                
                return noteArray[i];
            
            }
        
        }
        
        return noteArray[randomRow()];
        
    }
    
    public int randomRow() {
    
        Random rand = new Random();
        
        return rand.nextInt(100)/25;
    
    }
    
    public void checkCheat() {
    
        for (Note n : noteArray) {
            
            if (n.getInUse()&&n.checkCheat()) {
            
                endGame();
            
            }
        
        }
    
    }
    
    public void endGame() {
    
        showText("YOUR SCORE: "+score, 300, 200);
                
        Greenfoot.stop();
    
    }
}