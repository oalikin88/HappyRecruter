package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Type1;
import ru.ibs.trainee.happyrecruter.entities.Type4;

public interface Type4Repository extends CrudRepository<Type4, Long> {
    public Type4 findByTypeIs(String type);
}
