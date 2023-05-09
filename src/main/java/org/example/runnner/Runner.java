package org.example.runnner;

import org.example.Console;
import org.example.IO.FileService;
import org.example.attacks.BruteForce;
import org.example.cipher.Caesar;
import org.example.constants.Constants;

public class Runner {
    Console console = new Console();
    FileService fileService = new FileService();
    Caesar cipher = new Caesar(Constants.ALPHABET_EN);
    BruteForce bruteForce = new BruteForce(Constants.ALPHABET_EN, cipher);
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

            if (command.equals("ENCRYPT")) {
                String contentFromFile = fileService.readFile(filePath);
                String contentToFile = cipher.encrypt(contentFromFile, key);
                fileService.writeFileEncrypte(filePath, contentToFile);
            } else if (command.equals("DECRYPT")) {
                String contentFromFileEncrypt = fileService.readFile(filePath);
                String contentToFileDecrypt = cipher.decrypt(contentFromFileEncrypt, key);
                fileService.writeFileDecrypte(filePath, contentToFileDecrypt);
            } else if (command.equals("BRUTE_FORCE")) {
                String contentFromFileEncrypt = fileService.readFile(filePath);
                String contentToFile = bruteForce.bruteForce(contentFromFileEncrypt, cipher);
                fileService.writeFileDecrypte(filePath, contentToFile);
            } else {
                console.runFromConsole();
            }
    }
}
