import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Dictionary {
  String [] words;

  public Dictionary () {
    String [] dict = {"BREAD", "TREAD", "BEADS", "BROTH", "DONUT", "SOUTH"};
    words = dict;
  }

  public Dictionary (String [] words) {
    this.words = words;
  }
  
  public Dictionary (String filename) {

  }

  /** Checks to see if word is in the dictionary 
   @param word the word to look for
   @return true if word in dictionary, false otherwise 
  */
  public boolean contains (String word) {
    return true;
  }

  /**
   Returns a random word from the dictionary
  */
  public String getRandomWord () {
    return words[0];
  }
}