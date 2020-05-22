package ParametricAverage;

import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("How many numbers to calculate: ");
    int count = scanner.nextInt();
    int sum = 0;

    for (int i = 1; i <= count; i++) {
      System.out.print("Number " + i + ": ");
      int num = scanner.nextInt();
      sum += num;
    }

    float average = (float) sum / count;
    System.out.println("Sum: " + sum);
    System.out.println("Average: " + average);
  }
}
