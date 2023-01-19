import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Dictionary {
  String[] words;

  public Dictionary() {
    String[] dict = { "BREAD", "TREAD", "BEADS", "BROTH", "DONUT", "SOUTH" };
    words = dict;
  }

  public Dictionary(String[] words) {
    this.words = words;
  }

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
}