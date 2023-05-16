package org.example.attacks;

import java.util.Arrays;
import java.util.List;

public class CheckLanguage {
    private final List<String> LETTERS_UA = Arrays.asList(
            "о", "а", "и", "е", "ґ", "є", "ї"
    );
    public CheckLanguage() {
    }

    public boolean checkLanguage (String text) {

        for (String letter : LETTERS_UA) {
            int index = text.indexOf(letter);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }
}
