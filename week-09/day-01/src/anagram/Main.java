package anagram;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    System.out.println("Result: " + anagramChecker("anna", "nanan"));
  }

  public static boolean anagramChecker(String leftHand, String rightHand) {
    if (valuesAreSet(leftHand, rightHand)) {
      if (lengthEquals(leftHand, rightHand)) {
        char[] leftArray = leftHand.toCharArray();
        char[] rightArray = rightHand.toCharArray();
        Arrays.sort(leftArray);
        Arrays.sort(rightArray);

        return Arrays.equals(leftArray, rightArray);
      }
    }
    System.out.println("Given word lengths are not equal");
    return false;
  }

  public static boolean lengthEquals(String leftHand, String rightHand) {
    return leftHand.length() == rightHand.length();
  }

  public static boolean valuesAreSet(String leftHand, String rightHand) {
    if (leftHand != null && rightHand != null && !leftHand.isEmpty() && !rightHand.isEmpty()) {
      return true;
    }
    System.out.println("Please give a value to both...");
    return false;
  }
}
