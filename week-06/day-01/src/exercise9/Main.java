package exercise9;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    String myString = "Write a Stream Expression to find the frequency of characters in a given string!";

    Map<String, Long> frequency = Arrays.stream(myString.toLowerCase().split(""))
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    frequency.forEach((k, v) -> System.out.println(k + ":" + v));
  }
}
