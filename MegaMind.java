import java.util.Scanner;

/**
 * MegaMind is the class that picks the word and gives hints
 */
public class MegaMind {
  /**
   * hiddenWord is the word that the MegaMind is trying to guess
   */
  private String hiddenWord;
  /**
   * isHuman is true if the MegaMind is a human
   */
  private boolean isHuman;
  /**
   * input is the scanner for user input
   */
  Scanner input;

  /**
   * Constructor for objects of class MegaMind
   * @param d is the Dictionary to pick the hidden word from
   */
  public MegaMind(Dictionary d) {
    isHuman = false;
    chooseWord(d);
  }

  /**
   * Constructor for objects of class MegaMind
   * @param d is the Dictionary to pick the hidden word from
   * @param isHuman is true if the MegaMind is a human
   */
  public MegaMind(Dictionary d, boolean isHuman) {
    this.isHuman = isHuman;
    chooseWord(d);
  }

  /**
   * Sets the hiddenword to a selected word from the Dictionary d
   * @param d is the Dictionary to pick the hidden word from
   */
  public void chooseWord(Dictionary d) {
    if(isHuman) {
      System.out.println("\nPlease enter a word for the Guesser to guess, hit enter to manually score each guess");
    }
    if (isHuman) {
      input = new Scanner(System.in);
      while (hiddenWord == null ||
          !(hiddenWord.equals("") ||
              d.contains(hiddenWord))) {
        System.out.print("Secret word: ");
        hiddenWord = input.nextLine();
        hiddenWord = hiddenWord.toLowerCase();
      }
    } else {
      hiddenWord = d.getRandomWord();
      System.out.println("AI picked a secret word. Try to guess it!");
    }
  }

  /**
   * Returns the number of letters in common between guess and the hidden word
   * 
   * @param guess The guess in a round of JOTTO
   * @return The # of letters in common between guess and the hidden JOTTO word
   */
  public int getHint(String guess) {
    // return the number of letters in common between guess and hiddenWord
    int hint = 0;
    if (hiddenWord.equals("")) {
      System.out.print("Enter the hint for " + guess + ": ");
      hint = input.nextInt();
    } else {
      for (int i = 0; i < guess.length(); i++) {
        char c = guess.charAt(i);
        if (hiddenWord.indexOf(c) != -1) hint++;
      }
    }
    return hint;
  }

  /**
   * Returns the hidden word
   * 
   * @return The hidden word
   */
  public String revealWord() {
    String hiddenWord = this.hiddenWord;
    this.hiddenWord = ""; // reset hidden word so game can't be played after reveal
    return hiddenWord;
  }
}