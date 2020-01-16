
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
    private Note[] noteArray;
    private int timer;
    private int score;
    
    public GameTest(){
     
        super(600, 400, 1);
        note0 = new Note(0, false, 3, false);
        note1 = new Note(0, false, 3, false);
        note2 = new Note(0, false, 3, false);
        note3 = new Note(0, false, 3, false);
        note4 = new Note(0, false, 3, false);
        note5 = new Note(0, false, 3, false);
        
        noteArray = new Note[6];
        noteArray[0] = note0;
        noteArray[1] = note1;
        noteArray[2] = note2;
        noteArray[3] = note3;
        noteArray[4] = note4;
        noteArray[5] = note5;
        
        timer = 0;
        score = 0;
    }
    
    public void act() {
    
        if (timer%25==0) {
        
            addObject(getNote(), 0, 0);
            timer = 0;
            
            updateScore();
        
        }
        
        
        showText("Score: "+score, 40, 20);
        
        checkMiss();
    
        timer++;
        
    }
    
    public void updateScore() {
        
       score++;
        
    }
    
    public void checkMiss() {
    
        for (int i = 0; i<noteArray.length; i++) {
        
            if (noteArray[i].getInUse()&&noteArray[i].getX()==599) {
            
                showText("YOUR SCORE: "+score, 300, 200);
                
                Greenfoot.stop();
                
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
}