/** Container class for the guess and hint in a round
  of a JOTTO game */
public class Round {
  /** The guess from the player/guesser in a game of JOTTO */
  public final String guess;
  /** The hint from the MegaMind which is the number of 
      letters in common between the guess and the hidden
      word */
  public final int hint;

  /** CONSTRUCTOR 
      Sets ALL the instance variables the guess and hint
      which are both final and public */
  public Round (String guess, int hint) {
    this.guess = guess;
    this.hint = hint;
  }

  /** Returns a good String format for a Round */
  public String toString () {
    return guess +" "+hint;
  }
}