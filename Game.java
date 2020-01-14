
import greenfoot.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends World{
    
    Player newPlayer;//this is the player in the game
    ArrayList<Note> notePool = new ArrayList<Note>();
    //the current note that the player is supposed to hit
    
    public Game(){
     
        super(600, 400, 1);
        Note note0 = new Note(0,false,0,false);
        Note note1 = new Note(0,false,0,false);
        Note note2 = new Note(0,false,0,false);
        Note note3 = new Note(0,false,0,false);
        Note note4 = new Note(0,false,0,false);
        Note note5 = new Note(0,false,0,false);
        notePool.add(note0);
        notePool.add(note1);
        notePool.add(note2);
        notePool.add(note3);
        notePool.add(note4);
        notePool.add(note5);
    }
    
    public void act() {
    
       if (notePool.get(0).getNumInUse()<4) { 
           
           getNote().setRow(randomRow());
           getNote().setScrollSpeed(5);
           getNote().setInUse(true);
           getNote().incrementNumInUse();
           getNote().setImage(new GreenfootImage("BlueNote.png"));
           notePool.remove(getNote());
       
       }
       
       for (Note note : notePool) {
        
           if (note.getX()>500) {
            
               if (!note.hitNote()) {
                
                   Greenfoot.stop();
               
               }
               
           }
        
       }
       
       
    
    }
    
    public Note getNote() {
    
        for (Note note : notePool) {
        
            if (!note.getInUse()) {
            
                return note;
            
            }
        
        }
        
        return notePool.get(5);
    
    }
    
    public void returnNote(Note note) {
    
        notePool.add(note);
    
    }
    
    public int randomRow() {
    
        Random rand = new Random();
        
        return rand.nextInt(4);
    
    }
}