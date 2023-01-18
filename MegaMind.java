public class MegaMind {
  private String hiddenWord;
  private boolean isHuman;

  public MegaMind () {
    hiddenWord = "BREAD";
    isHuman = false;
  }

  public MegaMind (boolean isHuman) {
    hiddenWord = "BREAD";
    this.isHuman = isHuman;
  }

  /**
   Sets the hiddenword to a selected word from the Dictionary d
   @param d is the Dictionary to pick the hidden word from
  */
  public void chooseWord (Dictionary d) {
    hiddenWord = "BREAD";
  }

  /**
   Returns the number of letters in common between guess and the hidden word
   @param guess The guess in a round of JOTTO
   @return The # of letters in common between guess and the hidden JOTTO word
  */
  public int getHint (String guess) {
    return 0;

  }


}