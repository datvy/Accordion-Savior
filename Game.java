import greenfoot.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends World {

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
    private int cheatTimer;
    private int score;

    public Game() {

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
        note9 = new Note(0, false, 3, false); //create all notw objects


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
        noteArray[9] = note9; //add notes to note pool

        addTimer = 0;
        cheatTimer = 0;
        score = 0;
    }

    public void act() { //main game loop

        if (addTimer % calcAddTime() == 0) {

            addObject(getNote(), 0, 0);
            addTimer = 0;

            updateScore();

        }

        checkCheat();

        showText("Score: " + score, 40, 20);    //score display

        checkMiss();

        addTimer++;

    }

    public int calcAddTime() {

        if (50 - noteArray[0].getScrollSpeed() > 10) {

            return 50 - (noteArray[0].getScrollSpeed() * 2);

        } else return 10;

    }

    public void updateScore() { //increments the score

        score++;

    }

    public void checkMiss() {   //if note reaches the edge of the screen, the game ends

        for (int i = 0; i < noteArray.length; i++) {

            if (noteArray[i].getInUse() && noteArray[i].getX() == 599) {

                endGame();

            }

        }

    }

    public Note getNote() { //loop through note pool and reassign lane positions for all notes currently not in use

        for (int i = 0; i < noteArray.length; i++) {

            if (!noteArray[i].getInUse()) {

                noteArray[i].setRow(randomRow());
                noteArray[i].setInUse(true);

                return noteArray[i];

            }

        }

        return noteArray[randomRow()];

    }

    public int randomRow() {    //select a random lane

        Random rand = new Random();

        return rand.nextInt(100) / 25;

    }

    public void checkCheat() {  //check if the player is holding down the keys for too long

        for (Note n: noteArray) {

            if (n.getInUse() && n.checkCheat()) {

                endGame();

            }

        }

        cheatTimer--; //decrement cheat timer

    }

    public void endGame() { //game over screen

        showText("YOUR SCORE: " + score, 300, 200); //score display

        Greenfoot.stop();   //stop everything

    }
}