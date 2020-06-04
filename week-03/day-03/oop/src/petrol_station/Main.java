package petrol_station;

public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    Station station = new Station();

    System.out.println("Car's actual fuel state: " + car.gasAmount);
    station.refill(car);
    System.out.println("Car's actual fuel state: " + car.gasAmount);
  }
}
