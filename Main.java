/**
 * 
 */
package main.java.dev.m3s.programming2.homework4;

import java.util.Scanner;

/**
 * @author Kirsti Härö
 * @version 6.4.2023
 * Main for Hangman game
 */
public class Main {

    /**
     * @param args gives the name of the file
     */
    public static void main(String[] args) {
        String fileName = "words.txt";
        if (args.length > 0 ) fileName = args[0];
        Scanner reader = new Scanner(System.in);
        
        WordList words = new WordList(fileName);
        Hangman hangman = new Hangman(words.giveWords(), 5);
        
        do {
            System.out.println("\nThe hidden word...");
            System.out.println("\n" + hangman.getHiddenWord() + "\n");
            System.out.println("Guesses left: " + hangman.guessesLeft());
            System.out.println("Guessed letters: " + hangman.guesses());
            System.out.print("Guess a letter: ");
            String ch = reader.next();
            char c = ch.charAt(0);
            hangman.guess(c);
            
            
        } while (hangman.theEnd() == false);
        reader.close();
        
        if (hangman.getHiddenWord().contains("*")) {
            System.out.println("\nSorry, you lost!");
            System.out.println("The hidden word was: " + hangman.word());
        } else {
            System.out.println("\nCongratulations! You won!!!");
            System.out.println("The hidden word was: " + hangman.word());
        }
    
    }

}
