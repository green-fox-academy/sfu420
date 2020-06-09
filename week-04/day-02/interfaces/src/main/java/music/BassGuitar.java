package main.java.music;

public class BassGuitar extends StringedInstrument {

  public BassGuitar() {
    this.numberOfStrings = 4;
    this.name = "Bass Guitar";
  }

  public BassGuitar(int numberOfStrings) {
    this.numberOfStrings = numberOfStrings;
    this.name = "Bass Guitar";
  }

  @Override
  protected String sound() {
    return "Duum-duum-duum";
  }
}
