package fleet_of_things;

public class FleetOfThings {

  public static void main(String[] args) {
    Fleet fleet = new Fleet();
    // - You have the `Thing` class
    // - You have the `Fleet` class
    // - You have the `FleetOfThings` class with a `main` method
    // - Download those, use those
    // - In the main method create a fleet
    // - Achieve this output:
    // Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch

    Thing thing1 = new Thing("Get milk");
    Thing thing2 = new Thing("Remove the obstacles");
    Thing thing3 = new Thing("Stand up");
    thing3.complete();
    Thing thing4 = new Thing("Eat lunch");
    thing4.complete();

    fleet.add(thing1);
    fleet.add(thing2);
    fleet.add(thing3);
    fleet.add(thing4);

//    fleet.add(new Thing("Get milk"));
//    fleet.add(new Thing("Remove the obstacles"));
//    fleet.add(new Thing("Stand up"));
//    fleet.add(new Thing("Eat lunch"));

    System.out.println(fleet);
  }
}