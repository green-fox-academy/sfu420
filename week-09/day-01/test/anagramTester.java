import static org.junit.jupiter.api.Assertions.*;

import anagram.Main;
import org.junit.jupiter.api.Test;

public class anagramTester {

  String leftHand;
  String rightHand;

  @Test
  public void anagramTesterTrue() {
    leftHand = "anna";
    rightHand = "nana";
    assertTrue(Main.anagramChecker(leftHand, rightHand));
  }

  @Test
  public void anagramTesterFalse() {
    leftHand = "anna";
    rightHand = "anba";
    assertFalse(Main.anagramChecker(leftHand, rightHand));
  }

  @Test
  public void stringLengthNotEquals() {
    leftHand = "anna";
    rightHand = "annna";
    assertFalse(Main.lengthEquals(leftHand, rightHand));
  }

  @Test
  public void stringsAreEmpty() {
    leftHand = "";
    rightHand = "";
    assertTrue(Main.lengthEquals(leftHand, rightHand));
  }

  @Test
  public void stringsAreNullOrEmpty() {
    assertFalse(Main.valuesAreSet(leftHand, rightHand));
  }
}
