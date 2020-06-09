package char_sequence;

import java.lang.CharSequence;

public class Gnirts implements CharSequence {
  String text;

  public Gnirts(String text) {
    this.text = text;
  }

  @Override
  public int length() {
    return this.text.length();
  }

  @Override
  public char charAt(int index) {
    return this.text.charAt(this.length() - (index + 1));
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    StringBuilder subText = new StringBuilder();
    for (int i = this.text.length() - (start + 1); i >= this.text.length() - (end + 1); i--) {
      if (i >= 0) {
        subText.append(this.text.charAt(i));
      }
    }
    return subText.toString();
  }
}