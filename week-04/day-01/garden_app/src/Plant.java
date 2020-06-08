public class Plant {
  protected String color;
  protected double currentWaterLevel;
  protected double waterAbsorbPercent;
  protected double needsWaterBelow;

  public Plant(String color, double currentWaterLevel) {
    this.color = color;
    this.currentWaterLevel = currentWaterLevel;
  }

  public boolean isNeedsWater() {
    return this.currentWaterLevel < this.needsWaterBelow;
  }
}
