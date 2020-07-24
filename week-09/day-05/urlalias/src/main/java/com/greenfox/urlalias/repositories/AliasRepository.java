package com.greenfox.urlalias.repositories;

import com.greenfox.urlalias.entities.models.Alias;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRepository extends CrudRepository<Alias, Long> {

  Optional<Alias> findByUrlAlias(String urlAlias);

  @Query("SELECT id, baseUrl, urlAlias, hitCount FROM Alias")
  List<Alias> listAll();
}
