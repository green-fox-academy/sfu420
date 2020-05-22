package MultiplicationTable;

import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please give me a number: ");
    int num = scanner.nextInt();

    for (int i = 1; i <= 10; i++) {
      System.out.println(i + " * " + num + " = " + i * num);
    }

  }
}
