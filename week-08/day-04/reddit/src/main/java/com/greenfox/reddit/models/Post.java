package com.greenfox.reddit.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "parentId")
  private List<Post> childIds;

  @ManyToOne
  @JoinColumn(name = "parentId", referencedColumnName = "id")
  private Post parentId;

  @ManyToOne
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;

  @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  private String title;
  @Column(columnDefinition = "TEXT")
  private String content;
  private Integer vote = 0;
  private boolean initialPost = false;

  public void upVote() {
    this.vote++;
  }

  public void downVote() {
    if (this.vote > 0) {
      this.vote--;
    }
  }
}
