import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * Dictionary is the class that holds a dictionary of words
 */
public class Dictionary {
  /**
   * words is the array of words in the dictionary
   */
  String[] words;

  /**
   * Constructor for objects of class Dictionary
   */
  public Dictionary() {
    String[] dict = { "BREAD", "TREAD", "BEADS", "BROTH", "DONUT", "SOUTH" };
    words = dict;
  }

  /**
   * Constructor for objects of class Dictionary
   * 
   * @param words the array of words to use as the dictionary
   */
  public Dictionary(String[] words) {
    this.words = words;
  }

  /**
   * Constructor for objects of class Dictionary
   * 
   * @param filename the name of the file to read the dictionary from
   */
  public Dictionary(String filename) {
    // import words from csv file
    ArrayList<String> wordList = new ArrayList<String>();
    try {
      Scanner file = new Scanner(new File(filename));
      while (file.hasNextLine()) {
        String line = file.nextLine();
        wordList.add(line);
      }
      file.close();
      words = wordList.toArray(new String[0]);
    } catch (Exception e) {
      System.out.println("Error reading file: " + e);
    }
  }

  /**
   * Checks to see if word is in the dictionary
   * 
   * @param word the word to look for
   * @return true if word in dictionary, false otherwise
   */
  public boolean contains(String word) {
    for (String w : words) {
      if (w.equals(word)) {
        return true;
      }
    }
    System.out.println(word + " isn't in the dictionary");
    return false;
  }

  /**
   * Returns a random word from the dictionary
   */
  public String getRandomWord() {
    int index = (int) (Math.random() * words.length);
    return words[index];
  }

  /**
   * Returns the word at the given index
   * 
   * @param index the index of the word to return
   * @return the word at the given index
   */
  public String getWordAtIndex(int index) {
    return words[index];
  }
}