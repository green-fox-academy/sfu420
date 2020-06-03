package post_it;

import java.awt.Color;

public class Main {
  public static void main(String[] args) {
    PostIt obj1 = new PostIt(Color.ORANGE, "Idea 1", Color.BLUE);
    PostIt obj2 = new PostIt(Color.PINK, "Awesome", Color.BLACK);
    PostIt obj3 = new PostIt(Color.YELLOW, "SuperB!", Color.GREEN);
  }
}
