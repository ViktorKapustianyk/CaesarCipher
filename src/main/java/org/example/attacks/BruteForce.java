package org.example.attacks;

import org.example.cipher.Caesar;
import org.example.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce extends Caesar{
    private final List<String> WORDS = Arrays.asList(
            "the", "and", "is", "are", "in", "at", "that", "this", "for", "to", "on", "with", "it",
            "of", "an", "as", "be", "was", "or", "by", "from", "not", "but", "you", "all", "they",
            "we", "our", "your", "so", "if", "out", "about", "more", "has", "have", "what", "when",
            "where", "who", "which", "why", "how", "many", "much", "some", "any", "no", "just", "like",
            "into", "up", "down", "into", "over", "under", "there", "then", "her", "him", "his", "hers",
            "their", "them", "because", "could", "would", "should", "will", "can", "may", "might"
    );

    public BruteForce(ArrayList<Character> alphabet) {
        super(alphabet);
    }

    public String bruteForce(String message) {
        int resultKey = 0;
        int maxWords = 0;
        for (int key = 0; key <= Constants.ALPHABET_EN.size(); key++) {
            String result = Caesar.decrypt(message, Constants.ALPHABET_EN, key);
            int commonWords = countWords(result);
            if (commonWords > maxWords) {
                maxWords = commonWords;
                resultKey = key;
            }

        }
        return Caesar.decrypt(message, Constants.ALPHABET_EN, resultKey);
    }


    private int countWords(String text) {
        int count = 0;
        for (String word : WORDS) {
            int index = text.indexOf(word);
            while (index != -1) {
                count++;
                index = text.indexOf(word, index + 1);
            }
        }
        return count;
    }
}
