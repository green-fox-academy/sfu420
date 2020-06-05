package count_letters;

import java.util.HashMap;

public class Letter {

  public HashMap<String, Integer> splitToLetters(String text) {
    HashMap<String, Integer> mappedLetters = new HashMap<>();
    for (char item : text.toLowerCase().toCharArray()) {
      if (Character.isLetter(item)) {
        String key = Character.toString(item);
        if (mappedLetters.containsKey(key)) {
          mappedLetters.replace(key, mappedLetters.get(key) + 1);
        } else {
          mappedLetters.put(key, 1);
        }
      }
    }
    return mappedLetters;
  }
}
