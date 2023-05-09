package org.example.runnner;

import org.example.IO.FileService;
import org.example.cipher.Caesar;
import org.example.cipher.Cipher;
import org.example.constants.Constants;

public class Runner {
    public static void run(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Main <command> <file_path> <key>");
            System.exit(1);
        }

        String command = args[0];
        String filePath = args[1];
        Integer key = Integer.valueOf(args[2]);

        if (command.equals("ENCRYPT")) {
            String contentFromFile = FileService.readFile(filePath);
            String contentToFile = Caesar.encrypt(contentFromFile, Constants.ALPHABET_EN, key);
            FileService.writeFileEncrypte(filePath, contentToFile);
        } else if (command.equals("DECRYPT")) {
            String contentFromFileEncrypt = FileService.readFile(filePath);
            String contentToFileDecrypt = Cipher.decrypt(contentFromFileEncrypt,Constants.ALPHABET_EN, key);
            FileService.writeFileDecrypte(filePath, contentToFileDecrypt);
        }
    }
}
