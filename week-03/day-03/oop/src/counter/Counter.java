package counter;

public class Counter {
  int number;
  int initialNumber;

  public Counter() {
    this.number = 0;
    this.initialNumber = 0;
  }

  public Counter(int number) {
    this.number = number;
    this.initialNumber = number;
  }

  public void add(int number) {
    this.number += number;
  }

  public void add() {
    this.number++;
  }

  public int get() {
    return this.number;
  }

  public void reset() {
    this.number = this.initialNumber;
  }
}
