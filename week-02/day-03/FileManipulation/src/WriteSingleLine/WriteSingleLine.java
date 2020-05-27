// Write a function that is able to manipulate a file
// By writing your name into it as a single line
// The file should be named "my-file.txt"
// In case the program is unable to write the file,
// It should print the following error message: "Unable to write file: my-file.txt"

package WriteSingleLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WriteSingleLine {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Give me a filename to manipulate: ");
    String filename = scanner.next();

    writeFile(filename);
  }

  private static void writeFile(String filename) {
    List<String> content = new ArrayList<>(Arrays.asList("Sandor"));
    try {
      Path filePath = Paths.get(filename);
      if (Files.notExists(filePath)) {
        System.out.println("File not found, trying to create it...");
      }
      Files.write(filePath, content);
      System.out.println("Done");
    } catch (IOException e) {
      System.out.println("Unable to write file: " + filename);
    }
  }
}
