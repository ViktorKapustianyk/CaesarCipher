package org.example.attacks;

import org.example.cipher.Caesar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {
    private final List<String> WORDS = Arrays.asList(
            "the", "and", "is", "are", "in", "at", "that", "this", "for", "to", "on", "with", "it",
            "of", "an", "as", "be", "was", "or", "by", "from", "not", "but", "you", "all", "they",
            "we", "our", "your", "so", "if", "out", "about", "more", "has", "have", "what", "when",
            "where", "who", "which", "why", "how", "many", "much", "some", "any", "no", "just", "like",
            "into", "up", "down", "into", "over", "under", "there", "then", "her", "him", "his", "hers",
            "their", "them", "because", "could", "would", "should", "will", "can", "may", "might"
    );

    private  ArrayList<Character> alphabet;
    public BruteForce(ArrayList<Character> alphabet, Caesar cipher) {
        this.alphabet = alphabet;
    }

    public String bruteForce(String message, Caesar caesar) {
        int resultKey = 0;
        int maxWords = 0;
        for (int key = 0; key <= alphabet.size(); key++) {
            String result = caesar.decrypt(message, key);
            int commonWords = countWords(result);
            if (commonWords > maxWords) {
                maxWords = commonWords;
                resultKey = key;
            }

        }
        return caesar.decrypt(message, resultKey);
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
