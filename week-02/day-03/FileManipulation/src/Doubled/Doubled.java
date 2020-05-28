// Create a method that decrypts the duplicated-chars.txt

package Doubled;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {
  public static void main(String[] args) {
    String filename = "duplicated-chars.txt";
    String decryptedFile = "duplicated-chars-decrypted.txt";

    deduplication(filename, decryptedFile);
  }

  private static void deduplication(String filename, String decryptedFile) {
    try {
      Path filePath = Paths.get(filename);
      List<String> lines = Files.readAllLines(filePath);
      List<String> newLines = new ArrayList<>();
      for (String line : lines) {
        StringBuilder decryptedLine = new StringBuilder();
        char[] charsByLine = line.toCharArray();
        for (int i = 0; i < charsByLine.length; i += 2) {
          decryptedLine.append(charsByLine[i]);
        }
        newLines.add(decryptedLine.toString());
      }
      Path newFilePath = Paths.get(decryptedFile);
      Files.write(newFilePath, newLines);
      System.out.println("Decryption was successful!");
    } catch (IOException e) {
      System.out.println("File not found");
    }
  }
}
