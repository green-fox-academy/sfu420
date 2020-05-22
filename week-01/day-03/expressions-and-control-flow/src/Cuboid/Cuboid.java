package Cuboid;

public class Cuboid {
  public static void main(String[] args) {
    double a = 2;
    double b = 5;
    double c = 8;

    double surfaceArea = 2 * (a * b + a * c + b * c);
    double volume = a * b * c;

    System.out.println("Surface area: " + (int) surfaceArea);
    System.out.println("Volume: " + (int) volume);
  }
}
