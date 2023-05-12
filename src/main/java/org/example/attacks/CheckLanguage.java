package org.example.attacks;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class CheckLanguage {
    private final List<String> LETTERS_UA = Arrays.asList(
            "о", "а", "и", "е", "ґ", "є", "ї"
    );
//    private final List<String> LETTERS_EN = Arrays.asList(
//            "e", "t", "a", "o"
//    );

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
