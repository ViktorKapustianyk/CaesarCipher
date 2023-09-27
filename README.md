# CaesarCipher

This application implements encryption and decryption of messages using the Caesar Cipher.

The application can be run from the command line by passing arguments for operations.

To run the program from the command line, use the following command: java -jar CaesarCipher.jar command filePath key

- `command` - one of three options: `ENCRYPT`, `DECRYPT`, `BRUTE_FORCE`.
- `filePath` - the absolute path to the file to be encrypted or decrypted.
- `key` - an integer used for shifting through the alphabet.

Passing `key` is mandatory. In the case of `BRUTE_FORCE`, any `key` can be specified.

If the program is launched without arguments, you can interact with it using the command line.

The result of the program's execution will be saved in the output folder with the same name as the original file, but with the `[ENCRYPTED]` or `[DECRYPTED]` tag depending on the operation performed.

The input file should contain text in either Ukrainian or English, which will be encrypted or decrypted. The program will automatically determine the language and use the appropriate alphabet for encryption. Encryption/decryption is performed using the Caesar Cipher with the specified key. The alphabet shift is cyclical, meaning that if the key is greater than the number of letters in the alphabet, the shift will start from the beginning of the alphabet.

## Development

During the development of this application, the following points were considered:

- Creating separate classes and packages for different functionality.
- Utilizing object-oriented programming and access modifiers.
- Implementing a method that changes the file name with or without considering the file extension.
- Creating a method for automatically detecting the text's alphabet (Ukrainian/English).

## Extending Functionality

This code can be extended with additional letters and rules for detecting other languages. This allows for expanding its functionality for use in a broader context.
