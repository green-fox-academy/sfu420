//  Create the usual class wrapper
//  and main method on your own.

// - Create a function called `factorio`
//   that returns it's input's factorial

package Factorio;

import java.util.Scanner;

public class Factorio {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num;
    do {
      System.out.print("Please give me a number >= 0 : ");
      num = scanner.nextInt();
    } while (num < 0); // It can be 0 as well, because 0! = 1

    System.out.println("The factorial of " + num + " is: " + factorio(num));
  }

  // We need a long type here, because number 13 already reach integer's max capacity.
  public static long factorio(int number) {
    long factorial = 1;
    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }
    return factorial;
  }
}
