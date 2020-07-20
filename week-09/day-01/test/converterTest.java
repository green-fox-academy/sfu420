import number_converter.Main;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class converterTest {

  Long number;

  @Test
  void isZeroDollars() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      Main.convertToString(0.00f);
    });
  }

  @Test
  void underTenDollars() {
    assertEquals("nine dollars", Main.convertToString(9.00f));
  }

  @Test
  void tenDollars() {
    assertEquals("ten dollars", Main.convertToString(10.00f));
  }

  @Test
  void elevenDollars() {
    assertEquals("eleven dollars", Main.convertToString(11.00f));
  }

  @Test
  void sixteenDollars() {
    assertEquals("sixteen dollars", Main.convertToString(16.00f));
  }

  @Test
  void ninetyDollars() {
    assertEquals("ninety dollars", Main.convertToString(90.00f));
  }

  @Test
  void ninetyNineDollars() {
    assertEquals("ninety nine dollars", Main.convertToString(99.00f));
  }

  @Test
  void oneHundredDollars() {
    assertEquals("one hundred dollars", Main.convertToString(100.00f));
  }

  @Test
  void oneHundredAndOneDollars() {
    assertEquals("one hundred and one dollars", Main.convertToString(101.00f));
  }
}
