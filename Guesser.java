import java.util.ArrayList;
import java.util.Scanner;

public class Guesser {
  boolean isHuman;
  Scanner input;

  // constructors
  public Guesser () {
    isHuman = false;
    input = new Scanner(System.in);
  }
  public Guesser (boolean isHuman) {
    this.isHuman = isHuman;
    input = new Scanner(System.in);
  }

  // make a guess
  public Round makeGuess (ArrayList<Round> board, Dictionary allWords) {
    Round r = new Round();
    String guess = "";
    while(!isValidGuess(guess, board, allWords, isHuman)) {
      // new guess
      if(this.isHuman) {
        guess = makeHumanGuess();
      } else {
        guess = makeAIGuess(allWords);
      }
    }
    System.out.println("Your guess is: " + guess);
    r.setGuess(guess);
    return r;
  }

  private String makeHumanGuess () {
    System.out.print("Enter your guess: ");
    String guess = input.nextLine();
    return guess;
  }

  private String makeAIGuess (Dictionary allWords) {
    // demo code, return random word from dictionary
    return allWords.getRandomWord();
  }

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