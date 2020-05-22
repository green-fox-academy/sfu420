package PrintBigger;

import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please give me a number: ");
        int num1 = scanner.nextInt();
        System.out.print("Please give me a second number: ");
        int num2 = scanner.nextInt();

        if (num1 == num2) {
            System.out.println("They are equal!");
        } else if (num1 > num2) {
            System.out.println("The first number is the bigger one, which is: " + num1);
        } else {
            System.out.println("The second number is the bigger one, which is: " + num2);
        }
    }
}
