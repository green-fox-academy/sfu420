package blog_post;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BlogPost {
  String authorName;
  String title;
  String text;
  LocalDate publicationDate;

  public BlogPost() {
    this(null, null, null, null);
  }

  public BlogPost(String authorName, String title, String text, String publicationDate) {
    this.authorName = authorName;
    this.title = title;
    this.text = text;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    this.publicationDate = LocalDate.parse(publicationDate, formatter);
  }
}
