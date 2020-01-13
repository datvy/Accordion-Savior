import greenfoot.*;
import java.util.Random;

public class GameBoard extends Actor{
    private static boolean[][] board = new boolean[6][4];
    
    private void generateRow(int row) {
        Random rand = new Random();
        int randPos = rand.nextInt(4);  //generate number between 0 and 4 to determine position in row
            
        switch(randPos) {   //overwrite given row with new note position
            case 0:
                board[row][0] = true;
                break;
            case 1:
                board[row][1] = true;
                break;
            case 2:
                board[row][2] = true;
                break;
            case 3:
                board[row][3] = true;
                break;
        }
    }
    
    public GameBoard() {
        for(int i = 0; i < board.length - 1; i++) {     //loop through the entire board array and use generateRow() to fill all of it
            generateRow(i);
        }
    }
    
    public void updateBoard() {     //generate new row determined by which rows the player cannot see
        generateRow(Player.getScore() % 6);
    }
    
    public int getNotePos() {   //based on current row, return what position the note in said row is occupying
        int pos = -1;
        for(int i = 0; i < board[0].length - 1; i++) {
            if (board[Player.getScore() % 6][i] == true)
                pos = i;
        }
        
        return pos;
    }
}