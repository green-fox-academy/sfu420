package com.greenfox.urlalias.repositories;

import com.greenfox.urlalias.entities.DTO.AliasToList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasListRepo extends CrudRepository<AliasToList, Long> {

  @Query("SELECT id, baseUrl, urlAlias, hitCount FROM Alias")
  List<AliasToList> listAll();
}
