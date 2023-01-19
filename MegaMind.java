import java.util.Scanner;

public class MegaMind {
  private String hiddenWord;
  private boolean isHuman;

  public MegaMind(Dictionary d) {
    isHuman = false;
    chooseWord(d);
  }

  public MegaMind(Dictionary d, boolean isHuman) {
    this.isHuman = isHuman;
    chooseWord(d);
  }

  /**
   Sets the hiddenword to a selected word from the Dictionary d
   @param d is the Dictionary to pick the hidden word from
  */
  public void chooseWord (Dictionary d) {
    if(isHuman) {
      System.out.println("Please enter a word for the Guesser to guess");
      Scanner in = new Scanner(System.in);
      while(!d.contains(hiddenWord)) {
        hiddenWord = in.nextLine();
        hiddenWord = hiddenWord.toLowerCase();
      }
      in.close();
    } else {
      hiddenWord = d.getRandomWord();
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
    for(int i = 0; i < guess.length(); i++) {
      char c = guess.charAt(i);
      if(hiddenWord.indexOf(c) != -1) hint++;
    }
    return hint;
  }

  public String revealWord() {
    String hiddenWord = this.hiddenWord;
    this.hiddenWord = ""; // reset hidden word so game can't be played after reveal
    return hiddenWord;
  }
}