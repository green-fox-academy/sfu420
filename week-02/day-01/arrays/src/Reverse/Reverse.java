package Reverse;

import java.util.Arrays;

public class Reverse {
  public static void main(String[] args) {
    int[] numbers = {3, 4, 5, 6, 7};
    boolean swapped;

    do {
      swapped = false;
      for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] < numbers[i + 1]) {
          int swap = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = swap;
          swapped = true;
        }
      }
    } while (swapped);
  }
}