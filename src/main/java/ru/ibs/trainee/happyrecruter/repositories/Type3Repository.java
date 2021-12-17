package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Type3;

public interface Type3Repository extends CrudRepository<Type3, Long> {
    public Type3 findByTypeIs(String type);
    Collection<Type3> findAll();
}
