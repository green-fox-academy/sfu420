package DrawPyramid;

import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please give me a number: ");
    int num = scanner.nextInt();

    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= num - i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j < (i * 2); j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
