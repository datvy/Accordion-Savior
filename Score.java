import greenfoot.*;
import java.util.Random;

public class Score extends Actor{

  private int score; // player's score

  public Score()
  {
   score = 0; // score starts at 0
  }

  public static int getScore()
  {
   return score;
  }

  public void incScore() // increments score when a correct key is pressed
  {
   score++;
  }

}
