package apples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppleTest {
  Apple myApple;

  @BeforeEach
  void setUp() {
    myApple = new Apple();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void getApple() {
    assertEquals("apple", myApple.getApple());
  }

}