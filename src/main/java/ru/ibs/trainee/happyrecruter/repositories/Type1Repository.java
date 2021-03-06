package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Type1;

public interface Type1Repository extends CrudRepository<Type1, Long> {
    public Type1 findByTypeIs(String type);
    
    Collection<Type1> findAll();
}
