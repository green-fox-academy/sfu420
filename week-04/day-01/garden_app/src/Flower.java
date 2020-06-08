public class Flower extends Plant {

  public Flower(String color, double currentWaterLevel) {
    super(color, currentWaterLevel);
    this.waterAbsorbPercent = 0.75;
    this.needsWaterBelow = 5;
  }
}
