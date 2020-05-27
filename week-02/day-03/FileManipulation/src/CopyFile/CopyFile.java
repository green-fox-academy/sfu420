// Write a function that copies the contents of a file into another
// It should take the filenames as parameters
// It should return a boolean that shows if the copy was successful

package CopyFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyFile {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Give me the source file: ");
    String source = scanner.next();
    System.out.print("Give me the destination file: ");
    String destination = scanner.next();

    System.out.println(copyFile(source, destination));

  }

  private static boolean copyFile(String source, String destination) {
    boolean succesful = true;
    try {
      Path sourceFilePath = Paths.get(source);
      Path destinationFilePath = Paths.get(destination);
      Files.copy(sourceFilePath, destinationFilePath);
    } catch (Exception e) {
      succesful = false;
    }
    return succesful;
  }
}
