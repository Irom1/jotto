import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // scanner for user input
    Scanner s = new Scanner(System.in);

    // welcome message
    System.out.println("\n\nWelcome to Jotto!");

    // while the user wants to play, play a game
    boolean playAgain = true;
    while (playAgain) {
      // play a game
      playGame(s);
      // ask if the user wants to play again
      System.out.print("\n\nPlay again? (y/n): ");
      playAgain = s.nextLine().toLowerCase().equals("y");
    }

    // goodbye message
    System.out.println("Goodbye!");
  }

  // play a game
  public static void playGame(Scanner s) {
    // ask if the user wants to play against a human
    System.out.print("Have AI pick the word? (y/n): ");
    boolean humanMegaMind = s.nextLine().toLowerCase().equals("n");
    System.out.print("Have an AI guess the word? (y/n): ");
    boolean humanGuesser = s.nextLine().toLowerCase().equals("n");
    // create a new game
    JottoGame game = new JottoGame(humanMegaMind, humanGuesser);
    // play the game
    game.play();
  }
}
