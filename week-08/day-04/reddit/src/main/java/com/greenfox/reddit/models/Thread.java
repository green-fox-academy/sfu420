//package com.greenfox.reddit.models;
//
//import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Setter
//@Getter
//@NoArgsConstructor
//public class Thread {
////
////  @Id
////  @GeneratedValue(strategy = GenerationType.IDENTITY)
////  private Long id;
////
////  @OneToOne
////  @JoinColumn(name = "initial_post", referencedColumnName = "id")
////  private Post initialPost;
////
////  @OneToMany(mappedBy = "thread_id")
////  private Post comments;
//}
