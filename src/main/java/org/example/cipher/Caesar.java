package org.example.cipher;

import java.util.ArrayList;

public class Caesar extends Cipher{
    private final ArrayList<Character> alphabet;

    public Caesar(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public  String encrypt(String message, int key) {
        return Cipher.encrypt(message, alphabet, key);
    }

    public  String decrypt(String message, int key) {
        return Cipher.decrypt(message, alphabet, key);
    }

}
