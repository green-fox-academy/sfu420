package PersonalFinance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PersonalFinance {
  public static void main(String[] args) {
    ArrayList<Integer> myExpenses = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));
    int sum = myExpenses.stream().mapToInt(Integer::intValue).sum();
    float average = (float) sum / myExpenses.size();
    
    System.out.println("Sum: " + sum);
    System.out.println("Min expense: " + Collections.min(myExpenses));
    System.out.println("Max expense: " + Collections.max(myExpenses));
    System.out.println("Average: " + average);
  }
}
