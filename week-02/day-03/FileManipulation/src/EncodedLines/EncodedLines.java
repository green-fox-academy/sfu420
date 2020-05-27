// Create a method that decrypts encoded-lines.txt

package EncodedLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {
  public static void main(String[] args) {
    String filename = "encoded-lines.txt";
    String decryptedFile = "encoded-lines-correct.txt";

    decryption(filename, decryptedFile);
  }

  private static void decryption(String filename, String decryptedFile) {
    try {
      Path filePath = Paths.get(filename);
      List<String> lines = Files.readAllLines(filePath);
      List<String> newLines = new ArrayList<>();
      for (String line : lines) {
        StringBuilder decryptedLine = new StringBuilder();
        char[] charsByLine = line.toCharArray();
        for (char c : charsByLine) {
          if (c == 32) {
            decryptedLine.append(c);
          } else {
            decryptedLine.append((char) (c - 1));
          }
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
