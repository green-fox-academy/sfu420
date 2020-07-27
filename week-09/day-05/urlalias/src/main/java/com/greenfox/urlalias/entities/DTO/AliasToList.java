package com.greenfox.urlalias.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AliasToList {

  private Long id;
  private String baseUrl;
  private String urlAlias;
  private Long hitCount;

  public AliasToList(Long id, String baseUrl, String urlAlias, Long hitCount) {
    this.id = id;
    this.baseUrl = baseUrl;
    this.urlAlias = urlAlias;
    this.hitCount = hitCount;
  }
}
