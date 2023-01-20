/**
 * Container class for the guess and hint in a round
 * of a JOTTO game
 */
public class Round {
  /** The guess from the player/guesser in a game of JOTTO */
  private String guess;
  /**
   * The hint from the MegaMind which is the number of
   * letters in common between the guess and the hidden
   * word
   */
  private int hint;

  /**
   * CONSTRUCTOR
   * Sets ALL the instance variables the guess and hint
   */
  public Round(String guess, int hint) {
    this.guess = guess;
    this.hint = hint;
  }

  public Round() {
    this.guess = "";
    this.hint = 0;
  }

  /**
   * Sets the hint if it has not already been set
   * @param hint is the hint to set
   */
  public void setHint(int hint) {
    if (this.hint == 0)
      this.hint = hint;
  }

  /**
   * Sets the guess if it has not already been set
   * @param guess is the guess to set
   */
  public void setGuess(String guess) {
    if (this.guess.equals(""))
      this.guess = guess;
  }

  /**
   * Returns the guess
   * @return the guess
   */
  public String getGuess() {
    return guess;
  }

  /**
   * Returns the hint
   * @return the hint
   */
  public int getHint() {
    return hint;
  }

  /**
   * Returns a good String format for a Round
   * @return a good String format for a Round
   */
  public String toString() {
    return guess + " " + hint;
  }
}