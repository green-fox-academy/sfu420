package DrawSquare;

import java.util.Scanner;

public class DrawSquare {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please give me a number: ");
    int num = scanner.nextInt();

    for (int i = 0; i < num; i++) {
      if (i == 0 || i == num - 1) {
        for (int j = 0; j < num; j++) {
          System.out.print("%");
        }
      } else {
        for (int j = 0; j < num; j++) {
          if (j == 0 || j == num - 1) {
            System.out.print("%");
          } else {
            System.out.print(" ");
          }
        }
      }
      System.out.println();
    }
  }
}
