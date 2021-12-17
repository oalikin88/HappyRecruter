package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Type2;

public interface Type2Repository extends CrudRepository<Type2, Long> {
    public Type2 findByTypeIs(String type);
    Collection<Type2> findAll();
}
