package sum;

import java.util.ArrayList;

public class Sum {

  public Integer listSum(ArrayList<Integer> listOfNumbers) {
    Integer sumOfNumbers = 0;
    for (Integer item : listOfNumbers) {
      sumOfNumbers += item;
    }
    return sumOfNumbers;
  }
}
