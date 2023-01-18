import java.util.ArrayList;
/** Keeps track of an plays an entire game of JOTTO 
The game of Jotto is a guessing game where you try to figure out what hidden word is 
*/

public class JottoGame {
  /** The guesser for a game of Jotto - either human or AI */
  private Guesser guesser;
  /** The megamind or hint giver for a game of JOTTO */
  private MegaMind megaMind;
  /** All of the previous guesses and hints */
  private ArrayList<Round> board;
  /** The full list of words that the AI Megamind will
      choose from for a hidden word */
  private Dictionary hiddenWords;
  /** The full list of all words that can be valid guesses */
  private Dictionary allWords;

  /** CONSTRUCTOR
   Sets ALL the instance variables for a game of JOTTO
  */
  public JottoGame () {
  }

  /** CONSTRUCTOR
   Sets ALL the instance variables for a game of JOTTO
   @param humanMegaMind is true if you want a human hint giver and false for automated mode
   @param humanGuesser is true if you want a human guesser and false for automated mode
  */
  public JottoGame (boolean humanMegaMind, boolean humanGuesser) {
    
  }
  
  /**
   Plays a full game of JOTTO
  */
  public void play () {
  }

  public boolean gameOver () {
    return false;
  }
  
  /**
   Returns true if guess is a valid guess given the current state of JOTTO game board and a given dictionary
   @param guess the Guess to be checked
   @param board the Board to check the guess against
   @return true if guess is valid, and false otherwise
  */
  
  public static boolean isValidGuess (String guess, ArrayList<Round> board) {
    return true;
  }
  

}