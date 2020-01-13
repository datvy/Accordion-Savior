public class Game{
    
    Player newPlayer;//this is the player in the game
    GameBoard newGameBoard;//this is the board that is played on
    boolean isGoing; //this determines whether or not the game is being played
    Note currentNote;//the current note that the player is supposed to hit
    
    public Game(){
        isGoing=false;
        //set currentNote, is there a correlation with gameboard??
    }
    public boolean getIsGoing(){
        return isGoing;
    }
    public boolean startGame(){
        isGoing=true;
        return isGoing;
    }
    public void endGame(){
        GreenfootImage text=new GreenfootImage(x-size, y-size);
        setImage(text);
        text.drawString("YOU LOSE!");
        text.drawString("YOUR SCORE: "+newPlayer.getScore());
        System.exit(0);//end graphics
    }
    
    public boolean keepRunning(){//determines if the game is still going, used to end the game
        if(currentNote.verifyPlayerInput(currentNote.getRow)==false){//if the player hits the wrong key
            isGoing=false;
            return isGoing;
        }else if(key.getX() > 500){//if the player doesn't hit the key in time
            isGoing=false;
            return isGoing;
        }else{
            newPlayer.incrementScore();
            isGoing=true;
            return isGoing
        }
        
    }
}
