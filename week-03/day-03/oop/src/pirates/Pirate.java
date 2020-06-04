package pirates;

public class Pirate {
  int pirateToxicLevel;
  boolean isPirateDead;
  boolean isCaptain;

  public Pirate() {
    this.pirateToxicLevel = 0;
    this.isPirateDead = False;
    this.isCaptain = False;
  }

  public void drinkSomeRum() {
    if (this.pirateToxicLevel < 100) {
      this.pirateToxicLevel += 25;
    }
  }

  public void howItGoingMate() {
    if (!this.isPirateDead()) {
      if (this.pirateToxicLevel < 100) {
        System.out.println("Pour me anudder!");
        drinkSomeRum();
      } else {
        System.out.println(
            "Arghh, I'ma Pirate. How d'ya d'ink its goin?"); // TODO = the pirate passes out and sleeps it off.
        this.pirateToxicLevel = 0;
      }
    } else {
      System.out.println("He's dead");
    }
  }

  public void die() {
    this.isPirateDead = True;
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
      }else if(resultOfFight == 2) {
        pirate.die();
      } else if {
        this.die();
        pirate.die();
      }
    }
  }
}
