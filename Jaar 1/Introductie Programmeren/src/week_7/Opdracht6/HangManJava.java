package week_7.Opdracht6;

import java.util.Random;
import java.util.Scanner;

public class HangManJava {
    private static int MAX_TURNS = 13;
    private int turnsIncorrect = 0;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private char maskChar = '#';
    private String originalWord = "", maskedWord = "#############", lettersGuessedIncorrectly = "", lettersGuessedCorrectly = "";
    private String[] words = {"ANATOMIZATION", "WEIGHTLIFTING", "BOARDSAILINGS", "CARBONISATION", "DEMAGNETISING"};

    public static void main(String[] args) {
        new HangManJava().run();
    }

    /**
     * First get a word at a random index and convert it to lower case
     * do{
     *      if a guess wasn't correct. Increase the incorrect turns amount
     *      else just print the board
     *
     *      if the word was correct, exit out
     *
     *      pretty print (can be removed to decrease amount of code)
     * } while word isn't correct and amount of turns hasnt exceeded MAX TURNS
     *
     * at the end, print what's needed
     */
    private void run() {
        originalWord = words[random.nextInt(words.length)].toLowerCase();
        do {
            if (!takeAGuess()) {
                turnsIncorrect++;
                Board.print(turnsIncorrect);
            } else {
                Board.print(turnsIncorrect);
            }

            if (wordCorrect()) {
                System.out.println("  You guessed the word: " + maskedWord);
                System.exit(0);
            }

            if (turnsIncorrect > 0) {
                System.out.println("         " + maskedWord);
            } else {
                System.out.println("                " + maskedWord);
            }

            System.out.println("                Incorrect: " + lettersGuessedIncorrectly);
        } while (!wordCorrect() && turnsIncorrect != MAX_TURNS);
        Board.print(turnsIncorrect);
        System.out.println("          YOU DIED!");
    }

    private boolean wordCorrect() {
        return maskedWord.equals(originalWord);
    }

    /**
     * Extra stuff is for a nice printing
     * <p>
     *      Check if read isn't of length > 1
     *      Check if letter been used
     * <p>
     *      If the original word has the read in char:
     *           Add to letters guessed correctly
     *           un mask this character
     *      else
     *           Add to letters guessed incorrectly
     * </p>
     *
     * @return true or false
     */
    private boolean takeAGuess() {
        System.out.print("                Guess a letter: ");
        String read = scanner.next().toLowerCase();
        if (read.length() != 1) {
            System.out.println("                Incorrect input!");
            return takeAGuess();
        }
        if (lettersGuessedIncorrectly.contains(read) || lettersGuessedCorrectly.contains(read)) {
            System.out.println("                Letter has been used");
            return takeAGuess();
        }

        if (originalWord.contains(read)) {
            lettersGuessedCorrectly += read;
            unMask();
            return true;
        } else {
            lettersGuessedIncorrectly += read;
            return false;
        }
    }

    /**
     * <p>
     * First convert mask into a char array for easier checking
     * <p>
     *      Next loop through the original word or maskedWord (doesn't matter as long as the length is the same)
     *      Optimization: if masked is an unmasked character, skip the next loop and go towards the next iteration.
     *      If that isn't the case, do the next loop and if the character at position i (in the original word) the same is as
     *      the character at position j (in lettersGuessedCorrectly). Replace the masked character with the one in lettersGuessedCorrectly
     *      Character at position j (in lettersGuessedCorrectly). Replace the masked character with the one in lettersGuessedCorrectly
     *      <p>
     * Lastly set the masked character back into the string.
     * </p>
     */
    private void unMask() {
        char[] masked = maskedWord.toCharArray();
        for (int i = 0; i < originalWord.length(); i++) {
            if (masked[i] != maskChar) {
                continue;
            }
            for (int j = 0; j < lettersGuessedCorrectly.length(); j++) {
                if (originalWord.charAt(i) == lettersGuessedCorrectly.charAt(j)) {
                    masked[i] = lettersGuessedCorrectly.charAt(j);
                }
            }
        }
        maskedWord = String.valueOf(masked);
    }
}
