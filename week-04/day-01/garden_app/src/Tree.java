public class Tree extends Plant {

  public Tree(String color, double currentWaterLevel) {
    super(color, currentWaterLevel);
    this.waterAbsorbPercent = 0.40;
    this.needsWaterBelow = 10;
  }
}
