package char_sequence;

public class Shifter implements CharSequence {
  String text;
  int shiftAmount;

  public Shifter(String text, int shiftAmount) {
    this.text = text;
    this.shiftAmount = shiftAmount;
  }

  @Override
  public int length() {
    return this.text.length();
  }

  @Override
  public char charAt(int index) {
    return this.text.charAt(index + 2);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    StringBuilder subText = new StringBuilder();
    for (int i = start + 2; i <= end + 2; i++) {
      if (i < this.text.length()) {
        subText.append(this.text.charAt(i));
      }
    }
    return subText.toString();
  }
}
