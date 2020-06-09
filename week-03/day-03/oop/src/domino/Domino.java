package domino;

public class Domino implements Comparable<Domino> {
  private final Integer left;
  private final Integer right;

  public Domino(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public int getLeftSide() {
    return left;
  }

  public int getRightSide() {
    return right;
  }

  @Override
  public String toString() {
    return "[" + left + ", " + right + "]";
  }

  @Override
  public int compareTo(Domino o) {
//    return this.toString().compareTo(o.toString());
    if (this.left.compareTo(o.left) == 0) {
      return this.right.compareTo(o.right);
    } else {
      return this.left.compareTo(o.left);
    }
  }
}