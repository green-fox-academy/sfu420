package CountFromTo;

import java.util.Scanner;

public class CountFromTo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please give me a number: ");
    int num1 = scanner.nextInt();
    System.out.print("Please give me a second number: ");
    int num2 = scanner.nextInt();

    if (!(num2 > num1)) {
      System.out.println("The second number should be bigger!");
    } else {
      for (int i = num1; i <= num2; i++) {
        System.out.println(i);
      }
    }
  }
}
