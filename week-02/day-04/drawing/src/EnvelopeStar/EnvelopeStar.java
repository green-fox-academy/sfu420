package EnvelopeStar;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EnvelopeStar {
  public static void mainDraw(Graphics graphics) {

    int rasterQty = 32;

    lineDrawer(rasterQty, graphics);
  }

  public static void lineDrawer(int rasterQty, Graphics graphics) {
    int rasterSize = WIDTH / rasterQty;

    for (int j = 0; j < rasterQty; j++) {
      if (rasterSize * j < WIDTH / 2) {
        graphics.setColor(Color.ORANGE);
        graphics.drawLine(WIDTH / 2, j * rasterSize, (WIDTH / 2) - (j * rasterSize), WIDTH / 2);
        graphics.drawLine(WIDTH / 2, j * rasterSize, (WIDTH / 2) + (j * rasterSize), WIDTH / 2);
        graphics.drawLine(WIDTH / 2, HEIGHT - (j * rasterSize), (WIDTH / 2) - (j * rasterSize),
            WIDTH / 2);
        graphics.drawLine(WIDTH / 2, HEIGHT - (j * rasterSize), (WIDTH / 2) + (j * rasterSize),
            WIDTH / 2);
      }
    }
  }

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