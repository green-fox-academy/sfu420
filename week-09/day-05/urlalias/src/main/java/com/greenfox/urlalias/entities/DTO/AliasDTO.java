package com.greenfox.urlalias.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AliasDTO {

  private Long id;
  private String baseUrl;
  private String urlAlias;
  private Long hitCount;
}
