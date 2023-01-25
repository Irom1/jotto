/*

Simple JOTTO game, designed by Mori

Bells & Whistles:
- When Human MegaMind chooses word they can either input the hiddenWord and have hints automatically scored -OR- provide the hints for each guess
- Human guesser can "give up" mid game and switch to AI
- When a game ends, it asks you if you want to play again
- 

*/

import java.util.ArrayList;

/**
 * Keeps track of an plays an entire game of JOTTO
 * The game of Jotto is a guessing game where you try to figure out what hidden
 * word is
 */

public class JottoGame {
  /** The guesser for a game of Jotto - either human or AI */
  private Guesser guesser;
  /** The megamind or hint giver for a game of JOTTO */
  private MegaMind megaMind;
  /** All of the previous guesses and hints */
  private ArrayList<Round> board;
  /**
   * The full list of words that the AI Megamind will
   * choose from for a hidden word
   */
  private Dictionary hiddenWords;
  /** The full list of all words that can be valid guesses */
  private Dictionary allWords;

  /**
   * CONSTRUCTOR
   * Sets ALL the instance variables for a game of JOTTO
   */
  public JottoGame() {
    setup();
    this.guesser = new Guesser(false);
    this.megaMind = new MegaMind(hiddenWords, false);
  }

  /**
   * CONSTRUCTOR
   * Sets ALL the instance variables for a game of JOTTO
   * 
   * @param humanMegaMind is true if you want a human hint giver and false for
   *                      automated mode
   * @param humanGuesser  is true if you want a human guesser and false for
   *                      automated mode
   */
  public JottoGame(boolean humanMegaMind, boolean humanGuesser) {
    setup();
    this.guesser = new Guesser(humanGuesser);
    if (humanMegaMind) {
      this.megaMind = new MegaMind(allWords, true);
    } else {
      this.megaMind = new MegaMind(hiddenWords, false);
    }
  }

  /**
   * Sets up the dictionary for game of JOTTO
   */
  private void setup() {
    // create the dictionary of all words
    allWords = new Dictionary("allWords.csv");
    // create the dictionary of hidden words
    hiddenWords = new Dictionary("commonWords.csv");
    // create the board
    board = new ArrayList<Round>();
  }

  /**
   * Plays a full game of JOTTO
   */
  public void play() {
    // choose a word
    // megaMind.chooseWord(hiddenWords);
    // while the game is not over, make a guess and get a hint
    while (!gameOver()) {
      Round r = guesser.makeGuess(board, allWords);
      int hint = megaMind.getHint(r.getGuess());
      r.setHint(hint);
      board.add(r);
      // print the board
      System.out.println(board);
    }
    // Say the game is over
    System.out.print("\n\nGame Over!");
    String word = megaMind.revealWord();
    if (!word.equals("")) {
      System.out.println(" The word was " + word);
    }
  }

  /**
   * Returns true if the game is over
   * 
   * @return true if the game is over
   */
  public boolean gameOver() {
    // find the last guess hint
    // if the hint is 5, then the game is over
    if (board.size() == 0) {
      return false;
    }
    int lastHint = board.get(board.size() - 1).getHint();
    return lastHint == 5;
  }

}