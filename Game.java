public class Game{
    Player newPlayer;
    GameBoard newGameBoard;
    boolean isGoing; //determines whether or not the game is being played
    Note currentNote;
    public Game(/*inputs??*/){
        isGoing=false;
        //set currentNote, is there a correlation with gameboard??
    }
   //code start game method (in main??)
        //set isGoing to true
    public void endGame(){
        GreenfootImage text=new GreenfootImage(x-size, y-size);
        setImage(text);
        text.drawString("YOU LOSE!");
        text.drawString("YOUR SCORE: "+newPlayer.getScore());
        System.exit(0);//end graphics
    }
    
    public void isRunning(){
        if(currentNote.verifyPlayerInput(currentNote.getRow)==false){
            isGoing=false;
        }else if(key.getX() > 500){
        }else{
            isGoing=true;
        }
        
    }
}
