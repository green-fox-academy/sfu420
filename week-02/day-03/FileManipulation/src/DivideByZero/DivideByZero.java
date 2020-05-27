// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0

package DivideByZero;

import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Divisor: ");
    int num = scanner.nextInt();

    try {
      float result = 10 / num;
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("fail");
    }
  }
}
