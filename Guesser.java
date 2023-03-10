import java.util.ArrayList;
import java.util.Scanner;

/**
 * Guesser is the class that guesses the word
 */
public class Guesser {
  /** 
   * isHuman is true if the guesser is a human
  */
  boolean isHuman;
  /** 
   * input is the scanner for user input
  */
  Scanner input;
  /** 
   * wordIndex is the index of the word in the dictionary
  */
  int wordIndex;

  /**
   * Constructor for objects of class Guesser
   */
  public Guesser () {
    isHuman = false;
    input = new Scanner(System.in);
    wordIndex = 0;
  }
  public Guesser (boolean isHuman) {
    this.isHuman = isHuman;
    input = new Scanner(System.in);
    wordIndex = 0;
  }

  /**
   * Makes a guess
   * @param board the board
   * @param allWords the dictionary
   * @return the guess
   */
  public Round makeGuess (ArrayList<Round> board, Dictionary allWords) {
    System.out.println("\n");
    Round r = new Round();
    String guess = null;
    wordIndex = 0;
    while(guess == null || !isValidGuess(guess, board, allWords, isHuman)) {
      // new guess
      if(this.isHuman) {
        guess = makeHumanGuess();
        if(guess.equals("end")) {
          System.out.println("Guesser gives up, switching to AI");
          this.isHuman = false;
          guess = makeAIGuess(allWords);
        }
      } else {
        guess = makeAIGuess(allWords);
      }
    }
    System.out.println("Guesser picks word: " + guess);
    r.setGuess(guess);
    return r;
  }

  /**
   * Makes a human guess
   * @return the guess
   */
  private String makeHumanGuess () {
    System.out.print("Enter your guess (type 'end' to give up): ");
    String guess = input.nextLine();
    guess = guess.toLowerCase();
    return guess;
  }

  /**
   * Makes an AI guess
   * @param allWords is the dictionary of all words
   * @return the guess
   */
  private String makeAIGuess (Dictionary allWords) {
    // return random word from dictionary, pretty inefficient
    String word = allWords.getRandomWord();
    //String word = allWords.getWordAtIndex(wordIndex);
    //wordIndex++;
    return word;
  }

  /**
   * Checks if a guess is valid
   * @param guess is the guess
   * @param board is the current board
   * @param allWords is the dictionary of all words
   * @param isHuman is true if the guesser is human
   * @return true if the guess is valid
   */
  public boolean isValidGuess (String guess, ArrayList<Round> board, Dictionary allWords, boolean isHuman) {
    // check if guess is 5 letters
    if(guess.length() != 5) {
      if(isHuman) System.out.println("Your guess must be 5 letters long");
      return false;
    }
    // convert guess to lowercase
    guess = guess.toLowerCase();
    // check if guess is in the dictionary
    if(!allWords.contains(guess)) {
      if(isHuman) System.out.println("Your guess must be a valid word");
      return false;
    }
    // check if guess has been made before
    for(Round r : board) {
      if(r.getGuess().equals(guess)) {
        if(isHuman) System.out.println("You have already guessed that word");
        return false;
      }
    }
    // check for repeated letters
    for(int i = 0; i < guess.length(); i++) {
      for(int j = i+1; j < guess.length(); j++) {
        if(guess.charAt(i) == guess.charAt(j)) {
          if(isHuman) System.out.println("Your guess cannot contain repeated letters");
          return false;
        }
      }
    }
    // check if guess shares hint number of letters with each previous guess
    for(Round r : board) {
      int hint = r.getHint();
      String prevGuess = r.getGuess();
      int sharedLetters = 0;
      for(int i = 0; i < guess.length(); i++) {
        if(prevGuess.indexOf(guess.charAt(i)) != -1) {
          sharedLetters++;
        }
      }
      if(sharedLetters != hint) {
        if(isHuman) System.out.println("Your guess does not share the correct number of letters with previous guesses");
        return false;
      }
    }
    // if we get here, the guess is valid
    return true;
  }
}