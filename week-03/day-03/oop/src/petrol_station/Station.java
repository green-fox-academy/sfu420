package petrol_station;

public class Station {
  int gasAmount;

  public void refill(Car car) {
    this.gasAmount -= car.capacity - car.gasAmount;
    car.gasAmount = car.capacity;
  }
}
