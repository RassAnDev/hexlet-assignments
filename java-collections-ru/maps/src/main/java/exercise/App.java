package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsAndQuantity = new HashMap<>();
        String[] wordsArray = sentence.split(" ");

        if (sentence.equals("")) {
            return wordsAndQuantity;
        }

        for (String word : wordsArray) {
            if (wordsAndQuantity.containsKey(word)) {
                wordsAndQuantity.put(word, wordsAndQuantity.get(word) + 1);
            } else {
                wordsAndQuantity.put(word, 1);
            }
        }

        return wordsAndQuantity;
    }

    public static String toString(Map<String, Integer> mapWords) {
        StringBuilder result = new StringBuilder();

        if (mapWords.isEmpty()) {
            result.append("{}");
            return result.toString();
        }
        result.append("{\n");

        for (Map.Entry<String, Integer> wordsCount : mapWords.entrySet()) {
            result.append("  ").append(wordsCount.getKey()).append(":")
                    .append(" ").append(wordsCount.getValue()).append("\n");
        }
        result.append("}");
        
        return result.toString();
    }
}
//END
