package CompareLength;

public class CompareLength {
  public static void main(String[] args) {
    int[] firstArrayOfNumbers = {1, 2, 3};
    int[] secondArrayOfNumbers = {4, 5, 6, 7, 8};

    if (secondArrayOfNumbers.length > firstArrayOfNumbers.length) {
      System.out.println("secondArrayOFNumbers is longer");
    } else {
      System.out.println("firstArrayOfNumbers is longer");
    }
  }
}
