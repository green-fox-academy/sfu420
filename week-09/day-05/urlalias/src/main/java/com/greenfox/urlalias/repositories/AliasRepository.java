package com.greenfox.urlalias.repositories;

import com.greenfox.urlalias.entities.DTO.AliasDTO;
import com.greenfox.urlalias.entities.models.Alias;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRepository extends CrudRepository<Alias, Long> {

  Optional<Alias> findByUrlAlias(String urlAlias);

  @Query("SELECT new com.greenfox.urlalias.entities.DTO.AliasDTO(a.id, a.baseUrl, a.urlAlias, a.hitCount) FROM Alias as a")
  List<AliasDTO> listAll();
}
