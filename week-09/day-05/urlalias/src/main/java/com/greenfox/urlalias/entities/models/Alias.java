package com.greenfox.urlalias.entities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Alias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String baseUrl;
  private String urlAlias;
  @JsonIgnore
  private Long secret = (long) (Math.random() * 9000) + 1000;
  private Long hitCount = 0L;

  public Alias(String baseUrl, String urlAlias, Long hitCount) {
    this.baseUrl = baseUrl;
    this.urlAlias = urlAlias;
//    this.secret = (long)(Math.random() * 9000) + 1000;
  }

  public void updateHitCount() {
    this.hitCount++;
  }
}
