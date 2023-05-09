package org.example;

import org.example.IO.FileService;
import org.example.cipher.Caesar;
import org.example.cipher.Cipher;
import org.example.constants.Constants;
import org.example.runnner.Runner;

import java.lang.constant.Constable;

public class Main {
    public static void main(String[] args) {
        Console.runFromConsole();

//        FileService fileService = new FileService();
//        Cipher cipher = new Caesar(Constants.ALPHABET_EN);
//        Runner runner = new Runner(cipher, fileService);
//        Runner.run(args);
//
//        String message = "hello world";
//        int shift = 3;
//        String encryptedMessage = Cipher.encrypt(message, Constants.ALPHABET_EN, shift);
//        String decryptedMessage = Cipher.decrypt(encryptedMessage, Constants.ALPHABET_EN, shift);
//        System.out.println("Original message: " + message);
//        System.out.println("Encrypted message: " + encryptedMessage);
//        System.out.println("Decrypted message: " + decryptedMessage);

//        Scanner scanner = new Scanner(System.in);

//        String path = scanner.nextLine();
//        int key = scanner.nextInt();
//
//        String contentFromFile = FileService.readFile(path);
//        String contentToFile = Cipher.encrypt(contentFromFile,Constants.ALPHABET_EN, key);
//        FileService.writeFileEncrypte(path, contentToFile);

//        String pathEncrypteFile = scanner.nextLine();
//        int keyForDecrypte = scanner.nextInt();
//
//        String contentFromFileEncrypte = FileService.readFile(pathEncrypteFile);
//        String contentToFileDecrypte = Cipher.decrypt(contentFromFileEncrypte,Constants.ALPHABET_EN, keyForDecrypte);
//        FileService.writeFileDecrypte(pathEncrypteFile, contentToFileDecrypte);
    }
}