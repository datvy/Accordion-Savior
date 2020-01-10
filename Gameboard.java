import java.util.Random;

public class Gameboard {
    private boolean[][] board = new boolean[6][4];
    
    private void generateRow(int row) {
        Random rand = new Random();
        int randPos = rand.nextInt(4);
            
        switch(randPos) {
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
    
    public Gameboard() {
        for(int i = 0; i < board.length - 1; i++) {
            generateRow(i);
        }
    }
    
    //public void update() {
    //    generateRow(Player.getScore() % 6); //getScore should be static
    //}
}