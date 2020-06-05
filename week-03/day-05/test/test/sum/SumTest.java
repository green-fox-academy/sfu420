package sum;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumTest {
  ArrayList<Integer> listOfNumbers;
  Sum sum;

  @BeforeEach
  void setUp() {
    sum = new Sum();
  }

  @Test
  void sumListElements() {
    listOfNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
    assertEquals(25, sum.listSum(listOfNumbers));
  }

  @Test
  void sumEmptyList() {
    listOfNumbers = new ArrayList<>(Arrays.asList());
    assertEquals(0, sum.listSum(listOfNumbers));
  }

  @Test
  void sumOnlyOneElement() {
    listOfNumbers = new ArrayList<>(Arrays.asList(5));
    assertEquals(5, sum.listSum(listOfNumbers));
  }

  @Test
  void sumNullList() {
    assertThrows(NullPointerException.class, () -> {
      sum.listSum(listOfNumbers);
    });
  }
}