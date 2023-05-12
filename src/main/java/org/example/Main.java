package org.example;


import org.example.IO.FileService;
import org.example.attacks.CheckLanguage;
import org.example.runnner.Runner;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Runner runner = new Runner();
        runner.run(args);

//        FileService fileService = new FileService();
//        CheckLanguage checkLanguage = new CheckLanguage();
//        Scanner scanner = new Scanner(System.in);
//        String filePath = scanner.nextLine();
//        String contentFromFile = fileService.readFile(filePath);
//
//        System.out.println(checkLanguage.checkLanguage(contentFromFile));
    }
}