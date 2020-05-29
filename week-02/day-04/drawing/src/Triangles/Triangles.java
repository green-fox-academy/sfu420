package Triangles;

import javax.swing.*;
import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  public static void mainDraw(Graphics graphics) {

    for (int i = 10; i > 0; i--) {
      int margin = 20;
      int bottom = HEIGHT - margin;
      int sideLength = i * 16;

      int[] xpoints = {0, sideLength / 2, sideLength};
      int[] ypoints = {bottom, bottom - (int) ((Math.sqrt(3) / 2) * sideLength), bottom};

      graphics.drawPolygon(xpoints, ypoints, 3);

      int[] x2points = {sideLength, sideLength / 2, sideLength};
      int[] y2points = {bottom, bottom - (int) ((Math.sqrt(3) / 2) * sideLength), bottom};

      graphics.drawPolygon(x2points, y2points, 3);

//      int[] x3points = {sideLength / 2, WIDTH - sideLength) / 2, WIDTH - sideLength};
//      int[] y3points = {bottom - (int) ((Math.sqrt(3) / 2) * sideLength),
//          bottom - (int) ((Math.sqrt(3) / 2) * sideLength),
//          bottom - (int) ((Math.sqrt(3) / 2) * sideLength)};
//
//      graphics.drawPolygon(x3points, y3points, 3);
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
