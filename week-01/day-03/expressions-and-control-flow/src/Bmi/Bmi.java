package Bmi;

public class Bmi {
    public static void main(String[] args) {
        double massInKg = 81.2;
        double heightInM = 1.78;

        System.out.println("Your BMI is: " + massInKg / Math.pow(heightInM, 2));
    }
}
