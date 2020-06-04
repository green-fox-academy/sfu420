package sharpieset;

import java.util.ArrayList;
import sharpie.Sharpie;

public class SharpieSet {
  ArrayList<Sharpie> sharpies = new ArrayList<>();

  public int countUsable() {
    int count = 0;
    for (Sharpie item : sharpies) {
      if (item.getInkAmount() > 0) {
        count++;
      }
    }
    return count;
  }

  public void removeTrash() {
    sharpies.removeIf(item -> item.getInkAmount() < 1.0f);
  }

  public void add(Sharpie sharpie) {
    sharpies.add(sharpie);
  }

  public static void main(String[] args) {
    SharpieSet sharpieSet = new SharpieSet();
    sharpieSet.add(new Sharpie("black", 10.0f));
    sharpieSet.add(new Sharpie("blue", 5.0f));
    sharpieSet.add(new Sharpie("green", 8.0f));

    System.out.println("Usable sharies: " + sharpieSet.countUsable());
    for (int i = 0; i < 100; i++) {
      sharpieSet.sharpies.get(0).use();
    }
    System.out.println("1. Sharpie's new ink amount is: " + sharpieSet.sharpies.get(0).getInkAmount());
    System.out.println("Usable sharpies: " + sharpieSet.countUsable());

    System.out.println("Sharpie list size: " + sharpieSet.sharpies.size());
    sharpieSet.removeTrash();
    System.out.println("Sharpie list size: " + sharpieSet.sharpies.size());
  }
}
