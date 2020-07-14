package com.greenfox.todosql.services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.greenfox.todosql.models.Assignee;
import com.greenfox.todosql.repositories.AssigneeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AssigneeService {

  private AssigneeRepository assigneeRepository;

  public AssigneeService(AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  public List<Assignee> getAll() {
    return (List<Assignee>) assigneeRepository.findAll();
  }

  public Assignee getByID(Long id) {
    if (assigneeRepository.findById(id).isPresent()) {
      return assigneeRepository.findById(id).get();
    } else {
      return null;
    }
  }

  public Assignee save(Assignee assignee) {
    return assigneeRepository.save(assignee);
  }

  public void deleteByID(Long id) {
    assigneeRepository.deleteById(id);
  }
}
