package pirate;

import java.util.ArrayList;

public class Ship {
  ArrayList<Pirate> pirates = new ArrayList<>();
  String name;

  public Ship(String name) {
    this.name = name;
  }

  public Ship fillShip() {
    int piratesNumber = ((int) (Math.random() * 100) + 1);
    for (int i = 0; i < piratesNumber; i++) {
      this.pirates.add(new Pirate());
    }
    this.pirates.add(new Pirate(true));
    return this;
  }

  public int getPiratesNumber() {
    return this.pirates.size();
  }

  public Pirate getCaptain() {
    Pirate captain = new Pirate();
    for (Pirate item : pirates) {
      if (item.isCaptain) {
        captain = item;
      }
    }
    return captain;
  }

  public int getPiratesAlive() {
    int alive = 0;
    for (Pirate item : pirates) {
      if (!item.isPirateDead) {
        alive++;
      }
    }
    return alive;
  }

  public void getShipState() {
    System.out.println("Ship name: " + this.name);
    System.out.println("Pirates on board: " + this.getPiratesNumber());
    System.out.println("Pirates alive : " + this.getPiratesAlive());
    System.out.println("Is Captain alive: " + !this.getCaptain().isPirateDead);
    System.out.println("Captain's toxic level(0-4) : " + this.getCaptain().pirateToxicLevel);
    System.out.println("Captain passed out : " + this.getCaptain().isPassedOut);
  }

  public static void main(String[] args) {
    Ship myShip = new Ship("BlackDiamond");

    myShip.fillShip();
    myShip.getShipState();
    myShip.getCaptain().howItGoingMate();
    myShip.getCaptain().howItGoingMate();
    myShip.getCaptain().howItGoingMate();
    myShip.getCaptain().howItGoingMate();
    myShip.getCaptain().howItGoingMate();
    myShip.getShipState();
  }
}
