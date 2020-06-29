package exercise7;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String>
        cities = Arrays
        .asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

    char letterLookingFor = 'A';

    cities.stream()
        .filter(city -> city.charAt(0) == letterLookingFor)
        .forEach(System.out::println);
  }
}
