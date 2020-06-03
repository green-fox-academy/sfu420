package post_it;

import java.awt.Color;

public class PostIt {
  Color backgroundColor;
  String text;
  Color textColor;

  public PostIt(Color bgColor, String text, Color textColor) {
    this.backgroundColor = bgColor;
    this.text = text;
    this.textColor = textColor;
  }
}
