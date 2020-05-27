// Create a method that decrypts reversed-order.txt

package ReversedOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReversedOrder {
  public static void main(String[] args) {
    String filename = "reversed-order.txt";
    String decryptedFile = "reversed-order-correct.txt";

    reverseOrder(filename, decryptedFile);
  }

  private static void reverseOrder(String filename, String decryptedFile) {
    try {
      Path filePath = Paths.get(filename);
      List<String> lines = Files.readAllLines(filePath);
      Collections.reverse(lines);
      List<String> newLines = new ArrayList<>();
      for (String line : lines) {
        StringBuilder decryptedLine = new StringBuilder();
        char[] charsByLine = line.toCharArray();
        for (char c : charsByLine) {
          decryptedLine.append(c);
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
