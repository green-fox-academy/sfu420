package SecondsInADay;

public class SecondsInADay {
  public static void main(String[] args) {
    int currentHours = 14;
    int currentMinutes = 34;
    int currentSeconds = 42;
    int secInWeek = 86400;

    int secInHours = currentHours * 60 * 60;
    int secInMinutes = currentMinutes * 60;
    int remainingSecs = secInWeek - (secInHours + secInMinutes + currentSeconds);

    System.out.println("Remaining seconds in this day: " + remainingSecs);
  }
}
