package main.java.dev.m3s.programming2.homework4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordList {
    
    private ArrayList<String> words = new ArrayList<String>();

    public WordList(String fileName) {
        try (BufferedReader teksti = new BufferedReader ( new FileReader(fileName))) {
            String line;
                while ((line = teksti.readLine()) != null) {
                    words.add(line);
                }                
            } catch (FileNotFoundException e) {
                System.err.println("Cannot open the file!");
                return;
            } catch (IOException e) {
                System.err.println("Not a character!");
            }
    }
    
    public ArrayList<String> giveWords(){
        return words;
    }
    
}

