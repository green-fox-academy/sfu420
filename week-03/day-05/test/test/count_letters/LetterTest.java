package count_letters;

import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterTest {
  Letter letter;

  @BeforeEach
  void setUp() {
    letter = new Letter();
  }

  @Test
  void textWithWhitespace() {
    HashMap<String, Integer> testMap = new HashMap<String, Integer>() {
      {
        put("s", 3);
        put("c", 1);
        put("t", 2);
        put("e", 1);
        put("u", 1);
        put("g", 1);
        put("i", 1);
        put("k", 1);
        put("n", 1);
      }
    };
    assertEquals(testMap, letter.splitToLetters("Testing sucks"));
  }

  @Test
  void textWithSpecialChars() {
    HashMap<String, Integer> testMap = new HashMap<String, Integer>() {
      {
        put("a", 1);
        put("b", 1);
        put("s", 4);
        put("c", 1);
        put("t", 2);
        put("u", 2);
        put("h", 3);
        put("i", 3);
        put("l", 2);
      }
    };
    assertEquals(testMap, letter.splitToLetters("/This#is&such@a\\bullshit!"));
  }

  @Test
  void emptyString() {
    HashMap<String, Integer> testMap = new HashMap<String, Integer>();
    assertEquals(testMap, letter.splitToLetters(""));
  }

  @Test
  void nullString() {
    assertThrows(NullPointerException.class, () -> {
      letter.splitToLetters(null);
    });
  }
}