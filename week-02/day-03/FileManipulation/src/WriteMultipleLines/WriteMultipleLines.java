// Create a function that takes 3 parameters: a path, a word and a number
// and is able to write into a file.
// The path parameter should be a string that describes the location of the file you wish to modify
// The word parameter should also be a string that will be written to the file as individual lines
// The number parameter should describe how many lines the file should have.
// If the word is 'apple' and the number is 5, it should write 5 lines
// into the file and each line should read 'apple'
// The function should not raise any errors if it could not write the file.

package WriteMultipleLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteMultipleLines {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Give me a filename: ");
    String filename = scanner.next();
    System.out.print("Give me a word: ");
    String word = scanner.next();
    System.out.print("Give me a number: ");
    int count = scanner.nextInt();

    writeFile(filename, word, count);
  }

  private static void writeFile(String filename, String word, int count) {

    List<String> content = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      content.add(word);
    }

    try {
      Path filePath = Paths.get(filename);
      Files.write(filePath, content);
    } catch (IOException e) {
      System.exit(2);
    }
  }
}
