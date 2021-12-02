package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Methodology;

public interface MethodologyRepository extends CrudRepository<Methodology, Long> {
    public Methodology findByMethodologyNameIs(String methodology);
}
