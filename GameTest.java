
import greenfoot.*;
import java.util.ArrayList;
import java.util.Random;

public class GameTest extends World{
    
    Note note0;
    Note note1;
    Note note2;
    Note note3;
    Note note4;
    Note note5;
    Note[] noteArray;
    
    public GameTest(){
     
        super(600, 400, 1);
        note0 = new Note(0, false, 5, false);
        note1 = new Note(0, false, 5, false);
        note2 = new Note(0, false, 5, false);
        note3 = new Note(0, false, 5, false);
        note4 = new Note(0, false, 5, false);
        note5 = new Note(0, false, 5, false);
        
        noteArray = new Note[6];
        noteArray[0] = note0;
        noteArray[1] = note1;
        noteArray[2] = note2;
        noteArray[3] = note3;
        noteArray[4] = note4;
        noteArray[5] = note5;
    }
    
    public void act() {
    
        add();
    
    }
    
    public void add() {
    
        for (int i = 0; i<noteArray.length; i++) {
        
            if (!noteArray[i].getInUse()) {
            
                noteArray[i].setRow(randomRow());
                noteArray[i].setInUse(true);
                
                addObject(noteArray[i], 0, 0);
            
            }
        
        }
        
    }
    
    public int randomRow() {
    
        Random rand = new Random();
        
        return rand.nextInt(4);
    
    }
}