package AnimalsAndLegs;

import java.util.Scanner;

public class AnimalsAndLegs {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("How many chickens do you have? ");
    int chicken = scanner.nextInt();

    System.out.print("How many pigs do you have? ");
    int pig = scanner.nextInt();

    System.out.println("All the legs animals have: " + (2 * chicken + 4 * pig));
  }
}
