// Create the usual class wrapper and main method on your own.

// Write a function called `sum` that returns the sum of numbers from zero to the given parameter

package Sum;

import java.util.Scanner;

public class Sum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please give me a number: ");
    int num = scanner.nextInt();

    System.out.println("Sum of numbers from 0 to " + num + ": " + sum(num));
  }

  public static int sum(int number) {
    int summa = 0;
    for (int i = 0; i <= number; i++) {
      summa += i;
    }
    return summa;
  }
}
