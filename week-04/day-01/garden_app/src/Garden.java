import java.util.ArrayList;

public class Garden {
  private String name;
  private ArrayList<Plant> plants;

  public Garden(String name) {
    this.name = name;
    this.plants = new ArrayList<Plant>();
  }

  public void addTree(Tree tree) {
    this.plants.add(tree);
  }

  public void addFlower(Flower flower) {
    this.plants.add(flower);
  }

  public void getStatus() {
    for (Plant plant : this.plants) {
      System.out.println("The " + plant.color + plant.getClass().toString().substring(5) +
          (plant.isNeedsWater() ? " needs water" : " doesn't need water"));
    }
  }

  public ArrayList<Plant> getThirstyPlants() {
    ArrayList<Plant> thirsty = new ArrayList<Plant>();
    for (Plant plant : this.plants) {
      if (plant.isNeedsWater()) {
        thirsty.add(plant);
      }
    }
    return thirsty;
  }

  public void watering(int amount) {
    System.out.println("Watering with " + amount);
    for (Plant plant : getThirstyPlants()) {
      plant.currentWaterLevel +=
          (double) (amount / getThirstyPlants().size()) * plant.waterAbsorbPercent;
    }
    getStatus();
  }
}