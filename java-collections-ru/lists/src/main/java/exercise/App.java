package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        String modifiedLetters = letters.trim().toUpperCase();
        String modifiedWord = word.trim().toUpperCase();
        List<Character> lettersList = new ArrayList<>();
        List<Character> wordsList = new ArrayList<>();

        for (var i = 0; i < modifiedLetters.length(); i++) {
            lettersList.add(modifiedLetters.charAt(i));
        }

        for (var i = 0; i < modifiedWord.length(); i++) {
            wordsList.add(modifiedWord.charAt(i));
        }

        List<Character> newLettersList = new ArrayList<>();

        for (var i = 0; i < wordsList.size(); i++) {
            if (lettersList.contains(wordsList.get(i))) {
                newLettersList.add(wordsList.get(i));
                lettersList.remove(wordsList.get(i));
            }
        }
        
        return wordsList.size() == newLettersList.size();
    }
}
//END
