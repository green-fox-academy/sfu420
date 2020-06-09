package main.java.music;

public class Violin extends StringedInstrument {

  public Violin() {
    this.numberOfStrings = 4;
    this.name = "Violin";
  }

  public Violin(int numberOfStrings) {
    this.numberOfStrings = numberOfStrings;
    this.name = "Violin";
  }

  @Override
  protected String sound() {
    return "Screech";
  }
}
