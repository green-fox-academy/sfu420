package MapIntroduction;

import java.util.HashMap;

public class MapIntroduction {
  public static void main(String[] args) {
    HashMap<Integer, String> myMap = new HashMap<>();

    System.out.print("The map is empty: " + myMap.isEmpty());
    System.out.println();

    myMap.put(97, "a");
    myMap.put(98, "b");
    myMap.put(99, "c");
    myMap.put(65, "A");
    myMap.put(66, "B");
    myMap.put(67, "C");

    System.out.println(myMap.keySet());
    System.out.println(myMap.values());

    myMap.put(68, "D");

    System.out.println(myMap.size());

    System.out.println(myMap.get(99));

    myMap.remove(97);

    System.out.println(myMap.containsKey(100));

    myMap.clear();
  }
}
