package com.greenfox.reddit.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

//  @OneToOne(mappedBy = "id")
//  private Post parentId;

  @ManyToOne
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;

  @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  private String title;
  private String content;
  private boolean isInitialPost;
}
