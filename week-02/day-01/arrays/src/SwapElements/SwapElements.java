package SwapElements;

public class SwapElements {
  public static void main(String[] args) {
    String[] orders = {"first", "second", "third"};
    String swap;

    swap = orders[0];
    orders[0] = orders[2];
    orders[2] = swap;
  }
}
