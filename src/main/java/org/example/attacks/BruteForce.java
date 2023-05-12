package org.example.attacks;

import org.example.cipher.Caesar;
import org.example.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {
    private final List<String> WORDS_EN = Arrays.asList(
            "the", "and", "is", "are", "in", "at", "that", "this", "for", "to", "on", "with", "it",
            "of", "an", "as", "be", "was", "or", "by", "from", "not", "but", "you", "all", "they",
            "we", "our", "your", "so", "if", "out", "about", "more", "has", "have", "what", "when",
            "where", "who", "which", "why", "how", "many", "much", "some", "any", "no", "just", "like",
            "into", "up", "down", "into", "over", "under", "there", "then", "her", "him", "his", "hers",
            "their", "them", "because", "could", "would", "should", "will", "can", "may", "might"
    );
    private final List<String> WORDS_UA = Arrays.asList(
            "на", "що", "не", "він", "вона", "вони", "ми", "ти", "ви", "його", "її", "їх",
            "це", "так", "але", "тут", "там", "для", "по", "за", "зі", "від", "до", "під", "над", "про", "бо",
            "як", "щоб", "чи", "той", "та", "те", "тільки", "також", "можна", "бути", "має", "мати", "коли", "де",
            "хто", "який", "чому", "якщо", "все", "усе", "той", "та", "тий", "цей", "ця", "це", "ці", "собі", "дім"
    );

    private final ArrayList<Character> alphabet;
    public BruteForce(ArrayList<Character> alphabet, Caesar cipher) {
        this.alphabet = alphabet;
    }

    public String bruteForce(String message, Caesar caesar) {
        int resultKey = 0;
        int maxWords = 0;
        for (int key = 0; key <= alphabet.size(); key++) {
            String result = caesar.decrypt(message, key);
            if (alphabet.equals(Constants.ALPHABET_EN)) {
                int commonWords = countWords(result, WORDS_EN);
                if (commonWords > maxWords) {
                    maxWords = commonWords;
                    resultKey = key;
                }
            } else {
                int commonWords = countWords(result, WORDS_UA);
                if (commonWords > maxWords) {
                    maxWords = commonWords;
                    resultKey = key;
                }
            }
        }
        return caesar.decrypt(message, resultKey);
    }


    private int countWords(String text, List<String> WORDS ) {
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
