package main.java.music;

public class ElectricGuitar extends StringedInstrument {

  public ElectricGuitar() {
    this.numberOfStrings = 6;
    this.name = "Electric Guitar";
  }

  public ElectricGuitar(int numberOfStrings) {
    this.numberOfStrings = numberOfStrings;
    this.name = "Electric Guitar";
  }

  @Override
  protected String sound() {
    return "Twang";
  }
}
