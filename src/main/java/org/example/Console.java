package org.example;

import org.example.IO.FileService;
import org.example.attacks.BruteForce;
import org.example.attacks.CheckLanguage;
import org.example.cipher.Caesar;
import org.example.constants.Constants;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private final String firstQuestion = "You have launched the Caesar Cipher program";
    private final String chooseCommand = "Write one of the commands and press enter\n[e]encrypt [d]decrypt [b]bruteForce";
    private final String filePath = "Write the path to the file you want to encrypt or decrypt";
    private final String chooseKey = "Choose the key";
    public ArrayList<Character> alphabet;

    public void runFromConsole () {
        FileService fileService = new FileService();
        CheckLanguage checkLanguage = new CheckLanguage();

        Scanner scanner = new Scanner(System.in);
        System.out.println(firstQuestion);

        System.out.println(filePath);
        String filePath = scanner.nextLine();

        String contentFromFile = fileService.readFile(filePath);

        if (checkLanguage.checkLanguage(contentFromFile)) {
            alphabet = Constants.ALPHABET_UA;
        } else {
            alphabet = Constants.ALPHABET_EN;
        }

        Caesar caesar = new Caesar(alphabet);
        BruteForce bruteForce = new BruteForce(alphabet, caesar);

        System.out.println(chooseCommand);
        String command = scanner.nextLine();

        switch (command) {
            case "e" -> {
                System.out.println(chooseKey);
                int key = scanner.nextInt();
                String contentToFile = caesar.encrypt(contentFromFile, key);
                fileService.writeFileEncrypt(filePath, contentToFile);
            }
            case "d" -> {
                System.out.println(chooseKey);
                int key = scanner.nextInt();
                String contentToFileDecrypt = caesar.decrypt(contentFromFile, key);
                fileService.writeFileDecrypt(filePath, contentToFileDecrypt);
            }
            case "b" -> {
                String contentToFileDecrypt = bruteForce.bruteForce(contentFromFile, caesar);
                fileService.writeFileDecrypt(filePath, contentToFileDecrypt);
            }
        }
    }
}
