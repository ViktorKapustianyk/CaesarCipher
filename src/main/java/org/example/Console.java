package org.example;

import org.example.IO.FileService;
import org.example.attacks.BruteForce;
import org.example.cipher.Caesar;
import org.example.cipher.Cipher;
import org.example.constants.Constants;
import java.util.Scanner;

public class Console {
    private static final String firstQuestion = "What do you want to do with text?";
    private static final String chooseLanguage = "What language is used in the text?\nWrite one of the commands and press enter\n[u]Ukrainian [e]English";
    private static final String chooseCommand = "Write one of the commands and press enter\n[e]encrypt [d]decrypt [b]bruteForce";
    private static final String filePath = "Write path to the file";
    private static final String chooseKey = "Choose the key";

    public static void runFromConsole () {
        Caesar caesar = new Caesar(Constants.ALPHABET_EN);
        Scanner scanner = new Scanner(System.in);
        System.out.println(firstQuestion);
        //System.out.println(chooseLanguage);
        //String language = scanner.nextLine();


        System.out.println(filePath);
        String filePath = scanner.nextLine();

        System.out.println(chooseCommand);
        String command = scanner.nextLine();

        if (command.equals("e")) {
            System.out.println(chooseKey);
            Integer key = scanner.nextInt();
            String contentFromFile = FileService.readFile(filePath);
            String contentToFile = caesar.encrypt(contentFromFile, key);
            FileService.writeFileEncrypte(filePath, contentToFile);
        } else if (command.equals("d")) {
            System.out.println(chooseKey);
            Integer key = scanner.nextInt();
            String contentFromFileEncrypt = FileService.readFile(filePath);
            String contentToFileDecrypt = caesar.decrypt(contentFromFileEncrypt, key);
            FileService.writeFileDecrypte(filePath, contentToFileDecrypt);
        } else if (command.equals("b")) {
            String contentFromFileEncrypt = FileService.readFile(filePath);
            String contentToFileDecrypt = caesar.bruteForce(contentFromFileEncrypt);
            FileService.writeFileDecrypte(filePath, contentToFileDecrypt);
        }
    }
}
