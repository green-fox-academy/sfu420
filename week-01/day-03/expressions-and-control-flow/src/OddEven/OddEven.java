package OddEven;

import java.util.Scanner;

public class OddEven {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please give me a number: ");
    int num = scanner.nextInt();

    if (num % 2 == 0) {
      System.out.println("This number is even!");
    } else {
      System.out.println("This number is odd!");
    }
  }
}
