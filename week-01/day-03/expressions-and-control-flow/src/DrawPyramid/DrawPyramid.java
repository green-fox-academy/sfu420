package DrawPyramid;

import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please give me a number: ");
    int num = scanner.nextInt();

    for (int i = 0; i < num; i++) {
      for (int j = num; j > i + 1; j--) {
        System.out.print(" ");
      }
      System.out.print("*");
      for (int j = 0; j < i * 2; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
