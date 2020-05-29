package LinePlayQuarters;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinePlayQuarters {
  public static void mainDraw(Graphics graphics) {

    int rasterQty = 10;
    int quarters = 4;
    int rows = (int) Math.sqrt(quarters);
    int cols = (int) Math.sqrt(quarters);
    int quarterWidth = WIDTH / cols;
    int quarterHeight = HEIGHT / rows;
    int rasterSize = (int) quarterWidth / rasterQty;

    for (int col = 0; col < cols; col++) {
      for (int row = rows; row > 0; row--) {
        for (int j = 1; j < rasterQty; j++) {
          int leftBottomCornerX = col * quarterWidth;
          int leftBottomCornerY = row * quarterHeight;
          int x1 = leftBottomCornerX;
          int y1 = leftBottomCornerY - (rasterSize * j);
          int x2 = (leftBottomCornerX + quarterWidth) - (rasterSize * j);
          int y2 = leftBottomCornerY;
          graphics.setColor(Color.RED);
          graphics.drawLine(x1, y1, x2, y2);
          graphics.setColor(Color.BLUE);
          graphics.drawLine(y1, x1, y2, x2);
        }
      }
    }
  }

//  public static void lineDrawer(int x, int y, Graphics graphics) {
//    graphics.setColor(Color.GREEN);
//    graphics.drawLine(x, y, y, HEIGHT);
//    graphics.setColor(Color.BLUE);
//    graphics.drawLine(y, x, WIDTH, y);
//  }

  // Don't touch the code below
  static int WIDTH = 640;
  static int HEIGHT = 640;

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
