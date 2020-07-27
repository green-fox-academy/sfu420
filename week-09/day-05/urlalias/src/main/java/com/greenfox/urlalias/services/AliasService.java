package com.greenfox.urlalias.services;

import com.greenfox.urlalias.entities.DTO.AliasToList;
import com.greenfox.urlalias.entities.models.Alias;
import com.greenfox.urlalias.repositories.AliasListRepo;
import com.greenfox.urlalias.repositories.AliasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliasService {

  private AliasRepository aliasRepository;
  private AliasListRepo aliasListRepo;

  @Autowired
  public AliasService(AliasRepository aliasRepository) {
    this.aliasRepository = aliasRepository;
  }

  public Alias save(Alias newAlias) {
    return aliasRepository.save(newAlias);
  }

  public Optional<Alias> findByUrlAlias(String urlAlias) {
    return aliasRepository.findByUrlAlias(urlAlias);
  }

//  public List<Alias> listAll() {
//    return (List<Alias>) aliasRepository.findAll();
//  }

  public List<AliasToList> listAll() {
    return aliasListRepo.listAll();
  }
}
