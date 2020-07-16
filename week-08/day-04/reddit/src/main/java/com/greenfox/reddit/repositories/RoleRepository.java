package com.greenfox.reddit.repositories;

import com.greenfox.reddit.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

  Role findByRole(String role);
}
