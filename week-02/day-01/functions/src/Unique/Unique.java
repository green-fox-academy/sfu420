package Unique;

import java.util.Arrays;

public class Unique {
  public static void main(String[] args) {
    System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
  }

  public static String unique(int myArray[]) {
    int newArray[] = new int[myArray.length];
    int k = 0;
    for (int i = 0; i < myArray.length; i++) {
      boolean isUnique = true;
      for (int j = i + 1; j < myArray.length; j++) {
        if (myArray[i] == myArray[j]) {
          isUnique = false;
        }
      }
      if (isUnique) {
        newArray[k] = myArray[i];
        k++;
      }
    }

    // Remove unused blocks from array
    int finalArray[] = new int[k];
    for (int i = 0; i < k; i++) {
      finalArray[i] = newArray[i];
    }

    // Solution 1 for sorting:
    // Arrays.sort(finalArray);

    // Solution 2 for sorting:
    sorting(finalArray);

    return Arrays.toString(finalArray);
  }

  public static void sorting(int[] sourceArray) {
    boolean swapped;

    do {
      swapped = false;
      for (int i = 0; i < sourceArray.length - 1; i++) {
        if (sourceArray[i] > sourceArray[i + 1]) {
          int swap = sourceArray[i];
          sourceArray[i] = sourceArray[i + 1];
          sourceArray[i + 1] = swap;
          swapped = true;
        }
      }
    } while (swapped);

  }
}
