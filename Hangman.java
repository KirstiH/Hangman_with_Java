/**
 * 
 */
package main.java.dev.m3s.programming2.homework4;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Kirsti Härö
 * @version 6.4.2023
 * Hangman game
 */
public class Hangman {
    
    private ArrayList<String> words = new ArrayList<String>();
    private int guessesLeft;
    private String word;
    private StringBuilder masked = new StringBuilder();
    private ArrayList<Character> characters = new ArrayList<Character>();
    
    

    public Hangman(ArrayList<String> words, int guesses) {
        Random rand = new Random();
        int number = rand.nextInt(words.size());
        this.word = words.get(number);
        this.guessesLeft = guesses;
        this.words = words;   
        
        
        for (int i = 0; i < word.length(); i++) {
            masked.append("* ");
        }  

    }
    
    public boolean guess(Character c) {
        boolean found = false;
        if (characters.contains(c)) return found;
        if (word.indexOf(c) >= 0) {
            this.characters.add(c);
            found = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    if (i == 0) {
                        masked.setCharAt(i, c);
                    } else {
                        int j = i*2;
                        masked.setCharAt(j, c);
                    }
                }
            }
            
        } else {
            guessesLeft--;
            this.characters.add(c);
        }
            
        return found;   
        
    }
    
    public String getHiddenWord() {
        return masked.toString();
    }
    
    public int guessesLeft() {
        return this.guessesLeft;
    }
    
    public ArrayList<Character> guesses(){
        return this.characters;
    }
    
    public String word() {
        return this.word;
    }
    
    public boolean theEnd() {
        if (guessesLeft <= 0)
            return true;
        if (masked.indexOf("*") < 0)
            return true;       
        return false;
    }
    
}
