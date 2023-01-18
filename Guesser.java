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

  public String makeValidGuess (Dictionary d, ArrayList<Round> board) {
    String guess = "BREAD";
    return guess;
  }
}