package org.example.runnner;

import org.example.Console;
import org.example.IO.FileService;
import org.example.attacks.BruteForce;
import org.example.attacks.CheckLanguage;
import org.example.cipher.Caesar;
import org.example.constants.Constants;

import java.util.ArrayList;

public class Runner {
    Console console = new Console();
    FileService fileService = new FileService();
    CheckLanguage checkLanguage = new CheckLanguage();
    public ArrayList<Character> alphabet;
    public void run(String[] args) {
        if (args.length < 3 ) {
            System.out.println("You launched the console version of the program");
            console.runFromConsole();
            return;
        }
            String command = args[0];
            String filePath = args[1];
            int key = Integer.parseInt(args[2]);

        String contentFromFile = fileService.readFile(filePath);

        if (checkLanguage.checkLanguage(contentFromFile)) {
            alphabet = Constants.ALPHABET_UA;
        } else {
            alphabet = Constants.ALPHABET_EN;
        }

        Caesar cipher = new Caesar(alphabet);
        BruteForce bruteForce = new BruteForce(alphabet, cipher);


        switch (command) {
            case "ENCRYPT" -> {
                String contentToFile = cipher.encrypt(contentFromFile, key);
                fileService.writeFileEncrypte(filePath, contentToFile);
            }
            case "DECRYPT" -> {
                String contentToFileDecrypt = cipher.decrypt(contentFromFile, key);
                fileService.writeFileDecrypte(filePath, contentToFileDecrypt);
            }
            case "BRUTE_FORCE" -> {
                String contentToFile = bruteForce.bruteForce(contentFromFile, cipher);
                fileService.writeFileDecrypte(filePath, contentToFile);
            }
            default -> console.runFromConsole();
        }
    }
}
