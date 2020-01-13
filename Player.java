public class Player{
    private int score;
    private boolean hasLost;
    public Player(){
        score=0;
        hasLost=false;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int newScore){
        score=newScore;
    }
    public boolean getHasLost(){
        return hasLost;
    }
    public void setHasLost(boolean changeHasLost){
        hasLost=changeHasLost;
    }
    public void incrementScore(){
        score++;
    }
}
