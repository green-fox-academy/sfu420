package CodingHours;

public class CodingHours {
  public static void main(String[] args) {
    int numberOfWorkingWeeks = 17;
    int daysInAWeek = 5;
    int workingHours = 6;
    int weeklyAverageWorkHours = 52;
    int c = numberOfWorkingWeeks * daysInAWeek * workingHours;

    System.out.println("Coding Hours: " + c);
    System.out.println("Average coding hours in percent: " +
        (float) c / (numberOfWorkingWeeks * weeklyAverageWorkHours) * 100 + "%");
  }
}
