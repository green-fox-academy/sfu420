package exercise6;

public class Main {
  public static void main(String[] args) {
    String text = "StreaM ExpressIon";

    text.chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isUpperCase)
        .forEach(System.out::println);
  }
}
