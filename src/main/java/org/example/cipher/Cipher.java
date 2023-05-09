package org.example.cipher;

import java.util.ArrayList;

public class Cipher {
    protected static String encrypt(String message, ArrayList<Character> alphabet, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        int alphabetLength = alphabet.size();
        int newKey = key % alphabetLength;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int charIndex = getIndex(alphabet, c);
            if (charIndex != -1) {
                c = alphabet.get((charIndex + newKey) % alphabetLength);
            }
            encryptedMessage.append(c);
        }
        return encryptedMessage.toString();
    }

    protected static String decrypt(String encryptMessage, ArrayList<Character> alphabet, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        int alphabetLength = alphabet.size();
        int newKey = key % alphabetLength;
        for (int i = 0; i < encryptMessage.length(); i++) {
            char c = encryptMessage.charAt(i);
            int charIndex = getIndex(alphabet, c);
            if (charIndex != -1) {
                c = alphabet.get((charIndex - newKey + alphabetLength) % alphabetLength);
            }
            encryptedMessage.append(c);
        }
        return encryptedMessage.toString();
    }


    private static int getIndex(ArrayList<Character> alphabet, char c) {
        for (int i = 0; i < alphabet.size(); i++) {
            if (alphabet.get(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
