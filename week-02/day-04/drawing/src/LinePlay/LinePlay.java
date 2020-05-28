package LinePlay;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinePlay {
  public static void mainDraw(Graphics graphics) {

    Color color1 = Color.GREEN;
    Color color2 = Color.GREEN;
    int raster = 12;
    int rasterSize = WIDTH / raster;
    for (int i = 1; i <= raster; i++) {
      lineDrawer(0, rasterSize * i, graphics);
    }
  }

  public static void lineDrawer(int x, int y, Graphics graphics) {
    graphics.setColor(Color.GREEN);
    graphics.drawLine(x, y, y, HEIGHT);
    graphics.setColor(Color.BLUE);
    graphics.drawLine(y, x, WIDTH, y);
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