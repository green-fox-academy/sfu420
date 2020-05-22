package DrawChessTable;

import java.util.Scanner;

public class DrawChessTable {
  public static void main(String[] args) {
    int size = 8;

    for (int i = 2; i < size + 2; i++) {
      if (i % 2 == 0) {
        for (int j = 2; j < size + 2; j++) {
          if (j % 2 == 0) {
            System.out.print("%");
          } else {
            System.out.print(" ");
          }
        }
      } else {
        for (int j = 2; j < size + 2; j++) {
          if (j % 2 == 0) {
            System.out.print(" ");
          } else {
            System.out.print("%");
          }
        }
      }
      System.out.println();
    }
  }
}
