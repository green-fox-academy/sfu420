import static org.junit.jupiter.api.Assertions.*;

import anagram.Main;
import org.junit.jupiter.api.Test;

public class anagramTester {

  String leftHand;
  String rightHand;

  @Test
  void anagramTesterTrue() {
    leftHand = "anna";
    rightHand = "nana";
    assertTrue(Main.anagramChecker(leftHand, rightHand));
  }

  @Test
  void anagramTesterFalse() {
    leftHand = "anna";
    rightHand = "anba";
    assertFalse(Main.anagramChecker(leftHand, rightHand));
  }

  @Test
  void stringLengthNotEquals() {
    leftHand = "anna";
    rightHand = "annna";
    assertFalse(Main.lengthEquals(leftHand, rightHand));
  }

  @Test
  void stringsAreEmpty() {
    leftHand = "";
    rightHand = "";
    assertTrue(Main.lengthEquals(leftHand, rightHand));
  }

  @Test
  void stringsAreNullOrEmpty() {
    assertFalse(Main.valuesAreSet(leftHand, rightHand));
  }
}
