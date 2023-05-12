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

//    Caesar cipher = new Caesar(Constants.ALPHABET_EN);
//    BruteForce bruteForce = new BruteForce(Constants.ALPHABET_EN, cipher);
    public void run(String[] args) {
        if (args.length < 3 ) {
//            System.out.println("Usage: java Main <command> <file_path> <key>");
            System.out.println("You launched the console version of the program");
            console.runFromConsole();
            return;
        }
            String command = args[0];
            String filePath = args[1];
            Integer key = Integer.valueOf(args[2]);

        String contentFromFile = fileService.readFile(filePath);

        if (checkLanguage.checkLanguage(contentFromFile)) {
            alphabet = Constants.ALPHABET_UA;
        } else {
            alphabet = Constants.ALPHABET_EN;
        }

        Caesar cipher = new Caesar(alphabet);
        BruteForce bruteForce = new BruteForce(alphabet, cipher);


            if (command.equals("ENCRYPT")) {
                //String contentFromFile = fileService.readFile(filePath);
                String contentToFile = cipher.encrypt(contentFromFile, key);
                fileService.writeFileEncrypte(filePath, contentToFile);
            } else if (command.equals("DECRYPT")) {
                //String contentFromFileEncrypt = fileService.readFile(filePath);
                String contentToFileDecrypt = cipher.decrypt(contentFromFile, key);
                fileService.writeFileDecrypte(filePath, contentToFileDecrypt);
            } else if (command.equals("BRUTE_FORCE")) {
                //String contentFromFileEncrypt = fileService.readFile(filePath);
                String contentToFile = bruteForce.bruteForce(contentFromFile, cipher);
                fileService.writeFileDecrypte(filePath, contentToFile);
            } else {
                console.runFromConsole();
            }
    }
}
