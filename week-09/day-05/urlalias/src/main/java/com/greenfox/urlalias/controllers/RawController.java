package com.greenfox.urlalias.controllers;

import com.greenfox.urlalias.entities.models.Alias;
import com.greenfox.urlalias.services.AliasService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawController {

  private AliasService aliasService;

  @Autowired
  public RawController(AliasService aliasService) {
    this.aliasService = aliasService;
  }

  @GetMapping("/a/{alias}")
  public ResponseEntity<?> getAlias(@PathVariable String alias) {
    Optional<Alias> currentAlias = aliasService.findByUrlAlias(alias);
    HttpHeaders headers = new HttpHeaders();
    if (currentAlias.isPresent()) {
      currentAlias.get().updateHitCount();
      aliasService.save(currentAlias.get());
      headers.add("Location", currentAlias.get().getBaseUrl());
      return new ResponseEntity<String>(headers, HttpStatus.FOUND);
    }
      return ResponseEntity.notFound().build();
  }

  @GetMapping("/api/links")
  public ResponseEntity<?> listAll() {
    return ResponseEntity.ok(aliasService.listAll());
  }
}
