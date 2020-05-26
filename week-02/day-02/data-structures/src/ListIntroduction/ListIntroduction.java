package ListIntroduction;

import java.util.ArrayList;
import java.util.Collections;

public class ListIntroduction {
  public static void main(String[] args) {
    ArrayList names = new ArrayList<>();

    System.out.print("Number of elements: " + names.size());
    System.out.println();

    names.add("William");

    System.out.print("The list empty: " + names.isEmpty());
    System.out.println();

    names.add("John");
    names.add("Amanda");

    System.out.print("Number of elements: " + names.size());
    System.out.println();
    System.out.print("The third element is: " + names.get(2));
    System.out.println();

    for (Object item : names) {
      System.out.println(item);
    }

    for (int i = 0; i < names.size(); i++) {
      System.out.println((i + 1) + ". " + names.get(i));
    }

    names.remove(1);

    Collections.reverse(names);
    for (Object item : names) {
      System.out.println(item);
    }

    names.clear();
  }
}
