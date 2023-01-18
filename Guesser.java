import java.util.ArrayList;
import java.util.Scanner;

public class Guesser {
  boolean isHuman;
  Scanner input;

  public Guesser () {
    isHuman = false;
  }

  public Guesser (boolean isHuman) {
    this.isHuman = isHuman;
  }

  public Round makeGuess (ArrayList<Round> board) {
    Round r = new Round();
    String guess = "";
    while(!isValidGuess(guess, board)) {
      // new guess
      if(this.isHuman) {
        guess = makeHumanGuess();
      } else {
        guess = makeAIGuess();
      }
    }
    return r;
  }

  public String makeHumanGuess () {
    System.out.println("Enter your guess: ");
    String guess = input.nextLine();
    return guess;
  }

  public String makeAIGuess () {
    return "BREAD";
  }

  public boolean isValidGuess (String guess, ArrayList<Round> board) {
    return true;
  }

  /**
   Makes a valid guess given the current state of the JOTTO game board and a given dictionary
   @param d the Dictionary to pick the guess from
   @param board the Board to check the guess against
   @return a valid guess
  */
  public String makeValidGuess (Dictionary d, ArrayList<Round> board) {
    String guess = "BREAD";
    return guess;
  }
}