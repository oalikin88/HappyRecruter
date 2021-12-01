package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Type1;
import ru.ibs.trainee.happyrecruter.entities.Type2;

public interface Type2Repository extends CrudRepository<Type2, Long> {
    public Type2 findByTypeIs(String type);
}
