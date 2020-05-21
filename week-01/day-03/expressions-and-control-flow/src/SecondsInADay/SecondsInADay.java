package SecondsInADay;

public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        int secInHours = currentHours * 60 * 60;
        int secInMinutes = currentMinutes * 60;
        int remainingSecs = 86400 - (secInHours + secInMinutes + currentSeconds);

        System.out.println("Remaining seconds in this day: " + remainingSecs);
    }
}
