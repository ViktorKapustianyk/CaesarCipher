package org.example.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private final String ADD_ENCRYPTED = " [ENCRYPTED]";
    private final String ADD_DECRYPTED = " [DECRYPTED]";

    public String readFile (String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeFileEncrypte (String fileName, String content) {
        try {
            Path outputFilePath = Paths.get(getNewFileName(fileName, ADD_ENCRYPTED));
            if (Files.notExists(outputFilePath)) {
                Files.createFile(outputFilePath);
            }
            Files.write(outputFilePath, content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeFileDecrypte (String fileName, String content) {
        try {
            Path outputFilePath = Paths.get(getNewFileName(fileName, ADD_DECRYPTED));
            if (Files.notExists(outputFilePath)) {
                Files.createFile(outputFilePath);
            }
            Files.write(outputFilePath, content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String getNewFileName(String oldFileName, String add) {
        int dotIndex = oldFileName.lastIndexOf(".");

        if (oldFileName.contains(ADD_ENCRYPTED)) {
            return oldFileName.replace(ADD_ENCRYPTED, ADD_DECRYPTED);
        }
        if (dotIndex != -1) {
            return oldFileName.substring(0, dotIndex) + add + oldFileName.substring(dotIndex);
        } else {
            return oldFileName + add;
        }
    }
}
