public class Player{
    private static int score;//the player's score
    
    public Player(){
        score=0;//score starts at 0
    }
    //getters and setters
    public static int getScore(){
        return score;
    }
    public void setScore(int newScore){
        score=newScore;
    }
    //end getters and setters
    
    public void incrementScore(){//increments score when a correct key is pressed
        score++;
    }
}
