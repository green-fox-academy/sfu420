package pirate;

public class Pirate {
  int pirateToxicLevel;
  boolean isPirateDead;
  boolean isCaptain;
  boolean isPassedOut;

  public Pirate() {
    this.pirateToxicLevel = 0;
    this.isPirateDead = false;
    this.isCaptain = false;
    this.isPassedOut = false;
  }

  public Pirate(boolean isCaptain) {
    this.pirateToxicLevel = 0;
    this.isPirateDead = false;
    this.isCaptain = isCaptain;
    this.isPassedOut = false;
  }

  public void drinkSomeRum() {
    if (this.pirateToxicLevel < 4) {
      this.pirateToxicLevel += 1;
    }
  }

  public void howItGoingMate() {
    if (!this.isPirateDead()) {
      if (this.pirateToxicLevel < 4) {
        System.out.println("Pour me anudder!");
        drinkSomeRum();
      } else {
        System.out.println(
            "Arghh, I'ma Pirate. How d'ya d'ink its goin?"); // TODO = the pirate passes out and sleeps it off.
        this.isPassedOut = true;
//        this.pirateToxicLevel = 0;
      }
    } else {
      System.out.println("He's dead");
    }
  }

  public void die() {
    this.isPirateDead = true;
  }

  public boolean isPirateDead() {
    return this.isPirateDead;
  }

  public void brawl(Pirate pirate) {
    if (!this.isPirateDead() && !pirate.isPirateDead()) {
      int resultOfFight = ((int) (Math.random() * 3) + 1);
//      1 = this pirate dies
//      2 = other pirate dies
//      3 = both pirates die
      if (resultOfFight == 1) {
        this.die();
      } else if (resultOfFight == 2) {
        pirate.die();
      } else if (resultOfFight == 3) {
        this.die();
        pirate.die();
      }
    }
  }
}
