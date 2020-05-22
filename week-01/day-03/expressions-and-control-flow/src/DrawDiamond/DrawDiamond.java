package DrawDiamond;

import java.util.Scanner;

public class DrawDiamond {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // This exercise works properly only with odd numbers,
    // even numbers still draw you a proper diamond,
    // but with one line shorter, as requested!
    System.out.print("Please give me a number: ");
    int num = scanner.nextInt();
    int half;

    if (num % 2 == 0) {
      half = num / 2;
    } else {
      half = (num / 2) + 1;
    }

    // Draws the first half of the diamond
    for (int i = 1; i <= half; i++) {
      for (int j = 1; j <= half - i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j < (i * 2); j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // Draws the second half of the diamond
    for (int i = 1; i <= half; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j < (half - i) * 2; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
