// Create a method that decrypts reversed-lines.txt

package ReversedLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {
  public static void main(String[] args) {
    String filename = "reversed-lines.txt";
    String decryptedFile = "reversed-lines-correct.txt";

    reverseLine(filename, decryptedFile);
  }

  private static void reverseLine(String filename, String decryptedFile) {
    try {
      Path filePath = Paths.get(filename);
      List<String> lines = Files.readAllLines(filePath);
      List<String> newLines = new ArrayList<>();
      for (String line : lines) {
        StringBuilder decryptedLine = new StringBuilder();
        char[] charsByLine = line.toCharArray();
        for (int i = charsByLine.length; i > 0; i--) {
          decryptedLine.append(charsByLine[i - 1]);
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
