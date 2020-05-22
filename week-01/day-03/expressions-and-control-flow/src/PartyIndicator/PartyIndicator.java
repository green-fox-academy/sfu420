package PartyIndicator;

import java.util.Scanner;

public class PartyIndicator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("How many people come to the party?");
    System.out.print("Girls: ");
    int girls = scanner.nextInt();
    System.out.print("Boys: ");
    int boys = scanner.nextInt();

    int participants = girls + boys;

    if (girls == boys && participants >= 20) {
      System.out.println("The party is excellent!");
    } else if (participants >= 20 && girls != boys) {
      System.out.println("Quite cool party!");
    } else if (participants < 20) {
      System.out.println("Average party...");
    } else if (girls <= 0) {
      System.out.println("Sausage party");
    }
  }
}
