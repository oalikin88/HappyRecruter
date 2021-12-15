package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.SubjectArea;

public interface SubjectAreaRepository extends CrudRepository<SubjectArea, Long> {
    public SubjectArea findByNameIs(String name);
  
    public Collection<SubjectArea> findAll();
}
