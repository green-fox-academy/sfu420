package FourRectangles;

import java.util.Random;
import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

  public static void mainDraw(Graphics graphics) {
    // draw four different size and color rectangles.
    // avoid code duplication.

    Random random = new Random();
    for (int i = 0; i < 4; i++) {
      int x = random.nextInt(320);
      int y = random.nextInt(320);
      int aSide = random.nextInt(320 - x);
      int bSide = random.nextInt(320 - y);
      int r = random.nextInt(256);
      int g = random.nextInt(256);
      int b = random.nextInt(256);
      graphics.setColor(new Color(r, g, b));
      graphics.fillRect(x, y, aSide, bSide);
    }
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}
