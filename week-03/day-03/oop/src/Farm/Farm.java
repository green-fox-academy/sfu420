package Farm;

import animal.Animal;
import java.util.ArrayList;
import java.util.Collections;

public class Farm {
  ArrayList<Animal> animals = new ArrayList<>();
  private int freeSlots = 5;

  public int getFreeSlots() {
    return freeSlots;
  }

  public void breed() {
    if (getFreeSlots() > 0) {
      animals.add(new Animal());
      freeSlots--;
    } else {
      System.out.println("No free slot left!");
    }
  }

  public Animal leastHungry() {
    Animal leastHungryAnimal = new Animal();
    int minHunger = animals.get(0).getHunger();
    for (Animal item : animals) {
      if (item.getHunger() < minHunger) {
        leastHungryAnimal = item;
      }
    }
    return leastHungryAnimal;
  }

  public void slaughter() {
    animals.remove(leastHungry());
  }

  public static void main(String[] args) {
    Farm myFarm = new Farm();

    System.out.println("Animals on my farm: " + myFarm.animals.size());
    myFarm.breed();
    myFarm.breed();
    System.out.println("Animals on my farm: " + myFarm.animals.size());
    myFarm.animals.get(0).eat();
    myFarm.animals.get(1).play();
    myFarm.slaughter();
    System.out.println("Animals on my farm: " + myFarm.animals.size());
  }
}
