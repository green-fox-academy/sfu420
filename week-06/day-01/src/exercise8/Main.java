package exercise8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Character> charList = Arrays.asList('T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'i', 't');

    String output = charList.stream()
        .map(Object::toString)
        .collect(Collectors.joining(""));

    System.out.println(output);
  }
}
