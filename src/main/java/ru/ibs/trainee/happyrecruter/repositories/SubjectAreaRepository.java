package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.SubjectArea;

public interface SubjectAreaRepository extends CrudRepository<SubjectArea, Long> {
    public SubjectArea findByNameIs(String name);
}
