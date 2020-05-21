package MileToKmConverter;

import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Distance in Miles: ");
        double miles = scanner.nextDouble();

        System.out.println("Converted to Kilometers: " + miles / 1.6 + "km");
    }
}
